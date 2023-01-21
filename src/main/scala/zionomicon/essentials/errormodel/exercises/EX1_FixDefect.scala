package zionomicon.essentials.errormodel.exercises

import zio.{Cause, ZIO}

/*1. Using the appropriate effect constructor, fix the following function so that
it no longer fails with defects when executed. Make a note of how the
inferred return type for the function changes.*/

object EX1_FixDefect {
  def failWithMessage(string: String) =
    ZIO.succeed(Cause.fail(string))
}
