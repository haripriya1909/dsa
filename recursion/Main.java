import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // increasing(n);
        // int ans = factorial(n);
        // int ans = powerN(5 , n);
        // int ans = powerLogN(2 , n);

        // long ans = toh(n, 1, 2, 3);

        int[] arr = { 4, 6, 0, -1, 6, 7, 6, 5, 6 };
        // displayReverse(arr, 0);
        // int ans = MaxElementinArray(arr, 0);
        // int ans = firstindex(arr , 6 , 0);
        // int ans = lastindex(arr, 6, 0);
        // System.out.println(ans);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans = Allindices(arr, 6, 0);
        for (Integer ele : ans) {
            System.out.print(ele + " ");
        }

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

}
