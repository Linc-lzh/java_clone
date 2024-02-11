package cn.itcast.domain;

import java.io.Serializable;

public class Grandson implements Serializable {

    private String name;
    private Integer age;

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

    @Override
    public String toString() {
        return "Grandson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}