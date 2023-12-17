package fruitGame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Avocado extends Fruit {

	public Avocado()
	{
		
	img1 = new Image("file:Avo.gif");
	img2 = new Image("file:AvoSplit.gif");
        
	iv = new ImageView(img1);
        iv.setFitHeight(150);
        iv.setFitWidth(150);
	Name = "Avocado";
		
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
