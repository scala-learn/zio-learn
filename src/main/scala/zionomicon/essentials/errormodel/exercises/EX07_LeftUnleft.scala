package zionomicon.essentials.errormodel.exercises

import zio.ZIO

/*7. Using the ZIO#foldZIO method, implement the following two functions,
which make working with Either values easier, by shifting the unexpected
case into the error channel (and reversing this shifting).*/

object EX07_LeftUnleft {

  def left[R, E, A, B](
    zio: ZIO[R, E, Either[A, B]]
  ): ZIO[R, Either[E, B], A] =
    zio.foldZIO(
      failure => ZIO.fail(Left(failure)),
      success => success match {
        case Left(value) => ZIO.succeed(value)
        case Right(value) => ZIO.fail(Right(value))
      }
    )


  def unleft[R, E, A, B](
    zio: ZIO[R, Either[E, B], A]
  ): ZIO[R, E, Either[A, B]] =

    zio.foldZIO(
      failure => failure match {
        case Left(value) => ZIO.fail(value)
        case Right(value) => ZIO.succeed(Right(value))
      },
      success => ZIO.succeed(Left(success))
    )


}
