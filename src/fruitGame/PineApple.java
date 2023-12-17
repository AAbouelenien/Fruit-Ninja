package fruitGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PineApple extends Fruit {

	public PineApple()
	{
		
	img1 = new Image("file:pine.gif");
	img2 = new Image("file:pineSplit.gif");
        
	iv = new ImageView(img1);
        iv.setFitHeight(150);
        iv.setFitWidth(100);
	Name = "PineApple";
		
	}
	
	@Override
	public boolean isSliced() {
		return isSliced();
		
	}

	@Override
	public boolean hasMovedOffScreen() {
		return hasMovedOffScreen;
		
	}

	@Override
	public String getName() {
		return Name;
	}

	@Override
	public void slice() {
		iv.setImage(img2);
		isSliced=true;
		
	}

	@Override
	public ImageView getIV() {
		return iv;
		
	}

	

}
