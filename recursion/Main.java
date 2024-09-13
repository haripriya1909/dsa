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

        int[] arr = { 4, 6, 0, 0, 6, 7, 6, 5, 6 };
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

        // List<String> output = getStairspath(n);
        // int[][] arr = new int[5][6];
        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[0].length; j++) {
        //         arr[i][j] = scn.nextInt();
        //     }
        // }
        // boolean[][] visited = new boolean[5][6];
        // List<String> output = getMazepath(arr , 0 , 0 , 4 , 4);
        // List<String> output = getMazepathwJumps(arr, 0, 0, 4, 4);
        // System.out.println(output);
        // printSubsequence(input, "");
        // printKeypad(input, "");
        // printStairPaths(n , "");
        // printMazePaths(arr , 4 , 3 , 0 , 0 , "");
        // printMazePathswJumps(arr , 4 , 3 , 0 , 0 , "");
        // printPermutations(input, "");
        // printEncodings(input, "");
        // floodFill(arr, 0, 0, "", visited);
        TargetSum(arr, 0, "", 0, 30);
        
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

    public static List<String> getMazepath(int[][] arr, int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            List<String> li = new ArrayList<String>();
            li.add("");
            return li;
        }
        List<String> path1 = new ArrayList<String>();
        List<String> path2 = new ArrayList<String>();
        if (sr < dr)
            path1 = getMazepath(arr, sr + 1, sc, dr, dc);

        if (sc < dc)
            path2 = getMazepath(arr, sr, sc + 1, dr, dc);

        List<String> ans = new ArrayList<String>();
        for (String path : path1) {
            ans.add('v' + path);
        }
        for (String path : path2) {
            ans.add('h' + path);
        }
        return ans;
    }

    public static List<String> getMazepathwJumps(int[][] arr, int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            List<String> li = new ArrayList<String>();
            li.add("");
            return li;
        }

        List<String> ans = new ArrayList<String>();
        for (int ms = 1; ms <= dr - sr; ms++) {
            List<String> path1 = getMazepathwJumps(arr, sr + 1, sc, dr, dc);
            for (String vpath : path1) {
                ans.add("v" + ms + vpath);
            }
        }
        for (int ms = 1; ms <= dc - sc; ms++) {
            List<String> path2 = getMazepathwJumps(arr, sr, sc + 1, dr, dc);
            for (String hpath : path2) {
                ans.add("h" + ms + hpath);
            }
        }
        for (int ms = 1; ms <= dc - sc && ms <= dr - sr; ms++) {
            List<String> path3 = getMazepathwJumps(arr, sr + 1, sc + 1, dr, dc);
            for (String dpath : path3) {
                ans.add("d" + ms + dpath);
            }
        }
        return ans;
    }

    public static void printSubsequence(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0); // my work

        String ros = s.substring(1);
        printSubsequence(ros, ans);
        printSubsequence(ros, ans + ch);
    }

    public static void printKeypad(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        String ros = s.substring(1);
        for (int i = 0; i < codes[ch - '0'].length(); i++) {
            char c = codes[ch - '0'].charAt(i);
            printKeypad(ros, ans + c);
        }

    }

    public static void printStairPaths(int n, String ans) {
        if (n == 0) {
            System.out.println(ans);
            return;
        } else if (n < 0)
            return;
        printStairPaths(n - 1, ans + "1");
        printStairPaths(n - 2, ans + "2");
        printStairPaths(n - 3, ans + "3");
    }

    public static void printMazePaths(int[][] arr, int dr, int dc, int sr, int sc, String ans) {
        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }

        if (sc < dc)
            printMazePaths(arr, dr, dc, sr, sc + 1, ans + "h");
        if (sr < dr)
            printMazePaths(arr, dr, dc, sr + 1, sc, ans + "v");

    }

    public static void printMazePathswJumps(int[][] arr, int dr, int dc, int sr, int sc, String ans) {
        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }

        for (int i = sc; i < dc; i++)
            printMazePaths(arr, dr, dc, sr, sc + i, ans + "h");

        for (int i = sr; i < dr; i++)
            printMazePaths(arr, dr, dc, sr + i, sc, ans + "v");

        for (int i = sr; i < dr && i < dc; i++)
            printMazePaths(arr, dr, dc, sr + i, sc + i, ans + "d");

    }

    public static void printPermutations(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String ros = s.substring(0, i) + s.substring(i + 1);
            printPermutations(ros, ans + ch);
        }
    }

    public static void printEncodings(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        } else {
            char ch = s.charAt(0);
            if (ch == '0')
                return;
            else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);

                String ros = s.substring(1);
                printEncodings(ros, ans + code);
            }
        }
        if (s.length() >= 2) {
            String ch12 = s.substring(0, 2);
            String ros = s.substring(2);
            int ch12v = Integer.parseInt(ch12);
            char code12 = (char) ('a' + ch12v - 1);
            if (ch12v <= 26) {

                printEncodings(ros, ans + code12);
            }

        }
    }

    public static void floodFill(int[][] arr, int r, int c, String ans, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= arr.length || c >= arr[0].length || arr[r][c] == 1 || visited[r][c] == true) {
            return;
        }
        if (r == arr.length - 1 && c == arr[0].length - 1) {
            System.out.println(ans);
            return;
        }
        visited[r][c] = true;
        floodFill(arr, r - 1, c, ans + "t", visited); // top
        floodFill(arr, r + 1, c, ans + "d", visited); // down
        floodFill(arr, r, c + 1, ans + "r", visited); // right
        floodFill(arr, r, c - 1, ans + "l", visited); // left
    }

    public static void TargetSum(int[] arr, int idx, String ans , int sum , int target) {
        if (idx == arr.length) {
            if(sum == target)
            System.out.println(ans);
            
        return;
        }

        TargetSum(arr, idx + 1, ans + arr[idx] , sum+arr[idx] , target);
        TargetSum(arr, idx + 1, ans, sum, target);
    }
}
