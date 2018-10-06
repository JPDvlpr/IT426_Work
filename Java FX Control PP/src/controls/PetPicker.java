package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

/**
 * This Java FX UI show various animal images.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class PetPicker extends Application {
    public static final int HEIGHT = 380;
    public static final int WIDTH = 340;
    public static final int IMG_SIZE = 250;
    public static final int SPACING = 10;
    public static final int DOUBLE_SPACING = 15;
    public static final int FONT_SIZE = 14;

    private String[] images = {"BEAR", "CAT", "OWL", "PARROT"};
    private ImageView imageView;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Select an image!");
        stage.setScene(getScene());
        stage.show();
    }

    private Scene getScene() {
        //main panel
        VBox elements = new VBox();
        elements.setSpacing(SPACING);
        elements.setPadding(new Insets(DOUBLE_SPACING));

        //create buttons panel and viewer panel
        imageView = createViewerImage();
        elements.getChildren().addAll(createButtons(), imageView);

        return new Scene(elements, WIDTH, HEIGHT);
    }

    private HBox createButtons() {
        HBox panel = new HBox();
        panel.setSpacing(SPACING);

        ToggleGroup group = new ToggleGroup();

        for (int i = 0; i < images.length; i++) {
            RadioButton button = getButton(group, images[i]);
            panel.getChildren().add(button);

            if (i == 0) {
                button.setSelected(true);
            }
        }

        return panel;
    }

    private RadioButton getButton(ToggleGroup group, String image) {
        String imageFile = "res/" + image + ".jpg";

        RadioButton button = new RadioButton();
        button.setText(image);
        button.setToggleGroup(group);
        button.setFont(Font.font("Baskerville", FontWeight.LIGHT, FONT_SIZE));

        button.selectedProperty().addListener((observable, oldValue, newValue) -> {
            Image file = new Image(getImageLocation(imageFile), true);
            imageView.setImage(file);
        });

        return button;
    }

    private String getImageLocation(String image) {
        try {
            return new File(image).toURI().toURL().toString();
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Image not found: " + e.getMessage());
        }
    }

    private ImageView createViewerImage() {
        ImageView imageView = new ImageView();
        imageView.setFitHeight(IMG_SIZE);
        imageView.setFitWidth(IMG_SIZE);

        return imageView;
    }

    @Override
    public String toString() {
        return "A UI that shows various animal images.";
    }
}