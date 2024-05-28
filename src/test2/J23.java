package test2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/15:42
 * @Description: 贪吃蛇
 */
public class J23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            // 指定操作
            char[] ops = scanner.nextLine().toCharArray();
            //
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            scanner.nextLine();
            // 食物布局
            char[][] ar = new char[m][n];
            // 蛇的路径
            int[][] visited = new int[m][n];
            // 整个蛇 最小是尾部
            Queue<Node> body = new PriorityQueue<>(Comparator.comparingInt(e -> e.cnt));
            // 蛇头
            Node head = new Node(-1, -1, 0);
            for (int i = 0; i < m; ++i) {
                char[] charArray = scanner.nextLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    ar[i][j] = charArray[j];
                    if (ar[i][j] == 'H') {
                        // 蛇头
                        Node temp = new Node(i, j, 1);
                        body.offer(temp);
                        head = new Node(temp);
                        //
                        visited[i][j] = 1;
                    }
                }
            }
            // 当前方向
            char direction = 'L';
            // 是否提前完成
            boolean flag = false;
            for (char op : ops) {
                switch (op) {
                    case 'U': direction = 'U'; break;
                    case 'D': direction = 'D'; break;
                    case 'L': direction = 'L'; break;
                    case 'R': direction = 'R'; break;
                    default:
                        // 保持当前方向
                }
                flag = play(direction, head, body, ar, visited);
                if (flag) {
                    System.out.println(body.size());
                    break;
                }
            }
            if (!flag) {
                System.out.println(body.size());
            }
        }
    }

    private static boolean play(char op, Node head, Queue<Node> body, char[][] ar, int[][] visited) {
        switch (op) {
            case 'U':
                head.x -= 1;
                break;
            case 'D':
                head.x += 1;
                break;
            case 'L':
                head.y -= 1;
                break;
            case 'R':
                head.y += 1;
                break;
            default:
        }
        if (head.x < 0 || head.x >= ar.length || head.y < 0 || head.y >= ar[0].length || visited[head.x][head.y] != 0) {
            return true;
        }
        // 设置被访问过
        visited[head.x][head.y] = ++head.cnt;
        body.offer(new Node(head));
        // 食物 尾部不减
        if (ar[head.x][head.y] == 'F') {
            ar[head.x][head.y] = 'E';
        } else {
            // 不是食物 尾部-1
            Node tail = body.poll();
            visited[tail.x][tail.y] = 0;
        }
        return false;
    }

    static class Node {
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        Node(Node temp) {
            this.x = temp.x;
            this.y = temp.y;
            this.cnt = temp.cnt;
        }
    }
}
