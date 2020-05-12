package com.volkodav4ik;

import java.util.Arrays;

public class MyBigInteger {

    private static final int TEN = 10;
    private final int[] arr;

    public MyBigInteger(int[] val) {
        this.arr = val;
    }

    public MyBigInteger add(MyBigInteger val) {
        int arrLenght;
        int[] bigger;
        int[] smaller;
        if (val.arr.length > this.arr.length) {
            arrLenght = val.arr.length;
            bigger = reverseArray(Arrays.copyOf(val.arr, val.arr.length));
            smaller = reverseArray(Arrays.copyOf(this.arr, this.arr.length));
        } else {
            arrLenght = this.arr.length;
            bigger = reverseArray(Arrays.copyOf(this.arr, this.arr.length));
            smaller = reverseArray(Arrays.copyOf(val.arr, val.arr.length));
        }
        int[] resultArr = new int[arrLenght];
        int rest = 0;
        for (int i = 0; i < bigger.length; i++) {
            if (i < smaller.length) {
                int sum = bigger[i] + smaller[i] + rest;
                if (sum >= 10) {
                    rest = 1;
                    resultArr[i] = sum % TEN;
                } else {
                    rest = 0;
                    resultArr[i] = sum;
                }
            } else {
                resultArr[i] = bigger[i] + rest;
                rest = 0;
            }
            if (i == (resultArr.length - 1) && rest == 1) {
                int[] increasedArray = Arrays.copyOf(resultArr, resultArr.length + 1);
                increasedArray[increasedArray.length - 1] = 1;
                return new MyBigInteger(reverseArray(increasedArray));
            }
        }
        return new MyBigInteger(reverseArray(resultArr));
    }

    private static int[] reverseArray(int[] arr) {
        int middle = arr.length / 2;
        int index = 0;
        while (index < middle) {
            int tmp = arr[index];
            arr[index] = arr[arr.length - index - 1];
            arr[arr.length - index - 1] = tmp;
            index++;
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int value : this.arr) {
            sb.append(value);
        }
        return sb.toString();
    }
}

