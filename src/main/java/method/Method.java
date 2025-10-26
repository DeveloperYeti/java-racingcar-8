package method;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Method {

    // 차량 리스트 생성
    public static List<List<String>> createCarList() {
        List<String> names = inputAndValidateNames();
        return initializeCarMovements(names);
    }

    // 경주 실행
    public static void runRace(List<List<String>> carMovements) {
        int tryCount = inputTryCount();
        executeRace(carMovements, tryCount);
    }

    // 우승자 발표
    public static void announceWinner(List<List<String>> carMovements) {
        int maxDistance = findMaxDistance(carMovements);
        List<String> winners = findWinners(carMovements, maxDistance);
        printWinners(winners);
    }


    // 이름 입력 및 검증
    private static List<String> inputAndValidateNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return parseAndValidateNames(input);
    }

    private static List<String> parseAndValidateNames(String input) {
        String[] names = input.split(",");
        validateCarCount(names);
        return createValidatedNameList(names);
    }

    private static void validateCarCount(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }

    private static List<String> createValidatedNameList(String[] names) {
        List<String> nameList = new ArrayList<>();
        for (String name : names) {
            String trimmedName = name.strip();
            validateName(trimmedName, nameList);
            nameList.add(trimmedName);
        }
        return nameList;
    }

    private static void validateName(String name, List<String> existingNames) {
        validateNameLength(name);
        validateDuplicateName(name, existingNames);
    }

    private static void validateNameLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    private static void validateDuplicateName(String name, List<String> existingNames) {
        if (existingNames.contains(name)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다: " + name);
        }
    }

    // 차 이동 기록 초기화
    private static List<List<String>> initializeCarMovements(List<String> names) {
        List<List<String>> carMovements = new ArrayList<>();
        for (String name : names) {
            List<String> carMovement = new ArrayList<>();
            carMovement.add(name);
            carMovements.add(carMovement);
        }
        return carMovements;
    }

    // 시도 횟수 입력
    private static int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int tryCount = parseTryCount(input);
        validateTryCount(tryCount);
        return tryCount;
    }

    private static int parseTryCount(String input) {
        return Integer.parseInt(input);
    }

    private static void validateTryCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    // 경주 실행
    private static void executeRace(List<List<String>> carMovements, int tryCount) {
        System.out.println("\n실행 결과");
        for (int round = 0; round < tryCount; round++) {
            executeRound(carMovements);
            printRoundResult(carMovements);
            System.out.println();
        }
    }

    private static void executeRound(List<List<String>> carMovements) {
        for (List<String> car : carMovements) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            moveCar(car, randomValue);
        }
    }

    private static void moveCar(List<String> car, int randomValue) {
        if (randomValue >= 4) {
            car.add("-");
            return;
        }
        car.add("");
    }

    // 라운드 결과 출력
    private static void printRoundResult(List<List<String>> carMovements) {
        for (List<String> car : carMovements) {
            String name = car.get(0);
            String progress = buildProgress(car);
            System.out.println(name + " : " + progress);
        }
    }

    private static String buildProgress(List<String> car) {
        StringBuilder progress = new StringBuilder();
        for (int i = 1; i < car.size(); i++) {
            progress.append(car.get(i));
        }
        return progress.toString();
    }

    // 우승자 찾기
    private static int findMaxDistance(List<List<String>> carMovements) {
        int maxDistance = 0;
        for (List<String> car : carMovements) {
            int distance = calculateDistance(car);
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }

    private static List<String> findWinners(List<List<String>> carMovements, int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (List<String> car : carMovements) {
            int distance = calculateDistance(car);
            if (distance == maxDistance) {
                winners.add(car.get(0));
            }
        }
        return winners;
    }

    private static int calculateDistance(List<String> car) {
        int distance = 0;
        for (int i = 1; i < car.size(); i++) {
            if ("-".equals(car.get(i))) {
                distance++;
            }
        }
        return distance;
    }

    private static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}