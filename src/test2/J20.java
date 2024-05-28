package test2;

import java.util.*;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/12:19
 * @Description:
 */
public class J20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int[] nums = Arrays.stream(scanner.nextLine().split(","))
                    .mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(scanner.nextLine());

            Queue<int[]> queue = new PriorityQueue<>((e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e2[0] - e1[0]);
            for (int i = 0; i < k; i++) {
                queue.offer(new int[]{nums[i], i});
            }

            int n = nums.length;
            StringJoiner res = new StringJoiner(" ");
            res.add(String.valueOf(queue.peek()[0]));

            for (int i = k; i < n; ++i) {
                queue.offer(new int[]{nums[i], i});
                while (!queue.isEmpty() && queue.peek()[1] < i - k + 1) {
                    queue.poll();
                }
                res.add(String.valueOf(queue.peek()[0]));
            }

            System.out.println(res);
        }
    }
}
