package ru.netology.honeybadger;

public class PersonBuilder implements IPersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age > 0) {
            this.age = age;
            return this;
        } else {
            throw new IllegalArgumentException("Возраст не может быть отрицательным!");
        }
    }

    public PersonBuilder setAddress(String address) {
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
