package Day37;

import org.junit.Test;

import java.rmi.Remote;
import java.util.*;

/**
 * @ClassName: IteratorTest
 * @Description: 集合元素的遍历操作，使用迭代器Iterator接口
 * @Author: TianXing.Xue
 * @Date: 2021/8/2 11:47
 * @Version: 1.0
 * <p>
 *      1.内部的方法：hasNext() 和 Next()
 *      2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
 *      3.内部定义了remove()，可以在遍历的时候，删除集合中的元素，此方法不同于集合直接调用remove()
 **/
public class IteratorTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("TOM"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        Iterator iterator = coll.iterator();

        System.out.println(iterator.next());
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("TOM"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        Iterator iterator = coll.iterator();
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("TOM"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        //删除集合中的“TOM”
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if ("TOM".equals(obj)) {
                iterator.remove();
            }
        }

        //遍历集合
        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}

