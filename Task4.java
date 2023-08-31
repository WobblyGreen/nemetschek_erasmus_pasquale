import java.util.ArrayList;

public class Task4 {
    public int singleNumber(int[] nums) {
        ArrayList<Integer> alreadyFound = new ArrayList<>();
        for(int n:nums){
            if(!alreadyFound.contains(n)) alreadyFound.add(n);
            else{
                alreadyFound.remove(Integer.valueOf(n));
            }
        }
        return alreadyFound.get(0);
    }
}