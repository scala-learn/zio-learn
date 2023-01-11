package zionomicon.essentials.friststeps.excercizes

import zio.Console._
import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

import java.io.IOException

/*17. Using the Console, write a little program that asks the user what their
name is, and then prints it out to them with a greeting.*/

object EX17_HelloHuman extends ZIOAppDefault{

  val program: ZIO[Any, IOException, Unit] = for{
       _ <- printLine("Hello, what is your name?")
    name <- readLine
       _ <- printLine(s"Hello $name")
  } yield ()

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = program
}
