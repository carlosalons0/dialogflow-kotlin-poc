package carlosalonso.dialogflowkotlinpoc.repositories.model

class WeatherResult {
    class Main {
        var temp: Double? = null
        var pressure: Int? = null
        var humidity: Int? = null
        var tempMin: Double? = null
        var tempMax: Double? = null
    }

    class Coord {
        var lon: Double? = null
        var lat: Double? = null
    }

    class Clouds {
        var all: Int? = null
    }

    class Sys {
        var type: Int? = null
        var id: Int? = null
        var message: Double? = null
        var country: String? = null
        var sunrise: Int? = null
        var sunset: Int? = null
    }

    class Weather {
        var id: Int? = null
        var main: String? = null
        var description: String? = null
        var icon: String? = null
    }

    class Wind {
        var speed: Double? = null
        var deg: Int? = null
    }

    var coord: Coord? = null
    var weather: List<Weather>? = null
    var base: String? = null
    var main: Main? = null
    var visibility: Int? = null
    var wind: Wind? = null
    var clouds: Clouds? = null
    var dt: Int? = null
    var sys: Sys? = null
    var id: Int? = null
    var name: String? = null
    var cod: Int? = null
}





