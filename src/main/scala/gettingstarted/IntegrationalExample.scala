package gettingstarted

import zio._

object IntegrationalExample {
  val runtime: Runtime[Any] = Runtime.default

  Unsafe.unsafe{ implicit unsafe =>
    runtime.unsafe.run(ZIO.attempt(println("Hello world!"))).getOrThrowFiberFailure()
  }
}
