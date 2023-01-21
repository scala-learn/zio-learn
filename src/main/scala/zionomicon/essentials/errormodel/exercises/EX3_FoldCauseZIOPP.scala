package zionomicon.essentials.errormodel.exercises

import zio.ZIO


//3. Using the ZIO#foldCauseZIO operator and the Cause#prettyPrint
//method, implement an operator that takes an effect, and returns a new
//effect that logs any failures of the original effect (including errors and
//defects), without changing its failure or success value.
object EX3_FoldCauseZIOPP {
  def logFailures[R, E, A](zio: ZIO[R, E, A]): ZIO[R, E, A] =
    zio.foldCauseZIO(
      cause => ZIO.logError(cause.prettyPrint) *> ZIO.failCause(cause),
      a => ZIO.succeed(a)
    )
}
