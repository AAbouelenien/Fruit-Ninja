package fruitGame;
public class StrategyFactory {
	
	
	public IStrategy createFactory(String name)
	{
		if(name == "level1")
		{
			Strategy1 obj = Strategy1.getInstance();
			return obj;
			
		}
		
		if(name == "level2")
		{
			Strategy2 obj = Strategy2.getInstance();
			return obj;
			
		}
		
		if(name == "level3")
		{
			Strategy3 obj = Strategy3.getInstance();
			return obj;
			
		}
		
		if(name == "level4")
		{
			Strategy4 obj = Strategy4.getInstance();
			return obj;
			
		}
				
		return null;
	}

}
