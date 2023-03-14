package org.ianlai.example.collection;


import java.util.*;

/**
 * 关于List的小实验
 *
 * @author ianlianetlai
 */
public class ListExample {
    public static void main(String[] args) {
        // Arrays.asList()中，返回的new ArrayList是Arrays中的内部类，没有实现List.add()方法，而不是java.util.ArrayList。
        List<String> stringList = Arrays.asList("123","456");
        // stringList.add("222");

        List<String> stringArrayList = new ArrayList<>(Arrays.asList("123","123","123","456"));
        Iterator<String> iterator = stringArrayList.iterator();
        ListIterator<String> stringListIterator = stringArrayList.listIterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            stringArrayList.remove(next);
            /*
            Exception in thread "main" java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
	at java.util.ArrayList$Itr.remove(ArrayList.java:873)

             这里会报错，因为这个iterator是ArrayList内部实现类Itr，里面的remove方法会调用checkForComodification()，
             判断是否有被修改
            */
            // iterator.remove();
        }


    }
}
