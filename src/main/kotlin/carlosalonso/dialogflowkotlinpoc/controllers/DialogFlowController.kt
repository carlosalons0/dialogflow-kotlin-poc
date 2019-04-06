package carlosalonso.dialogflowkotlinpoc.controllers

import carlosalonso.dialogflowkotlinpoc.services.WebhookHandler
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2WebhookRequest
import com.google.api.services.dialogflow.v2.model.GoogleCloudDialogflowV2WebhookResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping
class DialogFlowController {
    @Autowired
    private lateinit var webhookHandler: WebhookHandler

    @Autowired
    private lateinit var jacksonFactory: JacksonFactory


    @PostMapping("/webhook", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun webhook(req: HttpServletRequest):GoogleCloudDialogflowV2WebhookResponse {

       val request:  GoogleCloudDialogflowV2WebhookRequest = jacksonFactory.createJsonParser(req.reader)
                .parse(GoogleCloudDialogflowV2WebhookRequest::class.java)


        return webhookHandler.handleRequest(request)
    }
}