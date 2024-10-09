package com.todo.TO_DO.Controller;

import com.todo.TO_DO.Entity.ToDo;
import com.todo.TO_DO.Service.ToDOService;
import com.todo.TO_DO.exception.RecordNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/todo")
public class ToDoCOntroller {

    @Autowired
    ToDOService toDOService;

    @PostMapping("/add")
    public String postTask(@Valid @RequestBody ToDo toDo){
        toDOService.createTask(toDo);
        return "Task Posted";
    }

    @GetMapping("/getTask/{id}")
    public Optional<ToDo> getTask(@PathVariable("id") String id) throws RecordNotFoundException {
        if(!toDOService.isToDOExist(id)){
            throw new RecordNotFoundException("Respected ToDo Not Found");
        }
        return toDOService.getTask(id);
    }

    @GetMapping("/getByTitle/{title}")
    public ToDo findTodoByTitle(@PathVariable("title") String title){
        return toDOService.findToDoByTitle(title);

    }

    @GetMapping("/getAllTasks")
    public List<ToDo> getAllTasks(){
        return toDOService.getAllTasks();
    }

    @PutMapping("/update/{id}")
    public String updateToDO(@PathVariable String id, @RequestBody ToDo toDo) throws RecordNotFoundException {
        if (!toDOService.isToDOExist(id)){
            throw new RecordNotFoundException("Respected ToDo Not Found");
        }
        toDOService.updateToDo(id, toDo);
        return "TODO Updated";
    }

    @PatchMapping("/updateStatus/{id}")
    public String updateStatus(@PathVariable String id, @RequestBody Map<String, Boolean> status){
        toDOService.updateStatus(id, status);
        return "Status Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable String id) throws RecordNotFoundException{
        if(!toDOService.isToDOExist(id)){
            throw new RecordNotFoundException("Respected ToDo Not Found");
        }
        toDOService.deleteTask(id);
        return "Task Deleted";
    }

    @DeleteMapping("deleteAllTasks")
    public String deleteAllTasks(){
        toDOService.deleteAllTasks();
        return "All Task Deleted";
    }


}
