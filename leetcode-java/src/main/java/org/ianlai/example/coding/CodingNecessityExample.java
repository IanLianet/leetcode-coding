package org.ianlai.example.coding;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class CodingNecessityExample {


    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap1 = new ConcurrentHashMap<>();
        List<String> values = (List<String>) concurrentHashMap1.values();
    }


}
