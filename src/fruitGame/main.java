package fruitGame;

import java.io.File;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;



	public class main extends Application {
		public static void main(String[] args){
			launch(args);
		}
			@Override
		public void start(Stage primaryStage) throws Exception {
				Score score = Score.getInstance();
				score.load();
				MainMenue menue = new MainMenue();
				menue.prepareScene(primaryStage);
				primaryStage.show();
		}

		
}
