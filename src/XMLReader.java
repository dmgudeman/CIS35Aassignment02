
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
 *
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

    // takes in xml file parses it into nodes
    public Document ReadXML() throws ParserConfigurationException, IOException, SAXException
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


 /*   // allow for retreval of the nodes
    public NodeList GetNodes(Document doc)
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

    */
    // allow for retreval of the nodes
    public ArrayList<Double[]> getArrayList(Document doc)
    {
        ArrayList<Double[]> llArrayList = new ArrayList<>();
        ArrayList<Double[]> testArrayList = new ArrayList<>();
        Double[] ar1 = {10.0, 70.0};
        Double[] ar2 = {10.0, 10.0};
        Double[] ar3 = {70.0, 70.0};
        Double[] ar4 = {30.0, 30.0};

        testArrayList.add(ar1);
        testArrayList.add(ar2);
        testArrayList.add(ar3);
        testArrayList.add(ar4);

        NodeList nList = doc.getElementsByTagName("Location");
        for (int i = 0; i < nList.getLength(); i++)
        {
            Node child = nList.item(i);
            Double[] g ={0.0,0.0};
            if (child.getNodeType() == Node.ELEMENT_NODE)
            {

                Element eElement = (Element) child;

             //   for(int k = 0; k<nList.getLength(); i++)
               // {
                   //   System.out.println("Latitude : " + eElement.getElementsByTagName("Latitude").item(0).getTextContent());
                    //System.out.println("Longitude : " + eElement.getElementsByTagName("Longitude").item(0).getTextContent());
               // System.out.println("\n");

                    double augmentedLong = Double.parseDouble(eElement.getElementsByTagName("Longitude").item(0).getTextContent()) + 180;
                    augmentedLong = (double) ((augmentedLong-73)*100);
                    double augmentedLat = Double.parseDouble(eElement.getElementsByTagName("Latitude").item(0).getTextContent());
                    augmentedLat = (double) (100*(augmentedLat)-30);
                    g[1]= augmentedLong;
                    g[0] = augmentedLat;
                    llArrayList.add(g);



                //}

            }
        }
        return testArrayList;
    }


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
        for (int h = 0; h < list.size(); h++)
        {

            System.out.println(list.get(h)[0].doubleValue());
            System.out.println(list.get(h)[1].doubleValue());
        }
    }


}

