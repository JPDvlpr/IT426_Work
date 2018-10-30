package view;

import controller.NoteAppController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class QuotesNotes {

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

//    public void start(Stage stage) {
//        note.start(stage);
//        Scene scene = getScene();
//        scene.getStylesheets().add("styles/styles.css");
//        stage.setScene(scene);
//        stage.show();
//        stage.setTitle("Quote Note");
//    }

    public void gridLayout() {
        note.gridLayout();
        grid.setAlignment(Pos.CENTER);
        //grid.setGridLinesVisible(true);
        grid.setId("grid");
        grid.setHgap(BUTTON_PADDING);
        grid.setVgap(BUTTON_PADDING);
        grid.setPadding(new Insets(BUTTON_PADDING));
    }

    public Scene getScene(HBox defaultButtons) {
    
        VBox scene = new VBox(  );
        scene.getChildren().add( defaultButtons );
    
        gridLayout();

        TextField quote = new TextField();
        quote.setFont(Font.font("Helvetica", FontPosture.ITALIC, 14));
        quote.setMaxHeight(BUTTON_WIDTH);
        quote.setId("quote");

        TextField author = new TextField();
        author.setMaxHeight(BUTTON_WIDTH);
        author.setId("author");

        Button post = new Button("Post");
        post.setMaxHeight(BUTTON_WIDTH);
        post.setId("post");

        post.setOnAction(event -> {
            controller.handleNewNote("quote", quote.getText(), author.getText());
        });

        grid.add(quote, 0, ROW_INDEX, NUM_COLS, ROWSPAN);

        grid.add(author, 0, 1, NUM_COLS, ROWSPAN);

        grid.add(post, 0, 2, NUM_COLS, ROWSPAN);
        scene.getChildren().add( grid );
        return new Scene(scene, WIN_WIDTH, WIN_HEIGHT);
    }
}