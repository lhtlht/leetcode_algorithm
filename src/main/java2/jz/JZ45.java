package jz;

public class JZ45 {
    public String minNumber(int[] nums) {
        /*
        排序规则：
        字符串拼接：x+y > y+x, 则x>y
         */
        String[] strs = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length-1);
        StringBuffer restr = new StringBuffer();
        for (String s: strs) {
            restr.append(s);
        }
        return restr.toString();
    }

    void quickSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l;
        int j = r;
        String tmp = strs[i];
        while (i < j) {
            while (i<j && (strs[j]+strs[l]).compareTo(strs[l]+strs[j])>0) {
                j--;
            }
            while (i<j && (strs[i]+strs[l]).compareTo(strs[l]+strs[i])<=0) {
                i++;
            }
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i-1);
        quickSort(strs, i+1, r);

    }

    public static void main(String[] args) {
        JZ45 j = new JZ45();
        System.out.println(j.minNumber(new int[] {10,2})); //102
        System.out.println(j.minNumber(new int[] {3,30,34,5,9})); //"3033459"
    }
}
