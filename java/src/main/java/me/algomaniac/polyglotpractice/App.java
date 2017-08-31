package me.algomaniac.polyglotpractice;

import me.algomaniac.polyglotpractice.general.OneDimensionalPeakFinderImpl;
import me.algomaniac.polyglotpractice.general.TwoDimensionalPeakFinderImpl;
import me.algomaniac.polyglotpractice.sorting.HeapSortImpl;
import me.algomaniac.polyglotpractice.sorting.InsertionSortImpl;
import me.algomaniac.polyglotpractice.sorting.MergeSortImpl;
import me.algomaniac.polyglotpractice.sorting.SortingComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.floorMod;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )    {

//        System.out.println("Testing One Dimensional Peak finding algorithm");
//        for(Integer[] input:OneDimensionalPeakFinderImpl.generateTestInput()) {
//            new OneDimensionalPeakFinderImpl().run(input);
//        }

//        System.out.println("Testing Two Dimensional Peak finding algorithm");
//        for(Integer[][] input:TwoDimensionalPeakFinderImpl.generateTestInput()) {
//            new TwoDimensionalPeakFinderImpl().run(input);
//        }

//        System.out.println("Testing Insertion sort algorithm");
//        for(int[] input: InsertionSortImpl.generateTestInput()) {
//            new InsertionSortImpl().run(input);
//        }

//        System.out.println("Testing Merge sort algorithm");
//        for(int[] input: MergeSortImpl.generateTestInput()) {
//            new MergeSortImpl().run(input);
//        }

//        System.out.println("Testing Heap sort algorithm");
//        for(int[] input: HeapSortImpl.generateTestInput()) {
//            new HeapSortImpl().run(input);
//        }

        (new SortingComparator()).runComparision();
    }
}
