package component

import data.Game
import data.Genre
import react.*
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import react.dom.*
import kotlin.browser.document
import kotlin.browser.window

interface GamePageProps : RProps {
    var index: Int
    var games: Array<Game>
    var genres: Array<Genre>
    var add: (Int) -> (Event) -> (Unit)
    var delete: (Int) -> Unit
    var edit: (Int) -> Unit
}

val fGamePage =
    functionalComponent<GamePageProps> { props ->
        div("card") {
            img(classes = "pic") {
                attrs.src = props.games[props.index].logo
                attrs.alt = "Wrong url to picture"
            }
            div("container") {
                h4 { +props.games[props.index].name }
                p { +"Genre: ${props.games[props.index].genre}" }
                p { +"Release year: ${props.games[props.index].releaseYear}" }
                p { +"Studio: ${props.games[props.index].studio}" }
                p { +"Metacritic rating: ${props.games[props.index].metacritic}%" }
                p { +"Cost: ${props.games[props.index].cost}(rub.)" }
                if (!props.games[props.index].possess) {
                    button(classes = "btn") {
                        +"Add to possessed list"
                        attrs.onClickFunction = props.add(props.index)
                    }
                } else {
                    p { +"You possesse it" }
                }
                p {
                    button(classes = "btn") {
                        +"Delete"
                        attrs.onClickFunction = {
                            props.delete(props.index)
                            window.history.back()
                        }
                    }
                }
                p{
                    button(classes = "btn") {
                        +"Edit"
                        attrs.onClickFunction = {
                            val editWindow = document
                                .getElementById("editWindow") as HTMLElement
                            editWindow.style.display = "block"
                        }
                    }
                }
            }
        }
        div("window") {
            attrs.id = "editWindow"
            div("window-content") {
                h1("window-h1") { +"Edit game" }
                ul {
                    li {
                        +"Name"
                        input(InputType.text) {
                            attrs.id = "eName"
                            attrs.defaultValue = props.games[props.index].name
                            attrs.placeholder = props.games[props.index].name
                        }
                    }
                    li {
                        +"Genre"
                        select {
                            for (element in props.genres) {
                                attrs.id = "eGenre"
                                option {
                                    +element.name
                                }
                            }
                        }
                    }
                    li {
                        +"Release year"
                        input(InputType.text) {
                            attrs.id = "eReleseYear"
                            attrs.defaultValue = props.games[props.index].releaseYear.toString()
                            attrs.placeholder = props.games[props.index].releaseYear.toString()
                        }
                    }
                    li {
                        +"Studio"
                        input(InputType.text) {
                            attrs.id = "eStudio"
                            attrs.placeholder = props.games[props.index].studio
                            attrs.defaultValue = props.games[props.index].studio
                        }
                    }
                    li {
                        +"Logo (link of picture)"
                        input(InputType.text) {
                            attrs.id = "eLogo"
                            attrs.defaultValue = props.games[props.index].logo
                            attrs.placeholder = props.games[props.index].logo
                        }
                    }
                    li {
                        +"Cost"
                        input(InputType.text) {
                            attrs.id = "eCost"
                            attrs.placeholder = props.games[props.index].cost.toString()
                            attrs.defaultValue = props.games[props.index].cost.toString()
                        }
                    }
                    li {
                        +"Metacritic rating"
                        input(InputType.text) {
                            attrs.id = "eMetacritic"
                            attrs.placeholder = props.games[props.index].metacritic.toString()
                            attrs.defaultValue = props.games[props.index].metacritic.toString()
                        }
                    }
                    button(classes = "submit-btn"){
                        +"Edit"
                        attrs.onClickFunction = {props.edit(props.index)}
                    }
                    button(classes = "submit-btn"){
                        +"Close"
                        attrs.onClickFunction = {
                            val editWindow = document
                                .getElementById("editWindow") as HTMLElement
                            editWindow.style.display = "none"
                        }
                    }
                }
            }
        }
    }
