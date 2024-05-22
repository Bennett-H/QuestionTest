package test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class J44Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int productNum = scanner.nextInt();
            int tze = scanner.nextInt();
            int risk = scanner.nextInt();
            int[] hbl = new int[productNum];
            for (int i = 0; i < productNum; i++) {
                hbl[i] = scanner.nextInt();
            }
            int[] fxz = new int[productNum];
            for (int i = 0; i < productNum; i++) {
                fxz[i] = scanner.nextInt();
            }
            int[] ztze = new int[productNum];
            for (int i = 0; i < productNum; i++) {
                ztze[i] = scanner.nextInt();
            }
            int[] result = new int[productNum];
            int max = 0;
            for (int i = 0; i < productNum; i++) {
                if (fxz[i] <= risk) {
                    int curTze = Math.min(ztze[i], tze);
                    int cur = curTze * hbl[i];
                    if (cur > max) {
                        max = cur;
                        Arrays.fill(result, 0);
                        result[i] = curTze;
                    }
                }
            }
            for (int i = 0; i < productNum - 1; i++) {
                for (int j = i + 1; j < productNum; j++) {
                    if (fxz[i] + fxz[j] <= risk) {
                        if (ztze[i] + ztze[j] <= tze) {
                           int cur = ztze[i] * hbl[i] + ztze[j] * hbl[j];
                            if (cur > max) {
                                max = cur;
                                Arrays.fill(result, 0);
                                result[i] = ztze[i];
                                result[j] = ztze[j];
                            }
                        } else {
                            int distance = ztze[i] + ztze[j] - tze;
                            for (int k = 0; k <= distance; ++k) {
                                int ztzei = ztze[i] - k;
                                int ztzej = ztze[j] - (distance - k);
                                if (ztzei > 0 && ztzej > 0) {
                                    int cur = ztzei * hbl[i] + ztzej + hbl[j];
                                    if (cur > max) {
                                        max = cur;
                                        Arrays.fill(result, 0);
                                        result[i] = ztzei;
                                        result[j] = ztzej;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            StringJoiner stringJoiner = new StringJoiner(" ");
            for (int re : result) {
                stringJoiner.add(re + "");
            }
            System.out.println(stringJoiner);
        }
    }
}
