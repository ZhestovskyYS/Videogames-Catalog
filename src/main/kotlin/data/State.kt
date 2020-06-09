package data

class State(
    val games: Map<Int, Game>,
    val genres: Map<Int, Genre>
)

fun <T> Map<Int, T>.newId() =
    (this.maxBy { it.key }?.key ?: 0) +1

fun initialState() =
    State(
        gameList().mapIndexed{ index, game ->
            index to game
        }.toMap(),
        genreList().mapIndexed{ index, genre ->
            index to genre
        }.toMap()
    )


