package LeetCode3;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
	List<Integer> prefix ;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }
    
    public void add(int num) {
        if(num==0) {
        	prefix.clear();
        	prefix.add(1);
        }else {
        	prefix.add(prefix.get(prefix.size() - 1) * num); 
        }
    }
    
    public int getProduct(int k) {
        int size =prefix.size();
        if(k>=size) {
        	return 0;
        }return prefix.get(size-1)/prefix.get(size-1-k);
    }
}
