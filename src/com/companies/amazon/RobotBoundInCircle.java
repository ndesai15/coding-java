package com.companies.amazon;

public class RobotBoundInCircle {
    public static boolean isCircle(String instructions) {
        // Initially we are facing to North
        int dirX = 0;
        int dirY = 1;
        // We start at origin
        int x = 0, y = 0;
        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                x = x + dirX;
                y = y + dirY;
            }
            else if (ch == 'L') {
                int temp = dirX;
                dirX = -1 * dirY;
                dirY = temp;
            }
            else{
                int temp = dirX;
                dirX = dirY;
                dirY = -1 * temp;
            }
        }

        System.out.println("x:" + x);
        System.out.println("y:" + y);
        System.out.println("dirX:" + dirX);
        System.out.println("dirY:" + dirY);

        // after one cycle:
        // robot returns into initial position
        // or robot has changed direction
        return (x == 0 && y == 0) || (dirX !=0 && dirY != 1);
    }

    public static void main(String[] args) {
        System.out.println(isCircle("LLGRL"));
    }
}
