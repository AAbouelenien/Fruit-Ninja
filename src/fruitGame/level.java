package fruitGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.Animation;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
public class level  {
	Stage stage;
	AnimationTimer timer;
	Scene scene;
	Timer timer2;
	Pane root = new Pane();
	List drop = new ArrayList();
	List sliced = new ArrayList();
	List bombs = new ArrayList();
	double mouseX;
	Rectangle cont;
	double speed;
	double falling;
	Label lblMissed;
	Label lblScore;
	Label lblTime;
	int lives =3;
	int score =0;
	Timeline timeline;
	int time =0;
	int maxSpeed = 1000;
	int mode;
	int highestScore;
        Label highest;
	Score scores = Score.getInstance();
	ArrayList<Fruit> fruitList = new ArrayList<Fruit>();
        
	
	IStrategy strategy;
	ArrayList<Fruit> list = new ArrayList<Fruit>();
	TimerTask task = new TimerTask()
			{
		
		public void run()
		{
			if(mode ==0)
			time++;
			else
				time--;
			
	
			
		}
			};

			
			


	public void prepareScene(Stage stage , IStrategy Strategy , int mode) throws Exception {
		highestScore = scores.getHighestScore();
		this.mode = mode;
		if(mode == 1)
			time = 60;
		this.stage = stage;
		strategy = Strategy;
		timer2 = new Timer();
		timer2.schedule(task, 1000,1000);
		lblMissed = new Label("Lives: 3");
		lblScore = new Label("Score: 0");
		lblTime = new Label("Time: 0");
              
                highest = new Label("Highest Score: "+ scores.getHighestScore());
		lblMissed.setLayoutX(860);
		lblMissed.setLayoutY(70);
                lblMissed.setTextFill(Color.web("#FFFFFF"));
		
		lblScore.setLayoutX(860);
		lblScore.setLayoutY(30);
	        lblScore.setTextFill(Color.web("#FFFFFF"));
                 
                 
		lblTime.setLayoutX(860);
		lblTime.setLayoutY(50);
	        lblTime.setTextFill(Color.web("#FFFFFF"));
		
                highest.setLayoutX(860);
		highest.setLayoutY(10);
	        highest.setTextFill(Color.web("#FFFFFF"));
		
		speed = 1;
		falling = 500;
		
		
		
		timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {
			if(lives<0)
				return;
			
			if(time == -1)
				back();
			
			if(speed < maxSpeed)
			speed += falling / 3000;
			
			
			
			
			
			
			Fruit added =strategy.getFruit();
			
		    if(added instanceof DangerousBomb || added instanceof FatalBomb )
		    	{
		    	
		    	bombs.add(added.getIV());
		    	
		    	}
		    
		    if(!(added instanceof DangerousBomb) && !(added instanceof FatalBomb) )
	    	{
	    	
	    	fruitList.add(added);
	    	
	    	}
		    	
		    
		    	
		    added.getIV().setLayoutX(rand(0, 800));
			added.getIV().setLayoutY(1);
			
			drop.add(added.getIV());
			root.getChildren().add(((Node)drop.get(drop.size() -1)));
			
			lblTime.setText("Time :" + String.valueOf(time));
                       
                        if (score > highestScore){
                            highest.setText("");
                            highest.setText("Highest Score: "+score);
                            
                        }
                        
                    

        }));
		
		timeline.setCycleCount(1000);
		timeline.play();
		
		
		
		timer = new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				
				gameUpdate();
				
			}
			
		};
		
		timer.start();	
		
		
		
		Image img = new Image("file:back.PNG");
		ImageView iv = new ImageView(img);
                  Image rot = new Image("file:wr.gif");
		        ImageView r = new ImageView(rot);
                          r.setFitHeight(100);
		          r.setFitWidth(100);
                          
		          
		          r.setOnMouseClicked(e->back());
                       
                      
                      final Rotate rotationTransform = new Rotate(0, 50, 50);
                        r.getTransforms().add(rotationTransform);
               final Timeline rotationAnimation = new Timeline();
    rotationAnimation.getKeyFrames()
      .add(
        new KeyFrame(
          Duration.seconds(5),
          new KeyValue(
            rotationTransform.angleProperty(),
            360
          )
        )
      );
    
    rotationAnimation.setCycleCount(Animation.INDEFINITE);
    rotationAnimation.play();
     rotationTransform.setAxis(Rotate.Y_AXIS);
     
		root.getChildren().addAll(iv,lblMissed , lblScore , lblTime,r,highest);
		iv.setFitHeight(700);
		iv.setFitWidth(1000);
		
		scene = new Scene(root, 1000, 700);
		
		
	}
	

	

	
	public int rand(int min, int max) {
		return (int)(Math.random() * max + min);
	}
	public void gameUpdate(){
		
		for(int j = 0; j < fruitList.size(); j++) {
			
			if( fruitList.get(j).getIV().getLayoutY()  >= 990) {
				
				fruitList.remove(j);
				
			}
		}
		
		for(int i = 0; i < drop.size(); i++) {
			((ImageView) drop.get(i)).setLayoutY(((ImageView) drop.get(i)).getLayoutY() + speed + ((ImageView) drop.get(i)).getLayoutY() / 150 );
			
			if(((ImageView) drop.get(i)).getLayoutY() >= 690) {
				root.getChildren().remove(((ImageView) drop.get(i)));
				
				
				if(!sliced.contains((ImageView) drop.get(i)) && !bombs.contains((ImageView) drop.get(i)))
				{
					lives = lives  -1;
					if(lives == 0) {
						AlertBox.display("End", "You have lost!");
					back();	
					}
				}
				drop.remove(i);
				
				lblMissed.setText("Lives: " + String.valueOf(lives));
			}
		}
	}
	
	
	
	public Scene getScene()
	{
		return scene;
	}
	
	public void back()
	{
	lives =-1;
	timeline.stop();
	scores.setScore(score);
	scores.save();
	System.out.println("Highest Score" + highestScore);
	MainMenue menue = new MainMenue();
	menue.prepareScene(stage);
	
		
	}

}