package component

import data.Game
import data.Genre
import react.*
import org.w3c.dom.events.Event
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import react.dom.*
import kotlin.browser.document

interface GameListProps : RProps {
    var games: Array<Game>
    var genres: Array<Genre>
    var add: (Event) -> Unit
}

val fGameList =
    functionalComponent<GameListProps> {
        val (genre, currentGenre) = useState("Action/RPG")
        h2 { +"Games" }
        button(classes = "btn") {
            +"Add game"
            attrs.onClickFunction = {
                val addWindow = document.getElementById("addWindow") as HTMLElement
                addWindow.style.display = "block"
            }
        }
        select {
            for (element in it.genres) {
                attrs.id = "genre"
                option {
                    +element.name
                }
                attrs.onChangeFunction = {
                    val genres = document.getElementById("genre") as HTMLSelectElement
                    currentGenre(genres.value)
                }
            }
        }
        table {
            attrs.id = "table"
            tr {
                th { +"Name" }
                th { +"Release year" }
                th { +"Studio" }
            }
            it.games.mapIndexed { index, game ->
                if (game.genre == genre) {
                    game(game,index)
                }
            }
        }
        div("window") {
            attrs.id = "addWindow"
            div("window-content") {
                h1("window-h1") { +"Add game" }
                ul {
                    li {
                        +"Name"
                        input(InputType.text) {
                            attrs.id = "name"
                        }
                    }
                    li {
                        +"Genre"
                        select {
                            for (element in it.genres) {
                                attrs.id = "genreType"
                                option {
                                    +element.name
                                }
                            }
                        }
                    }
                    li {
                        +"Release year"
                        input(InputType.text) {
                            attrs.id = "release_year"
                        }
                    }
                    li {
                        +"Studio"
                        input(InputType.text) {
                            attrs.id = "studio"
                        }
                    }
                    li {
                        +"Logo (url of picture)"
                        input(InputType.text) {
                            attrs.id = "logo"
                        }
                    }
                    li {
                        +"Cost"
                        input(InputType.text) {
                            attrs.id = "cost"
                        }
                    }
                    li{
                        +"Metacritic rating"
                        input(InputType.text){
                            attrs.id = "meta"
                        }
                    }
                    button(classes = "submit-btn") {
                        +"Add"
                        attrs.onClickFunction = it.add
                    }
                    button(classes = "submit-btn") {
                        +"Close"
                            attrs.onClickFunction = {
                            val name = document.getElementById("name") as HTMLInputElement
                            name.value=""
                            val genreType = document.getElementById("genreType") as HTMLSelectElement
                            genreType.value=""
                            val releaseYear = document.getElementById("release_year") as HTMLInputElement
                            releaseYear.value=""
                            val studio = document.getElementById("studio") as HTMLInputElement
                            studio.value=""
                            val logo = document.getElementById("logo") as HTMLInputElement
                            logo.value=""
                            val cost = document.getElementById("cost") as HTMLInputElement
                            cost.value=""
                            val metaCrtitic = document.getElementById("meta") as HTMLInputElement
                            metaCrtitic.value = ""
                            val addWindow = document.getElementById("addWindow") as HTMLElement
                            addWindow.style.display = "none"

                        }
                    }
                }
            }
        }
    }
