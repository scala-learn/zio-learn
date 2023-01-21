package zionomicon.testing

import zio.{Console, Scope, ZIO}
import zio.test.Assertion._
import zio.test.TestAspect.nonFlaky
import zio.test._

object ExampleSpec extends ZIOSpecDefault{

  val greet: ZIO[Any, Nothing, Unit] =
    for {
      name <- Console.readLine.orDie
      _ <- Console.printLine(s"Hello, $name!").orDie
    } yield ()

  override def spec: Spec[TestEnvironment with Scope, Any] =
    suite("ExampleSpec")(
      test("addition works") {
        assert(1+1)(equalTo(2))
      },

      test("ZIO.succeed succeeds with specified value"){
        assertZIO(ZIO.succeed(1+1))(equalTo(2))
      },

      test("testing an effect using map operator"){
        ZIO.succeed(1 + 1).map(n => assert(n)(equalTo(2)))
      },

      test("testing an effect using a for comprehension"){
        for{
          n <- ZIO.succeed(1 + 1)
        } yield assert(n)(equalTo(2))
      },

      test("Has Same elements") {
        assert(List(1, 1, 2, 4))(hasSameElements(List(1, 4, 1, 2)))
      },

      test("fails") {
        for {
          exit <- ZIO.attempt(1 / 0).catchAll(_ => ZIO.fail(())).exit
        } yield assert(exit)(fails(isUnit))
      },

      test("greet says hello to the user") {
        for {
          _ <- TestConsole.feedLines("Jane")
          _ <- greet
          value <- TestConsole.output
        } yield assert(value)(equalTo(Vector("Hello, Jane!\n")))
      },

      test("this test will be repeated to ensure it is stable") {
        assertZIO(ZIO.succeed(1 + 1))(equalTo(2))
      } @@ nonFlaky,

      test("integer addition is associative") {
        val intGen: Gen[Any, Int] =
          Gen.int
        check(intGen, intGen, intGen) { (x, y, z) =>
          val left = (x + y) + z
          val right = x + (y + z)
          assert(left)(equalTo(right))
        }
      }
    )
}
