package service;

import DAO.DBConnect;
import DAO.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private static final String FIND_ALL_STUDENTS = "select * from student";
    private static final String ADD_STUDENT = "insert into student "
            + "(name, surname, patronymic, birthday, group_name) "
            + "values (?, ?, ? ,?, ?)";
    private static final String DELETE_STUDENT = "delete from student where id = ?";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void addStudent(Student student) throws Exception {
        try(Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_STUDENT)){
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getPatronymic());
            preparedStatement.setString(4, student.getBirthday().format(FORMATTER));
            preparedStatement.setString(5, student.getGroup());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteStudent(long id) throws Exception {
        try(Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Student> findAll() throws Exception {
        List<Student> students = new ArrayList<>();

        try(Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_STUDENTS)){
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    Student student = new Student();
                    student.setId(resultSet.getLong("id"));
                    student.setName(resultSet.getString("name"));
                    student.setSurname(resultSet.getString("surname"));
                    student.setPatronymic(resultSet.getString("patronymic"));
                    student.setBirthday(LocalDate.parse(resultSet.getString("birthday")));
                    student.setGroup(resultSet.getString("group_name"));
                    students.add(student);
                }
            }
        }
        return students;
    }
}
