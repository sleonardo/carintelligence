package com.carintelligence.service;

import java.util.List;

import com.carintelligence.model.Task;
import com.carintelligence.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Project: carintelligence
 * Created by Leonardo Simoza on 09/3/17.
 **/
@Service("taskService")
public class TaskServiceImpl implements TaskService
{

    @Autowired
    private TaskRepository taskRepository;


    public Task find(Long taskId)
    {
        // Returns the Task for given taskId.
        return taskRepository.find(taskId);
    }


    @Transactional
    public Task save(Task task)
    {
        // Saves the given task object and returns the same.
        taskRepository.save(task);
        return task;
    }


    @Override
    public List<Task> findAll()
    {
        // Returns all the tasks in our system.
        return taskRepository.findAll();
    }


    @Transactional
    public Task update(Task task, Long taskId)
    {
        // Updates the task with the given taskId;
        return taskRepository.update(task, taskId);
    }


    @Transactional
    public Task delete(Long taskId)
    {
        // Deletes the task with the give taskId and returns the same.
        return taskRepository.delete(taskId);
    }


    @Override
    public List<Task> paginate(int offset, int limit)
    {
        // Paginates the tasks objects. 
        return taskRepository.paginate(offset, limit);
    }

}
