package carlosalonso.dialogflowkotlinpoc.services.actions

import carlosalonso.dialogflowkotlinpoc.domain.ActionResult

interface Action {
    operator fun invoke(parameters: Map<String,Any>) : ActionResult
}