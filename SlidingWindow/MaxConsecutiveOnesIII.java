package SlidingWindow;

//https://leetcode.com/problems/max-consecutive-ones-iii/

class MaxConsecutiveOnesIII {
  public int longestOnes(int[] nums, int k) {
    int left = 0;
    int curr = 0; // 지나쳐온 0의 개수 (뒤집은)
    int ans = 0; // 뒤집은 0을 포함한 1들의 최대 길이

    for (int right = 0; right < nums.length; right++) { // 0. right 0~배열의 끝까지 반복
      if (nums[right] == 0) { // 2. 현재 숫자가 0이면 curr 1증가
        curr++;
      }

      while (curr > k) { // 3-1. curr가 k보다 크다면
        if (nums[left] == 0){  // 3-3. 첫번째 0을 찾으면, curr를 줄여서, 다시 위에 ans 길이를 늘려가는 반복문 시작.
          curr--;
        }
        left++; // 3-2. left 포인터를 첫번째 0까지 증가 시킴.
      }
      ans = Math.max(ans, right - left + 1); // 1. 최소 길이 1, 현재 길이가 더 크면 갱신
    }
    return ans;
  }

  public static void main(String[] args) {
    MaxConsecutiveOnesIII m = new MaxConsecutiveOnesIII();

    int[] nums = new int[] {1, 1, 1, 1, 0, 0, 1, 0 , 1 , 0 , 1 , 1, 1 , 1, 0};
    int k = 2;

    System.out.println(m.longestOnes(nums, k));
  }
}
