package com.example

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.temporal.client.WorkflowClient
import io.temporal.client.WorkflowOptions
import io.temporal.client.WorkflowStub
import io.temporal.serviceclient.WorkflowServiceStubs
import kotlin.system.exitProcess


fun Route.sendGreeting(){
    post("/sendGreeting") {
        val greeting1 = call.receive<Greeting>()
        startWorker()

        val service = WorkflowServiceStubs.newLocalServiceStubs()
        val client = WorkflowClient.newInstance(service)
        val WORKFLOW_ID = "Pasaka001"

        val options = WorkflowOptions.newBuilder()
            .setWorkflowId(WORKFLOW_ID)
            .setTaskQueue("HelloWorldTaskQueue")
            .build()
        val workflow = client.newWorkflowStub(GreetingsWorkFlows::class.java, options)

        val greeting = workflow.greeting(greeting1.greeting)
        val workflowId = WorkflowStub.fromTyped(workflow).execution.workflowId
        println("$workflowId  $greeting")

        call.respondText("Request sent successful")
    }

}

