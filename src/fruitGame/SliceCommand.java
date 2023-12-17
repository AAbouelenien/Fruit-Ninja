package fruitGame;

import java.util.ArrayList;

public class SliceCommand implements ICommand{
Controller controller;
Fruit fruit;


public SliceCommand(Controller controller ,  Fruit fruit)
{
	this.controller=controller;
	this.fruit = fruit;
}

public void execute()
{
	controller.slice(fruit);

}


}
