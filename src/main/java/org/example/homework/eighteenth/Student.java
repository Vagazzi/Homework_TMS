package org.example.homework.eighteenth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Student {
    private int id;
    private String name;
    private String course;
    private String cafedre;
    private int age;
    private String city;
}
