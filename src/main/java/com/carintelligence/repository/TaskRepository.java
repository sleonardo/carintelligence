package com.carintelligence.repository;

import java.util.List;

import com.carintelligence.model.Task;

/**
 * Project: carintelligence
 * Created by Leonardo Simoza on 09/3/17.
 **/
public interface TaskRepository {

    Task find(Long taskId);
    List<Task> findAll();
    List<Task> paginate(int offset, int limit);
    Task save(Task task);
    Task update(Task task, Long taskId);
    Task delete(Long taskId);

}
