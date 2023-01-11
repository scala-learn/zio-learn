package zionomicon.essentials.friststeps.excercizes

import zio.ZIO

//16. Using ZIO.fromFuture, convert the following code to ZIO:

object EX16_FromRuture {

  import scala.concurrent.{ExecutionContext, Future}
  trait Query
  trait Result
  def doQuery(query: Query)(implicit
    ec: ExecutionContext
  ): Future[Result] =
    ???
  def doQueryZio(query: Query): ZIO[Any, Throwable, Result] =
    ZIO.fromFuture(implicit ec => doQuery(query))
}
