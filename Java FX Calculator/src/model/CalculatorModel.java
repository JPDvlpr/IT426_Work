package model;

import java.text.DecimalFormat;

/**
 * Model class takes the workload and the functionality to be passed
 * to the controller
 */
public class CalculatorModel {
    private static final int ZERO = 0;
    private String savedCalcInput;
    private String currentCalcInput;
    private String operators = "+ - * / Enter C";
    private String operatorInput = "";
    DecimalFormat df = new DecimalFormat("#.00");

    /**
     * takes first number, second, and an operator of add, sub, mult, div
     *
     * @param calcNumb1
     * @param calcNumb2
     * @param operator
     * @return
     */
    public long calculate(long calcNumb1, long calcNumb2, String operator) {
        switch (operator) {
            case "+":
                return calcNumb1 + calcNumb2;
            case "-":
                return calcNumb1 - calcNumb2;
            case "*":
                return calcNumb1 * calcNumb2;
            case "/":
                if (calcNumb2 == ZERO)
                    return ZERO;
                return calcNumb1 / calcNumb2;
            default:
                return ZERO;
        }
    }

    /**
     * main functionality of the calculator
     *
     * @param input
     */
    public void calcInput(String input) {

        if (input == "C") {
            currentCalcInput = "";
            savedCalcInput = "";
            operatorInput = "";
            input = "";
        } else if (operators.contains(input)) {
            if (operatorInput == "") {
                operatorInput = input;
                savedCalcInput = currentCalcInput;
                currentCalcInput = "";
            } else if (operatorInput == "Enter") {
                operatorInput = input;
                currentCalcInput = "";
            } else {
                savedCalcInput = "" + calculate(Integer.parseInt(savedCalcInput),
                        Integer.parseInt(currentCalcInput), operatorInput);
                operatorInput = input;
                currentCalcInput = "";
            }
        } else if (currentCalcInput == "" || currentCalcInput == null) {
            currentCalcInput = input;
        } else {
            currentCalcInput += input;
        }
    }

    /**
     * Returns the calculated input
     *
     * @return
     */
    public String showResult() {
        if (operatorInput == "Enter") {
            return savedCalcInput;
        }
        return currentCalcInput;
    }
}