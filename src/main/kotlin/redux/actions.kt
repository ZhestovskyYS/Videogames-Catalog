package redux

class AddGame: RAction
class AddGenre: RAction
class AddToPossessed(val id:Int): RAction
class DeleteGame(val id: Int): RAction
class DeleteGenre(val id: Int): RAction
class EditGenre(val id: Int): RAction
class EditGame(val id: Int): RAction
