package edu.knoldus.model


case class BillerAccount(accountNumber: Long,
                         category: String,
                         billerName: String,
                         transactionDate: java.time.LocalDate,
                         amount: Long,
                         totalIterations: Int,
                         executedIterations: Int,
                         paidAmount: Long
                   )
  extends Account(accountNumber)