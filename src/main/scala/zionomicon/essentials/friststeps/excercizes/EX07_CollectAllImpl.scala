package zionomicon.essentials.friststeps.excercizes

import zio.{Scope, ZIOAppArgs, ZIOAppDefault}


object EX07_CollectAllImpl extends ZIOAppDefault{
  import EX06_ZipWithImpl._
  //final case class ZIO[-R, +E, +A](run: R => Either[E, A])

  def collectAll[R, E, A](
    in: Iterable[ZIO[R, E, A]]
  ): ZIO[R, E, List[A]] =
    if (in.isEmpty) ZIO(_ => Right(List.empty))
    else zipWith(in.head, collectAll(in.tail))(_::_)

  override def run: zio.ZIO[Any with ZIOAppArgs with Scope, Any, Any] = ???
}
