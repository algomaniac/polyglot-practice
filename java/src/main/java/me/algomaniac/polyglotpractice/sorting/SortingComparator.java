package me.algomaniac.polyglotpractice.sorting;

import java.util.Random;
import java.util.stream.IntStream;

public class SortingComparator {

    public void runComparision() {


        for(int i = 0;i < 3;i++) {
            int[] input = generateInput(i);
            System.out.println("Input Size : " + input.length);


            long time = 0;
            for(int x = 0; x < 10;x++) {
                long startTime = System.nanoTime();
                new InsertionSortImpl().runSilent(input);
                time += (System.nanoTime() - startTime);
            }
            time = time / 10;
            System.out.println("Insertion Sort Time : " + time);


//            time = 0;
//            for(int x = 0; x < 10;x++) {
//                long startTime = System.currentTimeMillis();
//                new MergeSortImpl().runSilent(input);
//                time += (System.currentTimeMillis() - startTime)/1000;
//            }
//            time = time / 10;
//            System.out.println("Merge Sort Time : " + time);



            time = 0;
            for(int x = 0; x < 10;x++) {
                long startTime = System.nanoTime();
                new HeapSortImpl().runSilent(input);
                time += (System.nanoTime() - startTime);
            }
            time = time / 10;
            System.out.println("Heap Sort Time : " + time);
            System.out.println("\n\n");
        }

    }

    private int[] generateInput(int size) {

        int[] arr = null;
        switch (size) {
            case 0:
                arr = generateRandomArray(100);
                break;
            case 1 :
                arr = generateRandomArray(10000);
                break;
            case 2 :
                arr = generateRandomArray(1000000);
                break;
        }
        return arr;
    }

    private int[] generateRandomArray(long size) {
        IntStream ints = (new Random()).ints(size);
        return  ints.toArray();
    }

}

