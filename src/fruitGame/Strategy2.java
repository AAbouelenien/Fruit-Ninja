package fruitGame;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.input.MouseEvent;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;

public class Strategy2 implements IStrategy {

	private static Strategy2 strategy;
	
	
	private Fruit fruit;
	private Strategy2() {
		
	}
	
	public static Strategy2 getInstance()
	{
		if(strategy == null)
			strategy = new Strategy2();
		return strategy;
		
		
	}
	
	public void createFruit() 
	{
	
		Remote remote = Remote.getInstance();
		
		
		FruitFactory factory = new FruitFactory();
		
		Random rand = new Random();
		  int randomNum = rand.nextInt((9 - 1) + 1) + 1;
		  Controller control = Controller.getInstance();
		  
		  if(randomNum == 1)
		  {
			  Banana B = (Banana) factory.createFactory("Banana");
			  B.getIV().setOnMouseMoved((MouseEvent e) -> {
					SliceCommand command = new SliceCommand(control,B);
					remote.setCommand(command);
					if(B.isSliced == false)	
						remote.doCommand();
						//		control.slice(B);
						
					
				});
			 
			  fruit = B;
			  
		  }
		  
		  
		  else if(randomNum == 2)
		  {
			  Coconut C = (Coconut) factory.createFactory("Coconut");
			  C.getIV().setOnMouseMoved((MouseEvent e) -> {
					SliceCommand command = new SliceCommand(control,C);
					remote.setCommand(command);
					if(C.isSliced == false)	
						remote.doCommand();
						//		control.slice(B);
						
					
				});
			 
			  fruit = C;
			  
		  }
		
		  
		  else if(randomNum == 3)
		  {
			  Pomegranate P = (Pomegranate) factory.createFactory("Pomegranate");
			  P.getIV().setOnMouseMoved((MouseEvent e) -> {
					SliceCommand command = new SliceCommand(control,P);
					remote.setCommand(command);
					if(P.isSliced == false)	
						remote.doCommand();
						//		control.slice(B);
						
					
				});
			 
			  fruit = P;
			  
		  }
		  
		  else if(randomNum == 4)
		  {
			  WaterMelon W = (WaterMelon) factory.createFactory("WaterMelon");
			  W.getIV().setOnMouseMoved((MouseEvent e) -> {
					SliceCommand command = new SliceCommand(control,W);
					remote.setCommand(command);
					if(W.isSliced == false)	
						remote.doCommand();
						//		control.slice(B);
						
					
				});
			 
			  fruit = W;
			  
		  }
		  
		  else if(randomNum == 5)
		  {
			  Avocado A = (Avocado) factory.createFactory("Avocado");
			  A.getIV().setOnMouseMoved((MouseEvent e) -> {
					SliceCommand command = new SliceCommand(control,A);
					remote.setCommand(command);
					if(A.isSliced == false)	
						remote.doCommand();
						//		control.slice(B);
						
					
				});
			 
			  fruit = A;
			  
		  }
		  
		  else if(randomNum == 6)
		  {
			  PineApple I = (PineApple) factory.createFactory("PineApple");
			  I.getIV().setOnMouseMoved((MouseEvent e) -> {
					SliceCommand command = new SliceCommand(control,I);
					remote.setCommand(command);
					if(I.isSliced == false)	
						remote.doCommand();
						//		control.slice(B);
						
					
				});
			 
			  fruit = I;
			  
		  }
		  
		  else if(randomNum == 7)
		  {
			  Orange O = (Orange) factory.createFactory("Orange");
			  O.getIV().setOnMouseMoved((MouseEvent e) -> {
					SliceCommand command = new SliceCommand(control,O);
					remote.setCommand(command);
					if(O.isSliced == false)	
						remote.doCommand();
						//		control.slice(B);
						
					
				});
			 
			  fruit = O;
		  }
		  
		  
		  else if(randomNum == 8)
		  {
			  DangerousBomb D = (DangerousBomb) factory.createFactory("DangerousBomb");
			  D.getIV().setOnMouseMoved((MouseEvent e) -> {
					SliceCommand command = new SliceCommand(control,D);
					remote.setCommand(command);
					if(D.isSliced == false)	
						remote.doCommand();
						//		control.slice(B);
						
					
				});
			 
			  fruit = D;
		  }
		  
		  else if(randomNum == 9)
		  {
			  FatalBomb F = (FatalBomb) factory.createFactory("FatalBomb");
			  F.getIV().setOnMouseMoved((MouseEvent e) -> {
					SliceCommand command = new SliceCommand(control,F);
					remote.setCommand(command);
					if(F.isSliced == false)	
						remote.doCommand();
						//		control.slice(B);
						
					
				});
			 
			  fruit = F;
		  }
			
		  
		  
		
		
		
		


               
		
	}
	
	public Fruit getFruit() {
	
		createFruit();
		
		return fruit;
	}

	@Override
	public int getMaxSpeed() {
	
		return 600;
	}

}
