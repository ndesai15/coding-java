import java.util.*;

public class Main {
  public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) 
            map.put(n, map.getOrDefault(n, 0) + 1);      
        
        List<Map.Entry<Integer, Integer>> entries = new ArrayList(map.entrySet());
        Collections.sort(entries, (a,b) -> b.getValue() - a.getValue());
        int c = 0;
        List<Integer> topNumbers = new ArrayList<>(k);
        for(Map.Entry<Integer, Integer> entry: entries){
           topNumbers.add(entry.getKey());
            c++;
            if(c==k) break;
    
        // Let's create a list of top k elements
        }   
        return topNumbers;
    }

    public static void main(String[] args) {

        List<Integer> result = findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
 
    }
}
