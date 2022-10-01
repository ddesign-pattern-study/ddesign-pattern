package beverage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverageWithHook {
    @Override
    void brew() {
        System.out.println("필터로 커피를 우려내는 중");
    }

    @Override
    void addCondiments() {
        System.out.println("우유와 설탕을 추가하는 중");
    }

    @Override
    boolean customWantsCondiments() {
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    private String getUserInput() {
        String answer = null;

        System.out.println("커피에 우유와 설탕을 넣을까요? (y/n)? ");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe) {
            System.out.println("IO 오류");
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }
}
