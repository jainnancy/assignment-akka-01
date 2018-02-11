package edu.knoldus.model

case class UserAccount(accountNumber: Long,
                       accountHolderName: String,
                       address: String,
                       userName: String,
                       initialAmount: Long
                      )
  extends Account(accountNumber)
