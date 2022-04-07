package com.coding.patterns.stacks;

import java.util.Arrays;
import java.util.Stack;


/**
 * LeetCode Problem: https://leetcode.com/problems/car-fleet/
 */

// Time Complexity: O(NlogN)
// Space Complexity: O(N)
class Car implements Comparable<Car> {
    public int position;
    public int speed;

    public Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }
}
public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        Car[] car = new Car[position.length];
        Arrays.sort(car);

        for (int i = 0; i < position.length; i++) {
            car[i] = new Car(position[i], speed[i]);
        }
        Stack<Double> stack = new Stack<>();
        Double temp = 0d;
        for (int i = car.length - 1; i>= 0; i--) {
            int curPosition = car[i].position;
            int curSpeed = car[i].speed;

            if (!stack.isEmpty()) {
                temp = stack.peek();
            }
            stack.push(((double)(target - curPosition)) / curSpeed);
            if (stack.size() >= 2 && stack.peek() <= temp) {
                stack.pop();
            }
        }
        return stack.size();
    }
}
