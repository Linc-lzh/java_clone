package cn.itcast.utils;

import cn.itcast.domain.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class TestUtils {

    /**
     * 需求：使用new关键字和反射创建内容一模一样的对象，并且打印他们哈希值。
     * */
    @Test
    public void test1() throws Exception {
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(18);

        System.out.println(p1+":"+p1.hashCode());
        System.out.println(p2+":"+p2.hashCode());

        Class clazz = Class.forName("cn.itcast.domain.Person");
        Person p3 = (Person) clazz.getConstructor().newInstance();
        p3.setName("李四");
        p3.setAge(28);

        Person p4 = (Person) clazz.getConstructor().newInstance();
        p4.setName("李四");
        p4.setAge(28);

        System.out.println(p3+":"+p3.hashCode());
        System.out.println(p4+":"+p4.hashCode());
    }

    @Test
    public void test2() throws Exception {

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);

        Person p2 = p1.clone();

        System.out.println(p1+":"+p1.hashCode());
        System.out.println(p2+":"+p2.hashCode());

    }

    /**
     * 需求：测试克隆对象和原对象之间成员变量的联系
     * */
    @Test
    public void test3() throws Exception {

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(28);

        Children children1 = new Children();
        children1.setName("张伟");
        children1.setAge(5);
        p1.setChild(children1);

        Person p2 = p1.clone();

        System.out.println(p1+":对象的哈希值："+p1.hashCode()+":child成员变量的哈希值："+p1.getChild().hashCode());
        System.out.println(p2+":对象的哈希值："+p2.hashCode()+":child成员变量的哈希值："+p2.getChild().hashCode());

    }

    /**
     * 需求：测试浅表复制的弊端
     * */
    @Test
    public void test4() throws Exception {

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(28);

        Children children1 = new Children();
        children1.setName("张伟");
        children1.setAge(5);
        p1.setChild(children1);

        Person p2 = p1.clone();

        System.out.println(p1.getChild());
        System.out.println(p2.getChild());

        children1.setName("张三丰");
        System.out.println(p1.getChild());
        System.out.println(p2.getChild());

        Children children2 = p2.getChild();
        children2.setName("张无忌");
        System.out.println(p1.getChild());
        System.out.println(p2.getChild());


    }

    /**
     * 需求：测试深层复制
     * */
    @Test
    public void test5() throws Exception {

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(28);

        Children children1 = new Children();
        children1.setName("张伟");
        children1.setAge(5);
        p1.setChild(children1);

        Person p2 = p1.clone();

        System.out.println(p1.getChild());
        System.out.println(p2.getChild());

        children1.setName("张三丰");
        System.out.println(p1.getChild());
        System.out.println(p2.getChild());

        Children children2 = p2.getChild();
        children2.setName("张无忌");
        System.out.println(p1.getChild());
        System.out.println(p2.getChild());

        System.out.println(p1.getChild().hashCode());
        System.out.println(p2.getChild().hashCode());
    }
    /**
     *  1 重复实现cloneable接口
     *  2 重复实现clone方法
     *  3 重复改写Person类的clone方法
     * */
    @Test
    public void test6() throws Exception {

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(58);

        Children children1 = new Children();
        children1.setName("张伟");
        children1.setAge(25);
        p1.setChild(children1);

        Grandson grandson = new Grandson();
        grandson.setAge(2);
        grandson.setName("张无忌");
        p1.setGdson(grandson);

        Person p2 = p1.clone();

        System.out.println(p1.getGdson()+":"+p1.getGdson().hashCode());
        System.out.println(p2.getGdson()+":"+p2.getGdson().hashCode());

    }

    @Test
    public void test7() throws Exception {
        User user = new User();
        user.setName("李四");
        user.setAge(18);

        //1. 创建ByteArrayOutputStream，将数据可以转换成字节
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        //2. 创建ObjectOutputStream，关联ByteArrayOutputStream
        ObjectOutputStream out = new ObjectOutputStream(bout);
        //3. 使用ObjectOutputStream的writeObject，读取要复制的对象
        out.writeObject(user);
        //4. 使用ByteArrayInputStream读取ByteArrayOutputStream的转换的对象字节数据
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        //5. 创建ObjectInputStream读取对象字节数据，创建新的对象
        ObjectInputStream in =  new ObjectInputStream(bin);
        User obj = (User) in.readObject();

        System.out.println(user+":"+user.hashCode());
        System.out.println(obj+":"+obj.hashCode());
    }

    @Test
    public void test8() throws Exception {

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(58);

        Children children1 = new Children();
        children1.setName("张伟");
        children1.setAge(25);
        p1.setChild(children1);

        Grandson grandson = new Grandson();
        grandson.setAge(2);
        grandson.setName("张无忌");
        p1.setGdson(grandson);

        Person p2 = p1.clone();

        System.out.println(p1.getChild()+":"+p1.getChild().hashCode());
        System.out.println(p2.getChild()+":"+p2.getChild().hashCode());

        System.out.println(p1.getGdson()+":"+p1.getGdson().hashCode());
        System.out.println(p2.getGdson()+":"+p2.getGdson().hashCode());

    }

    @Test
    public void test9() throws Exception {
        ExampleA exampleA = new ExampleA();
        Object clone = exampleA.clone();
        System.out.println(clone);

    }
}
