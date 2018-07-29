package com.darja.accounts.model

class CheckingAccount(owner: Owner, balance: Float, private val limit: Float): Account(owner, balance) {
    override fun withdrawMoney(amount: Float) {
        withdrawMoney(balance + limit, amount)
    }

    @Throws(BankError::class)
    fun transferMoney(account: Account, amount: Float) {
        try {
            withdrawMoney(amount)
            account.addMoney(amount)
        } catch (e: BankError) {
            throw e
        }
    }

    override fun toString() = "[CHECKING] $owner\t-\t[$balance] + limit [$limit]"
}