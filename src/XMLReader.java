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
            }
        }
        return nList;
    }

    /**
     * Takes in a nodelist and returns an arraylist of Double[] containing the coordinates of a point
     * and a flag set to 0.0
     * @param: nodeList
     * @return: Arraylist of Double[]
     */
    public ArrayList<Double[]> getArrayList(NodeList nodeList)
    {
        ArrayList<Double[]> llArrayList = new ArrayList<>();

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
                g[2] = 0.0;  // this is a flag, set to zero when it is used in a distance calculation it is set to 1.0
                             // to avoid using this point twice
                llArrayList.add(g);

            }
        }
        return llArrayList;
    }
}


