package controllers

case class User(
      id: Int,
      firstName: String,
      lastName: String,
      age: Int,
      gender: Option[String] )

object OptionExample {
  private val users  = Map(1 -> User(1, "Scala","World",40, Some("male")),
                           2 -> User(2, "Scala","World",42, Some("female")))

  def findById(id:Int):Option[User] = users.get(id)
  def finaAll = users.values

  def main(args : Array[String])  ={
    println(OptionExample.findById(2))
    println(OptionExample.finaAll)
  }
}