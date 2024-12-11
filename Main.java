    package org.example;

    import java.util.Random;
    import java.util.Scanner;
    import java.util.*;

    public class Main {

        public static void main(String[] args) {
            do{
                Run();
            }while (true);
        }
    public static void Run (){

        // Khởi tạo Scanner để nhập dữ liệu từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập số lượng sinh viên n
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();  // Nhập số nguyên n từ người dùng
        // Tạo danh sách sinh viên giả lập
        List<Student1> Liststudents = generateFakeStudents(n);

        // Chuyển Liststudents thành mảng để sử dụng trong QuickSort, MergeSort và BubbleSort
        Student1[] stackArray1 = Liststudents.toArray(new Student1[0]);
        Student1[] stackArray2 = Liststudents.toArray(new Student1[0]);
        Student1[] stackArray3 = Liststudents.toArray(new Student1[0]);

        // Tạo một stack với dung lượng tối đa 10000 sinh viên
        Stack stack = new Stack(n);
        Stack stack2 = new Stack(n);
        Stack stack3 = new Stack(n);


        // Thêm tất cả sinh viên vào stack
        for (Student1 student : Liststudents) {
            stack.push(student); // Thêm từng sinh viên vào stack
        }
        for (Student1 student : Liststudents) {
            stack2.push(student); // Thêm từng sinh viên vào stack2
        }
        for (Student1 student : Liststudents) {
            stack3.push(student); // Thêm từng sinh viên vào stack3
        }

        // QuickSort: Đo thời gian sắp xếp
        long startTime = System.nanoTime();
        QuickSort.quickSort(stackArray1, 0, stackArray1.length - 1);
        long endTime = System.nanoTime();
        long quickSortTime = endTime - startTime;
        System.out.println("QuickSort time: " + quickSortTime + " nanoseconds");

        // MergeSort: Đo thời gian sắp xếp
        startTime = System.nanoTime();
        MergeSort.mergeSort(stackArray2, 0, stackArray2.length - 1);
        endTime = System.nanoTime();
        long mergeSortTime = endTime - startTime;
        System.out.println("MergeSort time: " + mergeSortTime + " nanoseconds");

        // BubbleSort: Đo thời gian sắp xếp
        startTime = System.nanoTime();
        BubbleSort.sort(stackArray3); // Sử dụng BubbleSort từ class BubbleSort
        endTime = System.nanoTime();
        long bubbleSortTime = endTime - startTime;
        System.out.println("BubbleSort time: " + bubbleSortTime + " nanoseconds");

        // In ra thời gian sắp xếp
        if (quickSortTime < mergeSortTime && quickSortTime < bubbleSortTime) {
            System.out.println("\nQuickSort is the fastest.");
        } else if (mergeSortTime < quickSortTime && mergeSortTime < bubbleSortTime) {
            System.out.println("\nMergeSort is the fastest.");
        } else if (bubbleSortTime < quickSortTime && bubbleSortTime < mergeSortTime) {
            System.out.println("\nBubbleSort is the fastest.");
        } else {
            System.out.println("\nAll sorting algorithms have the same performance.");
        }
    }
        // Phương thức tạo sinh viên giả lập
        public static List<Student1> generateFakeStudents(int count) {
            List<Student1> students = new ArrayList<>();
            Random random = new Random();

            // Tạo ngẫu nhiên sinh viên
            for (int i = 1; i <= count; i++) {
                int id = i;
                String name = "Student " + i;
                String contactNumber = "090" + String.format("%08d", random.nextInt(100000000));
                double marks = 5 + random.nextDouble() * 5; // Điểm ngẫu nhiên từ 5.0 đến 10.0

                Student1 student = new Student1(id, name, contactNumber, marks);
                students.add(student);
            }

            return students;
        }
    }
