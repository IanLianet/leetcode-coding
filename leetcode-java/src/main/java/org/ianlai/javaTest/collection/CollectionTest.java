package org.ianlai.javaTest.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author ianlianetlai
 */
public class CollectionTest {

    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("1");
        System.out.println(list);

        HashSet<Integer> hashSet = new HashSet<>();

        Iterator<String> iterator = list.iterator();
    }
}
