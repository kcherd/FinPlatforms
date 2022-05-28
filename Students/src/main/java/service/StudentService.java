package service;

import DAO.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student) throws Exception;
    void deleteStudent(long id) throws Exception;
    List<Student> findAll() throws Exception;
}
