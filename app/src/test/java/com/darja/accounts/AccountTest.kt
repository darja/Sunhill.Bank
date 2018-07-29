package com.darja.accounts

import com.darja.accounts.model.Account
import com.darja.accounts.model.InsufficientFundsException
import com.darja.accounts.model.InvalidAmountException
import junit.framework.Assert.assertEquals
import org.junit.Test

class AccountTest: BaseAccountTest() {
    @Test
    fun testInit() {
        val emptyAccount = Account(owner)
        assertEquals(0f, emptyAccount.balance)

        val account = Account(owner, 100f)
        assertEquals(100f, account.balance)
        assertEquals("John Doe", account.owner.name)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testInvalidInit() {
        Account(owner, -100f)
    }

    @Test
    fun testAddMoney() {
        val account = Account(owner, 100f)
        account.addMoney(10f)
        assertEquals(110f, account.balance)
    }

    @Test(expected = InvalidAmountException::class)
    fun testInvalidAddMoney() {
        val account = Account(owner, 100f)
        account.addMoney(-10f)
    }

    @Test
    fun testWithdrawMoney() {
        val account = Account(owner, 100f)
        account.withdrawMoney(10f)
        assertEquals(90f, account.balance)
    }

    @Test(expected = InvalidAmountException::class)
    fun testInvalidWithdrawMoney() {
        val account = Account(owner, 100f)
        account.withdrawMoney(-10f)
    }

    @Test(expected = InsufficientFundsException::class)
    fun testWithdrawTooMuchMoney() {
        val account = Account(owner, 100f)
        account.withdrawMoney(1000f)
    }
}