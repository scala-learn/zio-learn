

trait Animal {
  val name: String
}
final case class Cat(name: String) extends Animal

val i = implicitly[Cat <:< Animal]
//implicitly[Animal <:< Cat]
final case class Collection[+A](elements: List[A])

lazy val cats: List[Cat] = ???

lazy val animal:List[Animal] = cats.map(identity)


