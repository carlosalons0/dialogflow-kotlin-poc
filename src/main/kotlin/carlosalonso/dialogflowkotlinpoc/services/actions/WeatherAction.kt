package carlosalonso.dialogflowkotlinpoc.services.actions

import carlosalonso.dialogflowkotlinpoc.domain.ActionResult
import carlosalonso.dialogflowkotlinpoc.repositories.WeatherRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service("weather")
class WeatherAction : Action {

    @Autowired
    private lateinit var weatherRepository: WeatherRepository

    override operator fun invoke(parameters: Map<String, Any>): ActionResult {
        return ActionResult().apply {
            this.model["temperature"] = weatherRepository.getCurrentTemperature(parameters.get("address").toString()).toString()
        }
    }
}