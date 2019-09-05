package cn.cumt.practice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcatTest {
    public static void main(String[] args) {

        Stream<String> streamA = Stream.of("黄蓉","郭靖");
        Stream<String> streamB = Stream.of("小龙女","杨过");

        Stream<String> streamC = Stream.concat(streamA, streamB);

        //streamC.forEach(s -> System.out.println(s));
        streamC.forEach(System.out::println);

        //List<String> list = streamC.collect(Collectors.toList());

        //System.out.println(list);
    }

}
