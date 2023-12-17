package fruitGame;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.*;


public class AlertBox {
	public static void display (String title , String message)
	{
		Stage window = new Stage();
		window.setWidth(300);
		window.setHeight(200);
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		window.setTitle(title); 
		
		Pane pane = new Pane();
		
		Image img = new Image("file:gameOver.gif");
		ImageView iv = new ImageView(img);
		iv.setFitHeight(300);
                iv.setFitWidth(300);
		iv.setX(0);
                iv.setY(-60);
		pane.getChildren().add(iv);
		
		Scene scene = new Scene(pane);
		
		window.setScene(scene);
		
                window.show();

		
		
		
		
		
	}

}
