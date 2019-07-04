package org.pb.bean;

/**
 * @author boge.peng
 * @create 2019-04-14 20:36
 */
public class Employee {
    private int id;

    private String name;

    private int age;

    private double salary;

    private Address address;

    private Status status;

    public Employee() {}

    public Employee(int id) {
        this.id = id;
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(int id, String name, int age, double salary, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }

    public Employee(int id, String name, int age, double salary, Address address,Status status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
