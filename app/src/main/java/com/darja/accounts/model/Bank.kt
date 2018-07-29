package com.darja.accounts.model

class Bank(private var accounts: List<Account>) {
    fun provideInterestToAllUsers() {
        accounts
            .filterIsInstance<SavingsAccount>()
            .forEach { it.applyRate() }

    }
}