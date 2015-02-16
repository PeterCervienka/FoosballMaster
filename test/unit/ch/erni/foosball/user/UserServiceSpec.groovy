package ch.erni.foosball.user

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.validation.ValidationException
import org.junit.Test
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
@Mock(UserDAO)
class UserServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Test
    void testService() {
        expect: (service != null);
    }

    @Test
    void testSaveAction() {
        UserDAO u = new UserDAO(name: "Erni", surname: "Consulting")

        int countBefore = service.count();

        service.save(u);

        int countAfter = service.count();

        expect: (countAfter > countBefore);
        and: (countAfter == countBefore + 1);
    }

    @Test
    void testUserValidation1() {

        setup:
        UserDAO u = new UserDAO(name: "n", surname: "s")

        expect:
        !u.validate()
    }

    @Test
    void testUserValidation2() {
        setup:
        UserDAO u = new UserDAO(name: "Name", surname: "AbcdefGhijklmNOpQrstuvwXYzAbcdefGhijklmNOpQrstuvwXYzAbcdefGhijklmNOpQrstuvwXYz");

        expect:
        !u.validate()
    }

    @Test
    void testUserValidation3() {
        setup:
        UserDAO u = new UserDAO(name: "Name", surname: "Surname");

        expect:
        u.validate()
    }

    @Test
    void testUserValidation4() {

        setup:
        UserDAO u = new UserDAO(name: "n", surname: "s")

        when:
        service.save(u)

        then:
        thrown(ValidationException)
    }

}
