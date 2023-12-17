package fruitGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WaterMelon extends Fruit {

	public WaterMelon()
	{
		
	img1 = new Image("file:w.png");
	img2 = new Image("file:wSplit.gif");
	iv = new ImageView(img1);
        iv.setFitHeight(100);
        iv.setFitWidth(100);
	Name = "WaterMelon";
		
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
