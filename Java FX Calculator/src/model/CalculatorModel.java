package model;

import java.text.DecimalFormat;

/**
 * Model class takes the workload and the functionality to be passed
 * to the controller
 * @author Jhakon Pappoe
 * @version 1.0
 */
public class CalculatorModel {
    private static final int ZERO = 0;
    private String savedCalcInput;
    private String currentCalcInput;
    private String operators = "+ - * / Enter C";
    private String operatorInput = "";
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");

    /**
     * takes first number, second, and an operator of add, sub, mult, div
     *
     * @param calcNumb1 first number
     * @param calcNumb2 second number
     * @param operator operation for first and second number
     * @return return the operation
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
                if (calcNumb2 == ZERO) {
                    return ZERO;
                }
                return calcNumb1 / calcNumb2;
            default:
                return ZERO;
        }
    }

    /**
     * main functionality of the calculator
     *
     * @param input user input for the calculator
     */
    public void calcInput(String input) {

        if (input.equals("C")) {
            currentCalcInput = "";
            savedCalcInput = "";
            operatorInput = "";
        } else if (operators.contains(input)) {
            if (operatorInput.equals("")) {
                operatorInput = input;
                savedCalcInput = currentCalcInput;
                currentCalcInput = "";
            } else if (operatorInput.equals("Enter")) {
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
     *
     *
     * @return Returns the calculated input
     */
    public String showResult() {
        if (operatorInput.equals("Enter")) {
            return savedCalcInput;
        }
        return currentCalcInput;
    }

    @Override
    public String toString() {
        return "CalculatorModel{" +
                "savedCalcInput='" + savedCalcInput + '\'' +
                ", currentCalcInput='" + currentCalcInput + '\'' +
                ", operators='" + operators + '\'' +
                ", operatorInput='" + operatorInput + '\'' +
                ", decimalFormat=" + decimalFormat +
                '}';
    }
}