package method;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Method {
    // 입력된 값에 대해서 ,를 구분자로 사용하여 반환된 리스트를 return 값으로 사용.
    public static List<String> inputName(){
        List<String > myList = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputName = Console.readLine();
        String[] inputNameArr = inputName.split(",");
        for(String name : inputNameArr)
            myList.add(name.strip());
        return myList;
    }

    // 총 시도할 횟수 표시
    public static List<List<String>> inputChance() {
        System.out.println("시도할 횟수");
        String str = Console.readLine();
        int tryChance = Integer.parseInt(str);

        if(tryChance>=0 && tryChance < 5){
            return move(0,1,tryChance);
        }
            throw new IllegalArgumentException("잘못된 값 입력.");
    }
    // 각각의 name List를 생성하고 그에 맞

    public static List<List<String>> repeat() {
        List<String> nameMake = inputName();
        int nameNumbers = nameMake.size();
        List<List<String>> names = new ArrayList<>();
        for (int i = 0; i < nameNumbers; i++) {
            List<String> name = new ArrayList<String>();
            name.add(nameMake.get(i));
            names.add(name);
        }
        return names;
    }

    //요구 사항에서 Range 함수를 사용하라고 해서 함수 사용 및 값 반환.
    public static List<List<String>> move(final int start , final int end , int tryChance) {
        List<List<String>> movement = repeat();
        int index = 0;
        for(int i = 0; i<tryChance; i++){
            index = i % movement.size();
            int random = Randoms.pickNumberInRange(start, end);
            if(random == 0)
            {
                movement.get(index).add("");
            } else if (random == 1) {
                movement.get(index).add("-");
            }
            else {
                throw new IllegalArgumentException("범위 초과");
            }
        }

        return movement;
    }
}
