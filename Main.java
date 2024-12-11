package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Khởi tạo đối tượng StudentManagement với số lượng sinh viên tối đa là 100
        StudentManagement studentManagement = new StudentManagement(100);

        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị sinh viên");
            System.out.println("3. Sắp xếp sinh viên theo điểm (Bubble Sort)");
            System.out.println("4. Cập nhật điểm sinh viên");
            System.out.println("5. Xóa sinh viên");
            System.out.println("6. Tìm kiếm sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            switch (choice) {
                case 1:
                    // Thêm sinh viên bằng tay hoặc ngẫu nhiên
                    System.out.println("Chọn phương thức thêm sinh viên:");
                    System.out.println("1. Thêm sinh viên bằng tay");
                    System.out.println("2. Thêm sinh viên ngẫu nhiên");
                    System.out.print("Chọn phương thức: ");
                    int addChoice = scanner.nextInt();

                    if (addChoice == 1) {
                        // Thêm sinh viên bằng tay
                        System.out.print("Nhập ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Đọc bỏ dòng thừa
                        System.out.print("Nhập tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập số điện thoại: ");
                        String contactNumber = scanner.nextLine();
                        System.out.print("Nhập điểm: ");
                        double score = scanner.nextDouble();
                        Student student = new Student(id, name, contactNumber, score);
                        studentManagement.addStudent(student);
                        System.out.println("Đã thêm sinh viên " + name);
                    } else if (addChoice == 2) {
                        // Thêm sinh viên ngẫu nhiên
                        System.out.print("Nhập số lượng sinh viên cần thêm: ");
                        int numStudents = scanner.nextInt();

                        if (numStudents > 100) {
                            System.out.println("Số lượng sinh viên không thể vượt quá 100!");
                        } else {
                            for (int i = 0; i < numStudents; i++) {
                                int id = i + 1;
                                String name = "Sinh viên " + (i + 1);
                                String contactNumber = "01234567" + (random.nextInt(90) + 10);
                                double score = random.nextDouble() * 10;

                                Student student = new Student(id, name, contactNumber, score);
                                studentManagement.addStudent(student);
                            }
                            System.out.println("Đã thêm " + numStudents + " sinh viên ngẫu nhiên.");
                        }
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;

                case 2:
                    // Hiển thị danh sách sinh viên
                    studentManagement.displayStudents();
                    break;

                case 3:
                    // Sắp xếp sinh viên theo điểm bằng Bubble Sort
                    System.out.println("Đang sắp xếp sinh viên theo điểm bằng Bubble Sort...");
                    studentManagement.sortStudentsByBubbleSort();
                    studentManagement.displayStudents();
                    break;

                case 4:
                    // Cập nhật điểm sinh viên
                    System.out.print("Nhập ID sinh viên cần cập nhật điểm: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Nhập điểm mới: ");
                    double newScore = scanner.nextDouble();
                    studentManagement.updateStudent(updateId, newScore);
                    break;

                case 5:
                    // Xóa sinh viên theo ID
                    System.out.print("Nhập ID sinh viên cần xóa: ");
                    int deleteId = scanner.nextInt();
                    studentManagement.deleteStudent(deleteId);
                    break;

                case 6:
                    // Tìm kiếm sinh viên theo ID
                    System.out.print("Nhập ID sinh viên cần tìm: ");
                    int searchId = scanner.nextInt();
                    studentManagement.searchStudent(searchId);
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);

        scanner.close();
    }
}