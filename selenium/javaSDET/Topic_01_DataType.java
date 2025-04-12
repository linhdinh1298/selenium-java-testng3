package javaSDET;

public class Topic_01_DataType {
    // 2 nhóm kiểu dữ liệu

    // cách khai báo:
    // Access modifier: phạm vi truy cập (private/ public/ protected/ default)
    // 1: Access modifier - Kiểu dữ liệu - Tên biến - Giá trị của biến (Ngoài Hàm/ Trong hàm đều được)
    public char cName ='b';
    // 2.1: Access modifier - Kiểu dữ liệu - Tên biến
    private char cAddress;
    // 2.2: Tên biến - Giá trị gán sau (trong Hàm)

    public void clickToElement(){
        cAddress ='c';
    }

    // Nhóm 1: Kiểu dữ liệu nguyên thủy
    // Char: kí tự (character) > khi gán giá trị nằm trong dấu ''
    char cZip ='b';
    // byte/ short/ int/ long: số nguyên > khi khán giá trị không nằm trong dấu gì
    // float/ double: số thực > khi khán giá trị không nằm trong dấu gì

    // Nhóm 2 - Kiểu dữ liệu tham chiếu
    // String: chuỗi > khi gán giá trị nằm trong dấu ""

    // Convention: Quy ước khi lập trình
    // Tên biến, tên hàm: viết dưới dạng camel case > chữ cái đầu tiên luôn viết thường nếu 1 từ e.g name/address
    // Nếu nhiều hơn 1 từ: chữ cái đầu tiên của từ t2 viết hoa e.g getUserName, clickToElement
}