package org.ianlai.example.sync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ianlianetlai
 */
public class AtomicIntegerExample {



    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.addAndGet(1);
        atomicInteger.incrementAndGet();
    }
}
