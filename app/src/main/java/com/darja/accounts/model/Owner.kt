package com.darja.accounts.model

import java.util.*

class Owner(
    val name: String,
    val id: String = UUID.randomUUID().toString()
)