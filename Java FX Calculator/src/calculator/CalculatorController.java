package calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.CalculatorModel;

import java.text.DecimalFormat;

public class CalculatorController {
    private String savedCalcInput;
    private String currentCalcInput;
    private String operators = "+ - * / Enter C";
    private String operatorInput = "";
    DecimalFormat df = new DecimalFormat("#.00"); // Set your desired format here.

    private CalculatorModel model = new CalculatorModel();

    public void calcInput(String input) {

        if (operatorInput == "C") {
            currentCalcInput = "";
            savedCalcInput = "";
            operatorInput = "";
            input = "";
        }

        if (operators.contains(input)) {
            if (operatorInput == "") {
                operatorInput = input;
                savedCalcInput = currentCalcInput;
                currentCalcInput = "";
            } else if (operatorInput == "Enter") {
                //savedCalcInput = String.valueOf(model.calculate(Integer.parseInt(savedCalcInput), Integer.parseInt(currentCalcInput), operatorInput));
                operatorInput = input;
                currentCalcInput = "";
//            } //else if (operatorInput == "/") {
//                savedCalcInput = df.format(Integer.parseInt(savedCalcInput) / 100.0);
            } else {
                savedCalcInput = "" + model.calculate(Integer.parseInt(savedCalcInput), Integer.parseInt(currentCalcInput), operatorInput);
                operatorInput = input;
                currentCalcInput = "";
            }
            //if theres nothing in calc then set curr to input
        } else if (currentCalcInput == "" || currentCalcInput == null) {
            currentCalcInput = input;
        } else {
            currentCalcInput += input;
        }
        System.out.println("cci: " + currentCalcInput + "oi: " + operatorInput + "sci: " + savedCalcInput + " " + input);
    }

    public String showResult() {
        if (operatorInput == "Enter") {
            return savedCalcInput;
        }
        return currentCalcInput;
    }
}