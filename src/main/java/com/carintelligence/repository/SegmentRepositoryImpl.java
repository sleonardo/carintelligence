package com.carintelligence.repository;

import com.carintelligence.model.Segment;
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
 * @date 21/3/17
 */
@Repository("segmentRepository")
public class SegmentRepositoryImpl implements SegmentRepository {
    @PersistenceContext
    private EntityManager em;


    public Segment find(Long segmentId)
    {
        // Returns the Segment for given segmentId.
        return em.find(Segment.class, segmentId);
    }


    public Segment save(Segment segment)
    {
        // Saves the given segment object and returns the same.
        em.persist(segment);
        em.flush();
        return segment;
    }


    @Override
    public List<Segment> findAll()
    {
        // Returns all the segments in our system.
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Segment> q = cb.createQuery(Segment.class);
        Root<Segment> c = q.from(Segment.class);
        q.select(c);
        TypedQuery<Segment> query = em.createQuery(q);
        return query.getResultList();
    }


    @Override
    public List<Segment> paginate(int offset, int limit)
    {
        // Returns the list of paginated segments.
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Segment> q = cb.createQuery(Segment.class);
        Root<Segment> c = q.from(Segment.class);
        q.select(c);
        TypedQuery<Segment> query = em.createQuery(q);
        return query.setFirstResult(offset).setMaxResults(limit).getResultList();
    }


    @Override
    public Segment update(Segment segment, Long segmentId)
    {
        // Updates the given segment with new data.
        segment.setSegmentId(segmentId);
        Segment updatedSegment = em.merge(segment);
        em.flush();
        return updatedSegment;
    }


    @Override
    public Segment delete(Long segmentId)
    {
        // Deletes the segment with the given segmentId.
        Segment segmentToBeDeleted = em.find(Segment.class, segmentId);
        em.remove(segmentToBeDeleted);
        return segmentToBeDeleted;
    }
}
