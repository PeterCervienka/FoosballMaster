package ch.erni.foosball.user

class UserController {

    def userService

    def index() {
        // add array to controller. Without this, i cant use this array in view
        def list =  userService.getAll().sort({ it.id }).reverse()

        def map = [items : list]

        render(view: 'index', model: map)
    }

    def actionShowDetail() {

        UserDAO u = null

        if (params.id != null && params.id > 0) {
            u = userService.get(params.getLong("id"));
        }

        render(view: 'detail', model: [userObj: u]);
    }

    def save() {

        UserDAO user

        if (params.id != null && params.getLong("id") > 0) {
            user = userService.get(params.getLong("id"))
        } else {
            user = new UserDAO()
        }

        if (user != null) {
            user.name = params.name
            user.surname = params.surname
            user.email = params.email

            if (user.validate()) {
                def s = userService.save(user);
                s.toString();
            } else {
                render(view: 'detail', model: [userObj: user])
                return
            }
        }

        redirect(view: "index")
    }

    def actionRemoveDetail() {

        def item = userService.get(params.getLong("id"));
        if (item != null) {
            userService.remove(item);
        }

        def map = [items : userService.getAll().sort({ it.id }).reverse()];
        render(template: 'userTable', model: map)


    }

    def charts() {

    }
}
