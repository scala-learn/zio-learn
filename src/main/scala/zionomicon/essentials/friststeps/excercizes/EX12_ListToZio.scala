package zionomicon.essentials.friststeps.excercizes

import zio._

/*
12. Using ZIO.fail and ZIO.succeed, implement the following function,
which converts a List into a ZIO effect, by looking at the head element in
the list and ignoring the rest of the elements.
 */
object EX12_ListToZio {

  def listToZIO[A](list: List[A]): ZIO[Any, None.type, A] = list match {
    case Nil => ZIO.fail(None)
    case ::(head, tl) => ZIO.succeed(head)
  }

}
