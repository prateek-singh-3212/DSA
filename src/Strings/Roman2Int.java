package Strings;

import java.util.Arrays;

public class Roman2Int {
    public static void main(String[] args) {
        System.out.println("Roman: III Int:" + romanToInt("III"));
    }

    public static int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int num = 0;

        for(int i=0; i<arr.length; ) {
            switch(arr[i]) {
                case 'M': {
                    num += 1000;
                    i++;
                }
                break;
                case 'D': {
                    num += 500;
                    i++;
                }
                break;
                case 'C': {
                    if(i+1 < arr.length && arr[i+1] == 'D'){
                        num += 400;
                        i+=2;
                        continue;
                    }
                    if(i+1 < arr.length && arr[i+1] == 'M'){
                        num += 900;
                        i+=2;
                        continue;
                    }
                    num += 100;
                    i++;
                }
                break;
                case 'L': {
                    num += 50;
                    i++;
                }
                break;
                case 'X': {
                    if(i+1 < arr.length && arr[i+1] == 'L'){
                        num += 40;
                        i+=2;
                        continue;
                    }
                    if(i+1 < arr.length && arr[i+1] == 'C'){
                        num += 90;
                        i+=2;
                        continue;
                    }
                    num += 10;
                    i++;
                }
                break;
                case 'V': {
                    num += 5;
                    i++;
                }
                break;
                case 'I': {
                    if(i+1 < arr.length && arr[i+1] == 'V'){
                        num += 4;
                        i+=2;
                        continue;
                    }
                    if(i+1 < arr.length && arr[i+1] == 'X'){
                        num += 9;
                        i+=2;
                        continue;
                    }
                    num+=1;
                    i++;
                }
                break;
                default: {
                    // Do nothing...
                    i++;
                }
            }
        }

        return num;
    }
}
