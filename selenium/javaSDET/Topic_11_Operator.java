package javaSDET;

public class Topic_11_Operator {

    public static void main (String[] args){
        int number = 25;
        System.out.println("Add:" + (number += 5)); // number = number + 5
        System.out.println("Subtract:" + (number -= 3)); // number = number - 5
        System.out.println("Multiply:" + (number *= 5)); // number = number * 5
        System.out.println("Divide:" + (number /= 6)); // ( chia lấy phần nguyên)
        System.out.println("Divide1:" + (number %= 6)); //( chia lấy phần dư)
        System.out.println(++number) ;
        System.out.println(--number) ;
        System.out.println(number++) ;
        System.out.println(number--) ;

        for (int i=0; i<3; i++) {
            System.out.println(i);
        }

        String address = "Ho chi minh";
        if (address != "Ha Noi") {
            System.out.println("Address is the same");
        }

        // biểu thức tam nguyên " = ? : "
        boolean status = (address != "Ha Noi") ? true : false;
        System.out.println(status);
    }
}
