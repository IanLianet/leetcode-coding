package org.ianlai.example.string;

/**
 * 关于String的小实验
 *
 * @author ianlianetlai
 */
public class StringExample {
    public static void main(String[] args) {
        String a = "123";
        String b = new String("123");
        String c = b;
        String d = "12345";
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(a.equals(b));
        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(d));


    }
}
