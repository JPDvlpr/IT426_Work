package view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Notes extends Application {

    public GridPane grid = new GridPane();
    private final int NUM_COLS = 4;
    private final int COL_WIDTH = 40;
    private final int BUTTON_PADDING = 10;
    private final int WIN_WIDTH = COL_WIDTH * 7;
    private final int WIN_HEIGHT = COL_WIDTH * 7;

    /**
     * starts the stage, sets title, adds stylesheet
     *
     * @param stage sets the title of the program and displays the scene
     */
    public void start(Stage stage) {
        Scene scene = getScene();
        stage.setScene(scene);
        stage.show();
    }

    public void gridLayout() {
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(BUTTON_PADDING);
        grid.setVgap(BUTTON_PADDING);
        grid.setPadding(new Insets(BUTTON_PADDING));
        grid.setGridLinesVisible(true);
    }

    public Scene getScene() {
        gridLayout();
        ObservableList<ColumnConstraints> cols = grid.getColumnConstraints();
        for (int i = 1; i <= NUM_COLS; i++) {
            cols.add(new ColumnConstraints(COL_WIDTH));
        }
        return new Scene(grid, WIN_WIDTH, WIN_HEIGHT);
    }
}