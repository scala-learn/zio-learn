package zionomicon.essentials.errormodel

import zio.ZIO

object MainErrorModel {
  final case class InsufficientPermission(
    user: String,
    operation: String
  )
  final case class FileIsLocked(file: String)
  def shareDocument(
    doc: String
  ): ZIO[Any, InsufficientPermission, Unit] =
    ???
  def moveDocument(
    doc: String,
    folder: String
  ): ZIO[Any, FileIsLocked, Unit] =
    ???


  lazy val result: ZIO[Any, Any, Unit] = shareDocument("23456").zip(moveDocument("23456", "/usr/bin"))

  lazy val result2: ZIO[Any, Either[InsufficientPermission, FileIsLocked], Unit] =
    shareDocument("23456")
      .mapError(Left(_))
      .zip(moveDocument("23456", "/usr/bin").mapError(Right(_)))
}
