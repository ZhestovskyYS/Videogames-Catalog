package container

import component.GameListProps
import component.fGameList
import data.*
import hoc.withDisplayName
import org.w3c.dom.events.Event
import react.*
import react.redux.rConnect
import redux.*

interface GameListDispatchProps : RProps {
    var add: (Event) -> Unit
}

interface GameListStateProps : RProps {
    var games: Array<Game>
    var genres: Array<Genre>
}

val gameListHoc =
    rConnect<
            State,
            RAction,
            WrapperAction,
            RProps,
            GameListStateProps,
            GameListDispatchProps,
            GameListProps
            >(
        mapStateToProps = { state, _ ->
            games = state.games.values.toTypedArray()
            genres = state.genres.values.toTypedArray()
        },
        mapDispatchToProps = { dispatch, _ ->
            add = {dispatch(AddGame())}
        }
    )

val gameListRClass =
    withDisplayName(
        "GameList",
        fGameList
    )
        .unsafeCast<RClass<GameListProps>>()

val gameListContainer =
    gameListHoc(gameListRClass)