package edu.knoldus.driver

import akka.actor.{ActorSystem, Props}
import edu.knoldus.actors.{AccountGeneratorActor, DatabaseActor}
import edu.knoldus.model.UserAccount
import edu.knoldus.services.AccountService

object AutomatedTransactions extends App{

  val accountService = new AccountService
  val actorSystem = ActorSystem("AutomatedTransactions")
  val databaseActor = actorSystem.actorOf(Props[DatabaseActor])
  val accountGeneratorActor = actorSystem.actorOf(AccountGeneratorActor.props(databaseActor))

  val newUser: UserAccount = accountService.createUserAccount("nancy","East Delhi",30000)

  accountGeneratorActor ! newUser
  
}
