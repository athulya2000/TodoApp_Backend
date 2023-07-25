package com.example.TodoApp.controller;

import com.example.TodoApp.dao.TodoDao;
import com.example.TodoApp.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TodoController {
    @Autowired
    private TodoDao todoDao;
    @CrossOrigin(origins = "*")
    @PostMapping(path="addTask",consumes = "application/json",produces = "application/json")
    public String AddTodo(@RequestBody Todo td){
        System.out.println(td.getId());
        System.out.println(td.getTask());
        todoDao.save(td);
        return "task added successfully";
    }

    @CrossOrigin(origins = "*")
   @GetMapping("viewTask")
    public List<Todo> View(){

        return (List<Todo>) todoDao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="deleteTask",consumes = "application/json",produces = "application/json")
    public Map<String,String> DeleteTodo(@RequestBody Todo td){
        System.out.println(String.valueOf(td.getId()));
        HashMap<String,String> map=new HashMap<>();
        todoDao.delete(td.getId());
        map.put("status"," deleted successfully");
       return map;
    }

}
