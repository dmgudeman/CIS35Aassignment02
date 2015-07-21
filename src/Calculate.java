import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.*;

/**
 *
 * Class that performs has two methods to calculate the distance between
 * two point.  It takes a generic datatype. The haversine computation is
 * in its own method.
 *
 * Created by davidgudeman on 7/13/15.
 */

public class Calculate
{
    Double RADIUS = 3959.0;

    public Calculate() {}  // Constructor

    /**
     * uses the Haversine method to calculate the distance between two points given their
     * coordinates
     *
     * It takes in the coordinates as generics of the Gen class and returns the distance
     * as a string.
     * @param: double dlatitude1
     * @param: double  dlongitude1
     * @param: double dlatitude2
     * @param: double dlongitude2
     * @return: String distance
     */
    private int haversine(double dlatitude1, double  dlongitude1, double  dlatitude2, double  dlongitude2)
    {
        String answer;
        // unwrap the arguments to primitives

        // convert to radians
        double dLat = Math.toRadians(dlatitude2 - dlatitude1);
        double dLong = Math.toRadians(dlongitude1 - dlongitude2);
        dlatitude1 = Math.toRadians(dlatitude1);
        dlatitude2 = Math.toRadians(dlatitude2);

        // calculate distance and return a string
        double nA = pow(sin(dLat / 2.0), 2.0) + cos(dlatitude1) * cos(dlatitude2) * pow(sin(dLong / 2.0), 2.0);
        double nC = 2.0 * atan2(sqrt(nA), sqrt(1.0 - nA));
        double distance = RADIUS * nC;
        int distance1 = (int)Math.round(distance);
        return distance1;
    }



public  int getDistanceDouble(double latitude1, double latitude2, double longitude1, double longitude2)
    {

        String lat1, lat2, long1, long2;

        int answer;

        answer = haversine(latitude1, longitude1, latitude2, longitude2);
        //DecimalFormat df = new DecimalFormat("#");
        //String distance = (df.format(answer));


       // System.out.println("\n");
      //  System.out.println("The distance from latitude + "+ latitude1 + " and longidtude " + longitude1 + " to  lat2 " + latitude2 + " long2 " + longitude2 + " is " + answer + " miles.");
       // System.out.println("\n");
        //System.out.println("\n");

        return answer;

    }
    public int getMinimumDistanceDouble(ArrayList<Double[]> list, int index)
    {

        Calculate calc = new Calculate();
        double x1, x2, y1,y2;
        int idIndex = 0;

        double distance = 0;
        double xBase, yBase, xIdent, yIdent;
        xBase = list.get(index)[0];
        yBase = list.get(index)[1];
        double minDistance = 10000000.0;



        for (int i =0; i < list.size()-1; i++)
        {


            x2 = list.get(i)[0];
            y2 = list.get(i)[1];
            if (list.get(i)[3] == 0.0)
            {
                distance = calc.getDistanceDouble(xBase, x2, yBase, y2);
                if ((minDistance > distance && distance > 0))
                {
                    // System.out.print("i " + i + " min Distance " + minDistance);;
                    minDistance = distance;
                    idIndex = i;
                }
            }



        }
        System.out.println("index (Base Index) = " + index + " xBase = " + xBase + " yBase = " + yBase);
        System.out.println("idIndex(closest) = " + idIndex + " ix2 = " + list.get(idIndex)[0] + " iy2 = " + list.get(idIndex)[1]);
        System.out.println("THIS IS IN CLACULATE MINIMUM " + calc.getDistanceDouble(xBase, list.get(idIndex)[0], yBase, list.get(idIndex)[1]) + " idIndex = " + idIndex);
        System.out.println("\n");
      return idIndex;
    }

}
