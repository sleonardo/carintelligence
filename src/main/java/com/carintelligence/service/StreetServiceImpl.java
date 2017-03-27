package com.carintelligence.service;

import com.carintelligence.model.Coordinate;
import com.carintelligence.model.Rule;
import com.carintelligence.model.Segment;
import com.carintelligence.model.Street;
import com.carintelligence.repository.RuleRepository;
import com.carintelligence.repository.StreetRepository;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author leonardo
 * @project carintelligence
 * @date 20/3/17
 */
@Service("streetService")
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetRepository streetRepository;
    @Autowired
    private RuleRepository ruleRepository;
    @Autowired
    private SegmentService segmentService;

    public Street find(Long streetId)
    {
        // Returns the Street for given streetId.
        Street street = streetRepository.find(streetId);
        if (street!=null){
            Set<Segment> segmentSet = street.getSegments();
            Set<Rule> ruleSet = street.getRules();
            if(ruleSet.size()>0) {
                for (Rule rule : ruleSet) {
                    rule.setStreet(new Street(street.getStreetId()));
                }
            }
            if(segmentSet.size()>0){
                for (Segment segment : segmentSet) {
                    segment.setStreet(new Street(street.getStreetId()));
                    for (Coordinate coordinate : segment.getCoordinates()) {
                        coordinate.setSegment(new Segment(segment.getSegmentId()));
                    }
                }
            }
        }

        return street;
    }


    @Transactional
    public Street save(Street street)
    {
        // Saves the given street object and returns the same.
        try {
            Street newStreet = streetRepository.save(street);
            if (newStreet!=null){
                Set<Segment> segmentSet = newStreet.getSegments();
                Set<Rule> ruleSet = newStreet.getRules();
                if(ruleSet.size()>0) {
                    for (Rule rule : ruleSet) {
                        rule.setStreet(new Street(newStreet.getStreetId()));
                        ruleRepository.save(rule);
                    }
                }
                if(segmentSet.size()>0){
                    for (Segment segment : segmentSet) {
                        segment.setStreet(new Street(newStreet.getStreetId()));
                        segmentService.save(segment);
                    }
                }
            }
        } catch (HibernateException e) {
            throw (e);
        }
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
        List<Street> list = streetRepository.paginate(offset, limit);
        List<Street> listStreet = new ArrayList<>();
        if (list!=null){
            for (Street street : list) {
                Set<Segment> segmentSet = street.getSegments();
                Set<Rule> ruleSet = street.getRules();
                if(ruleSet.size()>0) {
                    for (Rule rule : ruleSet) {
                        rule.setStreet(new Street(street.getStreetId()));
                    }
                }
                if(segmentSet.size()>0){
                    for (Segment segment : segmentSet) {
                        segment.setStreet(new Street(street.getStreetId()));
                        for (Coordinate coordinate : segment.getCoordinates()) {
                            coordinate.setSegment(new Segment(segment.getSegmentId()));
                        }
                    }
                }
                listStreet.add(street);
            }
        }


        return listStreet;
    }
}
