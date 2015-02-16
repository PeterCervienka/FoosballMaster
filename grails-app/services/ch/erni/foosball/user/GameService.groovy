package ch.erni.foosball.user

import grails.transaction.Transactional

@Transactional
class GameService implements IBaseService<GameDAO>{

    @Override
    List<GameDAO> getAll() {
        return GameDAO.list();
    }

    @Override
    GameDAO get(Long id) {
        if (id == null) return null;
        return GameDAO.load(id);
    }

    @Override
    GameDAO save(GameDAO obj) {
        if (obj != null) {
            return obj.save()
        }
        return null;
    }

    @Override
    void remove(GameDAO obj) {
        if (obj != null) {
            obj.delete()
        }
    }

    @Override
    int count() {
        return GameDAO.count();
    }
}
