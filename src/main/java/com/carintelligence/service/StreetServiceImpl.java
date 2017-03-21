package com.carintelligence.service;

import com.carintelligence.model.Street;
import com.carintelligence.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author leonardo
 * @project carintelligence
 * @date 20/3/17
 */
@Service("streetService")
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetRepository streetRepository;


    public Street find(Long streetId)
    {
        // Returns the Street for given streetId.
        return streetRepository.find(streetId);
    }


    @Transactional
    public Street save(Street street)
    {
        // Saves the given street object and returns the same.
        streetRepository.save(street);
        return street;
    }


    @Override
    public List<Street> findAll()
    {
        // Returns all the streets in our system.
        return streetRepository.findAll();
    }


    @Transactional
    public Street update(Street street, Long streetId)
    {
        // Updates the street with the given streetId;
        return streetRepository.update(street, streetId);
    }


    @Transactional
    public Street delete(Long streetId)
    {
        // Deletes the street with the give streetId and returns the same.
        return streetRepository.delete(streetId);
    }


    @Override
    public List<Street> paginate(int offset, int limit)
    {
        // Paginates the streets objects. 
        return streetRepository.paginate(offset, limit);
    }
}
