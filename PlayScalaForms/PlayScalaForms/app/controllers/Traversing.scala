package controllers

case class User(
                 id: Int,
                 firstName: String,
                 lastName: String,
                 age: Int,
                 gender: Option[String] )

object Traversing{
  def main(args : Array[String]){
    val users  = List(User(1, "Scala","World",40, Some("male")),User(2, "Java","World",42, Some("female")))
    println(users.filter((user: User) => user.firstName.contains("Scala")).filter((user:User) =>user.lastName.contains("world")))

  }

}
