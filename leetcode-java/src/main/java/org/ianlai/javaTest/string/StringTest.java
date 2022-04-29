package org.ianlai.javaTest.string;

/**
 * 关于String的小实验
 *
 * @author ianlianetlai
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "123";
        String b = "123";
        String c = a;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);

    }
}
