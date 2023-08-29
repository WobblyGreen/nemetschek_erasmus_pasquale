import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Task3 {
    public static void main(String[] args){
        ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(1,3,2,2,5,2,3,7));
        System.out.println(maximumLhs(getLhsThresholds(ar), ar));

    }

    public static ArrayList<Integer> getLhsThresholds(ArrayList<Integer> nums){
        HashSet<Integer> uniqueIntegers = new HashSet<>();
        uniqueIntegers.addAll(nums);

        ArrayList<Integer> thresholds = new ArrayList<>();

        for(int num : uniqueIntegers){
            if(uniqueIntegers.contains(num+1)){
                thresholds.add(num);
                thresholds.add(num+1);
            }

            if(uniqueIntegers.contains(num-1)){
                thresholds.add(num);
                thresholds.add(num-1);
            }

            //logic to remove num in order to avoid duplicates uniqueIntegers.remove(num);
        }

        return thresholds;
    }

    private static ArrayList<Integer> maximumLhs(ArrayList<Integer> lhs, ArrayList<Integer> nums){
        if(lhs.isEmpty()) return null;

        int max=0;
        ArrayList<Integer> maxLHS = null;
        for(int i=0; i<lhs.size(); i+=2){
            int first = nums.indexOf(lhs.get(i));
            int second = nums.indexOf(lhs.get(i+1));

            int start = first < second ? first : second;

            first = nums.lastIndexOf(lhs.get(i));
            second = nums.lastIndexOf(lhs.get(i));

            int end = first > second ? first : second;

            ArrayList<Integer> slice = new ArrayList<>(nums.subList(start, end+1));
            filterArray(slice, first, second);

            if(slice.size()>max){
                max=slice.size();
                maxLHS=slice;
            }
        }
        return maxLHS;
    }

    private static ArrayList<Integer> filterArray(ArrayList<Integer> arraylist, int first, int second){
        for(int i=arraylist.size()-1; i>=0; i--){
            if(arraylist.get(i)!=first || arraylist.get(i)!=second)
                arraylist.remove(i);
        }
        
        return arraylist;
    }
}
