package com.example.demo;

import java.security.SecureRandom;
import java.util.List;

public class MathTest {

    public static void main(String[] args) {


        //   MyThread m = new MyThread();
        //   m.start();

        SecureRandom sr = new SecureRandom();
        byte[] bytes = sr.generateSeed(10);


        System.out.println("bytes.toString() = " + sr.nextLong());

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.print();

        InterfaceImp face = new InterfaceImp();
        System.out.println("face.absMethod() = " + face.absMethod());

        SingleThreadEx st = new SingleThreadEx("첫 번째");
        st.start();
    }
}


class SingleThreadEx extends Thread {
    private int[] temp;

    public SingleThreadEx(String threadname) {
        super(threadname);
        temp = new int[10];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = i;
        }
    }

    @Override
    public void run() {
        for (int start : temp) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("currentThread() = " + currentThread().getName());
            System.out.println("temp value = " + start);
        }
        // end for
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            for (Integer at : List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)) {
                sleep(1000);
                System.out.println("true = " + at);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
