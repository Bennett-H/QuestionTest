package test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J26Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int[] arra = new int[a];
            int[] arrb = new int[b];
            int suma = 0;
            int sumb = 0;
            Set<Integer> setA = new HashSet<>();
            Set<Integer> setB = new HashSet<>();
            for (int i = 0; i < a; i++) {
                arra[i] = scanner.nextInt();
                suma += arra[i];
                setA.add(arra[i]);
            }
            for (int i = 0; i < b; i++) {
                arrb[i] = scanner.nextInt();
                sumb += arrb[i];
                setB.add(arrb[i]);
            }
            int distance = (suma - sumb) / 2;
            int resultA = Integer.MAX_VALUE;
            int resultB = 0;
            for (Integer numA : setA) {
                if (setB.contains(numA - distance)) {
                    if (resultA > numA) {
                        resultA = numA;
                        resultB = numA - distance;
                    }
                }
            }
            System.out.println(resultA + " " + resultB);
        }
    }
}
