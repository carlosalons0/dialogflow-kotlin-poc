package carlosalonso.dialogflowkotlinpoc.repositories

import carlosalonso.dialogflowkotlinpoc.repositories.model.WeatherResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

@Repository
class WeatherRepository {
    @Autowired
    private lateinit var restTemplate: RestTemplate;

    @Value("\${OPENWEATHER_APPID}")
    private lateinit var appId: String

    fun getCurrentTemperature(location: String): Double {
        val parameters = mutableMapOf<String, String>()
        parameters.put("appId", appId)
        parameters.put("location", location)
        parameters.put("units","metric")

        val result = restTemplate.getForEntity("http://api.openweathermap.org/data/2.5/weather?appid={appId}&q={location}&units={units}", WeatherResult::class.java, parameters)

        return result.body?.main?.temp ?: 0.0
    }
}
