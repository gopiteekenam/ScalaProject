package controllers

trait Vehicle {
  val noOfWheels: String
  def getType(noOfWheels: String):String
  def show() = println(" Trait can have implemented methods and  can achieve multiple inheritance")

}

// due to Trait mixin concept  can allow to  extend any number of traits with a class or abstract class  and need to follow order
class Car (wheels: String= "4")extends Vehicle with models.BrandTrait {
  val noOfWheels: String= "4";
  def getType(noOfWheels: String): String = {
    " car  has "+ noOfWheels+ "wheels"
  }

  def apply: Car = new Car("4")
}



object DemoOnTraits{

  def main(args: Array[String]): Unit = {

    val result   =new Car().getType("4")
    new Car().show()
    println(result)

    //new  BrandTrait()   "can not instantiate trait"

    val name= new Car().brandName
    println( "Brand Name  "+name)

    // String Interpolatio
    println(s"value of name = $name")


  }
}

