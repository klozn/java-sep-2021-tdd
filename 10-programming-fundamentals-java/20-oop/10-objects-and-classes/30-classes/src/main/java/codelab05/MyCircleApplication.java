package codelab05;

import codelab05.shapes.MyCircle;

public class MyCircleApplication {
    public static void main(String[] args) {
        MyCircle c1 = new MyCircle();
        System.out.println(c1);

        MyCircle c2 = new MyCircle(8.5);
        System.out.println(c2);
    }
}
