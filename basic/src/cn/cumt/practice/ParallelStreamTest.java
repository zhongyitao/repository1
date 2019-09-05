package cn.cumt.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;
import java.util.Collection;

public class ParallelStreamTest {

    public static void main(String[] args) {

        Collection<String> coll = new ArrayList();
        Collections.addAll(coll,"张无忌","张三丰","张翠山","周芷若","赵敏");
        Stream<String> parallelStream1 = coll.parallelStream();

        Stream<Integer> parallelStream2 = Stream.of(100, 200, 300, 400).parallel();


        parallelStream1.forEach(System.out::println);
        parallelStream2.forEach(System.out::println);




    }
}
