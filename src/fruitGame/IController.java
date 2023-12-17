package fruitGame;

public interface IController {

	public void slice(Fruit fruit);
	public void newGame(IStrategy strategy , level level);
	
}
