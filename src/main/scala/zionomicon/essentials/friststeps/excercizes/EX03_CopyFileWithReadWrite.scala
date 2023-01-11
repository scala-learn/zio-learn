package zionomicon.essentials.friststeps.excercizes

import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}
import zionomicon.essentials.friststeps.excercizes.EX01_ReadFile.{readFile, readFileZio}
import zionomicon.essentials.friststeps.excercizes.EX02_WriteFile.{writeFile, writeFileZio}


object EX03_CopyFileWithReadWrite extends ZIOAppDefault{

  def copyFile(source: String, dest: String): Unit = {
    val contents = readFile(source)
    writeFile(dest, contents)
  }

  def copyFileZio(source: String, dest: String): ZIO[Any, Throwable, Unit] = readFileZio(source).flatMap(content => writeFileZio(dest, content))

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = copyFileZio("zio.txt", "zio-copy.txt")
}
