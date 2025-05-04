package com.company;

class GenericArrayExample<T> {
    private T[] array;

    public GenericArrayExample(int size) {
        // This is the tricky part! You can't directly create a generic array like this:
        //array = new T[size]; // This causes a compile-time error.

        // Instead, you have to use a workaround with Object[] and cast:
        array = (T[]) new Object[size];
    }

    public void set(int index, T value) {
        if (index >= 0 && index < array.length) {
            array[index] = value;
        } else {
            System.out.println("Index out of bounds.");
        }
    }

    public T get(int index) {
        if (index >= 0 && index < array.length) {
            return array[index];
        } else {
            System.out.println("Index out of bounds.");
            return null; // Or throw an exception
        }
    }

    public int length() {
        return array.length;
    }

    public void printArray(){
        for(T element: array){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GenericArrayExample<Integer> intArray = new GenericArrayExample<>(5);
        intArray.set(0, 10);
        intArray.set(1, 20);
        intArray.set(2, 30);

        System.out.println("Integer array:");
        intArray.printArray();

        GenericArrayExample<String> stringArray = new GenericArrayExample<>(3);
        stringArray.set(0, "Hello");
        stringArray.set(1, "World");

        System.out.println("String array:");
        stringArray.printArray();
    }
}