package method;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Method {
    public static List<String> inputName() {
        System.out.println("시도할 횟수");
        String str = Console.readLine();
        int trychance = Integer.parseInt(str);

        if(trychance>=0 && trychance < 5){
            List<String> name = new ArrayList<String>();

            for(int i=0;  i<=trychance ;i++){
                String inputName = Console.readLine();
                name.add(i,inputName);
            }

            return name;
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
