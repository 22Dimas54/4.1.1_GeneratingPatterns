package ru.netology.honeybadger;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    private boolean hasAge() {
        if (getAge().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasAddress() {
        if (address == null) {
            return false;
        } else {
            return true;
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    public PersonBuilderImpl newChildBuilder() {
        PersonBuilderImpl personBuilder = new PersonBuilderImpl();
        personBuilder.setSurname(this.getSurname());
        personBuilder.setAddress(this.getAddress());
        return personBuilder;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        return name.equals(other.name) && surname.equals(other.surname) && age == other.age && address.equals(other.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    @Override
    public String toString() {
        return name + " " + surname + "(возраст:" + age + ", адрес:" + address + ")";
    }
}
