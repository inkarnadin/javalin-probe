package game

import io.javalin.http.Context
import java.util.*

object GameController {

    private data class Game(val name: String, val genre: String, val rate: Double)

    private val games = hashMapOf(
        generateId() to Game(name = "Crysis 3", genre = "FPS", rate = 75.9),
        generateId() to Game(name = "Witcher", genre = "RPG", rate = 79.2),
        generateId() to Game(name = "Fallout 2", genre = "RPG", rate = 97.7),
        generateId() to Game(name = "Subnautica", genre = "Sandbox/Survival", rate = 92.5)
    )

    private fun generateId() = UUID.randomUUID().toString()

    fun getAll(ctx: Context) {
        ctx.json(games)
    }

    fun create(ctx: Context) {
        games[generateId()] = ctx.status(201).body<Game>()
    }

    fun update(ctx: Context) {
        games[ctx.pathParam(":game-id")] = ctx.status(201).body<Game>()
    }

    fun get(ctx: Context) {
        ctx.json(games[ctx.pathParam(":game-id")]!!).status(200)
    }

    fun delete(ctx: Context) {
        games.remove(ctx.pathParam(":game-id"))
    }

}