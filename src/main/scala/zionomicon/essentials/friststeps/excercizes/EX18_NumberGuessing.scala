package zionomicon.essentials.friststeps.excercizes

import zio.Console._
import zio.{Random, Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

import java.io.IOException

object EX18_NumberGuessing extends ZIOAppDefault{

  val program: ZIO[Any, IOException, Unit] = for {
    rnd <- Random.nextIntBetween(1, 4)
    _   <- printLine("Enter number from 1 to 3")
    i   <- readLine
    _   <- if (i.toInt == rnd) {
      printLine("You are guess")
    } else {
      printLine("You are wrong")
    }
  } yield ()

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = program
}
