package fruitGame;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Score {
	private static Score score;
	int s1;
	int s2;
	int s3;
	int s4;
	int num;
	private Score()
	{
		s1=s2=s3=s4=0;
	}

	public static Score getInstance()
	{
		if(score == null)
			score = new Score();
		
		return score;
	}
	
	public void setScore(int score)
	{
		if(num==1)
			if(score>s1)
				s1=score;

		if(num==2)
			if(score>s2)
				s2=score;

		if(num==3)
			if(score>s3)
				s3=score;

		if(num==4)
			if(score>s4)
				s4=score;

	}
	
	public int getHighestScore()
	{
		if(num==1)
			return s1;

		if(num==2)
			return s2;
		
		if(num==3)
			return s3;
		
		if(num==4)
			return s4;
		
		return 0;
	}
	
	
	  public void saveFile() {
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
	        try {
	            dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.newDocument();
	            //add elements to Document
	            Element rootElement =
	                    doc.createElementNS("data", "level");
	            //append root element to document
	            doc.appendChild(rootElement);

	            //append first child element to root element
	            rootElement.appendChild(getLevel(doc, s1 , s2 , s3 ,s4));

	            //for output to file, console
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            //for pretty print
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            DOMSource source = new DOMSource(doc);

	            //write to console or file
	            StreamResult console = new StreamResult(System.out);
	            StreamResult file = new StreamResult(new File("level.xml"));

	            //write data
	            transformer.transform(source, console);
	            transformer.transform(source, file);
	            System.out.println("DONE");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }


	    private static Node getLevel(Document doc, int s1 , int s2 , int s3 , int s4) {
	        Element level = doc.createElement("level");

//	        //set id attribute
//	        level.setAttribute("number", number);


	        //create name element
	        level.appendChild(getlevelElements(doc, level, "s1", String.valueOf(s1)));


	        //create name element
	        level.appendChild(getlevelElements(doc, level, "s2", String.valueOf(s2)));
	        //create age element
	        level.appendChild(getlevelElements(doc, level, "s3", String.valueOf(s3)));
//	        //create role element
	        level.appendChild(getlevelElements(doc, level, "s4", String.valueOf(s4)));
	        
	        
	        return level;
	    }


	    //utility method to create text node
	    private static Node getlevelElements(Document doc, Element element, String name, String value) {
	        Element node = doc.createElement(name);
	        node.appendChild(doc.createTextNode(value));
	        return node;
	    }




	    public void loadFile() {
	        String filePath = "level.xml";
	        File xmlFile = new File(filePath);
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
	        try {
	            dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse(xmlFile);
	            doc.getDocumentElement().normalize();
	            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	            NodeList nodeList = doc.getElementsByTagName("level");
	            //now XML is loaded as Document in memory, lets convert it to Object List

	            getLevel(nodeList.item(0));
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }

	    }


	    private  void getLevel(Node node) {
	        //XMLReaderDOM domReader = new XMLReaderDOM();

	        if (node.getNodeType() == Node.ELEMENT_NODE) {
	            Element element = (Element) node;

	            s1=Integer.parseInt(getTagValue("s1", element));
	            System.out.println(s1);


	            s2=Integer.parseInt(getTagValue("s2", element));
	            System.out.println(s2);
	            

	            s3=Integer.parseInt(getTagValue("s3", element));
	            System.out.println(s3);

	            

	            s4=Integer.parseInt(getTagValue("s4", element));
	            System.out.println(s4);





	        }


	    }


	    private static String getTagValue(String tag, Element element) {
	        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
	        Node node = (Node) nodeList.item(0);
	        return node.getNodeValue();
	    }






	    public void load()
	    {
	        loadFile();

	    }
	    
	    public void save()
	    {
	        saveFile();

	    }
	
	
}
