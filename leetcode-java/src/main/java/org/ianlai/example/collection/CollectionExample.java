package org.ianlai.example.collection;

import java.util.*;

/**
 * @author ianlianetlai
 */
public class CollectionExample {

    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        list.add("1");
        System.out.println(list);

        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();

        Iterator<String> iterator = list.iterator();
    }
}
