package component

import data.Game
import react.*
import hoc.withDisplayName
import react.dom.*
import react.router.dom.navLink

interface GameProps : RProps {
    var game: Game
    var index: Int
}

val fGame =
    functionalComponent<GameProps> {
        tr {
            td {  navLink("/games/${it.index}") {+it.game.name } }
            td { +"${it.game.releaseYear}" }
            td { +it.game.studio }
        }
    }

fun RBuilder.game(
    game: Game,
    index: Int
) = child(
    withDisplayName("Game", fGame)
) {
    attrs.game = game
    attrs.index = index
}