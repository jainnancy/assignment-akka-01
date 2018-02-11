package edu.knoldus.actors

import akka.actor.{Actor, ActorRef, Props}
import akka.dispatch.{BoundedMessageQueueSemantics, RequiresMessageQueue}
import edu.knoldus.model.{BillerAccount, UserAccount}

case object AccountGeneratorActor{
  def props(ref: ActorRef) = {
    Props(new DatabaseActor)
  }
}

class AccountGeneratorActor(ref: ActorRef) extends Actor with RequiresMessageQueue[BoundedMessageQueueSemantics]{

  override def receive: Receive = {
    case user: UserAccount => ref ! user
    case biller: BillerAccount => ref ! biller
  }

}
