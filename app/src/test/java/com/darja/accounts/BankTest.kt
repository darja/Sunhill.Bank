package com.darja.accounts

import com.darja.accounts.model.*
import org.junit.Assert.assertEquals
import org.junit.Test

class BankTest {
    @Test
    fun testBank() {
        val accounts = listOf(
            Account(Owner("John Doe"), 100f),
            SavingsAccount(Owner("John Smith"), 200f, 0.1f),
            SavingsAccount(Owner("Jane Doe"), 300f, 0.12f),
            CheckingAccount(Owner("Jane Doe"), 200f, 500f)
        )

        val bank = Bank(accounts)
        bank.provideInterestToAllUsers()

        assertEquals(100f, accounts[0].balance)
        assertEquals(220f, accounts[1].balance)
        assertEquals(336f, accounts[2].balance)
        assertEquals(200f, accounts[3].balance)

        (accounts[1] as SavingsAccount).setRate(0.15f)
        (accounts[2] as SavingsAccount).setRate(0.5f)
        bank.provideInterestToAllUsers()
        assertEquals(100f, accounts[0].balance)
        assertEquals(253f, accounts[1].balance)
        assertEquals(504f, accounts[2].balance)
        assertEquals(200f, accounts[3].balance)
    }
}