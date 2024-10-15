package org.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age > 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(this.hasAge() ? age : 0);
    }

    public String getAddress() {
        return this.hasAddress()||address.trim().isEmpty() ? address : "Has no address";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        age++;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(surname);
        child.setAddress(address);
        child.setAge(0);
        return child;
    }

    @Override
    public String toString() {
        return "Person " + name + " " + surname + ", age=" + age + " years" + ", currently live at address: " + this.getAddress();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
