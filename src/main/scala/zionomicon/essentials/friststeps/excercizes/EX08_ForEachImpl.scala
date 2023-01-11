package zionomicon.essentials.friststeps.excercizes

object EX08_ForEachImpl {

  import EX06_ZipWithImpl._

  def foreach[R, E, A, B](
    in: Iterable[A]
  )(f: A => ZIO[R, E, B]): ZIO[R, E, List[B]] =
    in.foldRight[ZIO[R, E, List[B]]](ZIO(_ => Right(List.empty))){(a,zio) =>
      zipWith(f(a), zio)(_ :: _)
    }
}
