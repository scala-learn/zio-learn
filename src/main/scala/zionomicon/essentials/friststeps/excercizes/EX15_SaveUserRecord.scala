package zionomicon.essentials.friststeps.excercizes

import zio.ZIO

/*
15. Using ZIO.async, convert the following asynchronous, callback-based function
into a ZIO function:
*/

object EX15_SaveUserRecord {

  trait User
  def saveUserRecord(
    user: User,
    onSuccess: () => Unit,
    onFailure: Throwable => Unit
  ): Unit =
    ???

  def saveUserRecordZio(user: User): ZIO[Any, Throwable, Unit] =
    ZIO.async { callback =>
        saveUserRecord(user, () => callback(ZIO.succeed()), ex => callback(ZIO.fail(ex)))
    }

}
