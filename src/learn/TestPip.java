package learn;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class TestPip {

    public static void main(String[] args) throws IOException {
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();
        writer.connect(reader);
        Thread printThread = new Thread(new Print(reader));
        printThread.start();
        int receive;
        try {
            while ((receive = System.in.read()) != -1) {
                writer.write(receive);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            writer.close();
        }
    }

    private static class Print implements Runnable {

        private PipedReader reader;

        public Print (PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            int receive;
            try {
                while ((receive = reader.read()) != -1) {
                    System.out.println((char) receive);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
