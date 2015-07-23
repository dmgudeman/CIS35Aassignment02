import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.*;

/**
 * Class that uses the haversine method to calculate distances.
 * one method calculates distances. Another method returns the
 * smallest distance of coordinates fed to it as an arraylist of
 * double arrays.
 *
 * Created by davidgudeman on 7/13/15.
 */

public class Calculate
{
    Double RADIUS = 3959.0;

    public Calculate()
    {
    }

    /**
     * uses the Haversine method to calculate the distance between two points given their
     * coordinates
     * <p>
     * It takes in the coordinates as doubles and returns a distance as an int
     *
     * @param: double dlatitude1
     * @param: double  dlongitude1
     * @param: double dlatitude2
     * @param: double dlongitude2
     * @return: int distance
     */
    private int haversine(double dlatitude1, double dlongitude1, double dlatitude2, double dlongitude2)
    {
        double dLat = Math.toRadians(dlatitude2 - dlatitude1);
        double dLong = Math.toRadians(dlongitude1 - dlongitude2);
        dlatitude1 = Math.toRadians(dlatitude1);
        dlatitude2 = Math.toRadians(dlatitude2);

        double nA = pow(sin(dLat / 2.0), 2.0) + cos(dlatitude1) * cos(dlatitude2) * pow(sin(dLong / 2.0), 2.0);
        double nC = 2.0 * atan2(sqrt(nA), sqrt(1.0 - nA));
        double distance = RADIUS * nC;
        int distance1 = (int) Math.round(distance);
        return distance1;
    }


    public int getDistanceDouble(double latitude1, double latitude2, double longitude1, double longitude2)
    {
        int answer;
        answer = haversine(latitude1, longitude1, latitude2, longitude2);
        return answer;
    }

    /**
     * Method takes in an arraylist of Double[]. The Double[] holds the x and y coordinates of a point
     * and a flag that is originally set to 0. When it has been part of an identified minimum distance, the
     * flag is set to 1.0 so that point is not used again.
     *
     * @param: arraylist of Double[]
     * @param: int index this is the reference point to determine the minimum distance from
     * @return: int index of the nearest point
     */
    public int getMinimumDistanceDouble(ArrayList<Double[]> list, int index)
    {

        Calculate calc = new Calculate();
        double xBase, yBase, x2, y2;
        int idIndex = 0;
        double distance = 0;
        xBase = list.get(index)[0];
        yBase = list.get(index)[1];
        double minDistance = 10000000.0;

        for (int i = 0; i < list.size() - 1; i++) // iterate through the arraylist
        {
            x2 = list.get(i)[0];
            y2 = list.get(i)[1];
            if (list.get(i)[3] == 0.0) // ignore if flag is not zero
            {
                distance = calc.getDistanceDouble(xBase, x2, yBase, y2);
                if ((minDistance > distance && distance > 0)) // capture smallest disance
                {
                    minDistance = distance;
                    idIndex = i;
                }
            }
        }
        return idIndex; // return the index of the nearest point to the original value
    }
}
