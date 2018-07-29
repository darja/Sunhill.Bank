package com.darja.accounts

import com.darja.accounts.model.Account
import com.darja.accounts.model.Owner
import junit.framework.Assert.assertEquals
import org.junit.Test

class AccountTest {
    private val owner = Owner(name = "John Doe")

    @Test
    fun testInit() {
        val account = Account(owner, 100f)
        assertEquals(100f, account.balance)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testInvalidInit() {
        Account(owner, -100f)
    }

    @Test
    fun testAddMoney() {

    }
}