package zionomicon.essentials.friststeps.excercizes

import zio.{Scope, Task, ZIO, ZIOAppArgs, ZIOAppDefault}


object EX04_FlatmapToForcompr extends ZIOAppDefault{

  def printLine(line: String): Task[Unit] = ZIO.attempt(println(line))
  val readLine: Task[String] = ZIO.attempt(scala.io.StdIn.readLine())

  printLine("What is your name?").flatMap(_ =>
    readLine.flatMap(name => printLine(s"Hello, $name!"))
  )

  val echo: ZIO[Any, Throwable, Unit] =
    for {
      _     <- printLine("What is your name?")
      name  <- readLine
      _     <- printLine(s"Hello, $name!")
    } yield ()

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = echo
}
