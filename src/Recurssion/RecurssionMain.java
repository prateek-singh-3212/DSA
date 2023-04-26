package Recurssion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RecurssionMain {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,6,7};
        List<List<Integer>> sets = new ArrayList<List<Integer>>();

        findSet(
                7,
                arr,
                sets,
                0,
                new ArrayList<Integer>()
        );
        System.out.println(sets);
    }

    public static void findSet(int target, int[] cand, List<List<Integer>> candList, int sum, List<Integer> currCand) {

        if(sum>target) {
            // No sum possible
            currCand.remove(currCand.size()-1);
            return;
        }

        if(sum == target) {
            // Sum found.
            List<Integer> data = new ArrayList<Integer>();
            data.addAll(currCand);
            data.sort(null);
            if (!candList.contains(data)) {
                candList.add(data);
            }
            currCand.remove(currCand.size()-1);
            return;
        }

        for(int i=0; i<cand.length; i++) {
            currCand.add(cand[i]);
            findSet(target, cand, candList, sum+cand[i], currCand);
        }

        if (currCand.size() > 0) {
            currCand.remove(currCand.size()-1);
        }
    }

    // Make subsets
    public static void makeSubSets(int index, int[] nums, List<Integer> subSets, List<List<Integer>> sets) {

        if(index == nums.length) {
            System.out.println(subSets);
            List<Integer> sub = new ArrayList<Integer>();
            sub.addAll(subSets);
            Collections.sort(sub);
            if (!sets.contains(sub)) {
                sets.add(sub);
            }
            return;
        }

        // Take.
        subSets.add(nums[index]);
        makeSubSets(index + 1, nums, subSets, sets);
        subSets.remove(subSets.size() - 1);
        makeSubSets(index+1, nums, subSets, sets);
    }

    // Print all subsets.
    private static void printSubSets(int index, int[] arr, int subSetIndex, int[] subSet) {
        if (index == 5) {
            int sum =0;
            for (int j : subSet) {
                sum = j + sum;
            }
            System.out.println(sum);
            return;
        }
        subSet[subSetIndex] = arr[index];
        printSubSets(index + 1, arr, subSetIndex+1, subSet); // Take.
        subSet[subSetIndex] = 0;
        printSubSets(index + 1, arr, subSetIndex, subSet); // Not Take.
    }
}
