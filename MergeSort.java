package org.example;

import java.util.Arrays;

public class MergeSort {

    // Hàm hợp nhất hai mảng con đã được sắp xếp
    public static void merge(Student1[] arr, int left, int mid, int right) {
        // Tạo hai mảng con tạm thời
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student1[] leftArray = new Student1[n1];
        Student1[] rightArray = new Student1[n2];

        // Sao chép dữ liệu vào các mảng tạm
        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        // Hợp nhất các mảng con
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getMarks() <= rightArray[j].getMarks()) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Sao chép phần còn lại của mảng con bên trái
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Sao chép phần còn lại của mảng con bên phải
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Hàm Merge Sort chính
    public static void mergeSort(Student1[] arr, int left, int right) {
        if (left < right) {
            // Tìm chỉ số giữa
            int mid = (left + right) / 2;

            // Sắp xếp nửa bên trái
            mergeSort(arr, left, mid);

            // Sắp xếp nửa bên phải
            mergeSort(arr, mid + 1, right);

            // Hợp nhất hai nửa đã sắp xếp
            merge(arr, left, mid, right);
        }
    }
}