import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // increasing(n);
        // int ans = factorial(n);
        // int ans = powerN(5 , n);
        // int ans = powerLogN(2 , n);

        // long ans = toh(n, 1, 2, 3);

        // int[] arr = { 4, 6, 0, -1, 6, 7, 6, 5, 6 };
        // displayReverse(arr, 0);
        // int ans = MaxElementinArray(arr, 0);
        // int ans = firstindex(arr , 6 , 0);
        // int ans = lastindex(arr, 6, 0);
        // System.out.println(ans);
        // ArrayList<Integer> ans = new ArrayList<Integer>();
        // ans = Allindices(arr, 6, 0);
        // for (Integer ele : ans) {
        // System.out.print(ele + " ");
        // }
        // String input = scn.next();
        // List<String> output = getSubsequence(input);
        // List<String> output = getKeypad(input);
        // System.out.println(output);
        // int count = getStairspath(n);
        // System.out.println(count);

        List<String> output = getStairspath(n);
        System.out.println(output);
    }

    public static void increasing(int n) {
        if (n == 0)
            return;

        increasing(n - 1);
        System.out.println(n);
    }

    public static int factorial(int n) {
        if (n == 0)
            return 1;

        int ans = n * factorial(n - 1);
        return ans;
    }

    public static int powerN(int x, int n) {
        if (n == 0)
            return 1;

        int ans = x * powerN(x, n - 1);
        return ans;
    }

    public static int powerLogN(int x, int n) {
        if (n == 0)
            return 1;

        int ans = powerLogN(x, n / 2);
        ans = ans * ans;
        if (n % 2 == 1)
            ans = ans * x;

        return ans;
    }

    public static long toh(int n, int from, int to, int aux) {
        long count = 1;

        if (n == 1) {
            System.out.println("move disk " + n + " from rod " + from + " to rod " + to);
            return 1;
        }

        count += toh(n - 1, from, aux, to);
        System.out.println("move disk " + n + " from rod " + from + " to rod " + to);
        count += toh(n - 1, aux, to, from);
        return count;
    }

    public static void display(int[] arr, int i) {
        if (i == arr.length)
            return;

        System.out.println(arr[i]);
        display(arr, i + 1);

    }

    public static void displayReverse(int[] arr, int i) {
        if (i == arr.length)
            return;

        displayReverse(arr, i + 1);
        System.out.println(arr[i]);

    }

    public static int MaxElementinArray(int[] arr, int i) {
        if (i == arr.length)
            return -1;
        int max = MaxElementinArray(arr, i + 1);
        if (max <= arr[i]) {
            max = arr[i];
        }
        return max;

    }

    public static int firstindex(int[] arr, int element, int i) {
        if (i == arr.length)
            return -1;

        int ans = firstindex(arr, element, i + 1);
        if (arr[i] == element) {
            ans = i;
        }
        return ans;
    }

    public static int lastindex(int[] arr, int element, int i) {
        if (i == arr.length)
            return -1;

        int liisa = lastindex(arr, element, i + 1);

        if (liisa == -1) {
            if (arr[i] == element)
                return i;
            else
                return -1;

        } else
            return liisa;

    }

    public static ArrayList<Integer> Allindices(int[] arr, int element, int i) {
        if (i == arr.length) {
            ArrayList<Integer> li = new ArrayList<Integer>();
            return li;
        }
        ArrayList<Integer> li = Allindices(arr, element, i + 1);
        if (arr[i] == element)
            li.add(i);

        return li;

    }

    public static List<String> getSubsequence(String s) {
        if (s.length() == 0) {
            List<String> list = new ArrayList<String>();
            list.add("");
            return list;
        }
        char ch = s.charAt(0); // my work

        String ros = s.substring(1); // rest of the substring
        List<String> li = getSubsequence(ros); // expectation ki ros ki subsequence muje recurison laakr dega
        List<String> ans = new ArrayList<String>(); // new arraylist har baar bana rahi hu aur answer copy krrhi hu
                                                    // space aur charcater add krke
        for (String str : li) {
            ans.add("" + str);
            ans.add(ch + str);
        }
        return ans;
    }

    static String[] codes = { ".,", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static List<String> getKeypad(String s) {
        char ch = s.charAt(0);
        if (s.length() == 1) {
            List<String> li = new ArrayList<String>();
            for (int i = 0; i < codes[ch - '0'].length(); i++) {
                char c = codes[ch - '0'].charAt(i);
                li.add(String.valueOf(c));
            }
            return li;
        }
        List<String> ros = getKeypad(s.substring(1));
        List<String> ans = new ArrayList<String>();
        for (String str : ros) {
            for (int i = 0; i < codes[ch - '0'].length(); i++) {
                char add = codes[ch - '0'].charAt(i);
                ans.add(add + str);
            }
        }
        return ans;
    }

    // public static int getStairspath(int n) {
    // if (n == 0) {

    // return 1;
    // } else if (n < 0)
    // return 0;

    // int count = 0;
    // count += getStairspath(n - 1);
    // count += getStairspath(n - 2);
    // count += getStairspath(n - 3);

    // return count;
    // }
    public static List<String> getStairspath(int n) {
        if (n == 0) {
            List<String> li = new ArrayList<String>();
            li.add("");
            return li;
        } else if (n < 0) {
            List<String> li = new ArrayList<String>();
            return li;
        }
        List<String> path1 = getStairspath(n - 1);
        List<String> path2 = getStairspath(n - 2);
        List<String> path3 = getStairspath(n - 3);
        List<String> ans = new ArrayList<String>();
        for (String path : path1) {
            ans.add(1 + path);
        }
        for (String path : path2) {
            ans.add(2 + path);
        }
        for (String path : path3) {
            ans.add(3 + path);
        }
        return ans;
    }
}
