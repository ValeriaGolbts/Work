package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Person {
    private String name;
    private int age;
    private String email;

    // Конструктор по умолчанию нужен для Jackson
    public Person() {}

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Геттеры и сеттеры
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Метод для сохранения в JSON файл
    public void saveToJson(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filename), this);
    }

    // Статический метод для загрузки из JSON файла
    public static Person loadFromJson(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), Person.class);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // Создаем объект
        Person person = new Person("Иван Иванов", 30, "ivan@example.com");

        try {
            // Сохраняем в JSON
            person.saveToJson("person.json");
            System.out.println("Объект сохранен в person.json");

            // Загружаем из JSON
            Person loadedPerson = Person.loadFromJson("person.json");
            System.out.println("Объект загружен из person.json");

            // Выводим для проверки
            System.out.println("Исходный объект: " + person);
            System.out.println("Загруженный объект: " + loadedPerson);
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}