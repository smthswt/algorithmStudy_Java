package Prefix;

// https://leetcode.com/problems/running-sum-of-1d-array/

import java.util.Arrays;

public class RunningSumOf1dArray {
  public int[] runningSum(int[] nums) {
    int[] prefix = new int[nums.length];
    prefix[0] = nums[0]; // 첫번째 숫자

    for (int i = 1; i < nums.length; i++) { // 1부터 배열 길이만큼 반복
      prefix[i] = prefix[i - 1] + nums[i];  // 다음 누적합 계산 (직전 누적합 + 다음 새로운 요소)
    }

    return prefix;
  }

  public static void main(String[] args) {
    RunningSumOf1dArray r = new RunningSumOf1dArray();

    int[] nums = {1, 2, 3, 4, 5};

    System.out.println(Arrays.toString(r.runningSum(nums)));
  }
}
