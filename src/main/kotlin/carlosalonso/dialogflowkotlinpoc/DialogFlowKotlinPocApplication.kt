package carlosalonso.dialogflowkotlinpoc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import com.google.api.client.json.jackson2.JacksonFactory



@SpringBootApplication
class DialogFlowKotlinPocApplication {
	@Bean
	fun getRestTemplate() = RestTemplate()

	@Bean
	fun jacksonFactory(): JacksonFactory = JacksonFactory.getDefaultInstance()
}

fun main(args: Array<String>) {
	runApplication<DialogFlowKotlinPocApplication>(*args)
}
