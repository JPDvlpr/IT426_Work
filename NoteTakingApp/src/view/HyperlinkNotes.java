package view;

import controller.NoteAppController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

public class HyperlinkNotes
{
    private Notes note = new Notes();
    public GridPane grid = new GridPane();
    private final int NUM_COLS = 4;
    private final int COL_WIDTH = 40;
    private final int ROW_INDEX = 0;
    private final int ROWSPAN = 1;
    private final int WIN_WIDTH = COL_WIDTH * 12;
    private final int WIN_HEIGHT = COL_WIDTH * 12;
    private final double BUTTON_WIDTH = 40;
    private final int BUTTON_PADDING = 10;
    private NoteAppController controller = new NoteAppController();


//    public void start(Stage stage){
//        note.start(stage);
//        Scene scene = getScene();
//        scene.getStylesheets().add("styles/styles.css");
//        stage.setScene(scene);
//        stage.show();
//        stage.setTitle("Hyperlink Note");
//    }

    public void gridLayout(){
        note.gridLayout();
        grid.setAlignment(Pos.CENTER);
        //grid.setGridLinesVisible(true);
        grid.setId("hyperlink-grid");
        grid.setHgap(BUTTON_PADDING);
        grid.setVgap(BUTTON_PADDING);
        grid.setPadding(new Insets(BUTTON_PADDING));
    }

    public Scene getScene() {

        gridLayout();

        TextField hyperlinkName = new TextField();
        hyperlinkName.setFont(Font.font("Helvetica", FontPosture.ITALIC, 14));
        hyperlinkName.setMaxHeight(BUTTON_WIDTH);
        hyperlinkName.setId("hyperlink-name");

        hyperlinkName.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Name: " + newValue);
        });

        TextField hyperlink = new TextField();
        hyperlink.setFont(Font.font("Helvetica", FontPosture.ITALIC, 14));
        hyperlink.setMaxHeight(BUTTON_WIDTH);
        hyperlink.setId("hyperlink");

        hyperlink.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Hyperlink: " + newValue);
        });

        Button post = new Button("Post");
        post.setMaxHeight(BUTTON_WIDTH);
        post.setId("post");

        post.setOnAction(event -> {
            controller.handleNewNote("hyperlink", hyperlinkName.getText(), hyperlink.getText());
        });

        grid.add(hyperlinkName, 0, ROW_INDEX, NUM_COLS, ROWSPAN);

        grid.add(hyperlink, 0, 1, NUM_COLS, ROWSPAN);

        grid.add(post, 0, 2, NUM_COLS, ROWSPAN);

        return new Scene(grid, WIN_WIDTH, WIN_HEIGHT);
    }
}