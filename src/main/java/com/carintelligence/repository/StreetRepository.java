package com.carintelligence.repository;

import com.carintelligence.model.Street;

import java.util.List;

/**
 * @author leonardo
 * @project carintelligence
 * @date 20/3/17
 */
public interface StreetRepository {
    Street find(Long streetId);
    List<Street> findAll();
    List<Street> paginate(int offset, int limit);
    Street save(Street street);
    Street update(Street street, Long streetId);
    Street delete(Long streetId);
}
