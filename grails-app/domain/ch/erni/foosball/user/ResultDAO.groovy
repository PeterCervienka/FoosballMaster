package ch.erni.foosball.user

import grails.validation.Validateable

@Validateable
class ResultDAO {

    static constraints = {
        resultTeam1(min: 0, max: 8)
        resultTeam2(min: 0, max: 8)
        duration(min: 1, max: 60)
        gameOrder(min: 1, max: 3)
    }

    private Long id;
    private int resultTeam1;
    private int resultTeam2;
    private int duration;
    private int gameOrder = 1;

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    int getResultTeam1() {
        return resultTeam1
    }

    void setResultTeam1(int resultTeam1) {
        this.resultTeam1 = resultTeam1
    }

    int getResultTeam2() {
        return resultTeam2
    }

    void setResultTeam2(int resultTeam2) {
        this.resultTeam2 = resultTeam2
    }

    int getDuration() {
        return duration
    }

    void setDuration(int duration) {
        this.duration = duration
    }

    int getGameOrder() {
        return gameOrder
    }

    void setGameOrder(int gameOrder) {
        this.gameOrder = gameOrder
    }
}
