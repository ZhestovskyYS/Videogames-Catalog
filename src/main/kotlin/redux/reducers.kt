package redux

import data.State
import data.*
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLSelectElement
import kotlin.browser.document

fun editReducer(state: State, action: RAction) =
    when(action) {
        is EditGame ->{
            val editWindow = document.getElementById("editWindow") as HTMLElement
            val eName = document.getElementById("eName") as HTMLInputElement
            val eGenre = document.getElementById("eGenre") as HTMLSelectElement
            val eReleseYear = document.getElementById("eReleseYear") as HTMLInputElement
            val eStudio = document.getElementById("eStudio") as HTMLInputElement
            val eLogo = document.getElementById("eLogo") as HTMLInputElement
            val eCost = document.getElementById("eCost") as HTMLInputElement
            val eMetacritic = document.getElementById("eMetacritic") as HTMLInputElement
            val editGame = Game(
                if(eName.value == "") "no name" else eName.value,
                eLogo.value,
                eGenre.value,
                eStudio.value,
                if(eReleseYear.value == "") 0 else eReleseYear.value.toInt(),
                if(eCost.value =="") 0 else eCost.value.toInt(),
                if(eMetacritic.value =="") 0 else eMetacritic.value.toInt(),
                state.games.getValue(action.id).possess
            )
            editWindow.style.display ="none"
            State(
                state.games.toMutableMap()
                    .apply { this[action.id] = editGame },
                state.genres
            )
        }
        is EditGenre -> {
            val editWindow = document.getElementById("editWindow") as HTMLElement
            val eGenre = document.getElementById("eGenre") as HTMLInputElement
            val editGenre = Genre(if(eGenre.value == "") "no name" else eGenre.value)
            editWindow.style.display = "none"
            eGenre.value=""
            State(
                state.games,
                state.genres.toMutableMap()
                    .apply { this[action.id] = editGenre }
            )
        }
        else -> state
    }

fun deleteReducer(state: State, action: RAction) =
    when (action) {
        is DeleteGame -> State(
            state.games.minus(action.id),
            state.genres
        )
        is DeleteGenre -> State(
            state.games,
            state.genres.minus(action.id))
        else -> state
    }


fun addReducer(state: State, action: RAction, newId: Int = -1) =
    when (action) {
        is AddGame -> {
            val addWindow = document.getElementById("addWindow") as HTMLElement
            val name = document.getElementById("name") as HTMLInputElement
            val genre = document.getElementById("genreType") as HTMLSelectElement
            val releaseYear = document.getElementById("release_year") as HTMLInputElement
            val studio = document.getElementById("studio") as HTMLInputElement
            val logo = document.getElementById("logo") as HTMLInputElement
            val cost = document.getElementById("cost") as HTMLInputElement
            val metacrtitic = document.getElementById("meta") as HTMLInputElement
            val newGame = Game(
                if(name.value == "") "no name" else name.value,
                logo.value,
                genre.value,
                studio.value,
                if(releaseYear.value == "") 0 else releaseYear.value.toInt(),
                if(cost.value=="") 0 else cost.value.toInt(),
                if(metacrtitic.value=="") 0 else metacrtitic.value.toInt(),
                false
            )
            addWindow.style.display = "none"
            name.value = ""
            releaseYear.value = ""
            studio.value = ""
            logo.value = ""
            cost.value = ""
            metacrtitic.value = ""

            State(
                state.games.plus(newId to newGame),
                state.genres
            )

        }
        is AddToPossessed -> {
            State(
                state.games.apply {
                    state.games.getValue(action.index).possess = true
                },
                state.genres
            )
        }
        is AddGenre ->{
            val addWindow = document.getElementById("addWindow") as HTMLElement
            val nGenre = document.getElementById("newGenre") as HTMLInputElement
            val newGenre = Genre(if(nGenre.value == "") "no name" else nGenre.value)
            addWindow.style.display = "none"
            nGenre.value =""
            State(
                state.games,
                state.genres.plus( newId to newGenre)
            )
        }
        else -> state
    }

fun rootReducer(state: State, action: RAction) =
    when (action) {
        is AddGame -> {
            val id = state.games.newId()
            addReducer(state, action, id)}
        is AddGenre -> {
            val id = state.genres.newId()
            addReducer(state,action,id)
        }
        is AddToPossessed -> addReducer(state, action)
        is DeleteGenre -> deleteReducer(state, action)
        is DeleteGame -> deleteReducer(state, action)
        is EditGame -> editReducer(state, action)
        is EditGenre -> editReducer(state, action)
        else -> state
    }
