package test2;

import java.util.*;

/**
 * @Author: Bennett
 * @Date: 2024/05/24/19:42
 * @Description:
 */
public class J3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] players = scanner.nextLine().split(",");
            String[] scores = scanner.nextLine().split(",");

            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int i = 0; i < n; ++i) {
                Integer player = Integer.valueOf(players[i]);
                List<Integer> list = map.getOrDefault(player, new ArrayList<>());
                list.add(Integer.valueOf(scores[i]));
                map.put(player, list);
            }

            List<List<Integer>> list = new ArrayList<>();
            map.forEach((key, value) -> {
                int len = value.size();
                if (len >= 3) {
                    List<Integer> subList = new ArrayList<>();
                    Collections.sort(value);
                    subList.add(key);
                    subList.add(value.get(len - 1) + value.get(len - 2) + value.get(len - 3));
                    list.add(subList);
                }
            });

            Collections.sort(list, (a, b) -> {
                if (b.get(1) > a.get(1)) {
                    return 1;
                }
                if (b.get(0) > a.get(0)) {
                    return 1;
                }
                return -1;
            });
            StringJoiner ans = new StringJoiner(",");
            for (List<Integer> integers : list) {
                ans.add(String.valueOf(integers.get(0)));
            }
            System.out.println(ans);
        }
    }
}
