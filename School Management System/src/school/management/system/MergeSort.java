package school.management.system;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {
    //This is to take user input to list number in array//
    ArrayList<Integer> takeInput(ArrayList<Integer> elements)
    {
        System.out.println("Welcome to Wolverhampton MergeSort Program:");
        System.out.println("--------------------------------------------------------------");
        Scanner ms = new Scanner(System.in);
        System.out.print("Please enter the number of elements you want in an array:");
        int a = ms.nextInt();
        System.out.println("--------------------------------------------------------------");
        System.out.print("Enter "+ a +" elements in an array:");
        for (int i = 0; i < a; i++) {
            elements.add(ms.nextInt());
        }
        ms.close();
        System.out.println("--------------------------------------------------------------");
        return elements;
    }
    //This is to return the answer after sorting in order.//
    void returnOutput(ArrayList<Integer> elements)
    {
        System.out.println("So, the Sorted Elements are: " + elements);
    }
    //This is to merge the input given by user.//
    void merge(ArrayList<Integer> elements, int srt, int bet, int end) {
        ArrayList<Integer> sortedElements = new ArrayList<Integer>();
        int j = bet + 1;
        int i = srt;
        while (i <= bet && j <= end) {
            if (elements.get(i) < elements.get(j)) {
                sortedElements.add(elements.get(i));
                i++;
            } else {
                sortedElements.add(elements.get(j));
                j++;
            }
        }
        for (int k = i; k <= bet; k++) sortedElements.add(elements.get(k));

        for (int k = 0; k < sortedElements.size(); k++) {
            elements.set(srt + k, sortedElements.get(k));
        }
    }

    void sort(ArrayList<Integer> elements, int srt, int end) {
        if (srt >= end) return;

        int bet = (srt + end) / 2;
        sort(elements, srt, bet);
        sort(elements, bet + 1, end);
        merge(elements, srt, bet, end);
    }

    public static void main(String[] args) {
        MergeSort msrt = new MergeSort();

        ArrayList<Integer> elements = new ArrayList<Integer>();
        msrt.takeInput(elements);
        msrt.sort(elements, 0, elements.size() - 1);
        msrt.returnOutput(elements);

    }
}
