package DAO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Student {
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private String group;
}
