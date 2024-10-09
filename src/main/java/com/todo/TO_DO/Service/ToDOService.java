package com.todo.TO_DO.Service;

import com.todo.TO_DO.Entity.ToDo;
import com.todo.TO_DO.Repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ToDOService {

    @Autowired
    ToDoRepo toDoRepo;

    public void createTask(ToDo toDo){
        toDoRepo.save(toDo);
    }

    public boolean isToDOExist(String id){
        return toDoRepo.existsById(id);
    }
    public Optional<ToDo> getTask(String id){
        return toDoRepo.findById(id);
    }

    public List<ToDo> getAllTasks(){
        return toDoRepo.findAll();
    }

    public void updateToDo(String id, ToDo toDo){
        Optional<ToDo> newToDo = toDoRepo.findById(id);
        newToDo.get().setTitle(toDo.getTitle());
        toDoRepo.save(newToDo.get());
    }

    public Optional<ToDo> updateStatus(String id, Map<String, Boolean> status){
        Optional<ToDo> newTodo = toDoRepo.findById(id);
        for (Map.Entry<String, Boolean> isDone : status.entrySet()){
            newTodo.get().setDone(isDone.getValue());
        }
        toDoRepo.save(newTodo.get());
        return newTodo;
    }

    public void deleteTask(String id){
        toDoRepo.deleteById(id);
    }

    public void deleteAllTasks(){
        toDoRepo.deleteAll();
    }

    public ToDo findToDoByTitle(String title) {
        return toDoRepo.findByTitle(title);
    }
}
