package Mesho;

/*
A Person class  is defined as follows:
Person {int id, String name, int age}

Persons can be divided into three categories:
1. KID => Age < 21
2. ADULT => Age >= 21 && Age < 60
3. SENIOR => Age >= 60
Given a list of persons, arrange them in such a way that all SENIOR(s)come first in the list followed by ADULT(s), followed by KID(s) .

Example:
[
Person(5471, "Robert", 65),
Person(8785, "Matt", 54),
Person(3142, "Lisa", 24),
Person(3215, "Greta", 16),
Person(2132, "Maria", 58),
Person(4525, "Giorgio", 73),
Person(1987, "Alex", 5),
Person(4565, "David", 51),
Person(1897, "Jeetu", 12)
]

Output: [
Person(5471, "Robert", 65),
Person(4525, "Giorgio", 73),
Person(8785, "Matt", 54),
Person(2132, "Maria", 58),
Person(4565, "David", 51),
Person(3142, "Lisa", 24),
Person(3215, "Greta", 16),
Person(1987, "Alex", 5),
Person(1897, "Jeetu", 12)
]

This is a variation of Dutch National Flag algorithm. (https://leetcode.com/problems/sort-colors/)
Categorize data using three pointers in O(n) and without using extra space.

 */

class Solution1 {

    public void solution() {
        /*
         * Logic is as below
         * To left of low - Senior
         * Between low and mid - Adult
         * To Right of high - Kid
         * */


        int[] nums = {65, 54, 24, 16, 58, 73, 5, 51, 12};

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        int tmp;

        while (mid <= high) {
            if (nums[mid] >= 60) {
                tmp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = tmp;
                low++;
                mid++;
            } else if (nums[mid] < 60 && nums[mid] >= 21) {
                mid++;
            } else if (nums[mid] < 21) {
                tmp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = tmp;
                high--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

public class CategorySortingMeshoRound1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.solution();
    }
}
