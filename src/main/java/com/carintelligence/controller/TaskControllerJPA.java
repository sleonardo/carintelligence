package com.carintelligence.controller;

import com.carintelligence.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.carintelligence.service.TaskService;

/**
 * Project: carintelligence
 * Created by Leonardo Simoza on 09/3/17.
 **/
@Controller
public class TaskControllerJPA {

    @Autowired
    TaskService taskService;

    @RequestMapping(method=RequestMethod.GET, value = "/tasks/persistence")
    public ModelAndView getView(@ModelAttribute("tasks") Task task) {
        return new ModelAndView("addTask");
    }
    
    @RequestMapping(method=RequestMethod.POST, value = "/tasks/persistence")
    public ModelAndView add(Model model, @ModelAttribute("tasks") Task task) {
        task = taskService.save(task);
        return new ModelAndView("taskAddedWithId", "task", task);
    }
}
