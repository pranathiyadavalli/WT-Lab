package experiment3;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class UserParsing {
	public static void main(String[] args)throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.parse(new File("users.xml"));

		Element root = document.getDocumentElement();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter User Id : ");
		String id=br.readLine();
		
		NodeList nList = document.getElementsByTagName("user");
		
		System.out.println("============================");
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
		Node node = nList.item(temp);
		System.out.println(""); 
		if (node.getNodeType() == Node.ELEMENT_NODE)
		{
		 Element eElement = (Element) node;
		 if(eElement.getAttribute("id").equals(id))
		 {
		 System.out.println("User id : " + eElement.getAttribute("id"));
		 System.out.println("First Name : " +
		eElement.getElementsByTagName("firstName").item(0).getTextContent());
		 System.out.println("Last Name : " +
		eElement.getElementsByTagName("lastName").item(0).getTextContent());
		 System.out.println("Location : " +
		eElement.getElementsByTagName("location").item(0).getTextContent());
		 }
		}
		}
	}
}
