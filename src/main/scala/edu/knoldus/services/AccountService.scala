package edu.knoldus.services

import edu.knoldus.databaseHandler.DatabaseHandler
import edu.knoldus.model.{BillerAccount, UserAccount}


class AccountService {

  def createUserAccount(holderName: String,address: String,initialAmount: Long): UserAccount = {
    val accountNumber = createUserAccountNumber()
    val userName = createUserName(holderName)

    UserAccount(accountNumber,holderName,address,userName,initialAmount)
  }

  def createBillerAccount(category: String, billerName: String,
                          amount: Long, totalIterations: Int): BillerAccount = {

    val accountNumber: Long = createBillerAccountNumber()
    val transactionDate = java.time.LocalDate.now
    val executedIterations = 0
    val paidAmount = 0

    BillerAccount(accountNumber,category,billerName,
      transactionDate,amount,totalIterations,executedIterations,paidAmount)
  }

  def createUserAccountNumber(): Long = {
    val random = new java.util.Random
    val accountNo = (random.nextInt(5000) * 100) + DatabaseHandler.users.size + 1
    accountNo.toLong
  }

  def createBillerAccountNumber(): Long = {
    val random = new java.util.Random
    val accountNo = (random.nextInt(1000) * 100) + DatabaseHandler.billers.size + 1
    accountNo.toLong
  }

  def createUserName(name: String): String = {
    val userName = s"$name" + s"${DatabaseHandler.users.size + 1}"
    userName
  }

}