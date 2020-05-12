package com.volkodav4ik;

public class Main {

    private int[] arr3;

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = {9, 8, 7, 6, 5, 4, 3, 2, 2};

        MyBigInteger bi1 = new MyBigInteger(arr1);
        MyBigInteger bi2 = new MyBigInteger(arr2);
        MyBigInteger bi3 = bi1.add(bi2);

        System.out.println(bi1.toString() + " + " + bi2.toString() + " = " + bi3.toString());

    }
}
