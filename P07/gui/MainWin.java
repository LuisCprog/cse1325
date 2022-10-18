package gui;

import emporium.Emporium;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.w3c.dom.events.Event;

import product.IceCreamFlavor;
import product.Item;
import product.MixIn;
import product.MixInAmount;
import product.MixInFlavor;
import product.Scoop;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.Box;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



/*Author: Gergo F Rice
 *Vestion 1
 *sorce code: MainWin.java
 *https://github.com/prof-rice/cse1325-prof/blob/main/P06/gui/MainWin.java
 */


public class MainWin extends JFrame {
    public MainWin() {
        super("Mavs Ice Cream Emporium");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        filename = new File("untitled.txt");
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();
        
        JMenu     file         = new JMenu("File");
        JMenuItem quit         = new JMenuItem("Quit");
        JMenu     view         = new JMenu("View");
        JMenuItem viewICF      = new JMenuItem("Ice Cream Flavor");
        JMenuItem viewMIF      = new JMenuItem("Mix In Flavor");
        JMenuItem viewScoop    = new JMenuItem("Scoop");
        JMenu     create       = new JMenu("Create");
        JMenuItem createICF    = new JMenuItem("Ice Cream Flavor");
        JMenuItem createMIF    = new JMenuItem("Mix In Flavor");
                  createScoop  = new JMenuItem("Scoop");
        JMenu     help         = new JMenu("Help");
        JMenuItem about        = new JMenuItem("About");
        
        quit       .addActionListener(event -> onQuitClick());
        viewICF    .addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        viewMIF    .addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
        viewScoop  .addActionListener(event -> view(Screen.SCOOPS));
        createICF  .addActionListener(event -> onCreateIceCreamFlavorClick());
        createMIF  .addActionListener(event -> onCreateMixInFlavorClick());
        createScoop.addActionListener(event -> onCreateScoopClick());
        createScoop.setEnabled(false); // until an ice cream flavor is defined
        about      .addActionListener(event -> onAboutClick());

        file.add(quit);
        view.add(viewICF);
        view.add(viewMIF);
        view.add(viewScoop);
        create.add(createICF);
        create.add(createMIF);
        create.add(createScoop);
        help.add(about);
        
        menubar.add(file);
        menubar.add(view);
        menubar.add(create);
        menubar.add(help);
        
        setJMenuBar(menubar);
        
       // /////////////////////////// ////////////////////////////////////////////
        // M A I N   D I S P L A Y
        // Provide a text entry box to show data
        display = new JLabel();
        display.setFont(new Font("Courier New", Font.BOLD, 30));
        display.setVerticalAlignment(JLabel.TOP);
        add(display, BorderLayout.CENTER);

        // Make everything in the JFrame visible
        setVisible(true);
        //ToolBar ???????????????????????
        JToolBar toolbar = new JToolBar("IceCream Emporium Controls");

        // Add a New Game stock icon
        /// add butoons 

        
        JButton anewB  = new JButton(new ImageIcon("Disk.png"));
          anewB.setActionCommand("Save to write all data to the current filename");
          anewB.setToolTipText("Save to write all data to the current filename");
          anewB.addActionListener(event->onSaveClick());
          toolbar.add(anewB);
          
        
           anew2 = new JButton(new ImageIcon("Disk.png"));
          anew2.setActionCommand("Save As to change the current filename");
          anew2.setToolTipText("Save As to change the current filename");
          anew2.addActionListener(event->onSaveAsClick());
          toolbar.add(anew2);
          //<a href="https://www.flaticon.com/free-icons/save" title="save icons">Save icons created by Freepik - Flaticon</a>

          anew3 = new JButton(new ImageIcon("Disk.png"));
          anew3.setActionCommand("Open to select a filename");
          anew3.setToolTipText("Open to select a filename");
          anew3.addActionListener(event->{
            try {
                onOpenClick();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
          toolbar.add(anew3);
          
        
        
        // A "horizontal strut" is just a space of the specified pixel width
        toolbar.add(Box.createHorizontalStrut(25));
        
        // Create the 3 buttons using the icons provided
        button1  = new JButton(new ImageIcon("bowl.png"));
          button1.setActionCommand("Creat IceCreamFlavor");
          button1.setToolTipText("Creat IceCreamFlavor");
          button1.addActionListener(event -> onCreateIceCreamFlavorClick());
          toolbar.add(button1);
          //credit for button 1
          //<a href="https://www.flaticon.com/free-icons/ice-cream" title="ice cream icons">Ice cream icons created by Freepik - Flaticon</a>
          
          

        button2    = new JButton(new ImageIcon("sprinkling.png"));
          button2.setActionCommand("Creat MixInFlavor");
          button2.setToolTipText("Creat MixInFlavor");
          button2.addActionListener(event -> onCreateMixInFlavorClick());
          toolbar.add(button2);
          //credit ofr button 2
          //<a href="https://www.flaticon.com/free-icons/sugar" title="sugar icons">Sugar icons created by Freepik - Flaticon</a>

        button3 = new JButton(new ImageIcon("Scoop.png"));
          button3.setActionCommand("Creat scoop");
          button3.setToolTipText("Creat scoop");
          button3.addActionListener(event -> onCreateScoopClick());
          toolbar.add(button3);
          //credit for buttion 1
          //<a href="https://www.flaticon.com/free-icons/scoop" title="scoop icons">Scoop icons created by Freepik - Flaticon</a>
        
        toolbar.add(Box.createHorizontalStrut(20));

        button4 = new JButton(new ImageIcon("viewIce.png"));
        button4.setActionCommand("View all ice cream flavors");
        button4.setToolTipText("View all ice cream flavors");
        button4.addActionListener(event ->view(Screen.ICE_CREAM_FLAVORS));
        toolbar.add(button4);
        

        button5 = new JButton(new ImageIcon("viewMixIn.png"));
        button5.setActionCommand("View a new mix in flavors");
        button5.setToolTipText("View a new mix in flavors");
        button5.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
        toolbar.add(button5);
        

        button6 = new JButton(new ImageIcon("viewScoop.png"));
        button6.setActionCommand("View a new scoops");
        button6.setToolTipText("View a new scoops");
        button6.addActionListener(event -> view(Screen.SCOOPS));
        toolbar.add(button6);
        

        
        // Create a toggle button to enable or disable the computer player
        computerPlayer = new JToggleButton(new ImageIcon("freepik_robot.png"));
          computerPlayer.setActionCommand("Enable computer player");
          computerPlayer.setToolTipText("Enable for computer to be Player 2");
          computerPlayer.setBorder(null);
          toolbar.add(computerPlayer);
          //computerPlayer.addActionListener(event -> onComputerPlayerClick());

        // "Horizontal glue" expands as much as possible, pushing the "X" to the right
        toolbar.add(Box.createHorizontalGlue());
        
        // Create a custom Quit button (not available in Swing stock icons)
        JButton quitB  = new JButton("X");
          quitB.setActionCommand("Quit");
          quitB.setToolTipText("Exit game");
          quitB.setBorder(null);
          toolbar.add(quitB);
          quitB.addActionListener(event -> onQuitClick());
        toolbar.addSeparator();

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        //////////////////////////////////////////////////////?
        
        // Start a new emporium
        emporium = new Emporium();
    }
    protected void onOpenClick() throws FileNotFoundException, IOException{
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileNameExtensionFilter TexFile = new FileNameExtensionFilter("Txt files", "txt");
        fc.addChoosableFileFilter(TexFile);         // Add "Nim file" filter
        fc.setFileFilter(TexFile);                  // Show Nim files only by default
        
        int result = fc.showOpenDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();        // Obtain the selected File object
            
            try(BufferedReader br = new BufferedReader(new FileReader(filename))){
                Emporium nEmp= new Emporium(br);
                emporium=nEmp;
            }    
             catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Unable to open " + filename + '\n' + e, 
                    "Failed", JOptionPane.ERROR_MESSAGE); 
                // TODO: handle exception
            }
            
        
        }
    }
    protected void onSaveClick() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            System.out.println("in the save");
            emporium.save(bw);//nim.save(bw);//make save method
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e,
                "Failed", JOptionPane.ERROR_MESSAGE); 
        }
    }

    protected void onSaveAsClick(){
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileNameExtensionFilter TexFile = new FileNameExtensionFilter("Txt files", "txt");
        fc.addChoosableFileFilter(TexFile);         // Add "Nim file" filter
        fc.setFileFilter(TexFile);                  // Show Nim files only by default
        
        int result = fc.showSaveDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();         // Obtain the selected File object
            if(!filename.getAbsolutePath().endsWith(".txt"))  // Ensure it ends with ".nim"
                filename = new File(filename.getAbsolutePath() + ".txt");
            onSaveClick();                       // Delegate to Save method
        }
    }

    // Listeners
    protected void onQuitClick() {System.exit(0);}   // Exit the game
    

    protected void onCreateIceCreamFlavorClick() {
        try {
            emporium.addIceCreamFlavor(new IceCreamFlavor(
                JOptionPane.showInputDialog(this, "Name?", 
                    "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE),
                JOptionPane.showInputDialog(this, "Description?", 
                    "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Price?", 
                    "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE)),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Cost?", 
                    "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE))
            ));
        } catch(Exception e) {
        }
        createScoop.setEnabled(true);  // Now we have a flavor, we can create a scoop!
        view(Screen.ICE_CREAM_FLAVORS);         
    }
    protected void onCreateMixInFlavorClick() {
        try {
            emporium.addMixInFlavor(new MixInFlavor(
                JOptionPane.showInputDialog(this, "Name?", 
                    "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE),
                JOptionPane.showInputDialog(this, "Description?", 
                    "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Price?", 
                    "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE)),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Cost?", 
                    "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE))
            ));   
        } catch(Exception e) {
        }
        view(Screen.MIX_IN_FLAVORS);         
    }
    protected void onCreateScoopClick() {
        IceCreamFlavor icf = (IceCreamFlavor) JOptionPane.showInputDialog(this, 
            "Ice Cream Flavor?", "New Scoop", JOptionPane.QUESTION_MESSAGE, null, 
            emporium.iceCreamFlavors(), null);
        if(icf != null) {
            Scoop scoop = new Scoop(icf);
            if(emporium.mixInFlavors().length > 0) {
                String prompt = "<html>" + scoop + "<br/>Add a mix in?</html>";
                while(true) {
                    MixInFlavor mif = (MixInFlavor) JOptionPane.showInputDialog(this, prompt, 
                        "Add Mix In", JOptionPane.QUESTION_MESSAGE, null, 
                        emporium.mixInFlavors(), null);
                    if(mif == null) break;
                    MixInAmount mia = (MixInAmount) JOptionPane.showInputDialog(this, prompt, 
                        "Add Mix In", JOptionPane.QUESTION_MESSAGE, null, 
                        MixInAmount.values(), MixInAmount.Normal);
                    scoop.addMixIn(new MixIn(mif, mia));
                    prompt = "<html>" + scoop + "<br/>Add another mix in?</html>";
                }
            }
            emporium.addScoop(scoop);
            view(Screen.SCOOPS);         
        }
    }
    
    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog(this, "Mavs Ice Cream Emporium");
        about.setLayout(new BoxLayout(about.getContentPane(), BoxLayout.PAGE_AXIS));
              
        try {
            BufferedImage myPicture = ImageIO.read(new File("gui/logo.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }

    ///////////////////////Save filess////////////////////////
    /* 
    protected void onOpenGameClick() {         // Create a new game
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileFilter nimFiles = new FileNameExtensionFilter("Nim files", "nim");
        fc.addChoosableFileFilter(nimFiles);         // Add "Nim file" filter
        fc.setFileFilter(nimFiles);                  // Show Nim files only by default
        
        int result = fc.showOpenDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();        // Obtain the selected File object
            
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String magicCookie = br.readLine();
                if(!magicCookie.equals(MAGIC_COOKIE)) throw new RuntimeException("Not a Nim file");
                String fileVersion = br.readLine();
                if(!fileVersion.equals(FILE_VERSION)) throw new RuntimeException("Incompatible Nim file format");
                
                nim = new Nim(br);                   // Open a new game
                if(computerPlayer.isSelected()) 
                    computerPlayer.doClick();        // Turn off AI (can be turned on if desired)
                         // doClick() generates a click event, while setSelected(false) does not
                setSticks();                         // Update the user interface
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Unable to open " + filename + '\n' + e, 
                    "Failed", JOptionPane.ERROR_MESSAGE); 
             }
        }
    }
    */
  
/* 
    protected void onSaveAsClick() {         // Create a new game
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileFilter nimFiles = new FileNameExtensionFilter("Nim files", "nim");
        fc.addChoosableFileFilter(nimFiles);         // Add "Nim file" filter
        fc.setFileFilter(nimFiles);                  // Show Nim files only by default
        
        int result = fc.showSaveDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();         // Obtain the selected File object
            if(!filename.getAbsolutePath().endsWith(".nim"))  // Ensure it ends with ".nim"
                filename = new File(filename.getAbsolutePath() + ".nim");
            onSaveClick();                       // Delegate to Save method
        }
    }
    */
    ///////////////////////////////////end of save files//////////////////////
        
        JLabel title = new JLabel("<html>"
          + "<br/><p><font size=+4>MICE</font></p>"
          + "</html>", JLabel.CENTER);
        about.add(title);

        JLabel subTitle = new JLabel("<html>"
          + "<br/><p><font size=+1>Mavs Ice Cream Emporium</font></p>"
          + "</html>", JLabel.CENTER);
        about.add(subTitle);

        JLabel artists = new JLabel("<html>"
          + "<br/><p>Version 0.2</p>"
          + "<p>Copyright 2022 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "Logo by Schmidsi, per the Pixabay License"
          + "<p><font size=-2>https://pixabay.com/en/ice-ice-cream-cone-ice-ball-pink-1429596/</font></p>"
          + "<br/></html>", JLabel.CENTER);
        about.add(artists);

        JPanel panel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        panel.add(ok);
        about.add(panel);
        
        about.add(Box.createVerticalStrut(10));
        
        about.pack();
        about.setVisible(true);
     }
     
     private enum Screen {ICE_CREAM_FLAVORS, MIX_IN_FLAVORS, SCOOPS}
     private void view(Screen screen) {
         String title = "";
         StringBuilder s = new StringBuilder();
         switch(screen) {
             case ICE_CREAM_FLAVORS: 
                 title = "Ice Cream Flavors";
                 for(var t : emporium.iceCreamFlavors()) s.append(t.toString() + "<br/>");
                 break;
             case MIX_IN_FLAVORS: 
                 title = "Mix In Flavors";
                 for(var t : emporium.mixInFlavors()) s.append(t.toString() + "<br/>");
                 break;
             case SCOOPS: 
                 title = "Scoops";
                 for(var t : emporium.scoops()) s.append(t.toString() + "<br/>");
                 break;
             default:
                 display.setText("PANIC: Invalid Displays type: " + display);
         }
         display.setText("<html><font size=+4>" + title + 
                         "<br/></font><font size=+2>" + s.toString() + 
                         "</font></html>");
     }
     
    private Emporium emporium;

    private JMenuItem createScoop;  // defined here so we can disable and enable it
    private JLabel display;                 // Main data display
    private JButton anew2;
    private JButton anew3;
    private JButton button1;                // Button to select 1 stick
    private JButton button2;                // Button to select 2 sticks
    private JButton button3;                // Button to select 3 sticks
    private JButton button4;                // Button to select 3 sticks
    private JButton button5;                // Button to select 3 sticks
    private JButton button6;                // Button to select 3 sticks
    private JToggleButton computerPlayer;   // Button to enable robot
    private File filename;                  // contains file name
}
