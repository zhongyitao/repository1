package cn.cumt.practice;

/*练习一：Pedicate接口使用
        请在测试类main方法中完成以下需求
        已知有Integer[] arr = {-12345, 9999, 520, 0,-38,-7758520,941213}
        使用lambda表达式创建Predicate对象p1,p1能判断整数是否是自然数(大于等于0)
        使用lambda表达式创建Predicate对象p2,p2能判断整数的绝对值是否大于100
        使用lambda表达式创建Predicate对象p3,p3能判断整数是否是偶数

        遍历arr，仅利用已创建的Predicate对象(不使用任何逻辑运算符)，完成以下需求
        打印自然数的个数
        打印负整数的个数
        打印绝对值大于100的偶数的个数
        打印是负整数或偶数的数的个数
*/


import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateTest {

    public static void main(String[] args) {
        //*请在测试类main方法中完成以下需求
        //已知有Integer[] arr = {-12345, 9999, 520, 0,-38,-7758520,941213}
        Integer[] arr = {-12345,9999,520,0,-38,-78768783,98947432};

        //使用lambda表达式创建Predicate对象p1,p1能判断整数是否是自然数(大于等于0)
        Predicate<Integer> p1 = integer -> integer >= 0;


        //使用lambda表达式创建Predicate对象p2,p2能判断整数的绝对值是否大于100
        Predicate<Integer> p2 = integer -> Math.abs(integer) >= 100;

        //使用lambda表达式创建Predicate对象p3,p3能判断整数是否是偶数
        Predicate<Integer> p3 = integer -> integer % 2 == 0;

        //遍历arr，仅利用已创建的Predicate对象(不使用任何逻辑运算符)，完成以下需求
        //打印自然数的个数
        long n = Stream.of(arr).filter(p1).count();
        System.out.println("自然数的个数:"+n);

        //打印负整数的个数
        long m = Arrays.stream(arr).filter(p1.negate()).count();
        System.out.println("负整数的个数:"+m);

        // 打印绝对值大于100的偶数的个数
        long a = Arrays.stream(arr).filter(p2.and(p3)).count();
        System.out.println("绝对值大于100的偶数的个数:"+a);

        //打印是负整数或偶数的数的个数*//**/
        long b = Arrays.stream(arr).filter(p1.negate().or(p3)).count();
        System.out.println("是负整数或偶数的数的个数:"+b);

    }
}
