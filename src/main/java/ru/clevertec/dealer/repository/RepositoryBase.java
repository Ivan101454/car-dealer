package ru.clevertec.dealer.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import ru.clevertec.dealer.entity.Car;

import java.util.List;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public abstract class RepositoryBase<K, E> implements Repository<K, E> {

    private final Class<E> clazz;

    private final Session session;

    @Override
    public E save(E entity) {
        session.persist(entity);
        return entity;
    }

    @Override
    public void delete(K id) {
        session.remove(id);
        session.flush();
    }

    @Override
    public void update(E entity) {
        session.merge(entity);
    }

    @Override
    public Optional<E> finById(K id) {
        return Optional.ofNullable(session.find(clazz, id));
    }

    @Override
    public List<E> findAll() {
        var criteria = session.getCriteriaBuilder().createQuery(clazz);
        criteria.from(clazz);
        return session.createQuery(criteria).getResultList();
    }

}
