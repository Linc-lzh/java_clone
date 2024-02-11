package cn.itcast.domain;

import java.io.*;

public class Person implements Cloneable,Serializable{
    private String name;
    private Integer age;
    private Children child;
    private Grandson gdson;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Children getChild() {
        return child;
    }

    public void setChild(Children child) {
        this.child = child;
    }

    public Grandson getGdson() {
        return gdson;
    }

    public void setGdson(Grandson gdson) {
        this.gdson = gdson;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", child=" + child +
                ", gdson=" + gdson +
                '}';
    }

    @Override
    public Person clone() {

        try {
            //1. 创建ByteArrayOutputStream，将数据可以转换成字节
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            //2. 创建ObjectOutputStream，关联ByteArrayOutputStream
            ObjectOutputStream out = new ObjectOutputStream(bout);
            //3. 使用ObjectOutputStream的writeObject，读取要复制的对象
            out.writeObject(this);
            //4. 使用ByteArrayInputStream读取ByteArrayOutputStream的转换的对象字节数据
            ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
            //5. 创建ObjectInputStream读取对象字节数据，创建新的对象
            ObjectInputStream in = new ObjectInputStream(bin);
            Person clone = (Person) in.readObject();
            return clone;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}