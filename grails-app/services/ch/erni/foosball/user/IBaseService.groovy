package ch.erni.foosball.user

/**
 * Created by cepe on 13.02.2015.
 */
interface IBaseService<E> {
    public List<E> getAll();

    public E get(Long id);

    public E save(E obj);

    public void remove(E obj);

    public int count();
}