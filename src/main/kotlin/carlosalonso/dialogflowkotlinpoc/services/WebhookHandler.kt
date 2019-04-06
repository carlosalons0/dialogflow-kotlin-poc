package carlosalonso.dialogflowkotlinpoc.services

import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2WebhookRequest
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2WebhookResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WebhookHandler {

    @Autowired
    private lateinit var actionProvider: ActionProvider

    @Autowired
    private lateinit var actionResultProcessor: ActionResultProcessor


    fun handleRequest(request: GoogleCloudDialogflowV2WebhookRequest): GoogleCloudDialogflowV2WebhookResponse {
        val webhookResponse = GoogleCloudDialogflowV2WebhookResponse()

        request.queryResult?.let { queryResult ->
            queryResult.action?.let(actionProvider::resolve)?.let { action ->
                val actionResult = action(queryResult.parameters)
                with(actionResultProcessor) {
                    webhookResponse.processActionResult(queryResult, actionResult)
                }
            }
        }

        return webhookResponse
    }

}