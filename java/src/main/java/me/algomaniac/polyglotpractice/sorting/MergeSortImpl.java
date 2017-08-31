package me.algomaniac.polyglotpractice.sorting;

import com.google.common.base.Joiner;
import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.floorDiv;

/**
 * Created by tapan on 01-07-2017.
 */
public class MergeSortImpl {

    public void run(int[] input)
    {
        System.out.println("Input is : " + Joiner.on(",").join(Ints.asList(input)));
        int[] sortedArray = this.mergeSort(input);
        System.out.println("Sorted Input is : " + Joiner.on(",").join(Ints.asList(sortedArray)));
    }

    public void runSilent(int[] input) {
        int[] sortedArray = this.mergeSort(input);
    }

    private int[] mergeSort(int[] unsorted) {
        return mergeSort(unsorted,0,unsorted.length);
    }

    private int[] mergeSort(int[] unsorted, int startIndex, int lastIndex) {
        int midKey = floorDiv(lastIndex - startIndex,2);

        if(startIndex >= lastIndex) {
            return unsorted;
        } else {
            unsorted = mergeSort(unsorted,startIndex,midKey+1);
            unsorted = mergeSort(unsorted,midKey+1,lastIndex);
        }

        //Merge the two sorted pieces
        int[] mergedArray = new int[lastIndex-startIndex];
        int mergedArrayIndex = 0;
        int first = startIndex;
        int second = midKey + 1;

        while (first < midKey && second < lastIndex) {

            if(unsorted[first] > unsorted[second]) {
                mergedArray[mergedArrayIndex++] = unsorted[second];
                second++;
            }
            else {
                mergedArray[mergedArrayIndex++] = unsorted[first];
                first++;
            }
        }

        while (first < midKey)
            mergedArray[mergedArrayIndex++] = unsorted[first++];

        while (second < lastIndex)
            mergedArray[mergedArrayIndex++] = unsorted[second++];


        for(int offset=0;offset< mergedArray.length;offset++) {
            unsorted[startIndex + offset] = mergedArray[offset];
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
