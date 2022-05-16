public class Tradesun {
    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.almostPalindrome("abcdcbg"));
        System.out.println(p.almostPalindrome("abccia"));
        System.out.println(p.almostPalindrome("abcdaaa"));
        System.out.println(p.almostPalindrome("1234312"));
        System.out.println(p.almostPalindrome(""));
        System.out.println(p.almostPalindrome("radar"));
        System.out.println(p.almostPalindrome("a"));
    }
}

class Palindrome{

    public boolean almostPalindrome(String ip){
        if(ip.length() ==0) return false;

        int left = 0;
        int right = ip.length() - 1;
        boolean canChange = true;
        char[] ipChar = ip.toCharArray();

        while(left < right){
            if((ipChar[left] != ipChar[right])){
                if(!canChange) return false;
                canChange = false;
            }
            left++;
            right--;
        }
        return true;
    }
}
