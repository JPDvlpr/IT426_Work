package view;

import calculator.CalculatorController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Calculator user interface. Displays the view
 * for the user to interact and process calculations
 *
 * @author Jhakon Pappoe
 * @version 1.0
 */
public class CalculatorUI extends Application {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int COLSPAN = 2;
    private static final int NUM_COLS = 4;
    private static final int COL_WIDTH = 40;
    private static final int ROW_INDEX = 5;
    private static final int ROWSPAN = 1;
    private static final int WIN_WIDTH = COL_WIDTH * 7;
    private static final int WIN_HEIGHT = COL_WIDTH * 7;
    private static final double BUTTON_WIDTH = 40;
    private static final int BUTTON_PADDING = 10;
    private CalculatorController controller = new CalculatorController();
    private GridPane grid = new GridPane();


    /**
     * starts the stage, sets title, adds stylesheet
     * @param stage sets the title of the program and displays the scene
     */
    @Override
    public void start(Stage stage) {
        Scene scene = getScene();
        scene.getStylesheets().add("styles/styles.css");
        stage.setTitle("The Most Basic Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private void gridLayout(){
        grid.setAlignment(Pos.CENTER);
        grid.setId("grid");
        grid.setHgap(BUTTON_PADDING);
        grid.setVgap(BUTTON_PADDING);
        grid.setPadding(new Insets(BUTTON_PADDING));
    }

    private Scene getScene() {
        gridLayout();
        ObservableList<ColumnConstraints> cols = grid.getColumnConstraints();
        for (int i = 1; i <= NUM_COLS; i++) {
            cols.add(new ColumnConstraints(COL_WIDTH));
        }
        TextArea total = new TextArea();
        total.setMaxHeight(BUTTON_WIDTH);
        Button[] buttons = {new Button("7"), new Button("8"), new Button("9"),
                new Button("+"), new Button("4"), new Button("5"), new Button("6"),
                new Button("-"), new Button("1"), new Button("2"), new Button("3"),
                new Button("*"), new Button("0"), new Button("Enter"), new Button("/"), new Button("C")};
        int counter = ZERO;
        for (int i = ZERO; i < buttons.length; i++) {
            int columns = i % NUM_COLS;
            int rows = i / NUM_COLS;
            String text = buttons[i].getText();
            buttons[i].setOnAction(event -> {
                getController().calcInput(text);
                total.setText(getController().showResult());
            });

            if (buttons[i].getText().equals("Enter")) {
                grid.add(buttons[i], columns, rows, COLSPAN, ONE);
                buttons[i].setPrefWidth(COL_WIDTH * COLSPAN + BUTTON_PADDING);
                counter++;
            } else {
                grid.add(buttons[i], columns + counter, rows);
                buttons[i].setPrefWidth(BUTTON_WIDTH);
            }
        }

        grid.add(total, ZERO, ROW_INDEX, NUM_COLS, ROWSPAN);

        return new Scene(grid, WIN_WIDTH, WIN_HEIGHT);
    }

    @Override
    public String toString() {
        return "CalculatorUI{" +
                "controller=" + getController() +
                '}';
    }

    private CalculatorController getController() {
        return controller;
    }
}