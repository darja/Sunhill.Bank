package com.darja.accounts

import com.darja.accounts.model.*
import org.junit.Assert.assertEquals
import org.junit.Test

class CheckingAccountTest: BaseAccountTest() {
    val recipient = Owner(name = "Jane Doe")

    @Test
    fun testInit() {
        val account = CheckingAccount(owner, 100f, 200f)
        assertEquals(100f, account.balance)
    }

    @Test
    fun testWithdrawFromBalance() {
        val account = CheckingAccount(owner, 100f, 200f)
        account.withdrawMoney(10f)
        assertEquals(90f, account.balance)
    }

    @Test
    fun testWithdrawOverBalance() {
        val account = CheckingAccount(owner, 100f, 200f)
        account.withdrawMoney(150f)
        assertEquals(-50f, account.balance)
    }

    @Test(expected = InsufficientFundsException::class)
    fun testWithdrawOverLimit() {
        val account = CheckingAccount(owner, 100f, 200f)
        account.withdrawMoney(500f)
    }

    @Test
    fun testTransferMoney() {
        val account = CheckingAccount(owner, 100f, 200f)
        val recipientAccount = Account(recipient, 5f)

        account.transferMoney(recipientAccount, 50f)

        assertEquals(50f, account.balance)
        assertEquals(55f, recipientAccount.balance)
    }

    @Test(expected = InvalidAmountException::class)
    fun testNegativeTransferMoney() {
        val account = CheckingAccount(owner, 100f, 200f)
        val recipientAccount = Account(recipient, 5f)

        account.transferMoney(recipientAccount, -50f)
    }

    @Test(expected = InsufficientFundsException::class)
    fun testInsufficientTransferMoney() {
        val account = CheckingAccount(owner, 100f, 200f)
        val recipientAccount = Account(recipient, 5f)

        account.transferMoney(recipientAccount, 900f)
    }
}