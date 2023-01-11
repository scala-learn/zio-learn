package zionomicon.essentials.friststeps.excercizes

import zio.{Clock, ZIO}

import java.util.concurrent.TimeUnit

/*13. Using ZIO.succeed, convert the following procedural function into a ZIO
function:*/
object EX13_CurrentTimeZIO {

  def currentTime(): Long = java.lang.System.currentTimeMillis()
  lazy val currentTimeZIO: ZIO[Any, Nothing, Long] = Clock.currentTime(TimeUnit.MILLISECONDS)
}
