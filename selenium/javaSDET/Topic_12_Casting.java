package javaSDET;

public class Topic_12_Casting {
    public static void main (String[] args){
//        // ép kiểu ngầm định (implicit) - không mất dữ liệu
//        byte bNumber = 126;
//        System.out.println(bNumber);
//        short sNumber = bNumber;
//        System.out.println(sNumber);
//        int iNumber = sNumber;
//        System.out.println(iNumber);
//        long lNumber = iNumber;
//        System.out.println(lNumber);
//        float fNumber = lNumber;
//        System.out.println(fNumber);
//        double dNumber = fNumber;
//        System.out.println(dNumber);

        // tường minh (explicit)
        double doubleNumber = 65432178565465469d;
        System.out.println(doubleNumber);
        float floatNumber = (float) doubleNumber;
        System.out.println(floatNumber);
        long longNumber = (long) floatNumber;
        System.out.println(longNumber);
        int intNumber = (int) longNumber;
        System.out.println(intNumber);

    }
}
