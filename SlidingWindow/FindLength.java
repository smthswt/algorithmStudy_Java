package SlidingWindow;

public class FindLength {
  public  int findLength(String s) {
    int left = 0;
    int curr = 0; // 지나친 0의 개수
    int ans = 0; //윈도우의 가장 긴 길이

    for (int right = 0; right < s.length(); right++) {
      System.out.println("right : " + right);
      if (s.charAt(right)== '0') { // 0 이면
        curr ++;
        System.out.println("curr++ : " + curr);
      }

      // ----

      while (curr > 1) { //0의 개수가 하나를 넘으면
        if (s.charAt(left) == '0') {
          curr--;
          System.out.println("curr-- : " + curr);
        }

        left++; // 0이 나올때까지 left를 증가시킨다 반복. 즉, 다음 서브어레이의 길이를 계산 (그리고 기존것보다 길면 대체 아니면 바이바이)
        System.out.println("left : " + left);
      }

      //---

      ans = Math.max(ans, right - left + 1); // 기존 길이와 현재 윈도우의 길이 비교해서 갱신
      System.out.println("ans : " + ans);
    }

    return ans;
  }

  public static void main(String[] args) {
    FindLength f = new FindLength();

    String s = "1110110111";

    System.out.println(f.findLength(s));
  }

}
