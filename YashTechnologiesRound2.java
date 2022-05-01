package day1;

import java.util.HashMap;
import java.util.Map;

public class YashTechnologiesRound2 {

    public static void main(String[] args) {
        StringOperation r = new StringOperation();
        r.countCharacterOccurence("aan vv vd ");
    }

}

class StringOperation {

    public void countCharacterOccurence(String a){
        char[] cArray = a.replaceAll(" ","").toCharArray();
        Map<Character,Integer> mp = new HashMap<>();
        int count = 0;
        for(char c:cArray){
            count = 0;
            for(int i=0 ;i<cArray.length;i++){
                if(c == cArray[i]){
                    count ++;
                }
            }
            mp.put(c,count);
        }
        System.out.println(mp);
    }
}
