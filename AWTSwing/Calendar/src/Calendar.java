import java.applet.Applet;
import java.awt.*;
import java.util.*;  //Used for Date and Calendar
import java.text.*;  //Used for DateFormat and TimeFormat

public class Calendar extends Applet
{
    private static Date now;  //Date variable

    public void paint(Graphics g)
    {
        GregorianCalendar today;  //Calendar variable for day of the week
        String dateTimeString;  //String variable for date and time
        String dateString;  //String variable for date
        String timeString;  //String variable for time
        String dayOfWeekString;  //String variable for day of the week

        int positionX = 20;  //Variable to hold the x coordinate
        int positionY = 20;  //Variables to hold the y coordinate

        setBackground(Color.white);  //Set the background of the applet to white
        now = new Date();  //Set Date variable now to the current date and time
        dateTimeString = DateFormat.getDateTimeInstance().format(now);  //Command to format both the date and time
        dateString = DateFormat.getDateInstance().format(now);  //Command to format the date
        timeString = DateFormat.getTimeInstance().format(now);  //Command to format the time

        today = new GregorianCalendar();  //Create a new Gregorian Calendar
        today.setTime(now);  //Set the time to the present
        String weekDay[] = new DateFormatSymbols().getWeekdays();  //Capture the days of the week in an array
        dayOfWeekString = weekDay[today.get(today.DAY_OF_WEEK)];  //Get the current day of the week

        g.setColor(Color.black);  //Set the forground color to black
        g.drawString("Display the date and time:", positionX, positionY);
        positionY+=20;  //Increment position y by 20

        g.setColor(Color.blue);  //Set the forground color to blue
        g.drawString(dateTimeString, positionX, positionY);  //Draw the datetime string at position x and y
        positionY+=40;

        g.setColor(Color.black);
        g.drawString("Display the date separately:", positionX, positionY);
        positionY+=20;

        g.setColor(Color.blue);
        g.drawString(dateString, positionX, positionY);  //Draw the date string at position x and y
        positionY+=40;

        g.setColor(Color.black);
        g.drawString("Display the time separately:", positionX, positionY);
        positionY+=20;

        g.setColor(Color.blue);
        g.drawString(timeString, positionX, positionY);  //Draw the time string at position x and y
        positionY+=40;

        g.setColor(Color.black);
        g.drawString("Display the day of the week:", positionX, positionY);
        positionY+=20;

        g.setColor(Color.blue);
        g.drawString(dayOfWeekString, positionX, positionY);  //Draw the dayOfWeek string at position x and y
    }  //End of paint

}  //End of DateTime