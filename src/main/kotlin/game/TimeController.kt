package game

import io.javalin.http.Context
import java.time.LocalDate

object TimeController {

    fun time(ctx: Context) {
        ctx.json(LocalDate.now()).status(200)
    }

}