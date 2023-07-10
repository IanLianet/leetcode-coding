package org.ianlai.example.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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

        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();

        Iterator<String> iterator = list.iterator();
    }
}
