import DAO.Student;
import service.StudentService;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    public static void addStudent(Scanner scan, StudentService studentService) {
        System.out.println("Введите данные студента: "
                + "имя, фамилия, отчество, дата рождения, номер группы. "
                + "Каждое значение с новой строки");
        Student student = new Student();
        student.setName(scan.next());
        student.setSurname(scan.next());
        student.setPatronymic(scan.next());
        try {
            student.setBirthday(LocalDate.parse(scan.next()));
        } catch (Exception e) {
            System.out.println("Неверный формат даты");
        }
        student.setGroup(scan.next());
        try {
            studentService.addStudent(student);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteStudent(Scanner scan, StudentService studentService) {
        System.out.println("Введите идентификатор студента");
        try{
            int id = Integer.parseInt(scan.next());
            studentService.deleteStudent(id);
        } catch (NumberFormatException e) {
            System.out.println("Неверный идентификатор");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printAllStudent(StudentService studentService) {
        try {
            studentService.findAll().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
