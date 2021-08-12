package Day37;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: ListTest
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/8/2 13:51
 * @Version: 1.0
 *
 *    |-----Collection接口：单列集合，用来存储一个一个的对象
 *       |-----List接口：存储有序的、可重复的数据。 --> “动态”数组
 *             |----ArrayList：作为List接口的主要实现类，线程不安全的，效率高；底层使用Object[]存储 elementData存储
 *             |----LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用双向链表存储
 *             |----Vector：作为List接口的古老实现类，线程安全的，效率低：底层使用Object[]存储
 *
 *   2.ArrayList源码分析：jdk 7情况下
 *     2.1 ArrayList list = new ArrayList(); //底层创建了长度是10的Object[] elementData数组
 *       list.add(123); //elementData[0] = new Integer(123)
 *       ...
 *       list.add(11); //如果此次的添加导致底层elementData数组容量不够，则扩容
 *       默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中
 *
 *       结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)
 *
 *     2.2 jdk 8中ArrayList的变化：
 *         ArrayList list = new ArrayList(); //底层Object[] elementData初始化为{}，并没有创建长度为10的数组
 *
 *         List.add(123); //第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到elementData[0]
 *         ...
 *         后续的添加和扩容操作和jdk 7无异
 *
 *     2.3 小结：jdk 7中的ArrayList的创建类似于单例的饿汉式，而jdk 8中的ArrayList的对象的创建类似于单例的懒汉式，
 *              延迟了数组的创建，节省内存。
 *
 *
 *   3.LinkedList的源码分析：
 *     LinkedList list = new LinkedList(); //内部声明了Node类型的first和last属性，默认值为null
 *     list.add(123); //将123封装到Node中，创建了Node对象
 *
 *     其中，Node定义为：体现了LinkedList的双向链表的说法
 *     Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *
 *
 *   面试题： ArrayList、LinkedList、Vector 三者的异同
 *   同：三个类都实现了List接口，存储的数据的特点相同：存储有序的，可重复的数据
 *   不同：见上
 *
 *   总结：常用方法
 *   增：add(Object obj)
 *   删：remove(int index) / remove(Object obj)
 *   改：set(int index, Object ele)
 *   查：get(int index)
 *   插：add(int index, Object ele)
 *   长度：size()
 *   遍历：①Iterator 迭代器方式
 *        ②增强for循环
 *        ③普通的循环
 **/

public class ListTest {

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 20));
        list.add(456);

        System.out.println(list);

        //void add(int )
        list.add("BB");
        System.out.println(list);

        //Boolean addAll(int index, Collection else):从index位置开始将else中的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list.size());

        //List subList(int fromIndex, int toIndex):返回从formIndex到toIndex位置的左闭右开子集合
        List subList = list.subList(2, 4);
        System.out.println(subList);
        System.out.println(list);

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(0));
    }

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 20));
        list.add(456);

        int index = list.indexOf(456);  //不存在就返回-1
        System.out.println(index);

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置。如果不存在，返回-1
        System.out.println(list.lastIndexOf(456));

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        //Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(1, "CC");
        System.out.println(list);
    }

    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        //方式一：使用迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("******************");

        //方式二：增强for循环
       for (Object obj : list) {
           System.out.println(obj);
       }

        System.out.println("******************");

       //方式三：普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

