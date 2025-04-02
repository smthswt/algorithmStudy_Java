package SlidingWindow;

import java.util.List;

// https://leetcode.com/problems/maximum-average-subarray-i/

class MaximumAverageSubarray {
  public double findMaxAverage(int[] nums, int k) {
    int left = 0;
    int currSum = 0; // 현재 합
    int maxSum = Integer.MIN_VALUE; // 최대 합, 음수를 대비 자바에서 가질 수 있는 가장 작은 숫자로 초기화

    for (int right = 0; right < nums.length; right++) {
      currSum += nums[right];
      if (right - left + 1 == k){
        maxSum = Math.max(maxSum, currSum);
        currSum -= nums[left];
        left++;
      }
    }

    double answer = (double) maxSum / k;

    return answer;
  }

  public static void main(String[] args) {
    MaximumAverageSubarray m = new MaximumAverageSubarray();

    int[] nums = new int[] {1, 23, 234, 423 ,112, 23, 56, 965, 234};
    int k = 4;

    System.out.println(m.findMaxAverage(nums, k));
  }
}
