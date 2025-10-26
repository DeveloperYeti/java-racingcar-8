package racingcar;
import method.Method;
import java.util.List;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<List<String>> carMovements = Method.createCarList();
        Method.runRace(carMovements);
        Method.announceWinner(carMovements);
    }
}
