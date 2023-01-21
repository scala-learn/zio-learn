package zionomicon.essentials.errormodel.exercises

import zio.{Exit, ZIO}

//4. Using the ZIO#foldCauseZIO method, which “runs” an effect to an Exit
//value, implement the following function, which will execute the specified
//effect on any failure at all:

class EX4_OnAnyFailure {
  def onAnyFailure[R, E, A](
    zio: ZIO[R, E, A],
    handler: ZIO[R, E, Any]
  ): ZIO[R, E, A] =
    zio.foldCauseZIO(
      failure => handler.flatMap(x => Exit.Failure(failure)) ,
      success => ZIO.succeed(success)
    )
}
