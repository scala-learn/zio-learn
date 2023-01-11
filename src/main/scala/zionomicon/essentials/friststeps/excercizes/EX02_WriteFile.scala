package zionomicon.essentials.friststeps.excercizes

import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object EX02_WriteFile extends ZIOAppDefault{

  def writeFile(file: String, text: String): Unit = {
    import java.io._
    val pw = new PrintWriter(new File(file))
    try pw.write(text)
    finally pw.close()
  }

  def writeFileZio(file: String, text: String): ZIO[Any, Throwable, Unit] = {
    import java.io._
    ZIO.acquireReleaseWith(
      ZIO.attempt(new PrintWriter(new File(file)))
    )(file => ZIO.attempt(file.close()).orDie){ pw =>
      ZIO.attempt(pw.write(text))
    }
  }

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = writeFileZio("zio.txt", "zio zio")
}
