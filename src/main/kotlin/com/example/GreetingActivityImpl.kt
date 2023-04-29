package com.example

class GreetingActivityImpl :GreetingActivity {
    override fun composeGreeting(name: String) : String {
        return "hello $name"
    }

}