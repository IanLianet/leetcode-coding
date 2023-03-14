package org.ianlai.example.box;

/**
 * @author ianlianetlai
 */
public class BoxingExample {

    public static void main(String[] args) {
        Integer integer = 1;
        if (Integer.hashCode(1) == integer.hashCode()) {
            System.out.println(Integer.hashCode(1)); // 1
        } else {
            System.out.println(Integer.hashCode(1)); // 1
            System.out.println(integer.hashCode());// 1
        }
        Object object1 = new Object();
        Object object2 = new Object();
        Object string1 = new String("1");
        Object string2 = new String("1");
        int hashCode1 = object1.hashCode();
        int hashCode2 = object2.hashCode();
        System.out.println(hashCode1);
        System.out.println(hashCode2);
        System.out.println(string1 == string2);
        System.out.println(string1.equals(string2));

/*        byte a = (byte) 128;
        System.out.println(a);
        int b = a + 100;
        System.out.println(b);*/

        // int以下的运算升级为int
//        byte a = 120 , b = 7;
//        byte c = a + 1;
        char a = 'a';
        char b = 'b';
        int i = a + b;
        System.out.println(i);


    }

}
