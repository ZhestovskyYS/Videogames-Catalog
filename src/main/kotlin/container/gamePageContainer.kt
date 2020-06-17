package container

import component.GamePageProps
import component.fGamePage
import data.*
import hoc.withDisplayName
import org.w3c.dom.events.Event
import react.*
import react.redux.rConnect
import redux.*

interface GamePageDispatchProps : RProps {
    var add: (Int)->(Event) -> Unit
    var delete: (Int) -> Unit
    var edit: (Int) -> Unit
}

interface GamePageStateProps: RProps {
    var games: Array<Game>
    var genres: Array<Genre>
}

interface GamePageOwnProps : RProps {
    var index: Int
}

val gamePageHoc =
    rConnect<
            State,
            RAction,
            WrapperAction,
            GamePageOwnProps,
            GamePageStateProps,
            GamePageDispatchProps,
            GamePageProps
            >(
        mapStateToProps = { state, _ ->
            games = state.games.values.toTypedArray()
            genres = state.genres.values.toTypedArray()
        },
        mapDispatchToProps = { dispatch, _ ->
            add =
                { index ->
                    {
                        dispatch(AddToPossessed(index))
                    }
                }
            delete = {dispatch(DeleteGame(it))}
            edit = {dispatch(EditGame(it))}
        }
    )

val gamePageRClass =
    withDisplayName(
        "GamePage",
        fGamePage
    )
        .unsafeCast<RClass<GamePageProps>>()

val gamePageContainer =
    gamePageHoc(gamePageRClass)
