package LeetCode8;

import java.util.HashMap;
import java.util.HashSet;

public class Count_Substring_Containing_Every_Vowel {
	static HashSet<Character > set = new HashSet<>();
    public static long countOfSubstrings(String s, int k) {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        long a = get(s,k);
        long b =get(s, k + 1);
        return a - b;
    }
    public static long get(String s, int k){
        int i = 0;
        int j = 0;
        long ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int c =0;
        while(i < s.length()){
            char chi =s.charAt(i);
            if(set.contains(chi)){
                map.put(chi, map.getOrDefault(chi, 0) + 1);
            }else c++;
            while(map.size() == 5 && c >= k){
                ans += (long)(s.length() - i);

                char chj = s.charAt(j);
                if(set.contains(chj)){
                    if(map.get(chj) == 1) map.remove(chj);
                    else map.put(chj, map.get(chj) - 1);
                }else c--;

                j++;
            }
            i++;
        }
        return ans;
    }

	public static void main(String[] args) {
		String word = "ieaouqqieaouqq";
		int k = 1;
		System.out.println(countOfSubstrings(word, k));
	}

}
