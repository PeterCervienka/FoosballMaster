package ch.erni.foosball.user

import grails.validation.Validateable

@Validateable
class UserDAO {

    static constraints = {
        name(nullable: false, blank: false, size: 2..20)
        surname(nullable: false, blank: false, size: 2..50)
    }

    static hasMany = [games: GameDAO]

    static belongsTo = GameDAO

    private Long id;
    private String name;
    private String surname;

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getSurname() {
        return surname
    }

    void setSurname(String surname) {
        this.surname = surname
    }

    String getCode() {
        String result = "";
        if (getSurname() != null && getSurname().length() > 1) {
            result = StringUtils.deAccent(getSurname().substring(0, 2));
        }

        if (getName() != null && getName().length() > 1) {
            result += StringUtils.deAccent(getName().substring(0, 2));
        }

        return result.toLowerCase();
    }

    void addGame(GameDAO game) {
        if (this.games == null) {
            this.games = new HashSet();
        }

        this.games.add(game)
    }
}
