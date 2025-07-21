import java.util.*;

public class ArrayAndString {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
            c[t.charAt(i) - 'a']--;
        }

        for (int a : c) {
            if (a != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visitedNumbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ans = target - nums[i];
            if (visitedNumbers.containsKey(ans)) {
                return new int[]{i, visitedNumbers.get(ans)};
            }
            visitedNumbers.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return sb.toString().equals(sb.reverse().toString());
        /*
        if (s.length() == 0) {
            return true;
        }
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (r > l && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
         */
    }

    public int maxProfit(int[] prices) {
        int pist = 0;
        int maxProfit = 0;
        int lsp = Integer.MAX_VALUE;
        for (int i : prices) {
            if (i < lsp)
                lsp = i;
            pist = i - lsp;
            if (pist > maxProfit) {
                maxProfit = pist;
            }
        }
        return maxProfit;
    }

}
