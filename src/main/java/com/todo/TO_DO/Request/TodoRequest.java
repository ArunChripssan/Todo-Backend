package com.todo.TO_DO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
public class TodoRequest {
    @NonNull
    private String title;
    private boolean isDone;
}
