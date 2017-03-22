package com.carintelligence.service;

import com.carintelligence.model.Coordinate;

import java.util.List;

/**
 * @author leonardo
 * @project carintelligence
 * @date 22/3/17
 */
public interface CoordinateService {
    Coordinate find(Long coordinateId);
    List<Coordinate> findAll();
    List<Coordinate> paginate(int offset, int limit);
    Coordinate save(Coordinate coordinate);
    Coordinate update(Coordinate coordinate, Long coordinateId);
    Coordinate delete(Long coordinateId);
}
