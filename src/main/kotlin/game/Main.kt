package game

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

fun main() {
    val app = Javalin.create { config ->
        config.defaultContentType = "application/json"
        config.enableCorsForAllOrigins()
    }.routes {
        path("games") {
            get(GameController::getAll)
            post(GameController::create)
            path(":game-id") {
                get(GameController::get)
                put(GameController::update)
                delete(GameController::delete)
            }
        }
        path("time") {
            get(TimeController::time)
        }
    }

    app.start(8081)
}
