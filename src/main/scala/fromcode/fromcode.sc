import zio.{Task, UIO, ZIO}

import java.io.IOException
import scala.io.StdIn

//Sync code
val readLine: Task[String] = ZIO.attempt(StdIn.readLine())

def printLine(line: String): UIO[Unit] = ZIO.succeed(println(line))

//// Specific error
val readLine2: ZIO[Any, IOException, String] = ZIO.attempt(StdIn.readLine()).refineToOrDie[IOException]

//Acync code
case class User(login: String, pass: String)
object legacy {
  def login(
    onSuccess: User => Unit,
    onFailure: IllegalAccessError => Unit
  ) = ???
}

val login =
  ZIO.async[Any, IllegalAccessError, User]{ callback =>
    legacy.login(
      user => callback(ZIO.succeed(user)),
      err  => callback(ZIO.fail(err))
    )
  }