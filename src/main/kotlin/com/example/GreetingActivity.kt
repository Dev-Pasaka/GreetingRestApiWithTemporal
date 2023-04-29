package com.example

import io.temporal.activity.ActivityInterface

@ActivityInterface
interface GreetingActivity {
    fun composeGreeting(name: String): String
}