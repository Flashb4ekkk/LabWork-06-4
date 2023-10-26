package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> c = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.print("n = ");
        int n = scan.nextInt();
        if (n >= 1) {
            System.out.print("a = ");
            int a = scan.nextInt();
            System.out.print("b = ");
            int b = scan.nextInt();

            initArray(c, n);
            printList(c);
            int indexOfMinValue = searchIndexForMinValue(c);
            System.out.println("мінімальний номер елементу масиву по модулю = " + indexOfMinValue);
            int bsearchSumOfElements = searchSumOfElements(c);
            if (bsearchSumOfElements == 0) {
                System.out.println("Не можливо вирахувати суму елементів масива");
            } else {
                System.out.println("сума модулів елементів масиву = " + bsearchSumOfElements);
            }
            int numberOfShift = deleteRangeOfArray(c, a, b);
            printList(c);
            compareArray(c, numberOfShift);
            printList(c);
        } else {
            System.out.println("Масив не може мати менше одного елементу");
        }
    }

    public static void compareArray(ArrayList<Integer> c, int numberOfShift) {
        for (int i = 0; i < numberOfShift; i++) {
            c.remove(Integer.valueOf(0));
            c.add(0);
        }
    }


    public static int deleteRangeOfArray(ArrayList<Integer> c, int a, int b) {
        int shift = 0;
        for(int i = 0; i < c.size();i++){
            if(c.get(i) >= a && c.get(i) <= b){
                c.set(i, 0);
                shift++;
            }
        }
        return shift;
    }

    public static int searchIndexForMinValue(ArrayList<Integer> c) {
        int temp = 0;
        for (int i = 1; i < c.size(); i++) {
            if (Math.abs(c.get(i)) < Math.abs(c.get(temp))) {
                temp = i;
            }
        }
        return temp;
    }

    public static int searchFirstNegativeElement(ArrayList<Integer> c) {
        for (int j = 0; j < c.size(); j++) {
            if (c.get(j) < 0) {
                return j;
            }
        }
        return -1;
    }

    public static int searchSumOfElements(ArrayList<Integer> c) {
        int index = searchFirstNegativeElement(c);
        int sum = 0;
        if (index == -1) {
            System.out.println("В масиві немає від'ємних елементів або масив <= 1");
            return 0;
        } else {
            for (int i = index + 1; i < c.size(); i++) {
                sum += Math.abs(c.get(i));
            }
            return sum;
        }
    }

    public static void printList(ArrayList<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void initArray(ArrayList<Integer> list, int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            list.add(rand.nextInt(61) - 35);
        }
    }
}
