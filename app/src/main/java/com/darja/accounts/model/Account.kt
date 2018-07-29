package com.darja.accounts.model

open class Account(
    val owner: Owner,
    balance: Float = 0f
) {
    init {
        if (balance < 0) {
            throw IllegalArgumentException("Balance cannot be negative")
        }
    }

    var balance: Float = balance
        protected set

    @Synchronized
    @Throws(InvalidAmountException::class)
    fun addMoney(amount: Float) {
        if (amount <= 0) {
            throw InvalidAmountException()
        }
        balance += amount
    }

    @Throws(AccountError::class)
    open fun withdrawMoney(amount: Float) {
        withdrawMoney(balance, amount)
    }

    @Synchronized
    @Throws(AccountError::class)
    fun withdrawMoney(availableAmount: Float, amount: Float) {
        if (amount <= 0) {
            throw InvalidAmountException()
        }
        if (amount > availableAmount) {
            throw InsufficientFundsException()
        }

        balance -= amount
    }

    override fun toString() = "[ACCOUNT] $owner\t–\t[$balance]"
}