package com.carintelligence.service;

import com.carintelligence.model.Coordinate;
import com.carintelligence.repository.CoordinateRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author leonardo
 * @project carintelligence
 * @date 22/3/17
 */
@Service("coordinateService")
public class CoordinateServiceImpl implements CoordinateService {
    @Autowired
    private CoordinateRepository coordinateRepository;


    public Coordinate find(Long coordinateId)
    {
        // Returns the Coordinate for given coordinateId.
        return coordinateRepository.find(coordinateId);
    }


    @Transactional
    public Coordinate save(Coordinate coordinate)
    {
        // Saves the given coordinate object and returns the same.
        try {
            coordinateRepository.save(coordinate);
        } catch (HibernateException e) {
            throw (e);
        }
        return coordinate;
    }


    @Override
    public List<Coordinate> findAll()
    {
        // Returns all the coordinates in our system.
        return coordinateRepository.findAll();
    }


    @Transactional
    public Coordinate update(Coordinate coordinate, Long coordinateId)
    {
        // Updates the coordinate with the given coordinateId;
        return coordinateRepository.update(coordinate, coordinateId);
    }


    @Transactional
    public Coordinate delete(Long coordinateId)
    {
        // Deletes the coordinate with the give coordinateId and returns the same.
        return coordinateRepository.delete(coordinateId);
    }


    @Override
    public List<Coordinate> paginate(int offset, int limit)
    {
        // Paginates the coordinates objects.
        return coordinateRepository.paginate(offset, limit);
    }
}
