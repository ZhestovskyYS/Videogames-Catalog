package data

data class Genre(
    val name: String
)

fun genreList() =
    arrayOf(
        Genre("Action/RPG"),
        Genre("Racing simulator"),
        Genre("Open World Survival Craft"),
        Genre("Real-Time Strategy"),
        Genre("Turn-Based Strategy"),
        Genre("Stealth Action"),
        Genre("Action-adventure"),
        Genre("Looter shooter")
    )