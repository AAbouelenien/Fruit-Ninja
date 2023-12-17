package fruitGame;
public class FruitFactory {
	
	
	public Fruit createFactory(String name)
	{
		if(name == "Banana")
		{
			Banana obj = new Banana();
			return obj;
			
		}
		
		else if(name == "Pomegranate")
		{
			Pomegranate obj = new Pomegranate();
			return obj;
			
		}
		
		else if(name == "Coconut")
		{
			Coconut obj = new Coconut();
			return obj;
			
		}
		else if(name == "WaterMelon")
		{
			WaterMelon obj = new WaterMelon();
			return obj;
			
		}
		else if(name == "Avocado")
		{
			Avocado obj = new Avocado();
			return obj;
			
		}
		else  if(name == "PineApple")
		{
			PineApple obj = new PineApple();
			return obj;
			
		}
		else if(name == "Orange")
		{
			Orange obj = new Orange();
			return obj;
			
		}
		else if(name == "FatalBomb")
		{
			FatalBomb obj = new FatalBomb();
			return obj;
			
		}
		
		else if(name == "DangerousBomb")
		{
			DangerousBomb obj = new DangerousBomb();
			return obj;
			
		}
		
		return null;
	}

}
