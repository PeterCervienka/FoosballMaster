package ch.erni.foosball.user

class GameController {

    def gameService

    def index() {
        def list =  gameService.getAll().sort({ it.dateAndTime }).reverse()

        def map = [items : list]

        render(view: "index", model: map)
    }

    def actionShowDetail() {

        GameDAO g = null

        if (params.id != null && params.id > 0) {
            g = gameService.get(params.getLong("id"));
        }

        render(view: 'detail', model: [gameObj: g]);
    }

    def save() {

        GameDAO game

        if (params.id != null && params.getLong("id") > 0) {
            game = gameService.get(params.getLong("id"))
        } else {
            game = new GameDAO()
        }

        if (game != null) {
            game.name = params.name
            game.dateAndTime = params.dateAndTime

            if (game.validate()) {
                gameService.save(game);
            } else {
                render(view: 'detail', model: [gameObj: game])
                return
            }
        }

        redirect(view: "index")
    }
}
