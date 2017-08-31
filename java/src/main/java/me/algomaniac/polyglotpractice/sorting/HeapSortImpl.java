package me.algomaniac.polyglotpractice.sorting;

import com.google.common.base.Joiner;
import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floor;

/**
 * Created by tapan on 07-07-2017.
 */
public class HeapSortImpl {

    public void run(int[] input)
    {
        System.out.println("Input is : " + Joiner.on(",").join(Ints.asList(input)));
        int[] sortedArray = this.heapSort(input);
        System.out.println("Sorted Input is : " + Joiner.on(",").join(Ints.asList(sortedArray)));
    }

    public void runSilent(int[] input) {
        int[] sortedArray = this.heapSort(input);
    }

    private int[] heapSort(int[] unsorted) {

        int lastIndex = unsorted.length;
        int[] heapArray = build_max_heap(unsorted,unsorted.length);

        while (--lastIndex > 0) {
            swap(heapArray,0,lastIndex);
            heapArray = build_max_heap(unsorted,lastIndex);
        }
        return heapArray;
    }

    private int[] swap(int[] input, int startIndex,int endIndex) {

        int tmp = input[startIndex];
        input[startIndex] = input[endIndex];
        input[endIndex] = tmp;
        return input;
    }

    private int[] build_max_heap(int[] input,int length) {

        for(int i = (int)floor(length/2) - 1; i >= 0; i--) {
            max_heapify(input,i,length);
        }
        return input;
    }

    private int[] max_heapify(int[] input,int parentNodeIndex,int length) {

        int leftIndex = 2 * parentNodeIndex + 1;
        int rightIndex = 2 * parentNodeIndex + 2;

        if(leftIndex < length && input[parentNodeIndex] < input[leftIndex]) {

            if(rightIndex < length && input[rightIndex] > input[leftIndex]) {
                swap(input,parentNodeIndex,rightIndex);
                input = max_heapify(input,rightIndex,length);
                return input;
            } else {
                swap(input,parentNodeIndex,leftIndex);
                input = max_heapify(input,leftIndex,length);
                return input;
            }
        }


        if(rightIndex < length && input[parentNodeIndex] < input[rightIndex]) {
            if(leftIndex < length && input[leftIndex] > input[rightIndex]) {
                swap(input,parentNodeIndex,leftIndex);
                input = max_heapify(input,leftIndex,length);
                return input;
            } else {
                swap(input,parentNodeIndex,rightIndex);
                input = max_heapify(input,rightIndex,length);
                return input;
            }
        }

        return input;
    }

    public static List<int[]> generateTestInput() {
        List<int[]> inputs = new ArrayList<>();

        inputs.add(new int[]{1,9,5,6,3,2,4,7,8,10});
        inputs.add(new int[]{8,6,9,5,4,7,1,10,2,3});
        inputs.add(new int[]{6,5,2,1,4,7,10,8,9,3});
        inputs.add(new int[]{9,10,2,5,1,4,8,7,6,3});
        inputs.add(new int[]{10,3,5,7,8,6,9,4,2,1});
        inputs.add(new int[]{10,9,8,7,6,5,4,3,2,1});
        inputs.add(new int[]{1,2,3,4,5,6,7,8,9,10});

        return inputs;
    }
}


/* Notes
 * 1. You can reduce the number of comparisions using binary search
 */


