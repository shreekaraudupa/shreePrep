package Mesho;


/*
A group of friends have gone to watch the first day first show of an awesome new movie. However, since they did not book the tickets well in advance, they have ended up with crazy seats. To be more specific, rather than getting seats such that all the friends are seated in the same row, they have ended up with seats such that all of them are seated in the same column! Now this is very inconvenient since they won't be able to chat with each other during the movie or have any kind of fun, but they are okay with this since they'd rather watch the movie like this, than not watch the movie at all.

But there is another problem apart from this. Now we know that all the friends are seated in a single column, one behind the other. Since all of them reached the theatre just in time for the movie, they rushed and occupied the first of the booked seats that they could find. However all the friends have different heights, and due to the lack of planning, there is no guarantee that a shorter person is always seated in front of a taller person. But this would mean that the shorter person would struggle to see the screen throughout the movie !

But the movie has started and it's too late now to do anything.

What you need to do is the following : For every person, find the height of the closest person seated in front of him/her who is blocking his/her view ( that is, the person closest in front with a greater height ). If no such person exists, take this height as 1. Print the product of all such values modulo 1000000007.

Input #1:
5 2 1 4 3 | screen

Output #1:
16  (4*4  as 4 is hindrance for 1 and 4 is hindrance for 2)

Input #2:
9 8 3 5 7 | screen

Output #2:
35 (7*5 as 7 is hindrance for 5 and 5 is hindrance for 3)


Input #3:
30 10 50 70 11 60 20 80 31 12 | screen

Output #3:
999962375


*/

import java.util.Stack;

class Solution {

    public int solution() {
        //int[] ip = {5,2, 1, 4, 3};
        int[] ip = {9,8,3,5,7};
        //int[] ip = {30,10,50,70,11,60,20,80,31,12};

        Stack<Integer> s = new Stack<>();
        int product = 1;
        int n = 1000000007;
        //(a*b) % n = (a%n * b%n) % n

        for (int i = 0; i < ip.length; i++) {
            while (!s.isEmpty() && s.peek() < ip[i]){
                if(s.peek() < ip[i]){
                    product = ((product%n) * (ip[i]%n))%n;
                    //product = product * ip[i];
                    s.pop();
                }
            }
            s.push(ip[i]);
        }

        /*  Complexity is O(n2)
        for (int i = 0; i < ip.length; i++) {
            for (int j = i + 1; j < ip.length; j++) {
                if (ip[i] < ip[j]) {
                    product = product * ip[j];
                    break;
                }
            }
        }*/

        return product;
    }
}

public class TheaterSeatingMeshoRound1 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution());
    }
}
