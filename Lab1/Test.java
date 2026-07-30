public class Test {
    public static void main(String[] args) {
        char x = 'a';
        char y = 'c';
        System.out.println(++x);
        //output: b เพราะเป็น pre-increment เพิ่มค่าก่อนค่อยนำไปใช้

        System.out.println(y++);
        //output: c เพราะเป็น post-increment ใช้ก่อนค่อยเพิ่ม ตอนนี้ y = d
        
        System.out.println(x - y);
        //output: -2
        //สามารถคำนวณได้เป็นรหัส ASCII
        //ตอนนี้ x = b = 98 , y = d = 100
        //จะได้ 98 - 100 = -2
    }
}