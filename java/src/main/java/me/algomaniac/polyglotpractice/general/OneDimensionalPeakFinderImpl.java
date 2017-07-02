package me.algomaniac.polyglotpractice.general;

import java.util.Arrays;

import static java.lang.Math.floorDiv;

/**
 * Created by tapan on 01-07-2017.
 */
public class OneDimensionalPeakFinderImpl {

    //Uses divide and conquer strategy

    public void run(int[] input)
    {
        int currIndex = input.length;

    }

    public int findPeak(int[] input) {

        int key = floorDiv(input.length, 2);
        return 0;
    }

    private int[] slice(int[] input,int startIndex, SliceDirection direction) {

        int[] result = new int[input.length]

        switch (direction) {
            case Left:
                Arrays.asList(input).subList(0,startIndex).toArray(int[])
                break;
            case Right:
                break;
            default:
                break;
        }

    }

    enum SliceDirection {
        Left,
        Right
    }


}
