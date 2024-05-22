package test;

import java.util.*;

public class J29Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String inputStr = scanner.nextLine();
            int[] nums = Arrays.stream(inputStr.split(" ")).mapToInt(Integer::parseInt).toArray();
            Map<Integer, Integer> countMap = new HashMap<>();
            int max = 0;
            for (int num : nums) {
                Integer val = countMap.getOrDefault(num, 0);
                countMap.put(num, val + 1);
                max = Math.max(max, val + 1);
            }
            ArrayList<Integer> zNums = new ArrayList<>();
            for (Integer key : countMap.keySet()) {
                Integer val = countMap.get(key);
                if (val == max) {
                    for (int i = 0; i < max; i++) {
                        zNums.add(key);
                    }
                }
            }
            int zSize = zNums.size();
            if (zSize % 2 == 1) {
                System.out.println(zNums.get(zSize / 2));
            } else {
                System.out.println((zNums.get(zSize / 2 - 1) + zNums.get(zSize / 2)) / 2);
            }
        }
    }
}
