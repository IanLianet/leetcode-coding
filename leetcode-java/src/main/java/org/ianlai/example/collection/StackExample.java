package org.ianlai.example.collection;


import java.util.*;

/**
 * 关于Java Stack的小实验
 *
 * @author ianlianetlai
 */
public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();

        Class<Stack> stackClass = Stack.class;

        Deque<Integer> integerDeque = new ArrayDeque<>();

        integerDeque.push(1);
        integerDeque.push(2);
        // poll()和pollFirst()相同作用，若Stack为空，会返回null;pop()和removeFirst()相同作用，若Stack为空，会抛出异常;
        System.out.println(integerDeque.pop());
        System.out.println(integerDeque.poll());

    }
}
