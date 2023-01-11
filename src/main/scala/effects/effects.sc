import zio.{IO, Task, ZIO, ZIOAppDefault, durationInt}

import scala.concurrent.Future
import scala.util.Try

val s1 = ZIO.succeed(44)

val f1 = ZIO.fail("Uh oh!")
val f2 = ZIO.fail(new Exception("Uh oh!"))

val zoption: IO[Option[Nothing], Int] = ZIO.fromOption(Some(45))
val ztry: Task[Int] = ZIO.fromTry(Try(42 / 0))

lazy val future = Future.successful("Hello!")
val zfuture = ZIO.fromFuture{ implicit ec =>
  future.map(_ => "Goodbuy!")
}

val goShopping = ZIO.attempt(println("Going to the grocery store"))
val goShoppingLate = goShopping.delay(1.hour)

object GroceryStore extends ZIOAppDefault {
  override def run = goShopping
}