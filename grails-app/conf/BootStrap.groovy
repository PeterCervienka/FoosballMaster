import ch.erni.foosball.user.GameDAO
import ch.erni.foosball.user.ResultDAO
import ch.erni.foosball.user.UserDAO

class BootStrap {

    def userService
    def gameService

    def init = { servletContext ->

        UserDAO u1, u2, u3, u4, u5, u6;
        u1 = new UserDAO(name: "Peter", surname: "Červienka", email: "peter.cervienka@erni.sk");
        u2 = new UserDAO(name: "Erni", surname: "Consulting", email: "erni.consulting@erni.sk");
        u3 = new UserDAO(name: "Name 1", surname: "Surname 1", email: "name1.surname1@erni.sk");
        u4 = new UserDAO(name: "Name 2", surname: "Surname 2", email: "name2.surname2@erni.sk");
        u5 = new UserDAO(name: "Name 3", surname: "Surname 3", email: "name3.surname3@erni.sk");
        u6 = new UserDAO(name: "Name 4", surname: "Surname 4", email: "name4.surname4@erni.sk");

        userService.save(u1);
        userService.save(u2);
        userService.save(u3);
        userService.save(u4);
        userService.save(u5);
        userService.save(u6);

        GameDAO g1, g2, g3;
        if (gameService.count() == 0) {
            ResultDAO r1, r2, r3;
            Calendar c = Calendar.getInstance()
            c.time = new Date();

            r1 = new ResultDAO(resultTeam1: 3, resultTeam2: 8, gameOrder: 1, duration: 7);
            r2 = new ResultDAO(resultTeam1: 8, resultTeam2: 1, gameOrder: 2, duration: 9);
            r3 = new ResultDAO(resultTeam1: 7, resultTeam2: 8, gameOrder: 3, duration: 6);

            g1 = new GameDAO(dateAndTime: c.getTime(), name: "Abc Game");
            g1.addUser(u1);
            g1.addUser(u2);
            g1.addUser(u3);
            g1.addUser(u4);
            g1.addResult(r1);
            g1.addResult(r2);
            g1.addResult(r3);
            gameService.save(g1);

            r1 = new ResultDAO(resultTeam1: 8, resultTeam2: 5, gameOrder: 1, duration: 14);
            r2 = new ResultDAO(resultTeam1: 8, resultTeam2: 7, gameOrder: 2, duration: 15);
            c.set(Calendar.DAY_OF_MONTH, -2)
            g2 = new GameDAO(dateAndTime: c.getTime(), name: "Testing game");
            g2.addUser(u5);
            g2.addUser(u6);
            g2.addResult(r1);
            g2.addResult(r2);
            gameService.save(g2)

            r1 = new ResultDAO(resultTeam1: 0, resultTeam2: 8, gameOrder: 1, duration: 3);
            r2 = new ResultDAO(resultTeam1: 8, resultTeam2: 0, gameOrder: 2, duration: 5);
            r3 = new ResultDAO(resultTeam1: 0, resultTeam2: 8, gameOrder: 3, duration: 4);
            c.set(Calendar.DAY_OF_MONTH, -3)
            g3 = new GameDAO(dateAndTime: c.getTime(), name: "First Game");
            g3.addUser(u5);
            g3.addUser(u3);
            g3.addUser(u1);
            g3.addUser(u6);
            g3.addResult(r1);
            g3.addResult(r2);
            g3.addResult(r3);
            gameService.save(g3);

        }

    }
    def destroy = {
    }
}