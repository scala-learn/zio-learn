package zionomicon.essentials.friststeps.excercizes

import zio.{Scope, Task, ZIO, ZIOAppArgs, ZIOAppDefault}

object EX05_FlatmapToForcompr extends ZIOAppDefault{

  val random: Task[Int] = ZIO.attempt(scala.util.Random.nextInt(3) + 1)
  def printLine(line: String): Task[Unit] = ZIO.attempt(println(line))
  val readLine: Task[String] = ZIO.attempt(scala.io.StdIn.readLine())
  random.flatMap { int =>
    printLine("Guess a number from 1 to 3:").flatMap { _ =>
      readLine.flatMap { num =>
        if (num == int.toString) printLine("You guessed right!")
        else printLine(s"You guessed wrong, the number was $int!")
      }
    }
  }

  val echo: ZIO[Any, Throwable, Unit] =
    for {
      int <- random
      _   <- printLine("Guess a number from 1 to 3:")
      num <- readLine
      _   <- {
        if (num == int.toString) printLine("You guessed right!")
        else printLine(s"You guessed wrong, the number was $int!")
      }
    } yield ()

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = echo
}
