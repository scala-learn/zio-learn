package zionomicon.essentials.friststeps.excercizes

/*
9. Implement the orElse function in terms of the toy model of a ZIO effect.
The function should return an effect that tries the left hand side, but if
that effect fails, it will fallback to the effect on the right hand side.*/
object EX09_OrElse {

  final case class ZIO[-R, +E, +A](run: R => Either[E, A])

  def orElse[R, E1, E2, A](
    self: ZIO[R, E1, A],
    that: ZIO[R, E2, A]
  ): ZIO[R, E2, A] =
    ZIO((r:R) => self.run(r).fold(fa => that.run(r), fb => Right(fb)))
}
