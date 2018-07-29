package com.darja.accounts.model

class SavingsAccount(owner: Owner, balance: Float): Account(owner, balance) {

    constructor(owner: Owner, balance: Float, rate: Float) : this(owner, balance) {
        setRate(rate)
    }

    /**
     * Rate in interval [0, 1]
     */
    private var rate: Float = 0f

    fun setRate(newRate: Float) {
        if (newRate < 0 || newRate > 1) {
            throw IllegalArgumentException("Rate should be in interval [0, 1]")
        }

        rate = newRate
    }

    fun applyRate() {
        addMoney(balance * rate)
    }

    override fun toString() = "[SAVINGS] $owner\t-\t[$balance] + rate [${rate * 100}%]"
}
