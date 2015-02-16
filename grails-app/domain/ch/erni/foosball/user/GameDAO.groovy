package ch.erni.foosball.user

import grails.validation.Validateable

@Validateable
class GameDAO {

    static constraints = {
        name(nullable: true, blank: true, size: 0..30)
        dateAndTime(nullable: false, blank: false)
    }

    static hasMany = [users: UserDAO, results: ResultDAO]

    private Long id;
    private String name;
    private Date dateAndTime = new Date();

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

    Date getDateAndTime() {
        return dateAndTime
    }

    void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime
    }

    void addResult(ResultDAO result) {
        if (this.results == null) {
            this.results = new HashSet<>();
        }

        this.results.add(result);
    }

    void addUser(UserDAO user) {
        if (this.users == null) {
            this.users = new HashSet<>();
        }

        this.users.add(user);
    }
}
