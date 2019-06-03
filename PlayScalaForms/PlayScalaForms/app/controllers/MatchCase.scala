package controllers

object MatchCase {
  def what(any:Any) = any match{
    case i : Int => "It's an Int"
    case s : String => "It's a String value"
    case _ : Any => "Other than int and String"
  }

  def main(args : Array[String]){
    println(what(123))
    println(what("Sateesh"))
    println(what(118.12))
  }

}
