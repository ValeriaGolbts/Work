package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class Person {
    private String name;
    private int age;
    private String email;

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

    // Метод для сохранения в JSON
    public void saveToJson(String filename) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(this, writer);
        }
    }

    // Статический метод для загрузки
    public static Person loadFromJson(String filename) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            return gson.fromJson(reader, Person.class);
        }
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
            // Сохраняем
            person.saveToJson("person.json");
            System.out.println("Объект сохранен в person.json");

            // Загружаем
            Person loadedPerson = Person.loadFromJson("person.json");
            System.out.println("Объект загружен из person.json");

            // Выводим
            System.out.println("Исходный объект: " + person);
            System.out.println("Загруженный объект: " + loadedPerson);
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}