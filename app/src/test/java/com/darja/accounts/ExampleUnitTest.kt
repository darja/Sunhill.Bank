package com.darja.accounts

import com.darja.accounts.model.Account
import com.darja.accounts.model.Owner
import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val owner = Owner(name = "Daria")
        val account = Account(owner, 10f)
        account.addMoney(100.2f)

        Assert.assertEquals(110.2f, account.balance)


    }
}
