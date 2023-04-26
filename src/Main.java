import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String args[]) {
        System.out.println(nearestExit(new char[][]{new char[]{'+', '.', '+', '+', '+', '+', '+'}, new char[]{'+', '.', '+', '.', '.', '.', '+'}, new char[]{'+', '.', '+', '.', '+', '.', '+'}, new char[]{'+', '.', '.', '.', '+', '.', '+'}, new char[]{'+', '+', '+', '+', '+', '.', '+'}}, new int[]{0, 1}));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        return calculate(maze, entrance[0], entrance[1], -1, -1, 0, true);
    }

    public static int calculate(char[][] data, int x, int y, int prex, int prey, int step, boolean start) {
        if (data[x][y] == '+') {
            return -1;
        }
        if ((x == 0 || y == 0 || x == data.length-1 || y == data[0].length-1 ) && !start) {
            return step;
        }
        int a = -1;
        int b = -1;
        int c = -1;
        int d = -1;
        if (y - 1 != prey && y - 1 >= 0) {
            a = calculate(data, x, y - 1, x, y, step + 1, false);
        }
        if (y + 1 != prey && y + 1 < data[0].length) {
            b = calculate(data, x, y + 1, x, y, step + 1, false);
        }
        if (x - 1 != prex && x - 1 >= 0) {
            c = calculate(data, x - 1, y, x, y, step + 1, false);
        }
        if (x + 1 != prex && x + 1 < data.length) {
            d = calculate(data, x + 1, y, x, y, step + 1, false);
        }
        System.out.println(a + " " + b + " " + c + " " + d);

        int ab = Math.min(a,b);
        int cd = Math.min(c,d);
        if (ab < 0 && b < 0){
            ab = a;
        }else if (ab < 0 && b > 0) {
            ab = b;
        }

        if (cd < 0 && d < 0){
            cd = c;
        }else if (cd < 0 && d > 0) {
            cd = d;
        }

        int abcd = Math.min(ab,cd);
        if (abcd < 0 && cd < 0){
            abcd = ab;
        }else if (abcd < 0 && cd > 0) {
            abcd = cd;
        }

        return abcd;
    }

    public static int calculate(String s) {
        char[] data = s.toCharArray();
        Stack<Character> stack = new Stack();
        operateRecurse(data, 0, stack);
        return stack.pop();
    }

    public static void operateRecurse(char[] data, int i, Stack<Character> stack) {
        if (data[i] == ')') {
            int temp = 0;
            while (stack.get(stack.size() - 2) != '(') {
                int num1 = Integer.parseInt(String.valueOf(stack.pop()));
                char oper = stack.pop();
                int num2 = Integer.parseInt(String.valueOf(stack.pop()));
                temp = operate(num1, oper, num2);
                stack.push((char) temp);
            }
            temp = Integer.parseInt(String.valueOf(stack.pop()));
            stack.pop(); // Removes (
            stack.push((char) temp);
            return;
        }
        stack.push(data[i]);
        operateRecurse(data, i + 1, stack);
    }

    public static int operate(int num1, char operation, int num2) {
        if (operation == '+') {
            return num1 + num2;
        } else {
            return num1 - num2;
        }
    }

    public static int[][] outerTrees(int[][] trees) {
        // On every value of X check the top value of Y and bottom
        // value of Y.

        int[][] parameter = new int[trees.length][2];
        for (int i = 0; i < parameter.length; i++) {
            parameter[i][0] = -1;
            parameter[i][1] = -1;
        }

        int minY = -1;
        int maxY = -1;
        int tempX = -1;
        for (int i = 0; i < trees.length; i++) {
            int currX = trees[i][0];
            int currY = trees[i][1];

            if (tempX != currX) {
                // Save all the values of minY maxY on tempX
                if (minY == maxY) {
                    addIntToList(new int[]{tempX, maxY}, parameter);
                } else {
                    addIntToList(new int[]{tempX, maxY}, parameter);
                    addIntToList(new int[]{tempX, minY}, parameter);
                }

                maxY = currY;
                minY = currY;
                tempX = currX;
            }

            if (tempX == currX && currY > maxY) {
                maxY = currY;
            } else if (tempX == currX && minY > currY) {
                minY = currY;
            }

            if (i == trees.length - 1) {
                // Save all the values of minY maxY on tempX
                if (minY == maxY) {
                    addIntToList(new int[]{tempX, maxY}, parameter);
                } else {
                    addIntToList(new int[]{tempX, maxY}, parameter);
                    addIntToList(new int[]{tempX, minY}, parameter);
                }
            }
        }

        return parameter;
    }

    public static void addIntToList(int[] parameter, int[][] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i][0] == -1) {
                data[i] = parameter;
                return;
            }
        }
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int al = Math.abs(ax1 - ax2);
        int ab = Math.abs(ay1 - ay2);

        int bl = Math.abs(bx1 - bx2);
        int bb = Math.abs(by1 - by2);

        int ax1a = Math.abs(ax1);
        int ax2a = Math.abs(ax2);
        int ay1a = Math.abs(ay1);
        int ay2a = Math.abs(ay2);
        int bx1a = Math.abs(bx1);
        int bx2a = Math.abs(bx2);
        int by1a = Math.abs(by1);
        int by2a = Math.abs(by2);
        if (ax1a == bx1a && ax2a == bx2a && ay1a == by1a && ay2a == by2a) {
            return (al * ab);
        } else if (ax1a > bx1a && ax2a > bx2a && ay1a > by1a && ay2a > by2a) {
            return al * ab;
        }

        int maxArea = (al * ab) + (bl * bb);


        if ((ax1 < bx1 && bx1 < ax2) && (ay1 < by2 && by2 < ay2)) {
            // Inside between the rectangle...
            int newL = Math.abs(bx1 - ax2);
            int newB = Math.abs(ay1 - by2);
            return maxArea - (newL * newB);
        }

        if ((ax1 < bx1 && bx1 < ax2) && (ay1 < by1 && by1 < ay2)) {
            // Inside between the rectangle...
            int newL = Math.abs(bx1 - ax2);
            int newB = Math.abs(ay1 - by1);
            return maxArea - (newL * newB);
        }

        if ((ax1 < bx2 && bx2 < ax2) && (ay1 < by1 && by1 < ay2)) {
            // Inside between the rectangle...
            int newL = Math.abs(bx2 - ax1);
            int newB = Math.abs(ay1 - by1);
            return maxArea - (newL * newB);
        }

        if ((ax1 < bx2 && bx2 < ax2) && (ay1 < by2 && by2 < ay2)) {
            // Inside between the rectangle...
            int newL = Math.abs(bx2 - ax1);
            int newB = Math.abs(ay1 - by2);
            return maxArea - (newL * newB);
        }
        return maxArea;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> data = new ArrayList<List<String>>();

        for (int group = 1; group <= s.length(); group++) {
            for (int i = 0; i < s.length(); i++) {
                int end = i + group;
                if (end > s.length()) {
                    continue;
                }
                String first = s.substring(0, end);
                String second = s.substring(end, s.length());
                if (isPal(first) && isPal(second)) {
                    List<String> ad = new ArrayList<>();
                    ad.add(first);
                    ad.add(second);
                    data.add(ad);
                }
            }
        }

        return data;
    }

    public static boolean isPal(List<String> data) {
        int start = 0;
        int end = data.size() - 1;

        while (end >= start) {
            if (data.get(start) != data.get(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static boolean isPal(String string) {
        char[] data = string.toCharArray();
        int start = 0;
        int end = data.length - 1;

        while (end >= start) {
            if (data[start] != data[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
