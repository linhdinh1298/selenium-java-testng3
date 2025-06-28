package javaSDET;

import java.util.ArrayList;

public class Topic_18_Array {
    public static void main(String[] args) {
        // MẢNG ĐƯỢC DEFINE CỐ ĐỊNH KHI VIẾT CODE (COMPILE)
        // cách 1: phổ biến nhất
        int number[] = {10,11,12,13,14};
        // cách 2:
        int[] studentID = {1,2,3,4,5};
        String studentName[] = {"Name1","Name2"};
        studentName[0] = "Name3"; // gán đè lên Name 1

        for (int i = 0; studentName.length < 3; i++) {
            if (studentName[i].equals("Name1")) {
                System.out.println(studentName[i]);
            }
        }

        // cách 3:
        int b[] = new int [5];
        b[0] = 10;
        b[1] = 12;

        // lấu ra phần tủ đầu tiên của mảng
        System.out.println(studentID[0]);

        // MẢNG ĐƯỢC THÊM VÀO KHI RUN
        ArrayList<String> stdName = new ArrayList<String>();
        // khi run code, add student name into List
        for (String std: studentName) {
            stdName.add(std);
        }
    }
}

