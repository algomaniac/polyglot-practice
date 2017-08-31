package me.algomaniac.polyglotpractice.sorting;

import com.google.common.base.Joiner;
import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tapan on 01-07-2017.
 */
public class InsertionSortImpl {

    public void run(int[] input)
    {
        System.out.println("Input is : " + Joiner.on(",").join(Ints.asList(input)));
        int[] sortedArray = this.insertionSort(input);
        System.out.println("Sorted Input is : " + Joiner.on(",").join(Ints.asList(sortedArray)));
    }

    public void runSilent(int[] input) {
        int[] sortedArray = this.insertionSort(input);
    }

    private int[] insertionSort(int[] unsorted) {

        for(int i = 1;i < unsorted.length;i++) {

            int j = i - 1;
            int curr = unsorted[i];
            while(j >= 0 && curr < unsorted[j]) {
                unsorted[j+1] = unsorted[j];
                j--;
            }
            unsorted[j+1] = curr;
        }
        return unsorted;
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
