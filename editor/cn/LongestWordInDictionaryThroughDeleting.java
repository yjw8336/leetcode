//给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符
//串。如果答案不存在，则返回空字符串。
//
// 示例 1:
//
//
//输入:
//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//输出:
//"apple"
//
//
// 示例 2:
//
//
//输入:
//s = "abpcplea", d = ["a","b","c"]
//
//输出:
//"a"
//
//
// 说明:
//
//
// 所有输入的字符串只包含小写字母。
// 字典的大小不会超过 1000。
// 所有输入的字符串长度不会超过 1000。
//
// Related Topics 排序 双指针
// 👍 145 👎 0

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ø
 * [524]通过删除字母匹配到字典里最长单词
 */
class LongestWordInDictionaryThroughDeleting {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String findLongestWord(String s, List<String> dictionary) {
            return dictionary.stream().filter(word -> {
                if (word.equals(s)) {
                    return true;
                }
                if (word.length() > s.length()) {
                    return false;
                }

                int j = 0;
                for (int i = 0; i < s.length() && j < word.length(); i++) {
                    if (word.charAt(j) == s.charAt(i))
                        j++;
                }
                return j == word.length();
            }).min((a, b) -> {
                if (a.length() != b.length()) {
                    return b.length() - a.length();
                }
                return a.compareTo(b);
            }).orElse("");

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
        List<String> collect = Stream.of("ale", "apple", "monkey", "plea").collect(Collectors.toList());
        String longestWord = solution.findLongestWord("abpcplea", collect);
        System.out.println(longestWord);
        collect = Stream.of("a", "b", "c").collect(Collectors.toList());
        longestWord = solution.findLongestWord("abpcplea", collect);
        System.out.println(longestWord);
    }

}
