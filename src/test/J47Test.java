package test;

import java.util.Scanner;

public class J47Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String token = "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";
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int distance = scanner.nextInt();
            float result = 0;
            for (int i = 0; i < n; i++) {
                int speed = scanner.nextInt();
                if (i == 0) {
                    result = (float) distance / speed;
                } else {
                    float cur = (float) distance / speed;
                    if (cur + 1 < result) {
                        // 后面一辆赶上了前面一辆一起冲线，后面少花1秒
                        result -= 1;
                    } else {
                        result = cur;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
