package gettingstarted

import zio.Console._
import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

import java.io.IOException

object MyApp extends ZIOAppDefault{
  val myAppLogic: ZIO[Any, IOException, Unit] =
    for {
      _    <- printLine("Hello! What is your name")
      name <- readLine
      _    <- printLine(s"Hello, $name, welcome to ZIO!")
    } yield ()

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = myAppLogic
}
