import java.util.ArrayList;
import java.util.HashSet;

public class Task3 {
    public int findLHS(int[] nums) {
        ArrayList<Integer> ar = new ArrayList<>();
        for(int num : nums)
            ar.add(num);
        return maximumLhs(getLhsThresholds(ar), ar);
    }

    /**
     * creates an array with pairs of matching integers.
     * A pair of matching integers is made of initial_num, plus/minus_one_of_initial
     * @param nums
     * @return
     */
    public static ArrayList<Integer> getLhsThresholds(ArrayList<Integer> nums){
        HashSet<Integer> uniqueIntegers = new HashSet<>();
        uniqueIntegers.addAll(nums);

        ArrayList<Integer> pairs = new ArrayList<>();

        for(int num : uniqueIntegers){
            if(pairs.contains(num)) continue;
            if(uniqueIntegers.contains(num+1)){
                pairs.add(num);
                pairs.add(num+1);
            }

            if(uniqueIntegers.contains(num-1)){
                pairs.add(num);
                pairs.add(num-1);
            }

            //optimazation todo: logic to remove num in order to avoid duplicates uniqueIntegers.remove(num);
        }

        return pairs;
    }

    /**
     * finds the longest sequence made only of lhs pairs in nums and returns the length of the sequence
     * @param lhs
     * @param nums
     * @return 
     */
    private static int maximumLhs(ArrayList<Integer> lhs, ArrayList<Integer> nums){
        if(lhs.isEmpty()) return 0;

        int max=0;
        ArrayList<Integer> maxLHS = null;
        for(int i=0; i<lhs.size(); i+=2){
            int first = nums.indexOf(lhs.get(i));
            int second = nums.indexOf(lhs.get(i+1));

            int start = first < second ? first : second;

            first = nums.lastIndexOf(lhs.get(i));
            second = nums.lastIndexOf(lhs.get(i+1));

            int end = first > second ? first : second;

            ArrayList<Integer> slice = new ArrayList<>(nums.subList(start, end+1));
            filterArray(slice, lhs.get(i), lhs.get(i+1));

            if(slice.size()>max){
                max=slice.size();
                maxLHS=slice;
            }
        }
        return max;
    }

    /**
     * Removes all numbers that are not equal to first and second from a sequence
     * @param arraylist
     * @param first
     * @param second
     * @return
     */
    private static ArrayList<Integer> filterArray(ArrayList<Integer> unfiltered, int first, int second){
        for(int i=unfiltered.size()-1; i>=0; i--){
            if(unfiltered.get(i)!=first && unfiltered.get(i)!=second)
                unfiltered.remove(i);
        }
        
        return unfiltered;
    }
}
