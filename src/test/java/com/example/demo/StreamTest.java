package com.example.demo;

import org.assertj.core.util.Lists;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author shancg
 * @data 2018/9/3
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
//        System.out.println(nums.stream().filter(num -> num != null).count());
//
//        Stream<List<Integer>> inputStream = Stream.of(
//                Arrays.asList(1),
//                Arrays.asList(2, 3),
//                Arrays.asList(4, 5, 6)
//        );
//        System.out.println(inputStream.count());
//
//        Stream<Integer> outputStream = inputStream.
//                flatMap((childList) -> childList.stream());
//
//        System.out.println(outputStream.count());


//        List<Integer> numss = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
//        System.out.println("sum is:"+numss.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(System.out::println).skip(2).limit(4).sum());

        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
                collect(Collectors.toList());

        System.out.println(numsWithoutNull);

    }
}
