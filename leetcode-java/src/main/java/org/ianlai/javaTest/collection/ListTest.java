package org.ianlai.javaTest.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 关于List的小实验
 *
 * @author ianlianetlai
 */
public class ListTest {
    public static void main(String[] args) {
        // Arrays.asList()中，返回的new ArrayList是Arrays中的内部类，没有实现List.add()方法，而不是java.util.ArrayList。
        List<String> stringList = Arrays.asList("123","456");
        // stringList.add("222");

        List<String> stringArrayList = new ArrayList<>(Arrays.asList("123","123","123","456"));
        Iterator<String> iterator = stringArrayList.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            stringArrayList.remove(next);
            iterator.remove();
        }


    }
}
