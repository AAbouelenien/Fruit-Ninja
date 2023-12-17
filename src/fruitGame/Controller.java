package fruitGame;

import java.io.File;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Controller implements IController {
	
	static Controller control;
	level level;
	IStrategy strategy;
	  Media sound;
          

    MediaPlayer mediaPlayer;
     Media sound2;
          

    MediaPlayer mediaPlayer2;
     Media sound3;
          

    MediaPlayer mediaPlayer3;
	private Controller() {};
	
	public static Controller getInstance()
	{
		if(control == null)
			control = new Controller();
		
		return control;
		
	}
	
	
	
	public void slice(Fruit fruit) {
		fruit.slice();
		level.sliced.add(fruit.getIV());
		
		
		if(fruit.Name == "Banana"){
                     String musicFile = "swipe.wav";    
                   sound = new Media(new File(musicFile).toURI().toString());
                       mediaPlayer = new MediaPlayer(sound);
                        mediaPlayer.play();
                    level.score++;
                }
			
		
		if(fruit.Name == "Coconut"){level.score = level.score+2;
                String musicFile = "swipe.wav";    
                      sound = new Media(new File(musicFile).toURI().toString());
                     mediaPlayer = new MediaPlayer(sound);
//                        
//
                        mediaPlayer.play();
                }
                if(fruit.Name == "Orange"){

                for(int i = 0; i<level.fruitList.size();i++)
                {
                	if(level.fruitList.get(i).isSliced == false)
                	slice(level.fruitList.get(i));
                	
                }
                
                }
			if(fruit.Name == "PineApple"){
				level.score = level.score+2;
                 String musicFile = "swipe.wav";    
                      sound = new Media(new File(musicFile).toURI().toString());
                        mediaPlayer = new MediaPlayer(sound);
//                       
//
                         mediaPlayer.play();
			
                }
		
		if(fruit.Name == "Pomegranate")
			{
			  String musicFile = "swipe.wav";    
                       sound = new Media(new File(musicFile).toURI().toString());
                     mediaPlayer = new MediaPlayer(sound);
//                        
//
                        mediaPlayer.play();
			level.score = level.score+1;
			if(level.lives<3)
			level.lives +=1;
			
			}
		if(fruit.Name == "WaterMelon"){ 
                  String musicFile = "swipe.wav";    
                        sound = new Media(new File(musicFile).toURI().toString());
                       mediaPlayer = new MediaPlayer(sound);
////                        

                        mediaPlayer.play();
                    level.score = level.score+2;
                }
                
                  
			
	if(fruit.Name == "Avocado"){  
            level.speed=0;
         String musicFile = "swipe.wav";    
                       sound = new Media(new File(musicFile).toURI().toString());                        mediaPlayer = new MediaPlayer(sound);
//                        
                     mediaPlayer.play();
        }
                  
		
		if(fruit.getName() == "DangerousExplosion")
		{
                   
			 String musicFile2 = "Dang.wav";   
                     sound2 = new Media(new File(musicFile2).toURI().toString());                     mediaPlayer2 = new MediaPlayer(sound2);
////                        
                     mediaPlayer2.play();

			level.lives = level.lives-1;
				
				if(level.lives == 0)
					{
					AlertBox.display("End", "You have lost!");
					level.back();
					}
			
			
			level.lblMissed.setText("Lives: " + String.valueOf(level.lives));
		
		
		}
	

		if(fruit.getName() == "FatalBomb")
		{
//                  
                   String musicFile3 = "Fatal.wav";   
                        sound3 = new Media(new File(musicFile3).toURI().toString());
mediaPlayer3 = new MediaPlayer(sound3);
////                        
                     mediaPlayer3.play();
                          
			level.lives = 0;
			
			//if(level.lives == 0)
				AlertBox.display("End", "You have lost!");
				level.back();
		
		
		level.lblMissed.setText("Lives: " + String.valueOf(level.lives));
	
		}

		
		level.lblScore.setText("Score :" + String.valueOf(level.score));
		
	
	}




	@Override
	public void newGame(IStrategy strategy, fruitGame.level level) {
		this.level = level;
		this.strategy=strategy;
		level.maxSpeed = strategy.getMaxSpeed();
	}

}
