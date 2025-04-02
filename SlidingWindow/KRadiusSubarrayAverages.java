package SlidingWindow;

import java.util.Arrays;

// https://leetcode.com/problems/k-radius-subarray-averages/

public class KRadiusSubarrayAverages {
  public int[] getAverages(int[] nums, int k) {
    int n = nums.length;
    int[] answer = new int[n];
    int windowSize = 2 * k + 1;

    if (windowSize > n) {
      // 전체 배열에 평균을 구할 수 없을 때
      Arrays.fill(answer, -1);
      return answer;
    }

    // 결과 기본값 -1로 채우기
    Arrays.fill(answer, -1);

    // 윈도우 합을 long으로 (오버플로우 방지)
    long windowSum = 0;

    // 초기 윈도우 (0 ~ windowSize-1)
    for (int i = 0; i < windowSize; i++) {
      windowSum += nums[i];
    }

    // 첫 중앙 인덱스에 평균 저장
    answer[k] = (int)(windowSum / windowSize);

    // 윈도우 슬라이딩
    for (int i = windowSize; i < n; i++) {
      // 왼쪽값 빼고 오른쪽값 더함
      windowSum = windowSum - nums[i - windowSize] + nums[i];
      int center = i - k;
      answer[center] = (int)(windowSum / windowSize);
    }

    return answer;
  }

  public static void main(String[] args) {
    KRadiusSubarrayAverages kr = new KRadiusSubarrayAverages();

    int[] nums = new int[] {7,4,3,9,1,8,5,2,6};
    int k = 3;

    System.out.println(Arrays.toString(kr.getAverages(nums, k)));
    System.out.println(kr.getAverages(nums, k));
  }
}
