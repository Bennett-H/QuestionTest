package test;

import java.util.*;

public class J54Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arrs = new int[n];
            for (int i = 0; i < n; i++) {
                arrs[i] = scanner.nextInt();
            }
            int m = scanner.nextInt();
            System.out.println(getResult(m, arrs));
        }
    }

    static int getResult(int m, int[] arrs) {
        Arrays.sort(arrs);
        List<Integer> list = new ArrayList<>();
        for (int arr : arrs) {
            if (list.contains(arr)) {
                continue;
            }
            list.add(arr);
        }
        if (list.size() < m) {
            return -1;
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int index = m;
        while (m != 0) {
            int left = list.get(m - 1);
            sum += left;
            sb.append(left);
            m--;
        }
        while (index != 0) {
            int right = list.get(list.size() - index);
            sum += right;
            if (sb.toString().contains(String.valueOf(right))) {
                return -1;
            }
            index--;
        }
        return sum;
    }
}
