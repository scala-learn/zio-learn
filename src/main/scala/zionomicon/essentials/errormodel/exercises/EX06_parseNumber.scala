package zionomicon.essentials.errormodel.exercises

import zio.ZIO

/*6. Using the ZIO#refineToOrDie method, narrow the error type of the following
effect to just NumberFormatException.*/

object EX06_parseNumber {

  val parseNumber: ZIO[Any, Throwable, Int] =
    ZIO.attempt("foo".toInt)

  val parseNumber2: PartialFunction[Throwable, NumberFormatException] => ZIO[Any, NumberFormatException, Int] =
    parseNumber.refineOrDie[NumberFormatException]
}
