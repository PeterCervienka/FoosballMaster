package ch.erni.foosball.user

import grails.transaction.Transactional

@Transactional
class UserService implements IBaseService<UserDAO> {

    @Override
    List<UserDAO> getAll() {
        return UserDAO.list();
    }

    @Override
    UserDAO get(Long id) {
        if (id == null) return null;
        return UserDAO.load(id);
    }

    @Override
    UserDAO save(UserDAO obj) {
        if (obj != null) {
            return obj.save()
        }
        return null;
    }

    @Override
    void remove(UserDAO obj) {
        if (obj != null) {
            obj.delete()
        }
    }

    @Override
    int count() {
        return UserDAO.count();
    }
}
