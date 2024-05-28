package test2;

import java.util.*;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/11:06
 * @Description:
 */
public class J14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int[] input1 = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] input2 = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(scanner.nextLine());
            List<Integer> sum = new ArrayList<>();
            for (int i = 1; i < input1.length; ++i) {
                for (int j = 1; j < input2.length; ++j) {
                    sum.add(input1[i] + input2[j]);
                }
            }
            Collections.sort(sum);
            int res = 0;
            for (int i = 0; i < k; ++i) {
                res += sum.get(i);
            }
            System.out.println(res);
        }
    }
}
