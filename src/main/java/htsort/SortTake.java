package htsort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class SortTake {
    public int[] bubbleSort(int[] nums, boolean ascending) {
        /**
         * 平均时间复杂度O（n2），最坏O（n2），最好O（n）， 空间复杂度O（1）， 稳定
         */
        int noSortNums[] = new int[nums.length];
        System.arraycopy(nums,0, noSortNums,0, nums.length); //深拷贝
        for (int i=0; i<noSortNums.length-1; i++) {
            for (int j=i; j<noSortNums.length; j++) {
                if ((!ascending) && (noSortNums[i] < noSortNums[j])) { // 从大到小
                    int tmp = noSortNums[i];
                    noSortNums[i] = noSortNums[j];
                    noSortNums[j] = tmp;
                }
                if ((ascending) && (noSortNums[i] > noSortNums[j])) { // 从小到大
                    int tmp = noSortNums[i];
                    noSortNums[i] = noSortNums[j];
                    noSortNums[j] = tmp;
                }
            }
        }
        return noSortNums;
    }

    public int[] selectSort(int[] nums, boolean ascending) {
        /**
         * 时间复杂度平均O（n2），最坏O（n2），最好O（n2），空间复杂度O（1）， 不稳定
         * 不稳定例子：【5,8,5,2,9】 有一个比它小的数在跟它相等的数的后面，对换位置后稳定性被破坏
         */
        int noSortNums[] = new int[nums.length];
        System.arraycopy(nums, 0, noSortNums, 0, nums.length);
        for (int i=0; i<nums.length-1; i++) {
            int mIndex = i;
            for (int j=i+1; j<nums.length; j++) {
                if (ascending && noSortNums[j]<noSortNums[mIndex]) {
                    mIndex = j;
                }
                if (!ascending && noSortNums[j]>noSortNums[mIndex]) {
                    mIndex = j;
                }
            }
            int tmp = noSortNums[i];
            noSortNums[i] = noSortNums[mIndex];
            noSortNums[mIndex] = tmp;
        }
        return noSortNums;
    }

    public int[] insertSort(int[] nums, boolean ascending) {
        /**
         * 时间复杂度平均O(n2)、最坏O（n2）， 最好O（n）， 稳定
         */
        int noSortNums[] = new int[nums.length];
        System.arraycopy(nums, 0, noSortNums, 0, nums.length);
        int preIndex = 0;
        for (int i=1; i<noSortNums.length; i++) {
            preIndex = i-1;
            int curNum = noSortNums[i];
            while (preIndex>=0 && curNum<noSortNums[preIndex]) { //升序
                noSortNums[preIndex+1] = noSortNums[preIndex];
                preIndex --;
            }
            noSortNums[preIndex+1] = curNum;
        }
        return noSortNums;
    }

    public int[] shellSort(int[] nums, boolean ascending) {
        /**
         * 时间复杂度O（n^(3/2)）,最坏O（n^2）,最好O（n）
         * 空间复杂度O（1）
         *希尔排序（缩小增量排序） K的选择一般 N/2
         * 不稳定
         */
        int noSortNums[] = new int[nums.length];
        System.arraycopy(nums, 0, noSortNums, 0, nums.length);
        int k = noSortNums.length / 2;
        int i;
        int preIndex;
        int cur;
        while (k>=1) {
            for (i=k; i<noSortNums.length; i++) {
                cur = noSortNums[i];
                preIndex = i - k;
                while (preIndex>=0 && noSortNums[preIndex]>cur) { //升序
                    noSortNums[preIndex+k] = noSortNums[preIndex];
                    preIndex = preIndex -k;
                }
                noSortNums[preIndex+k] = cur;
            }
            k = k/2;

        }



        return noSortNums;

    }


    public void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[nums.length];
        int p1 = left;
        int p2 = mid+1;
        int k = left;
        while (p1<=mid && p2<=right) {
            if (nums[p1] <= nums[p2]) { //升序
                tmp[k++] = nums[p1++];
            } else {
                tmp[k++] = nums[p2++];
            }
        }
        while (p1<=mid) tmp[k++] = nums[p1++];
        while (p2<=right) tmp[k++] = nums[p2++];

        //复制回原数组
        for (int i=left; i<=right; i++) {
            nums[i] = tmp[i];
        }


    }
    public void mergeSort(int[] nums, int start, int end) {
        /**
         * 归并排序
         * 时间复杂度 nlog2n
         * 空间复杂度 n
         * 稳定
         */
        if (start<end) {
            int mid = (start+end)/2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid+1, end);
            //System.out.println(start+" "+mid+" "+end);
            merge(nums, start, mid, end);
        }



    }


    public void quickSort(int[] nums, int leftIndex, int rightIndex) {
        /**
         * 时间复杂度平均 nlog2（n），最坏n^2，
         * 空间复杂度log2（n）
         * 不稳定
         */
        if (leftIndex>=rightIndex) {
            return;
        }
        int left = leftIndex;
        int right = rightIndex;
        //基准值
        int key = nums[left];
        //左右交替扫描，直到left=right
        while (left < right) {
            while (left<right && nums[right]>=key) {
                right --;
            }
            nums[left] = nums[right];
            //左遍历
            while (left<right && nums[left]<=key) {
                left ++;
            }
            nums[right] = nums[left];
        }
        //基准值放中间
        nums[left] = key;
        quickSort(nums, leftIndex, left-1);
        quickSort(nums, right+1, rightIndex);
    }

    public void justHeap(int[] nums, int parent, int len) {
        int root = nums[parent]; //父节点
        int lchild = 2*parent+1;
        while (lchild<len) {
            int rchild = lchild + 1;
            //取两个孩子中最大的一个
            if (rchild<len && nums[rchild]>nums[lchild]) {
                lchild ++;
            }

            if (root > nums[lchild]) {
                break;
            }

            nums[parent] = nums[lchild];
            parent = lchild;
            lchild = 2*lchild+1;
        }
        nums[parent] = root;


    }
    public void heapSort(int[] nums) {
        /**
         *  时间复杂度nlog2n
         *  空间复杂度O（1）
         *  不稳定
         */
        //创建堆,大顶堆
        for (int i=(nums.length-1)/2; i>=0; i--) {
            justHeap(nums, i, nums.length);
        }

        //调整堆结构 交换堆顶元素进行交换, 使得最大的在最后面
        for (int i=nums.length-1; i>0; i--){
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;

            justHeap(nums, 0, i);
        }


    }

    public int[] countSort(int[] nums, int k) {
        /**
         * 复杂度都是n+k 稳定
         */
        int[] C = new int[k+1];
        int length = nums.length;
        int sum = 0;
        int[] B = new int[length];

        for (int i=0; i<length; i++) { //存放所有数字的计数
            C[nums[i]] += 1;
        }
        for (int i=0; i<k+1; i++) { //累计计数
            sum += C[i];
            C[i] = sum;
        }

        for (int i=length-1; i>=0; i--) {
            B[C[nums[i]]-1] = nums[i];
            C[nums[i]] --;
        }

        return B;

    }

    public void bucketSort(int[] nums) {
        /**
         * 时间复杂度：平均O(n+k), 最坏O(n^2), 最好O(n),
         * 空间复杂度：O（n+k）
         */
        //存储数组的最大最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i:nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        //桶数,假设均匀分布
        int bucketNum = (max-min) / nums.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<ArrayList<Integer>>(bucketNum);
        for (int i=0; i<bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放进桶
        for(int i = 0; i < nums.length; i++){
            int num = (nums[i] - min) / (nums.length);
            bucketArr.get(num).add(nums[i]);
        }

        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }

        System.out.println(bucketArr.toString());





    }

    //基数排序
    public void radixSort(int[] nums) {
        /**
         * 时间复杂度O（n*k）
         * 空间复杂度O（n+k）
         * 稳定
         *
         */
        //求最大值和位数
        int max = nums[0];
        int exp;
        for (int n : nums) {
            if (n>max) {
                max = n;
            }
        }

        for (exp=1; max/exp>0; exp*=10) {
            int[] tmp = new int[nums.length];
            int[] buckets = new int[10];

            //将数据出现的个数存放在桶中
            for (int v : nums) {
                buckets[(v/exp)%10] ++;
            }

            for (int i=1; i<10; i++) {
                buckets[i] += buckets[i-1];
            }

            for (int i=nums.length-1; i>=0; i--) { //从后开始遍历，重新排序
                tmp[buckets[(nums[i] / exp) % 10] - 1] = nums[i]; //得出该数值对应bucket的位置，
                buckets[(nums[i] / exp) % 10]--;
            }

            //
            System.arraycopy(tmp, 0, nums, 0, nums.length);
        }



    }

    public static void main(String[] args) {
        System.out.println("-----");
        int [] nums = {2,3,4,6,7,756,86,23,2,32};
        for (int i :nums) {
            System.out.print(i+",");
        }
        System.out.println();

        SortTake st = new SortTake();
        //冒泡排序法
//        int[] sortNums = st.bubbleSort(nums,true);
//        System.out.println("bubble sort:");
//        for (int i:sortNums) {
//            System.out.print(i + ",");
//        }
//        System.out.println();
        //选择排序法
//        sortNums = st.selectSort(nums, false);
//        System.out.println("select sort:");
//        for (int i:sortNums) {
//            System.out.print(i + ",");
//        }
//        System.out.println();

        //插入排序
//        sortNums = st.insertSort(nums, true);
//        System.out.println("insert sort:");
//        for (int i:sortNums) {
//            System.out.print(i + ",");
//        }
//        System.out.println();

        //希尔排序
//        sortNums = st.shellSort(nums, true);
//        System.out.println("shell sort:");
//        for (int i:sortNums) {
//            System.out.print(i + ",");
//        }
//        System.out.println();

        //归并排序
//        st.mergeSort(nums, 0, nums.length-1);
//        System.out.println("merge sort:");
//        for (int i:nums) {
//            System.out.print(i + ",");
//        }
//        System.out.println();


//        st.quickSort(nums, 0, nums.length-1);
//        System.out.println("quick sort:");
//        for (int i:nums) {
//            System.out.print(i + ",");
//        }
//        System.out.println();
//
//        st.heapSort(nums);
//        System.out.println("heap sort:");
//        for (int i:nums) {
//            System.out.print(i + ",");
//        }
//        System.out.println();

//        int[]B = st.countSort(nums, 800);
//        System.out.println("heap sort:");
//        for (int i:B) {
//            System.out.print(i + ",");
//        }
//        System.out.println();

//        st.bucketSort(nums);
//        System.out.println("heap sort:");
//        for (int i:B) {
//            System.out.print(i + ",");
//        }
//        System.out.println();

        st.radixSort(nums);
        System.out.println("radix sort:");
        for (int i:nums) {
            System.out.print(i + ",");
        }
        System.out.println();


    }
}
