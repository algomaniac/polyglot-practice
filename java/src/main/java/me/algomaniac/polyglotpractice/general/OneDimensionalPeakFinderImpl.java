package me.algomaniac.polyglotpractice.general;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.floorDiv;

/**
 * Created by tapan on 01-07-2017.
 */
public class OneDimensionalPeakFinderImpl {

    //Uses divide and conquer strategy

    public void run(Integer[] input)
    {
        Integer peak = findPeak(input);
        System.out.println("Input is : " + Joiner.on(",").join(input));
        System.out.println("Peak value is " + peak.intValue());
    }

    private int findPeak(Integer[] input) {

        int key = floorDiv(input.length, 2);

        if((key <= 0 || input[key] >= input[key - 1]) && (key >= (input.length - 1) || input[key] >= input[key + 1])) {
            return input[key];
        }
        else if(key > 0 && input[key] < input[key - 1]) {
            return findPeak(slice(input,key,SliceDirection.Left));
        }
        else {
            return findPeak(slice(input,key,SliceDirection.Right));
        }

    }

    private Integer[] slice(Integer[] input,int startIndex, SliceDirection direction) {

        int sliceSize = Math.abs(startIndex - (direction.equals(SliceDirection.Left)? 0 : (input.length - 1)));
        Integer[] result = new Integer[sliceSize];

        switch (direction) {
            case Left:
                Arrays.asList(input).subList(0,startIndex).toArray(result);
                break;
            case Right:
                Arrays.asList(input).subList(startIndex + 1,input.length).toArray(result);
                break;
        }
        return result;
    }

    public static List<Integer[]> generateTestInput() {
        List<Integer[]> inputs = new ArrayList<>();

        inputs.add(new Integer[]{1,2,3,4,5,4,3,2,1,0});
        inputs.add(new Integer[]{9,8,7,6,5,4,3,2,1,0});
        inputs.add(new Integer[]{1,2,3,4,5,6,7,8,9,10});
        inputs.add(new Integer[]{1,5,2,8,3,6,1,2,9,6});
        inputs.add(new Integer[]{1,4,9,7,3,4,7,8,8,2});
        inputs.add(new Integer[]{1,2,5,7,7,7,7,6,5,4});
        inputs.add(new Integer[]{3,7,7,6,5,4,3,2,1,0});

        return inputs;
    }


}
