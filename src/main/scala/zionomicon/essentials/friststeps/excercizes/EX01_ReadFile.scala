package zionomicon.essentials.friststeps.excercizes

import zio.Console.printLine
import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object EX01_ReadFile extends ZIOAppDefault {

  def readFile(file: String): String = {
    val source = scala.io.Source.fromFile(file)
    try source.getLines().mkString
    finally source.close()
  }


  def readFileZio(file: String): ZIO[Any, Throwable, String] = {
    ZIO.acquireReleaseWith(
      ZIO.attempt(scala.io.Source.fromFile(file))
    )(file => ZIO.attempt(file.close()).orDie) { source =>
      ZIO.attempt(source.getLines().mkString)
    }
  }

  val output: ZIO[Any, Throwable, Unit] =
    readFileZio("build.sbt").flatMap(s => printLine(s))


  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = output
}
