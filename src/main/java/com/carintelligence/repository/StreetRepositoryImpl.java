package com.carintelligence.repository;

import com.carintelligence.model.Street;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author leonardo
 * @project carintelligence
 * @date 20/3/17
 */
@Repository("streetRepository")
public class StreetRepositoryImpl implements StreetRepository {
    @PersistenceContext
    private EntityManager em;


    public Street find(Long streetId)
    {
        // Returns the Street for given streetId.
        return em.find(Street.class, streetId);
    }


    public Street save(Street street)
    {
        // Saves the given street object and returns the same.
        em.persist(street);
        em.flush();
        return street;
    }


    @Override
    public List<Street> findAll()
    {
        // Returns all the streets in our system.
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Street> q = cb.createQuery(Street.class);
        Root<Street> c = q.from(Street.class);
        q.select(c);
        TypedQuery<Street> query = em.createQuery(q);
        return query.getResultList();
    }


    @Override
    public List<Street> paginate(int offset, int limit)
    {
        // Returns the list of paginated streets.
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Street> q = cb.createQuery(Street.class);
        Root<Street> c = q.from(Street.class);
        q.select(c);
        TypedQuery<Street> query = em.createQuery(q);
        return query.setFirstResult(offset).setMaxResults(limit).getResultList();
    }


    @Override
    public Street update(Street street, Long streetId)
    {
        // Updates the given street with new data.
        street.setStreetId(streetId);
        Street updatedStreet = em.merge(street);
        em.flush();
        return updatedStreet;
    }


    @Override
    public Street delete(Long streetId)
    {
        // Deletes the street with the given streetId.
        Street streetToBeDeleted = em.find(Street.class, streetId);
        em.remove(streetToBeDeleted);
        return streetToBeDeleted;
    }
}
