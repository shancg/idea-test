package com.example.demo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author shancg
 * @data 2018/9/3
 */
public class LambdaFunction {

    public static void main(String[] args) {

        Function function = (s) -> s + ":function";

        Supplier supplier = ()->"supplier";

        Consumer consumer = (s)-> System.out.println("consumer");

        Predicate predicate = (s)->true;

        System.out.println(function.apply("sss"));

        System.out.println(supplier.get());

        consumer.accept("ccc");

        System.out.println(predicate.test("ppp"));

    }

}
