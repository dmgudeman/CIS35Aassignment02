
import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The input functions of the program. The readXML method takes a text xml
 * file and returns a document of nodes.
 * <p>
 * The GetNodes method makes the nodes available
 * Created by davidgudeman on 7/9/15.
 */

/**
 * Takes a string name of a xml text file can return a Nodelist
 */

public class XMLReader
{

    public Document doc;
    public String sfile;

    public XMLReader(String sfile) throws ParserConfigurationException, IOException, SAXException
    {
        this.sfile = sfile;
    }

    public XMLReader()
    {
    }

    // takes in xml file parses it into nodes
    public Document readXML() throws ParserConfigurationException, IOException, SAXException
    {
        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(sfile);

            doc.getDocumentElement().normalize();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return doc;
    }


    // allow for retreval of the nodes
    public NodeList getNodes(Document doc)
    {
        NodeList nList = doc.getElementsByTagName("Location");
        for (int i = 0; i < nList.getLength(); i++)
        {
            Node child = nList.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) child;
                System.out.println();
            }
        }
        return nList;
    }


    // allow for retreval of the nodes
    public ArrayList<Double[]> getArrayList(NodeList nodeList)
    {
        ArrayList<Double[]> llArrayList = new ArrayList<>();
        ArrayList<Double[]> testArrayList = new ArrayList<>();


        for (int i = 0; i < nodeList.getLength(); i++)
        {

            Node child = nodeList.item(i);
            Double[] g = {0.0, 0.0, 0.0, 0.0};
            if (child.getNodeType() == Node.ELEMENT_NODE)
            {

                Element eElement = (Element) child;

                double dLong = Double.parseDouble(eElement.getElementsByTagName("Longitude").item(0).getTextContent());
                double dLat = Double.parseDouble(eElement.getElementsByTagName("Latitude").item(0).getTextContent());

                g[0] = dLat;
                g[1] = dLong;
                g[2] = 0.0;
                g[3] = 0.0;
                llArrayList.add(g);

            }
        }
        return llArrayList;
    }
}

/*
    public void showNodeList(NodeList nodeList)
    {
        try
        {
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node child = nodeList.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) child;

                    System.out.println("Latitude : " + eElement.getElementsByTagName("Latitude").item(0).getTextContent());
                    System.out.println("Longitude : " + eElement.getElementsByTagName("Longitude").item(0).getTextContent());
                    System.out.println("City : " + eElement.getElementsByTagName("City").item(0).getTextContent());
                    System.out.println("State : " + eElement.getElementsByTagName("State").item(0).getTextContent());
                }
            }

            System.out.println("----------------------------");


        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void showArrayList(ArrayList<Node> list)
    {
        try
        {
            for (int i = 0; i < list.size(); i++)
            {
                Node child = list.get(i);
                if (child.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) child;
                    System.out.println("SHOW ARRAYLIST");
                    System.out.println("Latitude : " + eElement.getElementsByTagName("Latitude").item(0).getTextContent());
                    System.out.println("Longitude : " + eElement.getElementsByTagName("Longitude").item(0).getTextContent());
                    System.out.println("City : " + eElement.getElementsByTagName("City").item(0).getTextContent());
                    System.out.println("State : " + eElement.getElementsByTagName("State").item(0).getTextContent());
                    System.out.println("\n");
                }
            }

            System.out.println("----------------------------");


        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void showNode(NodeList nodeList, int index, String tagname)
    {
        try
        {
            Node child = nodeList.item(index);
            if (child.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) child;
                if (eElement.getElementsByTagName(tagname) != null)

                    System.out.println(tagname + " : " + eElement.getElementsByTagName(tagname).item(0).getTextContent());
            }

            System.out.println("------------*****************----------------");


        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void showArrayListDouble(ArrayList<Double[]> list)
    {
        System.out.println("ARRAYLIST.SIZE " + list.size());
        for (int h = 0; h < list.size(); h++)
        {
            System.out.println("SHOW ARRAYLIST DOUBLE");

            System.out.println("(" + list.get(h)[0].doubleValue() + ", " +
                    list.get(h)[1].doubleValue() + ")");
        }
    }


}
*/
