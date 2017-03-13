package com.carintelligence.service;

import java.util.List;

import com.carintelligence.model.Project;

/**
 * Project: carintelligence
 * Created by Leonardo Simoza on 09/3/17.
 **/
public interface ProjectService {

    Project find(Long projectId);
    List<Project> findAll();
    List<Project> paginate(int offset, int limit);
    Project save(Project project);
    Project update(Project project, Long projectId);
    Project delete(Long projectId);
}
