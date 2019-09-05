package cn.cumt.practice;

/*
使用lambda表达式分别将以下功能封装到Function对象中
        求Integer类型ArrayList中所有元素的平均数
        将Map<String,Integer>中value存到ArrayList<Integer>中
        已知学生成绩如下

        姓名	成绩
        岑小村	59
        谷天洛	82
        渣渣辉	98
        蓝小月	65
        皮几万	70
        以学生姓名为key成绩为value创建集合并存储数据，使用刚刚创建的Function对象求学生的平均成绩
*/


import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionTest {

    public static void main(String[] args) {

//        求Integer类型ArrayList中所有元素的平均数
        Function<ArrayList<Integer> , Integer> f1 = list -> {

            Integer sum = 0;
            for (Integer number : list) {
                sum +=number;
            };
            return sum / list.size();
        };

        /*将Map<String,Integer>中value存到ArrayList<Integer>中
        已知学生成绩如下

        姓名	成绩
        岑小村	59
        谷天洛	82
        渣渣辉	98
        蓝小月	65
        皮几万	70*/
        Function<Map<String , Integer> , ArrayList<Integer>> f2 = map -> {

            ArrayList<Integer> values = new ArrayList();

            for (String key : map.keySet()) {
                values.add(map.get(key));
            };
            return values;
        };

        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("岑小村", 59);
        map.put("谷天洛", 82);
        map.put("渣渣辉", 98);
        map.put("蓝小月", 65);
        map.put("皮几万", 70);

        System.out.println("学生的平均成绩:" + f2.andThen(f1).apply(map));




    }

}
