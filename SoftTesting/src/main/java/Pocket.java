import java.util.ArrayList;
import java.util.List;

public class Pocket {
    private int[] pocket = {50,20,10,5,5,1,1,1};

   public boolean getIf(int sum){
       List<Integer> result = new ArrayList<>();
       for (int i : pocket) {
           if (sum >= i) {
               sum -= i;
               result.add(i);
           }
           if (sum == 0) {
               for (int x : result){
                   System.out.print(x + " ");
               }
               return true;
           }
       }
       result.clear();
       return false;

   }


}
