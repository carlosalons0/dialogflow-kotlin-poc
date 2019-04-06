package carlosalonso.dialogflowkotlinpoc.services


import org.apache.commons.text.StringSubstitutor
import org.springframework.stereotype.Service


@Service
class TemplateProcessor {

    operator fun invoke(template: String, model: Map<String, String>): String {
        val stringSubstitutor = StringSubstitutor(model, "%", "%")
        return stringSubstitutor.replace(template)
    }
}