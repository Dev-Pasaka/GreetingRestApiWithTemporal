package com.example

import io.temporal.client.WorkflowClient
import io.temporal.serviceclient.WorkflowServiceStubs
import io.temporal.worker.WorkerFactory


    fun startWorker(){
        val service = WorkflowServiceStubs.newLocalServiceStubs()
        val client = WorkflowClient.newInstance(service)
        val factory = WorkerFactory.newInstance(client)
        val worker = factory.newWorker("HelloWorldTaskQueue")
        worker.registerWorkflowImplementationTypes(GreetingsWorkFlowsImpl::class.java)
        worker.registerActivitiesImplementations(GreetingActivityImpl())

        factory.start()
    }

