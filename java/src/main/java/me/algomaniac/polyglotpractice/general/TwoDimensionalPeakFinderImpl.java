package me.algomaniac.polyglotpractice.general;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.floorDiv;

/**
 * Created by tapan on 01-07-2017.
 */
public class TwoDimensionalPeakFinderImpl {

    public void run(Integer[][] input)
    {
        Integer peak = findPeak(input);
        System.out.println("Input is");
        Arrays.stream(input).forEach(integers -> System.out.println(Joiner.on(",").join(integers)));
        System.out.println("Peak value is " + peak.intValue());
    }

    private int findPeak(Integer[][] input) {

        int colIndex = floorDiv(input[0].length, 2);
        int rowIndex = getGlobalMax(input,colIndex);

        if((colIndex <= 0 || input[rowIndex][colIndex] >= input[rowIndex][colIndex - 1]) && (colIndex >= (input[0].length - 1) || input[rowIndex][colIndex] >= input[rowIndex][colIndex + 1])) {
            return input[rowIndex][colIndex];
        }
        else if(colIndex > 0 && input[rowIndex][colIndex] < input[rowIndex][colIndex - 1]) {
            return findPeak(slice(input,colIndex, SliceDirection.Left));
        }
        else {
            return findPeak(slice(input,colIndex, SliceDirection.Right));
        }
    }

    private int getGlobalMax(Integer[][] input,int columnIndex) {
        List<Integer> columnList = new ArrayList<>();
        Arrays.stream(input).forEach(integers -> columnList.add(integers[columnIndex]));
        return columnList.indexOf(columnList.stream().max(Integer::compareTo).get());
    }

    private Integer[][] slice(Integer[][] input,int startColIndex, SliceDirection direction) {

        int sliceSize = Math.abs(startColIndex - (direction.equals(SliceDirection.Left)? 0 : (input[0].length - 1)));
        int[] indices = direction.equals(SliceDirection.Left)? new int[]{0,startColIndex}:new int[]{startColIndex + 1,input[0].length};
        Integer[][] result = new Integer[input.length][];

        for(int i =0;i < input.length;i++)
        {
            result[i] = Arrays.asList(input[i]).subList(indices[0],indices[1]).toArray(new Integer[sliceSize]);
        }

        return result;
    }

    public static List<Integer[][]> generateTestInput() {
        List<Integer[][]> inputs = new ArrayList<>();

        inputs.add(new Integer[][]{
                {1,2,3,4},
                {3,0,2,6},
                {6,1,1,7}
        });

        inputs.add(new Integer[][]{
                {1,5,3,2},
                {3,9,2,6},
                {6,1,1,7}
        });

        return inputs;
    }
}
