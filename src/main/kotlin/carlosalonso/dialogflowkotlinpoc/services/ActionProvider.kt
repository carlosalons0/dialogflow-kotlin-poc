package carlosalonso.dialogflowkotlinpoc.services


import carlosalonso.dialogflowkotlinpoc.services.actions.Action
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service


@Service
class ActionProvider @Autowired constructor(context: ApplicationContext) {
    companion object {
        private val log = LoggerFactory.getLogger(ActionProvider::class.java)
    }

    private final val actionBeans: Map<String, Action> = context.getBeansOfType(Action::class.java)

    fun resolve(name: String) : Action? {
        val action = actionBeans[name]

        if (action != null) {
            log.debug("$name => ${action::class.simpleName}")
        } else {
            log.warn("$name => not resolved")
        }
        return action
    }
}