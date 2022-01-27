package jz;

public class JZ11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left)/2;

            if(numbers[mid] > numbers[right]) {
                left = mid+1;
            } else if (numbers[mid] == numbers[right]){
                right --;
            } else {
                right = mid;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        JZ11 j = new JZ11();
        System.out.println(j.minArray(new int[] {3,4,5,1,2})); //1
        System.out.println(j.minArray(new int[] {2,2,2,0,1})); //0
        System.out.println(j.minArray(new int[] {7,8,9,1,2,3,4}));
    }
}
