package javaSDET;

import java.util.ArrayList;
import java.util.List;

public class Topic_07_For_While_DoWhile {
    public static void main(String[] args) {
        // biểu thức vòng lặp (loop)
        int number = 100;

        // For (classic - iterator)
        for(int i = 0; i<number; i++) {
            if (i == 5) {
                System.out.println(i);
                break; // thoát khỏi vòng lặp, thoát khỏi biểu thức điều kiện khi đã tìm thấy giá trị, không cần chạy tiếp
            }
        }

        //Collection:  List/ Set/ Queue/ Map
        List<String> name = new ArrayList<String>();
        name.add("Manual Testing");
        name.add("Auto Testing");
        name.add("Regression Testing");
        name.add("API Testing");
        name.add("UI Testing");

        // for-each
        for (String a: name){
            if (a.equals("Manual Testing")) {
                System.out.println("Interview");
            }
        }

        int i = 1000;
        // Do-While
        do {// Action trước
            System.out.println(i); // in ra i = 1000
            i++; // lúc này i = 1001
        } while (i<number); // kiểm tra điều kiện sau : 1001 > 1000 >

        // While
        while (i<number){
            System.out.println(i);
            i++;
        }
    }

}

