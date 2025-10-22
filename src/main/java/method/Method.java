package method;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class Method {

    public  List<String> inputName(){
        List<String > myList = new ArrayList<>();
        String inputName = Console.readLine();
        String[] inputNameArr = inputName.split(",");




        return ;
    }
    // 총 시도할 횟수 표시
    public static List<String> inputChance(int nameNumbers) {
        System.out.println("시도할 횟수");
        String str = Console.readLine();
        int tryChance = Integer.parseInt(str);

        if(tryChance>=0 && tryChance < 5){
            for (int i=0; i<nameNumbers; i++){
                List<String> name = new ArrayList<String>();
                for(int k=0; k<tryChance; k++){
                    name.add(k,"-");
                }
                return  name;
            }

        }
        else {
            throw new IllegalArgumentException("잘못된 값 입력.");
        }
    }

    //요구 사항에서 Range 함수를 사용하라고 해서 함수 사용 및 값 반환.
    public static int Move(final int start , final int end) {
        return Randoms.pickNumberInRange(start,end);
    }


}
