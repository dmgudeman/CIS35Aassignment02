import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;

/**
 * CIS35A assignment02
 * Created by David Gudeman on 7/17/15.
 */
public class Main
{
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException
    {

        String sfile = "/Users/davidgudeman/Documents/workspace/CIS35A_assignment02/src/Coordinates-1.xml";
        XMLReader xmlReader = new XMLReader(sfile);
        Document doc = xmlReader.readXML();
        NodeList nodeList = xmlReader.getNodes(doc);
        ArrayList<Double[]> aList = xmlReader.getArrayList(nodeList);

        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new MapFrame(aList);
                frame.setTitle("Map");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);


            }
        });
    }
}
