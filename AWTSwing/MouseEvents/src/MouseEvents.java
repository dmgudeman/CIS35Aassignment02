import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MouseEvents extends JPanel implements MouseListener 
{
    BlankArea blankArea;
    JTextArea textArea;
    static final String NEWLINE = System.getProperty("line.separator");
    
    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() 
    {
        //Create and set up the window.
        JFrame frame = new JFrame("MouseEvents");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        JComponent newContentPane = new MouseEvents();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public MouseEvents() 
    {
        super(new GridLayout(0,1));
        blankArea = new BlankArea(Color.YELLOW);
        add(blankArea);
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(200, 75));
        add(scrollPane);
        
        //Register for mouse events on blankArea and the panel.
        blankArea.addMouseListener(this);
        addMouseListener(this);
        setPreferredSize(new Dimension(450, 450));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }
    
    void eventOutput(String eventDescription, MouseEvent e) 
    {
        textArea.append(eventDescription + " detected on " + e.getComponent().getClass().getName()+ "." + NEWLINE);
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    
    public void mousePressed(MouseEvent e) 
    {
        eventOutput("Mouse pressed (# of clicks: "+ e.getClickCount() + ")", e);
    }
    
    public void mouseReleased(MouseEvent e) 
    {
        eventOutput("Mouse released (# of clicks: "+ e.getClickCount() + ")", e);
    }
    
    public void mouseEntered(MouseEvent e) 
    {
        eventOutput("Mouse entered", e);
    }
    
    public void mouseExited(MouseEvent e) 
    {
        eventOutput("Mouse exited", e);
    }
    
    public void mouseClicked(MouseEvent e) 
    {
        eventOutput("Mouse clicked (# of clicks: " + e.getClickCount() + ")", e);
    }
}