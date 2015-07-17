import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.lang.*;
import java.util.Scanner;

/**
 * Created by davidgudeman on 7/17/15.
 */
public class Main
{
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException
    {

        Search searcher = new Search();
        String city1, city2;

        Scanner in = new Scanner(System.in);

        System.out.println("");
        System.out.println("Enter first City in the format:   City/ST");
        city1 = in.nextLine();
        city1 = searcher.parseInput(city1);

        System.out.println("");
        System.out.println("Enter second City in the format:   City/ST");
        city2 = in.nextLine();
        city2 = searcher.parseInput(city2);


        String sfile = "/Users/davidgudeman/Documents/workspace/CIS35A_temp/Coordinates.xml";
        XMLReader xmlReader = new XMLReader(sfile);
        Document doc = xmlReader.ReadXML();
        NodeList nodeList = xmlReader.GetNodes(doc);

        Calculate calculate = new Calculate();
        calculate.getDistance(nodeList, city1, city2);

        in.close();




        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new NotHelloWorldFrame();
                frame.setTitle("Not Hello World");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);


            }
        });
    }
}
