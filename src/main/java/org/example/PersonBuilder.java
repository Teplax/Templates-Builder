package org.example;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder() {
        age = -1;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age couldn't be below zero");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (name == null && surname == null && age < 0 && address == null) {
            throw new IllegalStateException("There no one field value are specified");
        } else if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Field name value not specified");
        } else if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalStateException("Field surname value not specified");
        } else if (age < 0) {
            throw new IllegalStateException("Field age value not specified");
        } else if (address == null || address.trim().isEmpty()) {
            throw new IllegalStateException("Field address value not specified");
        }
        return new Person(name, surname, age, address);
    }
}
