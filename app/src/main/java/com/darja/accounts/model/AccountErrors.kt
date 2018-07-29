package com.darja.accounts.model

open class AccountError: Exception()

class InsufficientFundsException: AccountError()

class InvalidAmountException: AccountError()