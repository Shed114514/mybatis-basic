package com.shed.domain;

import java.util.Date;

public class Member {
    private Integer mid;
    private String name;
    private Integer age;
    private Date birthday;

    public Member() {}

    public Member(Integer mid, String name, Integer age, Date birthday) {
        this.mid = mid;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
