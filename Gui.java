/**
 * @Author Duffy Anderson, Lucius Holzinger, Myles Marr
 * @Date 04/09/2021
 * @Purpose: to Create series of JFrames, along with a way to check for similar hashtags,
             and ways to uplaod and view photos
 * @Update: 
 * @Bugs: -
 * 	    	-
 * 	    	-
 * */
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;



public class Gui implements ActionListener extends Main {
  //postFrame items
  String textAreaData;
  JTextArea caption;
  JFrame postFrame;
  
  //Welcome Frame Items
  JFrame welcomePage;
  JTextArea nameBox;
  JTextArea nameQuestion;
  JTextArea welcomeText;
  String name = "default";
  Font welcomeFont;
  Font ogFont;
  Color welcomeColor;

  //scrollPostsFrame items
  JFrame scrollPostsFrame;
  JPanel scrollPanel;
  JScrollPane scrollPane;

  //image Items
  protected ImageIcon image;
  protected JLabel label1;
  protected JButton button1;
  protected FileLoader canvas3;

  public Gui(String name){
    postFrame  = new JFrame("Post Frame");
    caption = new JTextArea(400, 200);
    label1 = new JLabel("Choose image");
    button1 = new JButton("select");
    postFrame.setSize(400, 800);
    postFrame.setLayout(new FlowLayout());
    postFrame.add(button1);
    postFrame.add(BorderLayout.SOUTH, caption);
    postFrame.getCloseOperation(JFrame.EXIT_ON_CLOSE);
    button1.addActionListener(this);
    canvas3 = new FileLoader(null);
    canvas3.setSize(700, 700);
    postFrame.add(BorderLayout.NORTH, canvas3);
    //postFrame.getContentPane...

    welcomePage = new JFrame("Welcome Frame");
    nameBox = new JTextArea(); 
    nameQuestion = new JTextArea();
    welcomeText = new JTextArea();
    ogFont = editingArea.getFont();
    welcomeColor = new Color(80,00,80);
    welcomeFont = new Font(f.getColor(welcomeColor), f.getSize()+5);
    
    //changes visibilty to allow different pages without action listener.
    caption.setVisible(false);
    postFrame.setVisible(false);
    welcomePage.setVisible(true);
    nameBox.setVisible(true);
    nameQuestion.setVisible(true);
    welcomeText.setVisible(true);  

    //scrollPane
    scrollPostsFrame = new JFrame();
    scrollPane = new JPanel();
    scrollPanel = new JScrollPane();

  }
  
  /**
  * Should check for people interacting with the project
  * might use a button but I would prefer something 
  * similar to hyper links
  */
  public void ActionPreformed(ActionEvent e){
    Button b = (Button) event.getSource;
    if(b == button1){
      FileDialog fd = new FileDialog(postFrame, "Open", FileDialog.load);
      fd.setVisible(true);
      imageLoad();
    }
  }

  public void imageLoad(){
    String f = (fd.getDirectory() + fd.getFile());
    Toolkit tk = Toolkit.getDefaultToolkit();
    image = tk.getImage(f);
    canvas3.setImage(image);
    canvas3.paint();
  }

  public JFrame algorithm(){
    List<String> myAlgList = new ArrayList<>();
    textAreaData = caption.getText();
    String tempString = textAreaData;

    while(tempString.indexOf('#') >= 0){
      String parsedText;
      tempString.subString(tempString.indexOf('#'));
      parsedText =  tempString.subString(0, tempString.indexOf('#'));
      myAlgList.add(parsedText);
    }//end of while loop to seperate hashtags 

    /**
     *This is where we will put the cross refrencing of the hashtags.
     */
    
  }//end of algorithm function
  
  public void start(){
    welcomePage.setSize(400, 800);
    welcomePage.setCloseOperation(JFrame.EXIT_ON_CLOSE);
    welcomePage.add(BorderLayout.CENTER, nameQuestion);
    welcomePage.add(BorderLayout.SOUTH, nameBox);
    welcomePage.add(BorderLayout.NORTH, welcomeText);
    nameQuestion.setEditable(false);
    nameQuestion.append("Please enter a UserName.");
    welcomeText.setFont(welcomeFont);
    welcomeText.setEditability(false);
    welcomeText.append("Welcome");

    name = nameBox.getText();
    nameQuestion.setText("Thank You.");
    
    caption.setVisible(true);
    postFrame.setVisible(true);
    welcomePage.setVisible(false);
    nameBox.setVisible(false);
    nameQuestion.setVisible(false);
    welcomeText.setVisible(false);
    
  }//end of start function
}//end of Gui class