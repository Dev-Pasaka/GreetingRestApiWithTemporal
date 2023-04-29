package com.example

import io.temporal.activity.ActivityOptions
import io.temporal.workflow.Workflow
import java.time.Duration
class GreetingsWorkFlowsImpl :GreetingsWorkFlows {
    val  options = ActivityOptions.newBuilder()
        .setStartToCloseTimeout(Duration.ofSeconds(60))
        .build()

    val activity: GreetingActivity = Workflow.newActivityStub(GreetingActivity::class.java, options);
    override fun greeting(name: String): String {
        return activity.composeGreeting(name)
    }
}