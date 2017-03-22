package com.carintelligence.repository;

import com.carintelligence.model.Coordinate;

import java.util.List;

/**
 * @author leonardo
 * @project carintelligence
 * @date 22/3/17
 */
public interface CoordinateRepository {
    Coordinate find(Long coordinateId);
    List<Coordinate> findAll();
    List<Coordinate> paginate(int offset, int limit);
    Coordinate save(Coordinate coordinate);
    Coordinate update(Coordinate Coordinate, Long coordinateId);
    Coordinate delete(Long coordinateId);
}
