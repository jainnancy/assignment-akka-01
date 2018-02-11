package edu.knoldus.actors

import akka.actor.Actor
import edu.knoldus.databaseHandler.DatabaseHandler
import edu.knoldus.model.{BillerAccount, UserAccount}
import edu.knoldus.driver.DefaultValues._

class DatabaseActor extends Actor {

  override def receive: Receive = {

    case userDetails: UserAccount =>
      if (!DatabaseHandler.users.exists(user => user.userName == userDetails.userName)) {
        DatabaseHandler.users += userDetails
        log.info(s"\nAccount Number = ${userDetails.accountNumber}" +
          s"\nUser Name = ${userDetails.userName}")
      }
      else{
        log.error(s"Username already exists")
      }

    case billerDetails: BillerAccount =>
      if(!DatabaseHandler.billers.exists(biller => biller.billerName == billerDetails.billerName)) {
        DatabaseHandler.billers += billerDetails
        log.info(s"\nAccount Number = ${billerDetails.accountNumber}" +
          s"\nBiller Name = ${billerDetails.billerName}")
      }
      else
        log.error(s"Biller name already exists")
  }
}
