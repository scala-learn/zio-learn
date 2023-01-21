package zionomicon.essentials.errormodel.exercises

import zio._

//2.Using the ZIO#foldCauseZIO operator and the Cause#defects method,
//implement the following function. This function should take the effect,
//inspect defects, and if a suitable defect is found, it should recover from
//the error with the help of the specified function, which generates a new
//success value for such a defect.

object EX2_FoldCauseZIO  {

  def recoverFromSomeDefects[R, E, A](zio: ZIO[R, E, A])(
    f: Throwable => Option[A]
  ): ZIO[R, E, A] = zio.foldCauseZIO(
    failure = {
      case Cause.Fail(value, trace) => ZIO.fail(value)
    },
    succeed => ZIO.succeed(succeed)
  )


}
