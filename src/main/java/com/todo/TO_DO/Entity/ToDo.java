package com.todo.TO_DO.Entity;

import com.todo.TO_DO.Validator.TitleValidator;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Document(collection = "ToDOList")
public class ToDo {

    @Id
    private String id;
    @TitleValidator()
    @NotBlank(message = "Must enter a task")
    private String title;
    private boolean isDone;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @CreatedDate
    private Date createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    private Date updatedAt;

}




