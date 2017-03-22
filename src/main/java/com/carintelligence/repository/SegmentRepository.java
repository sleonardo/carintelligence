package com.carintelligence.repository;

import com.carintelligence.model.Segment;

import java.util.List;

/**
 * @author leonardo
 * @project carintelligence
 * @date 21/3/17
 */
public interface SegmentRepository {
    Segment find(Long segmentId);
    List<Segment> findAll();
    List<Segment> paginate(int offset, int limit);
    Segment save(Segment segment);
    Segment update(Segment Segment, Long segmentId);
    Segment delete(Long segmentId);
}
