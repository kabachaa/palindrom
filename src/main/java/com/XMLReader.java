/**
 * 
 */
package com;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {

	public static Map<String, String> read(InputStream input, String word) {
		Map<String, String> resultMap = new HashMap<String, String>();

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(input);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("entry");
			if (nList.getLength() > 0) {
				
				Node nNode = nList.item(0);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					if (eElement != null) {
						System.out.println(" id : " + eElement.getAttribute("id"));
						System.out.println(" def : " + eElement.getElementsByTagName("def").item(0).getTextContent());
						resultMap.put(word, eElement.getElementsByTagName("def").item(0).getTextContent());
					}
				}
			} else {
				resultMap.put(word, "Not a valid word");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}

}