package com.allen.springbootelasticjob.config;

/**
 * @Auther: 20190598
 * @Date: 2020/8/26 11:26
 * @Description:
 */
public class Foo {

    private Integer id;
    private String name;

    public Foo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Foo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
