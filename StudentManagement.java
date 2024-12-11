package org.example;

public class StudentManagement {
    private Student[] students;
    private int count;

    public StudentManagement(int capacity) {
        students = new Student[capacity];
        count = 0;
    }

    // Thêm sinh viên vào danh sách
    public void addStudent(Student student) {
        if (count >= students.length) {
            System.out.println("Danh sách đã đầy, không thể thêm sinh viên mới.");
            return;
        }

        for (int i = 0; i < count; i++) {
            if (students[i].getId() == student.getId()) {
                System.out.println("Lỗi: Sinh viên với ID " + student.getId() + " đã tồn tại.");
                return;
            }
        }

        students[count++] = student;
        System.out.println("Đã thêm sinh viên: " + student);
    }

    // Sửa thông tin sinh viên theo ID
    public void updateStudent(int id, double newScore) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                students[i].setScore(newScore);
                System.out.println("Đã cập nhật điểm cho sinh viên: " + students[i]);
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên với ID: " + id);
    }

    // Xóa sinh viên theo ID
    public void deleteStudent(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--count] = null;
                System.out.println("Đã xóa sinh viên với ID: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên với ID: " + id);
    }

    // Tìm kiếm sinh viên theo ID
    public Student searchStudentById(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        System.out.println("Không tìm thấy sinh viên với ID: " + id);
        return null;
    }

    // Sắp xếp sinh viên theo điểm bằng Bubble Sort
    public void sortStudentsByBubbleSort() {
        if (count <= 1) {
            System.out.println("Không cần sắp xếp, danh sách sinh viên có ít hơn 2 phần tử.");
            return;
        }

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (students[j].getScore() > students[j + 1].getScore()) {
                    // Hoán đổi 2 sinh viên
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    // Hiển thị danh sách sinh viên
    public void displayStudents() {
        if (count == 0) {
            System.out.println("Không có sinh viên trong danh sách.");
            return;
        }

        System.out.println("Danh sách sinh viên:");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }

    public void searchStudent(int searchId) {
    }
}