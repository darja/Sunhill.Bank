package com.darja.accounts

import com.darja.accounts.model.SavingsAccount
import org.junit.Assert.assertEquals
import org.junit.Test

class SavingsAccountTest: BaseAccountTest() {
    @Test(expected = IllegalArgumentException::class)
    fun testInitExcessiveRate() {
        SavingsAccount(owner, 100f, 12f)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testInitNegativeRate() {
        SavingsAccount(owner, 100f, -0.4f)
    }

    @Test
    fun testApplyRate() {
        val account = SavingsAccount(owner, 100f)

        account.setRate(0.12f)
        account.applyRate()
        assertEquals(112f, account.balance)

        account.setRate(1f)
        account.applyRate()
        assertEquals(224f, account.balance)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testNegativeRate() {
        val account = SavingsAccount(owner, 100f)
        account.setRate(-0.12f)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testExcessiveRate() {
        val account = SavingsAccount(owner, 100f)
        account.setRate(12f)
    }
}