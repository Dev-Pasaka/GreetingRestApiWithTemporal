package com.example

import io.temporal.workflow.WorkflowInterface
import io.temporal.workflow.WorkflowMethod

@WorkflowInterface
interface GreetingsWorkFlows {

    @WorkflowMethod
    fun greeting(name: String): String
}