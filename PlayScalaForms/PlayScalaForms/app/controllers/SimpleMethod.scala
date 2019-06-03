package controllers

object SimpleMethod {

  //method implementation
  def  getFullName(firstName:String, lastName:String)  ={
    firstName + ""+lastName

  }

  def main(args : Array[String]){
    println(getFullName("scala","world"))
    println(getFullNameWithDefaultArgs())
  }

    //default arguments

  def getFullNameWithDefaultArgs(firstName:String = "Scala",lastName:String ="World"): String ={
    firstName + ""+ lastName
  }
}
