package easy;

import java.util.*;

public class PRO347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        List<int[]> val = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            val.add(new int[] {entry.getKey(), entry.getValue()});
        }
        quickSort(val, 0, val.size()-1, res, 0, k);
        return res;
    }

    public void quickSort(List<int[]> vals, int l, int r, int[] res, int reIndex, int k) {
        int picked = (int)(Math.random()*(r-l+1))+l;
        Collections.swap(vals, picked, l);

        int pivot = vals.get(l)[1];
        int index = l;
        for (int i=l+1; i<=r; i++) {
            if (vals.get(i)[1] >= pivot) {
                Collections.swap(vals, index+1, i);
                index++;
            }
        }
        Collections.swap(vals, l, index);
        if (k <= index-l){
            quickSort(vals, l, index-1, res, reIndex, k);
        } else {
            for (int i=l; i<=index; i++) {
                res[reIndex++] = vals.get(i)[0];
            }
            if (k > index - l + 1) {
                quickSort(vals, index+1, r, res, reIndex, k-(index-l+1));
            }
        }
    }


    public static void main(String[] args) {
        PRO347 p = new PRO347();
        int[] res = p.topKFrequent(new int[] {1,1,1,2,2,3}, 2); //1 2 出现频率
        for (int num: res) {
            System.out.println(num);
        }
        //System.out.println(p.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4)); //4
    }

}
