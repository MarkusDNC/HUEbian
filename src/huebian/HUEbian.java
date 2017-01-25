/*
 * Copyright (C) 2017 Markus
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package huebian;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Markus
 */
public class HUEbian extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("HUEbian");
        primaryStage.setResizable(false);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 20, 10, 20));
        Button btnSettings = new Button("");
        btnSettings.setId("imageButton");
        btnSettings.setMaxHeight(48);
        btnSettings.setMinHeight(48);
        btnSettings.setMaxWidth(48);
        btnSettings.setMinWidth(48);
       
        borderPane.setBottom(btnSettings);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(80, 25, 25, 25));
        
        Scene scene = new Scene(borderPane, 800, 480);
        primaryStage.setScene(scene);
        scene.getStylesheets().add
            (HUEbian.class.getResource("Huebian.css").toExternalForm());
        
        Button btn = createControlButton("Vardagsrum");
        btn.setId("buttonOn");
        grid.add(btn, 0, 0);
        //grid.addRow(3, btnSettings);
        for(int i=1; i<5; i++){
            btn = createControlButton("Hall" + i);
            if(i<5){
                grid.add(btn, i, 0);
            }
            else {
                grid.add(btn, i-5, 1);
            }
        }
        borderPane.setCenter(grid);
        primaryStage.show();
    }
    
    private Button createControlButton(String name){
        Button btn = new Button(name);
        btn.setMaxHeight(125);
        btn.setMaxWidth(125);
        btn.setMinHeight(125);
        btn.setMinWidth(125);
        btn.setId("buttonOff");
        return btn;
    }
    
    private Button createImageButton(String filePath){
        Button btn = new Button();
        Image image = new Image(filePath);
        double width = image.getWidth();
        double height = image.getHeight();
        btn.setMaxHeight(height);
        btn.setMinHeight(height);
        btn.setMaxWidth(width);
        btn.setMinWidth(width);
        btn.setId("imageButton");
        return btn;
    }
    /*
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Vardagsrum");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Running HUEbian");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 800, 480);
        
        primaryStage.setTitle("HUEbian");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
