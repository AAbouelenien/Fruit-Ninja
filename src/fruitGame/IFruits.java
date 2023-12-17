package fruitGame;

import javafx.scene.image.ImageView;

public interface IFruits {
	
	public boolean isSliced();
	
	public boolean hasMovedOffScreen();
	
	public String getName();

	public void slice();
	
	public ImageView getIV();
	
	
	
	
}
