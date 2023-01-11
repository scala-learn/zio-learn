package zionomicon.essentials.friststeps

import zio.Console.printLine
import zio.{Scope, Task, ZIO, ZIOAppArgs, ZIOAppDefault}

import java.io.IOException
import scala.io.StdIn

object Main1 extends ZIOAppDefault {

  val firstName: Task[String] = ZIO.attempt(StdIn.readLine("What is your first name?"))
  val lastName: Task[String] = ZIO.attempt(StdIn.readLine("What is your last name"))
  val fullName: ZIO[Any, Throwable, String] = firstName.zipWith(lastName)((first, last) => s"$first $last")
  val helloWorld: ZIO[Any, Throwable, Unit] =
    ZIO.attempt(print("Hello, ")) <* ZIO.attempt(print("World!\n"))

  val prints =
    List(
      printLine("The"),
      printLine("quick"),
      printLine("brown"),
      printLine("fox")
    )
  val printWords: ZIO[Any, IOException, List[Unit]] = ZIO.collectAll(prints)

  val readInt: ZIO[Any, Throwable, Int] = {
    val inline = StdIn.readLine()
    ZIO.attempt(inline.toInt)
  }

  lazy val readIntOrRetry: ZIO[Any, IOException, Nothing] =
    readInt
      .orElse(printLine("Please enter a valid integer"))
      .zipRight(readIntOrRetry)



  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = printWords
}
