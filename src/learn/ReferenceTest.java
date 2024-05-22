package learn;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用测试
 */
public class ReferenceTest {

    public static void main(String[] args) {

        String str = new String("哈哈哈");

        ReferenceQueue rq = new ReferenceQueue();
        PhantomReference pr = new PhantomReference(str,rq);
        System.out.println(str);
        System.out.println(pr.get());
        str = null;

        System.out.println(str);
        //并不能通过虚引用来获取被引用的对象
        System.out.println(pr.get());//输出：null

        System.gc();
        System.runFinalization();

        //取出引用队列中最先进入队列的引用和pr比较
        System.out.println(rq.poll() == pr);//输出：true

    }

}