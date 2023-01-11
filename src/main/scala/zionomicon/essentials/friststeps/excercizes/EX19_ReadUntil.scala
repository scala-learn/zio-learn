package zionomicon.essentials.friststeps.excercizes

import zio.Console.printLine
import zio.ZIO

import java.io.IOException
/*
19. Using the Console service and recursion, write a function that will repeatedly
read input from the console until the specified user-defined function
evaluates to true on the input.
*/

object EX19_ReadUntil {

  def readUntil(
    acceptInput: String => Boolean
  ): ZIO[Any, IOException, String] = {
    printLine("Enter something")
    zio.Console.readLine.flatMap{ input =>
      if(acceptInput(input)) ZIO.succeed("Finish")
      else readUntil(acceptInput)
    }
  }

}
