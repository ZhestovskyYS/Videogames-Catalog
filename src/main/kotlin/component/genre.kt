package component

import data.Genre
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import kotlin.browser.document

interface GenreProps : RProps {
    var genres: Map<Int,Genre>
    var delete: (Int) -> Unit
    var add: (Event) -> Unit
    var edit: (Int) -> Unit
}

val fGenre =
    functionalComponent<GenreProps> { props ->
        var currentId = 0
        h2 { +"Genres" }
        button (classes = "btn"){
            +"Add"
            attrs.onClickFunction = {
                val addWindow = document
                    .getElementById("addWindow") as HTMLElement
                addWindow.style.display = "block"
            }
        }
        table {
            attrs.id = "table"
            props.genres.map { genre ->
                tr {
                    td("bold") {
                        +genre.value.name
                    }
                    button(classes = "submit-btn") {
                        +"Delete"
                        attrs.onClickFunction = {
                            props.delete(genre.key)
                        }
                    }
                    button(classes = "submit-btn"){
                        +"Edit"
                        attrs.onClickFunction = {
                            val editWindow = document
                                .getElementById("editWindow") as HTMLElement
                            editWindow.style.display = "block"
                            currentId = genre.key
                        }
                    }
                }
            }
        }
        div("window") {
            attrs.id = "addWindow"
            div("window-content") {
                h1("window-h1"){+"Add Genre"}
                ul{
                    li{
                        +"Name of Genre"
                        input(InputType.text){
                            attrs.id = "newGenre"
                        }
                    }
                    button(classes = "submit-btn") {
                        +"Add"
                        attrs.onClickFunction = props.add
                    }
                    button(classes = "submit-btn") {
                        +"Close"
                        attrs.onClickFunction = {
                            val newGenre = document
                                .getElementById("newGenre") as HTMLInputElement
                            newGenre.value =""
                            val addWindow = document
                                .getElementById("addWindow") as HTMLElement
                            addWindow.style.display = "none"
                        }
                    }
                }
            }
        }
        div("window"){
            attrs.id = "editWindow"
            div("window-content") {
                h1("window-h1"){+"Edit Genre"}
                ul{
                    li{
                        +"Name of genre"
                        input(InputType.text) {
                            attrs.id = "eGenre"/*
                            attrs.placeholder = props.genres.getValue(currentId).name*/
                        }
                        button(classes = "submit-btn") {
                            +"Edit"
                            attrs.onClickFunction = {props.edit(currentId)}
                        }
                        button(classes = "submit-btn") {
                            +"Close"
                            attrs.onClickFunction ={
                                val editWindow = document
                                    .getElementById("editWindow") as HTMLElement
                                val eGenre = document
                                    .getElementById("eGenre") as HTMLInputElement
                                editWindow.style.display = "none"
                                eGenre.value = ""
                            }
                        }
                    }
                }
            }
        }
    }
