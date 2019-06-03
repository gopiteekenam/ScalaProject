package controllers

object MutableImmutable extends App{

  val message = "Immutable value, you can't reassign"

  println(message)

  var greeting = "Mutable value"
  println(greeting)
  greeting = " You can reassigne this value"
  println(greeting)
}
