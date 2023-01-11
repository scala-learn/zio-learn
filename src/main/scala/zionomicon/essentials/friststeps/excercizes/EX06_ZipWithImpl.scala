package zionomicon.essentials.friststeps.excercizes

object EX06_ZipWithImpl {

  final case class ZIO[-R, +E, +A](run: R => Either[E, A])

  def zipWith[R, E, A, B, C](
    self: ZIO[R, E, A],
    that: ZIO[R, E, B]
  )(f: (A, B) => C): ZIO[R, E, C] =
    ZIO((r:R) => self.run(r).fold(e => Left(e), s => that.run(r).fold(et => Left(et), t => Right(f(s, t)))))

//  val firstName = ZIO.attempt(StdIn.readLine("What is your first name?"))
//  val lastName = ZIO.attempt(StdIn.readLine("What is your last name"))

}

