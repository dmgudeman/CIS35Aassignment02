

import java.awt.*;
import javax.swing.*;

public class DragTest extends JFrame 
{
  JScrollPane jscroll;
  JTextArea jarea;	
  JList jllist;
  String[] items = {"Java", "C", "C++", "Lisp", "Perl", "Python"};

  public DragTest() 
  {
    super("Drag Test");

    jllist = new JList(items);
    jllist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jllist.setDragEnabled(true);
    jscroll = new JScrollPane(jllist);
    jarea = new JTextArea(200,350);
    jarea.setBackground(Color.yellow);
    
    setSize(400,500);  
    Container container = getContentPane();
    container.add(jscroll,BorderLayout.SOUTH);
    container.add(jarea,BorderLayout.NORTH); 
    Font font = new Font("Arial",Font.PLAIN,20);
    jarea.setFont(font);
    setVisible(true);
  }

  public static void main(String[] args) 
  {
    new DragTest();
  }
} 
