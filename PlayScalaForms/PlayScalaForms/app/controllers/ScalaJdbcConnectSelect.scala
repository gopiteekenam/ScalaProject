package controllers

import java.sql.{Connection, DriverManager}

import com.typesafe.config.ConfigFactory
import models.Employee

object ScalaJdbcConnectSelect {

  def main(args: Array[String]) {

    // connect to the database named "oracle" on the localhost
    val driver = ConfigFactory.load().getString("oracle.driver.name")
    val url = ConfigFactory.load().getString("oracle.driver.url")
    val username = ConfigFactory.load().getString("oracle.driver.user")
    val password = ConfigFactory.load().getString("oracle.driver.password")

    // there's probably a better way to do this
    var connection: Connection = null

    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
//      statement.execute("insert into candidate (name, city,programing_language) values('sateesh v','renugunta','multi language')")
      val resultSet = statement.executeQuery("SELECT * from CANDIDATE")
      val employees = Iterator.from(0).takeWhile(_ => resultSet.next()).map(_ => {
        Employee(resultSet.getString("CITY"), resultSet.getString("PROGRAMING_LANGUAGE"))
      }).toList
      println("iterating the list "+employees.foreach(print))
      println()
      println("list of all employees containing scala "+employees.filter((employee: Employee) => employee.language.contains("scala")))

      for(employee <- employees) println(employee.language)

      println("map"+employees.map(employee => employee.name))

      println("Sorting list"+employees.sortBy(employee => employee.language))


    } catch {
      case ex: NullPointerException => println("Connection is invalid")
      case e: RuntimeException => e.printStackTrace()

      case _ : Any => new Exception("new exception")
    }
    if(connection != null)
    connection.close()
  }
}
