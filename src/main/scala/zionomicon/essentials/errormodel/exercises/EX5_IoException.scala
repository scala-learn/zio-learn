package zionomicon.essentials.errormodel.exercises

import zio.ZIO

import java.io.IOException

/*
5. Using the ZIO#refineOrDie method, implement the ioException function,
which refines the error channel to only include the IOException
error.
*/

class EX5_IoException {

  def ioException[R, A](
    zio: ZIO[R, Throwable, A]
  ): ZIO[R, java.io.IOException, A] =
    zio.refineToOrDie[IOException]

}
