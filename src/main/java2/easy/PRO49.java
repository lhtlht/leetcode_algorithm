package easy;

import java.util.*;

public class PRO49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str: strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());

    }

    public static void main(String[] args) {
        PRO49 p = new PRO49();
        System.out.println(p.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

    }
}
