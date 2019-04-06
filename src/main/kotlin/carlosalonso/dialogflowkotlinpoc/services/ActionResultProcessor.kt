package carlosalonso.dialogflowkotlinpoc.services


import carlosalonso.dialogflowkotlinpoc.domain.ActionResult
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2WebhookResponse
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2QueryResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ActionResultProcessor {
    @Autowired
    private lateinit var templateProcessor: TemplateProcessor

    fun GoogleCloudDialogflowV2WebhookResponse.processActionResult(originalQueryResult: GoogleCloudDialogflowV2QueryResult, actionResult: ActionResult) {
        actionResult.model.let { model ->
            originalQueryResult.fulfillmentText?.let {
                this.fulfillmentText = templateProcessor(it, model)
            }
        }
    }
}