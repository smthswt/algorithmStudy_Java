package Prefix;

// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/description/

public class MinimumValuetoGetPositiveStepbyStepSum {
  public int minStartValue(int[] nums) {
    int prefixSum = 0;
    int minSum = 0; // 누적합 중 가장 작은 값 저장

    for (int num : nums) {
      prefixSum += num; //-3 + 2 + -3....= 2
      minSum = Math.min(minSum, prefixSum);  // 초기값 0과 비교(정수일 경우 0 유지), 음수일 경우 누적합의 최소값 갱신
    }

    return 1 - minSum;  // 누적합이 최소로 작을 때도 1 이상이 되려면 -> 시작 숫자
  }

  public static void main(String[] args) {
    MinimumValuetoGetPositiveStepbyStepSum m = new MinimumValuetoGetPositiveStepbyStepSum();

    int[] nums = {2,2,3,4,2};

    System.out.println(m.minStartValue(nums));
  }
}
