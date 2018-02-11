package edu.knoldus.databaseHandler

import edu.knoldus.model.{BillerAccount, UserAccount}

import scala.collection.mutable.ListBuffer

object DatabaseHandler {

  val users = new ListBuffer[UserAccount]

  val billers = new ListBuffer[BillerAccount]

}
