package com.carintelligence.repository;

import com.carintelligence.model.Coordinate;
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
 * @date 22/3/17
 */
@Repository("coordinateRepository")
public class CoordinateRepositoryImpl implements CoordinateRepository {
    @PersistenceContext
    private EntityManager em;


    public Coordinate find(Long coordinateId)
    {
        // Returns the Coordinate for given coordinateId.
        return em.find(Coordinate.class, coordinateId);
    }


    public Coordinate save(Coordinate coordinate)
    {
        // Saves the given coordinate object and returns the same.
        em.persist(coordinate);
        em.flush();
        return coordinate;
    }


    @Override
    public List<Coordinate> findAll()
    {
        // Returns all the coordinates in our system.
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Coordinate> q = cb.createQuery(Coordinate.class);
        Root<Coordinate> c = q.from(Coordinate.class);
        q.select(c);
        TypedQuery<Coordinate> query = em.createQuery(q);
        return query.getResultList();
    }


    @Override
    public List<Coordinate> paginate(int offset, int limit)
    {
        // Returns the list of paginated coordinates.
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Coordinate> q = cb.createQuery(Coordinate.class);
        Root<Coordinate> c = q.from(Coordinate.class);
        q.select(c);
        TypedQuery<Coordinate> query = em.createQuery(q);
        return query.setFirstResult(offset).setMaxResults(limit).getResultList();
    }


    @Override
    public Coordinate update(Coordinate coordinate, Long coordinateId)
    {
        // Updates the given coordinate with new data.
        coordinate.setCoordinateId(coordinateId);
        Coordinate updatedCoordinate = em.merge(coordinate);
        em.flush();
        return updatedCoordinate;
    }


    @Override
    public Coordinate delete(Long coordinateId)
    {
        // Deletes the coordinate with the given coordinateId.
        Coordinate coordinateToBeDeleted = em.find(Coordinate.class, coordinateId);
        if(coordinateToBeDeleted!=null)
            em.remove(coordinateToBeDeleted);
        return coordinateToBeDeleted;
    }
}
