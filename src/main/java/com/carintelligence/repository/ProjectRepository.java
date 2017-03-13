package com.carintelligence.repository;

import java.util.List;

import com.carintelligence.model.Project;

/**
 * Project: carintelligence
 * Created by Leonardo Simoza on 09/3/17.
 **/
public interface ProjectRepository {

    Project find(Long projectId);
    List<Project> findAll();
    List<Project> paginate(int offset, int limit);
    Project save(Project Project);
    Project update(Project Project, Long projectId);
    Project delete(Long projectId);

}
