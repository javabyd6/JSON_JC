package com.sda.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jarek Czaplicki
 */
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Jarek", "Czaplicki",40);
        Person person2 = new Person("Natalka", "Czaplicka",4);
        Person person3 = new Person("Maria", "Czaplicka",64);
        Person person4 = new Person("Ireneusz", "Czaplicki",73);
        List<Person> listOfPersons = new ArrayList<>();
        listOfPersons.add(person1);
        listOfPersons.add(person2);
        listOfPersons.add(person3);
        listOfPersons.add(person4);

        ObjectMapper mapper = new ObjectMapper();
        ObjectMapper mapperForPerson = new ObjectMapper();
        ObjectMapper mapperForStudents = new ObjectMapper();



        try {
            String personStr = mapper.writeValueAsString(person1);
            System.out.println(personStr);
            Files.write(Paths.get("person.json"), personStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Stworzyc liste typu Person i dodac do niej 4 obiekty Person
        // Zapisac liste do jsona


        try {
            String listOfPersonsStr = mapperForPerson.writeValueAsString(listOfPersons);
            System.out.println(listOfPersons);
            Files.write(Paths.get("persons.json"),listOfPersonsStr.getBytes());
            mapper.writeValue(new File("test.json"),listOfPersons); //działa na obiekcie i nie trzeba zmieniać go na Stringa
        } catch (IOException e) {
            e.printStackTrace();
        }

// Stworzyc liste typu Student i dodac do niej 3 obiekty Student
// Zapisac liste do jsona
        Address address = new Address("Bydgoszcz","Długa");

        Student student1 = new Student("Pierwszy", "Pierwszy", address);
        Student student2 = new Student("Drugi", "Drugi", new Address("Torun", "Długa 23"));
        Student student3 = new Student("Trzeci", "Trzeci", address);

        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(student1);
        listOfStudents.add(student2);
        listOfStudents.add(student3);

        try {
            String listOfStudentsStr = mapperForStudents.writeValueAsString(listOfStudents);
            System.out.println(listOfStudents);
            Files.write(Paths.get("students.json"),listOfStudentsStr.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }



    }



}
