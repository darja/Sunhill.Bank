package com.darja.accounts.model

open class BankError: Exception()

class InsufficientFundsException: BankError()

class InvalidAmountException: BankError()