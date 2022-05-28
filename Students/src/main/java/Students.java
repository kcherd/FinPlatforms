import DAO.DBConnect;
import service.StudentService;
import service.StudentServiceImpl;

import java.util.Scanner;

public class Students {
    private static final StudentService studentService = new StudentServiceImpl();
    public static void main(String[] args) {
        DBConnect.createConnectionPool();
        Scanner scan = new Scanner(System.in);
        String input ="";

        while (!"4".equals(input)) {
            System.out.println("Выберите действие:");
            System.out.println("1) Добавить студента");
            System.out.println("2) Удалить студента");
            System.out.println("3) Вывести список студентов");
            System.out.println("4) Выход");
            input = scan.next();

            switch (input){
                case "1":
                    Menu.addStudent(scan, studentService);
                    break;
                case "2":
                    Menu.deleteStudent(scan, studentService);
                    break;
                case "3":
                    Menu.printAllStudent(studentService);
                case "4":
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
        }
        DBConnect.closeConnection();
    }
}
