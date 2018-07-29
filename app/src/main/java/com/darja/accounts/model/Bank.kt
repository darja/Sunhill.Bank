package com.darja.accounts.model

import android.accounts.Account
import android.util.Log

class Bank(private var accounts: ArrayList<Account>) {
    companion object {
        private const val TAG = "Bank"
    }

    fun provideInterestToAllUsers() {
        accounts
            .filterIsInstance<SavingsAccount>()
            .forEach { it.applyRate() }

    }

    fun printAllAccounts() {
        accounts.forEach {
            Log.d(TAG, it.toString())
        }
    }
}