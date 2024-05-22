package learn;

import java.util.Random;
import java.util.StringJoiner;

public class test {

    public static void main(String[] args) {

        Person person = new Person();

        String a = "kasd";
        a = "1";
        System.out.println(a);

        int[] citations = new int[]{3,0,6,1,5};
        hIndex(citations);
        
    }

    public static int hIndex(int[] citations) {
        int n = citations.length - 1;
        int[] harr = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            if (citations[i] >= n) {
                harr[n]++;
            } else {
                harr[citations[i]]++;
            }
        }
        int cur = 0;
        for (int i = n; i >= 0; --i) {
            cur += harr[i];
            if (cur >= i) {
                return cur;
            }
        }
        return cur;
    }
}

class Animal {
    private String sleep;

    String eat;

    public String getSleep() {
        return sleep;
    }

    public void setSleep(String sleep) {
        this.sleep = sleep;
    }

    public String getEat() {
        return eat;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }
}

class Person extends Animal{
    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
