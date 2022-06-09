package ru.netology.honeybadger;

public class PersonBuilderImpl implements PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilderImpl setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilderImpl setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilderImpl setAge(int age) {
        if (age > 0) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException("Возраст не может быть отрицательным!");
        }
    }

    public PersonBuilderImpl setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() {
        if (name != null && surname != null && age >= 0 && address != null) {
            Person person = new Person(name, surname, age);
            person.setAddress(address);
            return person;
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append("\nНе указали достаточное количество данных:");
                builder.append("\nИмя - незаполнено!");
                builder.append("\nФамилия - незаполнено!");
                builder.append("\nВозраст - незаполнен или отрицательный!");
                builder.append("\nАдрес - незаполнено!");
            throw new IllegalStateException(builder.toString());
        }
    }


}
