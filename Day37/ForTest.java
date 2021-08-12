package Day37;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName: ForTest
 * @Description: jdk 5.0新增了foreach集合，用于遍历集合、数组
 * @Author: TianXing.Xue
 * @Date: 2021/8/2 13:31
 * @Version:
 **/
public class ForTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("TOM"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        //for(集合中元素的类型 局部变量 : 集合对象)
        //内部仍然调用迭代器
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        //for(数组中元素的类型 局部变量 : 数组对象)
        for (int i : arr) {
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        String[] arr = new String[]{"MM", "MM", "MM"};

//        //方式一：普通for循环赋值
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";
//        }

        //方式二：增强for循环
        for (String s:arr){
            s = "GG";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
