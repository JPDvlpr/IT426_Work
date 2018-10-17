package calculator;

import model.CalculatorModel;

public class CalculatorController {

    private CalculatorModel model = new CalculatorModel();

    public void calcInput(String input) {
        model.calcInput(input);
    }

    public String showResult() {
        return model.showResult();
    }
}