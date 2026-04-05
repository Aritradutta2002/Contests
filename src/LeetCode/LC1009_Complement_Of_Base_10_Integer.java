package LeetCode;

/*
 * @lc app=leetcode id=1009 lang=java
 *
 * [1009] Complement of Base 10 Integer
 */

// @lc code=start
class LC1009_Complement_Of_Base_10_Integer {

    public int bitwiseComplement(int n) {
        String str = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
// @lc code=end
