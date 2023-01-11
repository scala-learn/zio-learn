package zionomicon.essentials.friststeps.excercizes

import zio._

class EX10_Cat extends ZIOAppDefault {
//  def run(commandLineArguments: List[String]) = ???
  import EX01_ReadFile._
  import EX05_FlatmapToForcompr._

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = for {
    args <- getArgs
    _ <-
      if (args.isEmpty)
        Console.printLine("Please provide your name as an argument")
      else
        ZIO.foreach(args)(file => readFileZio(file).flatMap(printLine))
  } yield ()
}
