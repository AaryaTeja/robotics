package com.company;

public class GenericExampleMain {
    public static void main(String[] args) {
        // Create a GenericContainer for Integers
        GenericContainer<Integer> intContainer = new GenericContainer<>(42);
        System.out.println("Integer Container Item: " + intContainer.getItem());

        // Create a GenericContainer for Strings
        GenericContainer<String> stringContainer = new GenericContainer<>("Generic String");
        System.out.println("String Container Item: " + stringContainer.getItem());

        // Create a GenericContainer for a custom object.
        GenericContainer<MyCustomClass> customContainer = new GenericContainer<>(new MyCustomClass("Custom Object"));
        System.out.println("Custom Container Item: " + customContainer.getItem().getDescription());
    }
}
