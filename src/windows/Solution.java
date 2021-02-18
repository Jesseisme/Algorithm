package windows;

import java.util.HashMap;

/**
 * @Author: jesse
 * @Date: 2020/11/7
 * @Time: 8:41 AM
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int start = 0;
        int end = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))&&map.get(s.charAt(i))>=start) {
                start = map.get(s.charAt(i))+1;
            }
            map.put(s.charAt(i), i);
            end++;
            max = Math.max(max, end - start );
        }
        return max;
    }

}
