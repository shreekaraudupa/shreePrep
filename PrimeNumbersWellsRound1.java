package wf;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersWellsRound1 {
    public static void main(String[] args) {
        PrimeNumbers p = new PrimeNumbers();
        p.printPrimeNumbers(1,100);
    }
}

class PrimeNumbers{

    public void printPrimeNumbers(int start, int end){
        List<Integer> primeList = new ArrayList<>();
        for (int i =start;i<end;i++){
            if(i!=0 && i!=1){
                checkAndReturnPrimeList(i,primeList);
            }
        }
        System.out.println(primeList.size());
        System.out.println(primeList);

    }

    private void checkAndReturnPrimeList(int ip, List<Integer> primeList) {
        int counter = 0;

        for(int i =1 ; i <= ip; i++){
            if( ip%i == 0){
                counter++;
            }
        }
        if(counter==2) primeList.add(ip);
    }

}
