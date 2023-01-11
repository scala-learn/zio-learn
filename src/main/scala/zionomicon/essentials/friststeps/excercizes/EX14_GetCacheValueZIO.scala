package zionomicon.essentials.friststeps.excercizes

import zio.ZIO


/* 14. Using ZIO.async, convert the following asynchronous, callback-based function
       into a ZIO function:
*/

object EX14_GetCacheValueZIO {

  def getCacheValue(
    key: String,
    onSuccess: String => Unit,
    onFailure: Throwable => Unit
  ): Unit =
    ???

  def getCacheValueZio(key: String): ZIO[Any, Throwable, String] =
    ZIO.async { callback =>
      getCacheValue(key, s => callback(ZIO.succeed(s)), ex => ZIO.fail(ex))
    }

}
