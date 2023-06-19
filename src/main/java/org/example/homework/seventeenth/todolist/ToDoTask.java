package org.example.homework.seventeenth.todolist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.homework.seventeenth.todolist.enums.CompletionStatus;
import org.example.homework.seventeenth.todolist.enums.Priority;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ToDoTask {

    @JsonProperty("id")
    private long id;

    @JsonProperty("task")
    private String task;

    @JsonProperty("priority")
    private Priority priority;

    @JsonProperty("status")
    private CompletionStatus status;

}
