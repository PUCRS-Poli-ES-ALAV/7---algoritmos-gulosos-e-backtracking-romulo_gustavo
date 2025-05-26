import java.util.ArrayList;
import java.util.List;

public class somasubc {
    static int countItr = 0;
    static int numInstrucoes = 0;
    public static void main(String[] args) {
        int[] conjunto = {-7, -3, -2, 5, 8};
        List<Integer> result = findZeroSumSubset(conjunto, 0, new ArrayList<>());
        for (int i = 0; i < conjunto.length; i++) {
            System.out.print("[" + i + "] = " + conjunto[i]+" ");
        }
        if (result != null && !result.isEmpty()) {
            System.out.println("\nSubset with sum zero: " + result);
        } else {
            System.out.println("No non-empty subset sums to zero.");
        }
        System.out.println("Num de Instrucoes: " + numInstrucoes);
        System.out.println("Num de Iteracoes: " + countItr);
        
    }

    
    public static List<Integer> findZeroSumSubset(int[] nums, int idx, List<Integer> current) {
        //not empty subsets
        countItr++;
        if (!current.isEmpty() && sum(current) == 0) {
            return new ArrayList<>(current);
        }
        if (idx == nums.length) {
            return null;
        }

        //add the number
        numInstrucoes++;
        current.add(nums[idx]);
        List<Integer> found = findZeroSumSubset(nums, idx + 1, current);
        if (found != null) return found;
        //remove number (back tracking)
        numInstrucoes++;
        current.remove(current.size() - 1);

        return findZeroSumSubset(nums, idx + 1, current);
    }

    public static int sum(List<Integer> lst) {
        int s = 0;
        countItr++;
        for (int n : lst) {
            numInstrucoes++;
            s += n;
        }
        return s;
    }
}
