import java.util.*;

public class Find {
    static boolean find(int[] arr, int target, int index) {
        if(index == arr.length) {
            return false;
        }
        return arr[index] == target || find(arr, target, index + 1);
    }

    static int findIndex(int[] arr, int target, int index) {
        if(index == arr.length) {
            return -1;
        }
        if(arr[index] == target) {
            return index;
        } else {
            return  findIndex(arr, target, index + 1);
        }
    }

    static int findIndexLast(int[] arr, int target, int index) {
        if(index == -1) {
            return -1;
        }
        if(arr[index] == target) {
            return index;
        } else {
            return  findIndexLast(arr, target, index - 1);
        }
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int[] arr, int target, int index) {
        if(index == arr.length) {
            return;
        }
        if(arr[index] == target) {
            list.add(index);
        }
        findAllIndex(arr, target, index + 1);
        
    }

    static ArrayList<Integer> findAllInd(int[] arr, int target, int index, ArrayList<Integer> list) {
        if(index == arr.length) {
            return list;
        }
        if(arr[index] == target) {
            list.add(index);
        }
        return findAllInd(arr, target, index + 1, list);
        
    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 5, 4, 4};
        // System.out.println(find(arr, 4, 0));
        // System.out.println(findIndex(arr, 4, 0));
        // System.out.println(findIndexLast(arr, 4, arr.length-1));
        // findAllIndex(arr, 4, 0);
        // System.out.println(list);
        ArrayList<Integer> l = new ArrayList<Integer>();
        ArrayList<Integer> ans = findAllInd(arr, 4, 0, l);
        System.out.println(ans);
    }
}
