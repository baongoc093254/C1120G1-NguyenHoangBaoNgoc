package bai5_AccessModifier_StaticMethod_StaticProperty.baitap;

import bai5_AccessModifier_StaticMethod_StaticProperty.thuchanh.Test;

public class Test1 {
   static int a = 10;
    int b;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public static void main(String[] args) {
        Test1 number = new Test1();
        System.out.println(a);
        Test1 number2 = new Test1();
        System.out.println(number.a);
        System.out.println(number.b);
        System.out.println(number2.a);
        System.out.println(number2.b);
        Test1.a = 5;
        System.out.println(number.a + number.b);
        System.out.println(number2.a + number2.b);
    }
}
