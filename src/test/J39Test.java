package test;

import java.util.*;

public class J39Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String infect = scanner.nextLine();
            int[] infectNum = Arrays.stream(infect.split(",")).mapToInt(e -> Integer.parseInt(e)).toArray();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                int[] strings = Arrays.stream(scanner.nextLine().split(",")).mapToInt(e -> Integer.parseInt(e)).toArray();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = strings[j];
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            for (int i : infectNum) {
                queue.offer(i);
                set.add(i);
            }
            HashSet<Integer> test = new HashSet<>();
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                for (int i = 0; i < n; i++) {
                    if (arr[poll][i] == 1 && !test.contains(i)) {
                        queue.offer(i);
                        test.add(i);
                    }
                }
            }
            System.out.println(test.size() - set.size());
        }
    }
}
