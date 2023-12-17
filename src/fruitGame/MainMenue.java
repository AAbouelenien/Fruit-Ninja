


	
	
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
import javafx.scene.input.MouseEvent;
	import javafx.scene.layout.GridPane;
	import javafx.scene.layout.Pane;
	import javafx.scene.media.Media;
	import javafx.scene.media.MediaPlayer;
	import javafx.scene.transform.Rotate;
	import javafx.stage.Stage;
	import javafx.util.Duration;



	public class MainMenue {
			Stage stage;
	            Media sound;

	    MediaPlayer mediaPlayer;
	    Score score = Score.getInstance();


			IStrategy strategy;
			StrategyFactory factory = new StrategyFactory();
			public void level1()
			{
				score.num=1;
			
                                
                                mediaPlayer.setMute(true);
				strategy = factory.createFactory("level1");
				Controller control = Controller.getInstance();
				level level = new level();
				control.newGame(strategy, level);
				
				
				
				try {
					
					level.prepareScene(stage,strategy,0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				stage.setScene(level.getScene());
				
				
			}
			
			public void level2()
			{ 
                            mediaPlayer.setMute(true);
				score.num=2;
				strategy = factory.createFactory("level2");
				Controller control = Controller.getInstance();
				level level = new level();
				control.newGame(strategy, level);
				
				
				
				try {
					
					level.prepareScene(stage,strategy,0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				stage.setScene(level.getScene());
				
			}
			
			public void level3()
			{
	             mediaPlayer.setMute(true);
				score.num=3;
				strategy = factory.createFactory("level3");
				Controller control = Controller.getInstance();
				level level = new level();
				control.newGame(strategy, level);
				
				
				
				try {
					
					level.prepareScene(stage,strategy,0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				stage.setScene(level.getScene());
			
			}
			
			

			public void level4()
			{
				score.num=4;
	                  mediaPlayer.setMute(true);
				strategy = factory.createFactory("level4");
				Controller control = Controller.getInstance();
				level level = new level();
				control.newGame(strategy, level);
				
				
				
				try {
					
					level.prepareScene(stage,strategy,1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				stage.setScene(level.getScene());
			
			}
			
			public void prepareScene(Stage primaryStage) {
				this.stage = stage;
				stage = primaryStage;
				Button level1 = new Button("level 1");
				Button level2 = new Button("level 2");
				Button level3 = new Button("level 3");
				Image img = new Image("file:back.jpg");
			        ImageView iv = new ImageView(img);
	              
	                        Image level11 = new Image("file:level1.gif");
			        ImageView l1 = new ImageView(level11);
	                          l1.setFitHeight(800);
			          l1.setFitWidth(800);
	                       
                                  l1.setX(-40);
                                  l1.setY(-70);
	                   
	   
                                      Image level12 = new Image("file:level2.gif");
			        ImageView l2 = new ImageView(level12);
	                          l2.setFitHeight(800);
			          l2.setFitWidth(800);
	                       
                                  l2.setX(630);
                                  l2.setY(-16);
                                  
                                  Image level13 = new Image("file:level3.gif");
			        ImageView l3 = new ImageView(level13);
	                          l3.setFitHeight(800);
			          l3.setFitWidth(800);
	                       
                                  l3.setX(60);
                                  l3.setY(430);
                                  
                                   Image level14 = new Image("file:arcade.gif");
			        ImageView l4 = new ImageView(level14);
	                          l4.setFitHeight(800);
			          l4.setFitWidth(800);
	                       
                                  l4.setX(600);
                                  l4.setY(400);
	                        iv.setFitHeight(720);
			        iv.setFitWidth(1100);
	                        
                                  l1.setOnMouseClicked((MouseEvent e) ->{
      
            level1();
        });
                                   l2.setOnMouseClicked((MouseEvent e) ->{

            level2();
        });
                                   l3.setOnMouseClicked((MouseEvent e) ->{

            level3();
        });
                                   
                                     l4.setOnMouseClicked((MouseEvent e) ->{

            level4();
        });
	                        Pane pane = new Pane();
				
				
	                        pane.getChildren().add(iv);
	                        pane.getChildren().add(l1);
	                       pane.getChildren().add(l2);
	                       pane.getChildren().add(l3);
                               pane.getChildren().add(l4);
	                         
				Scene scene = new Scene(pane,1100,700);
				
				stage.setScene(scene);
				stage.show();
				
				
				

             String musicFile = "another.mp3";    
              
        sound = new Media(new File(musicFile).toURI().toString());

				
           mediaPlayer = new MediaPlayer(sound);
//	                         
	                   /*     
				Button level1 = new Button("level 1");
				Button level2 = new Button("level 2");
				Button level3 = new Button("level 3");
				Button level4 = new Button("Arcade");
				
				
				GridPane grid = new GridPane();
				grid.add(level1, 0, 0);
				grid.add(level2, 0, 1);
				grid.add(level3, 0, 2);
				grid.add(level4, 0, 3);
				
				level1.setOnAction(e->level1());
				level2.setOnAction(e->level2());
				level3.setOnAction(e->level3());
				level4.setOnAction(e->level4());
				*/
				
				mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

	                      mediaPlayer.play();

				
			}

			
	}



