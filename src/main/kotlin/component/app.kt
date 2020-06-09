package component

import container.gamePageContainer
import container.gameListContainer
import container.genreContainer
import data.Game
import data.Genre
import react.*
import react.dom.*
import react.router.dom.*

interface AppProps : RProps {
    var games: Map<Int, Game>
    var genres: Map<Int, Genre>
}

interface RouteNumberResult : RProps {
    var number: String
}

fun fApp() =
    functionalComponent<AppProps> { props ->
        div("home") {
            div {
                ul {
                    li { navLink("/games") { +"Game List" } }
                    li { navLink("/genres") { +"Genres" } }
                    li { navLink("/possessed_games") { +"Possessed games" } }
                }
            }
        }
        switch {
            route("/games",
                exact = true,
                render = { gameListContainer {} }
            )
            route("/games/:number",
                exact = true,
                render = renderObject(
                    { props.games[it] },
                    { index, _ ->
                        gamePageContainer {
                            attrs.index = index
                        }
                    }
                )
            )
            route("/possessed_games",
                exact = true,
                render = { possessedGames(props.games) }
            )
            route("/genres",
                exact = true,
                render = { genreContainer{}}
            )
        }
    }

fun <O> RBuilder.renderObject(
    selector: (Int) -> O?,
    rElement: (Int, O) -> ReactElement
) =
    { route_props: RouteResultProps<RouteNumberResult> ->
        val num = route_props.match.params.number.toIntOrNull() ?: -1
        val obj = selector(num)
        if (obj != null) {
            rElement(num, obj)
        } else
            p { +"Object not found" }
    }

