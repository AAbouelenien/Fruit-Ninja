package fruitGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coconut extends Fruit {

	public Coconut()
	{
		
	img1 = new Image("file:Coconut.png");
	img2 = new Image("file:Coc split.png");
	iv = new ImageView(img1);
         iv.setFitHeight(150);
        iv.setFitWidth(150);
	Name = "Coconut";
		
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
