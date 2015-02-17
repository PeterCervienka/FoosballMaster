package ch.erni.foosball.user

import grails.validation.Validateable

@Validateable
class UserDAO {

    static constraints = {
        name(nullable: false, blank: false, size: 2..20)
        surname(nullable: false, blank: false, size: 2..50)
        email(nullable: false, blank: false, size: 4..50, email: true)
    }

    static mapping = {
        games cascade: 'delete'
    }

    static hasMany = [games: GameDAO]

    static belongsTo = GameDAO

    private Long id;
    private String name;
    private String surname;
    private String email;

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

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
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
