package javaSDET;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_15_Loop_For_ForEach {
    @Test
    public void TC_01_For(){
//        for (int i = 0; i <=10; i++) {
//            System.out.println(i);

            // Vế 1: biến tạm, dùng để tăng giá trị lên sau mỗi lần
            // Dùng để so sánh với tổng giá t
            // Vế 2: So sánh với tổ
            // Vế 3: Tăng i lên 1 đơn vị sau khi chạy vào thân vòng

        // Array
        // Khi thao tác với Array/ List/ Set/ Queue > dùng index [], tính từ 0
        // For kết hợp với If, thoã mãn điều kiện mới action

        String[] cityName = {"Ha Noi","HCM","Da Nang","Can Tho"};

        for (int i = 0; i < cityName.length; i++) {
            if (cityName[i].equals("Da Nang")){
            System.out.println("Do action");
            break; // nếu không dùng break, thì chạy all tất cả các giá trị
        }}
    }
    @Test
    public void TC_01_ForEach() {
        String[] cityName = {"Ha Noi","HCM","Da Nang","Can Tho"};
        // For each: chạy qua hết tất cả các giá trị
        List<String> cityAddress = new ArrayList<String>();
        System.out.println(cityAddress.size());

        // Compile (Coding)
        cityAddress.add("Bac Giang");
        cityAddress.add("Ha Giang");
        cityAddress.add("Tien Giang");
        System.out.println(cityAddress.size());

        // Runtime (Running)
        for (String city:cityName) {
            cityAddress.add(city);
        }
        System.out.println(cityAddress.size());

        // Không nên dùng forEach cho các thao tác click, chuyển page, mở đường link,..
    }
    }
