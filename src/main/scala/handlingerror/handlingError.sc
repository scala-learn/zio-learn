import zio.{URIO, ZIO}

val zeather: URIO[Any, Either[String, Nothing]] = ZIO.fail("Uh oh!").either

