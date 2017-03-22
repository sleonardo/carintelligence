package com.carintelligence.service;

import com.carintelligence.model.Segment;

import java.util.List;

/**
 * @author leonardo
 * @project carintelligence
 * @date 22/3/17
 */
public interface SegmentService {
    Segment find(Long segmentId);
    List<Segment> findAll();
    List<Segment> paginate(int offset, int limit);
    Segment save(Segment segment);
    Segment update(Segment segment, Long segmentId);
    Segment delete(Long segmentId);
}
