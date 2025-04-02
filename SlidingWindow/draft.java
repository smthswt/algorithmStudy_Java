package SlidingWindow;

public class draft {
    public int sw(int[] nums, int k) {
        int left = 0;
        int curr = 0;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            System.out.println("curr, right:" + curr + ", " + right);

            while (curr > k) {
                curr -= nums[left];
                left++;
                System.out.println("curr, left:" + curr + ", " + left);
            }

            answer = Math.max(answer, right - left + 1); //현재 윈도우 크기
            System.out.println("answer크기 : " + answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        draft d = new draft();

        int[] nums = {1, 2, 3, 4, 5};  // 예시 입력
        int k = 5;

        int result = d.sw(nums, k);
        System.out.println("최대 길이: " + result);  // 출력: 최대 길이: 3
    }
}
