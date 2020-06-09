package container

import component.GenreProps
import component.fGenre
import data.*
import hoc.withDisplayName
import org.w3c.dom.events.Event
import react.*
import react.redux.rConnect
import redux.*

interface GenreStateProps: RProps {
    var genres: Map<Int,Genre>
}

interface GenreDispatchProps: RProps{
    var delete: (Int) -> Unit
    var add: (Event) -> Unit
    var edit: (Int) -> Unit
}

val fGenreHOC =
    rConnect<
            State,
            RAction,
            WrapperAction,
            RProps,
            GenreStateProps,
            GenreDispatchProps,
            GenreProps
            >(
        mapStateToProps = { state, _ ->
            genres = state.genres
        },
        mapDispatchToProps = {dispatch, _ ->
            add = {dispatch(AddGenre())}
            delete = {dispatch(DeleteGenre(it))}
            edit =  {dispatch(EditGenre(it))}
        }
    )

val genreRClass =
    withDisplayName(
        "Genres",
        fGenre
    )
        .unsafeCast<RClass<GenreProps>>()

val genreContainer =
    fGenreHOC(genreRClass)