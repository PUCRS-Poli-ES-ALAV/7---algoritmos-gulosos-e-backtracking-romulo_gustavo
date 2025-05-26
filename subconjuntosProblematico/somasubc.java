import java.util.ArrayList;
import java.util.List;

public class somasubc {

    public static void main(String[] args) {
        int[] conjunto = {-7, -3, -2, 5, 8};
        List<Integer> result = findZeroSumSubset(conjunto, 0, new ArrayList<>());
        if (result != null && !result.isEmpty()) {
            System.out.println("Subset with sum zero: " + result);
        } else {
            System.out.println("No non-empty subset sums to zero.");
        }
    }

    
    public static List<Integer> findZeroSumSubset(int[] nums, int idx, List<Integer> current) {
        //not empty subsets
        if (!current.isEmpty() && sum(current) == 0) {
            return new ArrayList<>(current);
        }
        if (idx == nums.length) {
            return null;
        }

        //add the number
        current.add(nums[idx]);
        List<Integer> found = findZeroSumSubset(nums, idx + 1, current);
        if (found != null) return found;
        //remove number (back tracking)
        current.remove(current.size() - 1);

        return findZeroSumSubset(nums, idx + 1, current);
    }

    public static int sum(List<Integer> lst) {
        int s = 0;
        for (int n : lst) s += n;
        return s;
    }
}
