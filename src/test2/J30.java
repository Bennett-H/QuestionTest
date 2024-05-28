package test2;

import java.util.*;

/**
 * @Author: Bennett
 * @Date: 2024/05/28/13:08
 * @Description:
 */
public class J30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int[] inputs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] nums = new int[inputs.length / 2][2];
            for (int i = 0; i < nums.length; ++i) {
                nums[i][0] = inputs[2 * i];
                nums[i][1] = inputs[2 * i + 1];
            }
            Arrays.sort(nums, (e1, e2) -> e1[0] != e2[0] ? e1[0] - e2[0] : e1[1] - e2[1]);
            // 求交集
            List<int[]> jList = new ArrayList<>();
            int i = 0, j = 0;
            while (i < nums.length && j < nums.length) {
                if (i == j) {
                    i++;
                    if (i >= nums.length) {
                        break;
                    }
                }
                int l = Math.max(nums[i][0], nums[j][0]);
                int r = Math.min(nums[i][1], nums[j][1]);
                if (l <= r) {
                    jList.add(new int[]{l, r});
                }
                if (nums[i][1] < nums[j][1]) {
                    i++;
                } else {
                    j++;
                }
            }
            // 求交集的并集
            int[][] array = jList.toArray(new int[jList.size()][]);
            Arrays.sort(array, (e1, e2) -> e1[0] != e2[0] ? e1[0] - e2[0] : e1[1] - e2[1]);
            List<int[]> bList = new ArrayList<>();
            int k = -1;
            for (int[] arr : array) {
                if (k == -1 || bList.get(k)[1] < arr[0]) {
                    bList.add(arr);
                    k++;
                } else {
                    bList.get(k)[1] = Math.max(bList.get(k)[1], arr[1]);
                }
            }
            StringJoiner res = new StringJoiner(" ");
            for (int[] ints : bList) {
                res.add(String.valueOf(ints[0])).add(String.valueOf(ints[1]));
            }
            System.out.println(res.length() == 0 ? "NONE" : res);
        }
    }
}
