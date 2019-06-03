package controllers

import org.mongodb.scala.bson.collection.Document
import org.mongodb.scala.{Completed, MongoClient, MongoCollection, MongoDatabase, Observable, Observer}

object ScalaMongo {

def main(args: Array[String]) {
  try {
    val mongoClient: MongoClient = if (args.isEmpty) MongoClient() else MongoClient(args.head)

    //get handle to database

    val database: MongoDatabase = mongoClient.getDatabase("mydb")

    //get collection
    val collection: MongoCollection[Document] = database.getCollection("testData")

    // make a document and insert it
    val document: Document = Document("_id" -> 0, "name" -> "MongoDB", "language" -> "scala",
      "city" -> "jaipur")

    val insertObservable: Observable[Completed] = collection.insertOne(document)

    insertObservable.subscribe(new Observer[Completed] {
      override def onNext(result: Completed): Unit = println(s"onNext: $result")
      override def onError(e: Throwable): Unit = println(s"onError: $e")
      override def onComplete(): Unit = println("onComplete")
    })

    collection.find().collect().subscribe((results: Seq[Document]) => println(s"Found: #${results.size}"))


  } catch {
    case e: Throwable => e.printStackTrace()
  }
}
}
