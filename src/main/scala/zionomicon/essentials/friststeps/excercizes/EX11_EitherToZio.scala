package zionomicon.essentials.friststeps.excercizes

import zio._

/*
11. Using ZIO.fail and ZIO.succeed, implement the following function,
which converts an Either into a ZIO effect
 */
object EX11_EitherToZio {

  def eitherToZIO[E, A](either: Either[E, A]): ZIO[Any, E, A] =
    either.fold(fa => ZIO.fail(fa), fb => ZIO.succeed(fb))

}
