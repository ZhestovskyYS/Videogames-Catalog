package component

import data.Game
import hoc.withDisplayName
import kotlinx.html.id
import react.*
import react.dom.*
import react.router.dom.navLink

interface PossessedGamesProps : RProps {
    var games: Map<Int,Game>
}

val fPossessedGames =
    functionalComponent<PossessedGamesProps> {
        h2 { +"Possessed games" }
        table {
            attrs.id = "table"
            tr {
                th { +"Name" }
                th { +"Release year" }
                th { +"Metacritic rating" }
            }
            it.games.map { game ->
                if (game.value.possess) {
                    tr {
                        td {navLink("/games/${game.key}") { +game.value.name }}
                        td { +"${game.value.releaseYear}" }
                        td { +"${game.value.metacritic}%" }
                    }
                }
            }
        }
    }

fun RBuilder.possessedGames(
    games: Map<Int,Game>
) = child(
    withDisplayName("Possessed Games", fPossessedGames)
) {
    attrs.games = games
}