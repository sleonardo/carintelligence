package com.carintelligence.service;

import com.carintelligence.model.Coordinate;
import com.carintelligence.model.Segment;
import com.carintelligence.repository.SegmentRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @author leonardo
 * @project carintelligence
 * @date 22/3/17
 */
@Service("segmentService")
public class SegmentServiceImpl implements SegmentService {
    @Autowired
    private SegmentRepository segmentRepository;
    @Autowired
    private CoordinateService coordinateService;

    public Segment find(Long segmentId)
    {
        // Returns the Segment for given segmentId.
        return segmentRepository.find(segmentId);
    }


    @Transactional
    public Segment save(Segment segment)
    {
        // Saves the given segment object and returns the same.
        try {
            Segment newSegment = segmentRepository.save(segment);
            if(newSegment!=null){
                Set<Coordinate> coordinateSet = newSegment.getCoordinates();
                if(coordinateSet.size()>0){
                    for (Coordinate coordinate : coordinateSet) {
                        coordinate.setSegment(new Segment(newSegment.getSegmentId()));
                        coordinateService.save(coordinate);
                    }
                }
            }
        } catch (HibernateException e) {
            throw (e);
        }
        return segment;
    }


    @Override
    public List<Segment> findAll()
    {
        // Returns all the segments in our system.
        return segmentRepository.findAll();
    }


    @Transactional
    public Segment update(Segment segment, Long segmentId)
    {
        // Updates the segment with the given segmentId;
        return segmentRepository.update(segment, segmentId);
    }


    @Transactional
    public Segment delete(Long segmentId)
    {
        // Deletes the segment with the give segmentId and returns the same.
        return segmentRepository.delete(segmentId);
    }


    @Override
    public List<Segment> paginate(int offset, int limit)
    {
        // Paginates the segments objects.
        return segmentRepository.paginate(offset, limit);
    }
}
