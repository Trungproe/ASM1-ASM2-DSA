
package org.example;

public class BubbleSort {
    // Phương thức BubbleSort
    public static void sort(Student1[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // So sánh điểm của hai sinh viên liên tiếp
                if (arr[j].getMarks() > arr[j + 1].getMarks()) {
                    // Hoán đổi nếu điểm sinh viên j lớn hơn sinh viên j + 1
                    Student1 temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
