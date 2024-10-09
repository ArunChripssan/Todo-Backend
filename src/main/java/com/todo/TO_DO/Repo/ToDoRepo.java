package com.todo.TO_DO.Repo;

import com.todo.TO_DO.Entity.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepo extends MongoRepository <ToDo, String> {

    public ToDo findByTitle(String title);
}
