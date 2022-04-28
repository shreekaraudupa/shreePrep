
/*
* A beautiful array is defined as an array of integers with a specific number of odd elements. Given an array a and an integer m representing the number of odd elements that constitutes a beautiful array, you're wondering how many distinct subarrays of a are beautiful arrays. We define distinct subarrays as arrays that don't share identical starting and ending indices, though they may share one of the two.
Your task is to return the number of the possible beautiful subarrays of a.
NOTE: Two subarrays may contain identical elements while still being considered distinct.
Example
* For a = [1, 2, 3, 4, 5] and m = 2, the output should be solution(a, m) = 4. The following 4 beautiful subarrays can be formed: a[0..2] = [1, 2, 3]
* a[0..3] = [1, 2, 3, 4]
* a[1..4] = [2, 3, 4, 5]
* a[2..4] = [3, 4, 5]
*  Since each of these contain exactly m = 2 odd elements, they are beautiful.
* For a = [2, 5, 4, 9] and m = 1, the output should be solution(a, m) = 6. There are six distinct beautiful subarrays with exactly m = 1 odd element: a[1..1] = [5]
* a[3..3] = [9]
* a[0..1] = [2, 5]
* a[1..2] = [5, 4]
* a[2..3] = [4, 9]
* a[0..2] = [2, 5, 4]
* 
Input/Output
* [execution time limit] 3 seconds (java)
* [input] array.integer a An array of integers, from which the beautiful subarrays can be constructed. Guaranteed constraints: 1 ≤ a.length ≤ 2 · 105, 1 ≤ a[i] ≤ 109.
* [input] integer m The number of odd elements within a beautiful array. Guaranteed constraints: 0 ≤ m ≤ a.length.
* [output] integer64 The number of beautiful subarrays of a.
* 
* 
* */

class Aqr{

    /*
    Time complexity here is O(n2)
    */

    long solution(int[] a, int m) {
        long op = 0;
        int oddCount = 0;
        for (int i=0;i<a.length;i++){
            if(a[i]%2!=0) oddCount++;
            if(oddCount == m) op++;
            for(int j=i+1;j<a.length;j++){
                if(a[j]%2!=0) oddCount++;
                if(oddCount == m) op++;
            }
            oddCount = 0;
        }


        return op;
    }

    /*
     This is using two pointers and shifting the window
     */

    long solution_1(int[] a, int m) {
        long op = 0;
        int oddCount = 0;
        int start=0;
        int end=0;

        while(start <= a.length-1){
            if(a[end]%2!=0) {
                oddCount++;
            }
            if(oddCount == m) {
                op++;
            }
            if(end == a.length-1){
                start++;
                end = start;
                oddCount = 0;
                continue;
            }
            end++;
        }
        return op;
    }

}
public class AQRRound1 {
    public static void main(String[] args) {
        Aqr a = new Aqr();
        int[] n = {2,5,4,9};
        System.out.println(a.solution_1(n,1));

    }
}
