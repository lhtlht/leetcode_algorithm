package easy;

import java.util.HashMap;
import java.util.Map;

public class Solution383 {
    /*
    383. 赎金信
    给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。

    (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)



    注意：

    你可以假设两个字符串均只含有小写字母。

    canConstruct("a", "b") -> false
    canConstruct("aa", "ab") -> false
    canConstruct("aa", "aab") -> true
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineMap = new HashMap<Character, Integer>();
        for (int i=0; i<magazine.length(); i++) {
            magazineMap.put(magazine.charAt(i),magazineMap.getOrDefault(magazine.charAt(i),0)+1);
        }
        for (int j=0; j<ransomNote.length(); j++) {
            if (magazineMap.containsKey(ransomNote.charAt(j)) && magazineMap.get(ransomNote.charAt(j))>0) {
                magazineMap.put(ransomNote.charAt(j),magazineMap.get(ransomNote.charAt(j))-1);
            } else {
                return false;
            }
        }
        return true;

    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] magazineMap = new int[26];
        for (int i=0; i<magazine.length(); i++) {
            magazineMap[magazine.charAt(i)-'a']++;
        }
        for (int j=0; j<ransomNote.length(); j++) {
            if (magazineMap[ransomNote.charAt(j)-'a']>0) {
                magazineMap[ransomNote.charAt(j)-'a']--;
            } else {
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {

    }
}
