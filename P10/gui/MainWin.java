package gui;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.awt.Font;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import emporium.Emporium;
import product.IceCreamFlavor;
import product.MixIn;
import product.MixInFlavor;
import product.MixInAmount;
import product.Scoop;
import product.Container;
import product.Order;
import product.Serving;

import javax.imageio.ImageIO;

public class MainWin extends JFrame {

    private final String NAME = "MICE";
    private final String EXTENSION = "mice";
    private final String VERSION = "0.3";
    private final String FILE_VERSION = "1.0";
    private final String MAGIC_COOKIE = "Mïċe";

    public MainWin() {
        super("Mavs Ice Cream Emporium");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 800);
        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();
        
        JMenu     file         = new JMenu("File");
        JMenuItem open         = new JMenuItem("Open");
        JMenuItem save         = new JMenuItem("Save");
        JMenuItem saveAs       = new JMenuItem("Save As");
        JMenuItem quit         = new JMenuItem("Quit");
        
        JMenu     view         = new JMenu("View");
        JMenuItem viewICF      = new JMenuItem("Ice Cream Flavor");
        JMenuItem viewMIF      = new JMenuItem("Mix In Flavor");
        JMenuItem viewContainer    = new JMenuItem("Container");
        JMenuItem viewOrders  = new JMenuItem("Orders");
        
        JMenu     create       = new JMenu("Create");
        JMenuItem createContainer  = new JMenuItem("Container");
        JMenuItem createICF    = new JMenuItem("Ice Cream Flavor");
        JMenuItem createMIF    = new JMenuItem("Mix In Flavor");
        JMenuItem createOrder  = new JMenuItem("Order");
        
        JMenu     help         = new JMenu("Help");
        JMenuItem about        = new JMenuItem("About");
        
        open       .addActionListener(event -> onOpenClick());
        save       .addActionListener(event -> onSaveClick());
        saveAs     .addActionListener(event -> onSaveAsClick());
        quit       .addActionListener(event -> onQuitClick());

        viewICF    .addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
        viewMIF    .addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
        viewContainer  .addActionListener(event -> view(Screen.CONTAINERS));
        viewOrders .addActionListener(event -> view(Screen.ORDERS));

        createContainer.addActionListener(event -> onCreateContainerClick());
        createICF  .addActionListener(event -> onCreateIceCreamFlavorClick());
        createMIF  .addActionListener(event -> onCreateMixInFlavorClick());
        createOrder.addActionListener(event->onCreateOrderClick());
        about      .addActionListener(event -> onAboutClick());

        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.add(quit);
        view.add(viewICF);
        view.add(viewMIF);
        view.add(viewOrders);
        view.add( viewContainer);
        create.add(createICF);
        create.add(createMIF);
        create.add(createContainer);
        create.add(createOrder);
        help.add(about);
        
        menubar.add(file);
        menubar.add(view);
        menubar.add(create);
        menubar.add(help);
        
        setJMenuBar(menubar);
        
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("Mice Controls");

       // Add a New Emporium icon
        saveButton  = new JButton(new ImageIcon("gui/Disk.png"));
          saveButton.setActionCommand("Save data to default file");
          saveButton.setToolTipText("Save data to default file");
          saveButton.setEnabled(false);
          saveButton.addActionListener(event -> onSaveClick());
          toolbar.add(saveButton);
        
        saveAsButton  = new JButton(new ImageIcon("gui/Disk.png"));
          saveAsButton.setActionCommand("Save data to selected file");
          saveAsButton.setToolTipText("Save data to selected file");
          saveAsButton.addActionListener(event -> onSaveAsClick());
          toolbar.add(saveAsButton);
        
        JButton openButton  = new JButton(new ImageIcon("gui/Disk.png"));
          openButton.setActionCommand("Load data from selected file");
          openButton.setToolTipText("Load data from selected file");
          openButton.addActionListener(event -> onOpenClick());
          toolbar.add(openButton);
        
        // A "horizontal strut" is just a space of the specified pixel width
        toolbar.add(Box.createHorizontalStrut(25));


        // Create the product buttons using the icons provided
        JButton createContB = new JButton(new ImageIcon("gui/bowl.png"));
        createContB.setActionCommand("Create container");
        createContB.setToolTipText("Create container");
        createContB.addActionListener(event -> onCreateContainerClick());
        toolbar.add(createContB);

        JButton createIceCreamFlavorButton  = new JButton(new ImageIcon("gui/flav.png"));
          createIceCreamFlavorButton.setActionCommand("New ice cream flavor");
          createIceCreamFlavorButton.setToolTipText("Create new ice cream flavor");
          toolbar.add(createIceCreamFlavorButton);
          createIceCreamFlavorButton.addActionListener(event -> onCreateIceCreamFlavorClick());

        JButton createMixInFlavorButton  = new JButton(new ImageIcon("gui/mixin.png"));
          createMixInFlavorButton.setActionCommand("New mix in flavor");
          createMixInFlavorButton.setToolTipText("New mix in flavor");
          toolbar.add(createMixInFlavorButton);
          createMixInFlavorButton.addActionListener(event -> onCreateMixInFlavorClick());

        JButton createOB = new JButton(new ImageIcon("gui/bowl.png"));
          createOB.setActionCommand("Create order");
          createOB.setToolTipText("Create order");
          createOB.addActionListener(event -> onCreateOrderClick());
          toolbar.add(createOB);

        toolbar.add(Box.createHorizontalStrut(25));

        //Corn view 
        
        JButton viewIceCreamFlavorsButton  = new JButton(new ImageIcon("gui/flav.png"));
          viewIceCreamFlavorsButton.setActionCommand("View ice cream flavors");
          viewIceCreamFlavorsButton.setToolTipText("View ice cream flavors");
          toolbar.add(viewIceCreamFlavorsButton);
          viewIceCreamFlavorsButton.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));

        JButton viewMixInFlavorsButton  = new JButton(new ImageIcon("gui/mixin.png"));
          viewMixInFlavorsButton.setActionCommand("View mix in flavors");
          viewMixInFlavorsButton.setToolTipText("View mix in flavors");
          toolbar.add(viewMixInFlavorsButton);
          viewMixInFlavorsButton.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));

        JButton viewOrdersButton  = new JButton(new ImageIcon("gui/bowl.png"));
        viewOrdersButton.setActionCommand("View Order");
        viewOrdersButton.setToolTipText("View Order");
          toolbar.add(viewOrdersButton);
          viewOrdersButton.addActionListener(event -> view(Screen.ORDERS));

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        
        // /////////////////////////// ////////////////////////////////////////////
        // M A I N   D I S P L A Y
        // Provide a text entry box to show data
        display = new JLabel();
        display.setVerticalAlignment(JLabel.TOP);
        display.setFont(new Font("Courier New", Font.BOLD, 18));
        add(display, BorderLayout.CENTER);

        // S T A T U S   B A R   D I S P L A Y ////////////////////////////////////
        // Provide a status bar for game messages
        // msg = new JLabel();
        // add(msg, BorderLayout.PAGE_END);
        
        // Make everything in the JFrame visible
        setVisible(true);
        
        // Start a new emporium
        emporium = new Emporium();
        filename = new File("untitled." + EXTENSION);
        setDirty(false);     // disables Save when no new data exists
        setScoopAvailable(); // disables new Scoop when no ice cream flavors exist
        view(Screen.ICE_CREAM_FLAVORS);   
    }
    
    // Listeners
    protected void onQuitClick() {System.exit(0);}   // Exit the game
    

    protected void onCreateIceCreamFlavorClick() {
        try {
            emporium.addIceCreamFlavor(new IceCreamFlavor(
                JOptionPane.showInputDialog(this, "Name?", "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE),
                JOptionPane.showInputDialog(this, "Description?", "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Price?", "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE)),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Cost?", "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE))
            ));
            
        } catch(Exception e) {
        }
        try {
            setScoopAvailable();
            setDirty(true);
            view(Screen.ICE_CREAM_FLAVORS);         
        } catch(Exception e) {
            System.err.println("onCreateIceCreamFlavorClick exception: " + e);
        }
    }
    protected void onCreateMixInFlavorClick() {
        try {
            emporium.addMixInFlavor(new MixInFlavor(
                JOptionPane.showInputDialog(this, "Name?", "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE),
                JOptionPane.showInputDialog(this, "Description?", "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Price?", "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE)),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Cost?", "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE))
            ));   
            setDirty(true);
            view(Screen.MIX_IN_FLAVORS);         
        } catch(Exception e) {
            System.err.println("onCreateMixInFlavorClick exception: " + e);
        }
    }
    //new add onns
    public void onCreateContainerClick(){
        //icecream chang
        try {
            emporium.addContiner(new Container(
                JOptionPane.showInputDialog(this, "Name?", "Create Container", JOptionPane.QUESTION_MESSAGE),
                JOptionPane.showInputDialog(this, "Description?", "Create Container", JOptionPane.QUESTION_MESSAGE),
                Integer.parseInt(JOptionPane.showInputDialog(this, "Max Scoops?", "Create Container", JOptionPane.QUESTION_MESSAGE))
            ));
        } catch(Exception e) {
        }

    }
    public Scoop onCreateScoop(){
        IceCreamFlavor icf = (IceCreamFlavor)JOptionPane.showInputDialog(null, "Flavor?","New Scoop", JOptionPane.INFORMATION_MESSAGE, null, emporium.iceCreamFlavors(),null);
        Scoop nscoop = new Scoop(icf);

        MixInFlavor MIF = (MixInFlavor)JOptionPane.showInputDialog(null, "Mixin?", "New Scoop", JOptionPane.INFORMATION_MESSAGE, null, emporium.mixInFlavors(),null);
        Object amount[] = MixInAmount.values();
        MixInAmount MIA = (MixInAmount)JOptionPane.showInputDialog(null, "Amount?", 
            "New Scoop", JOptionPane.INFORMATION_MESSAGE, null, amount,
            null);
            nscoop.addMixIn(new MixIn(MIF, MIA));

        while(true){
            int nMixin = JOptionPane.showConfirmDialog(null, "Another mixin?",null, JOptionPane.YES_NO_OPTION);
            if(nMixin==0){
                MIF = (MixInFlavor)JOptionPane.showInputDialog(null, "Mixin?", "New Scoop", JOptionPane.INFORMATION_MESSAGE, null, emporium.mixInFlavors(),null);
                MIA = (MixInAmount)JOptionPane.showInputDialog(null, "Amount?", "New Scoop", JOptionPane.INFORMATION_MESSAGE, null, amount,null);
                nscoop.addMixIn(new MixIn(MIF, MIA));
            }
            else{
                break;
            }
        }
        return nscoop;
    }
   

    public Serving onCreateServing(){
        Container cont = (Container)JOptionPane.showInputDialog(null, "Container?", "New Container", JOptionPane.INFORMATION_MESSAGE, null, emporium.containers(),emporium.containers()[0]);
        Serving servings;
        try {
            servings= new Serving(cont);
        } 
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        int Check=JOptionPane.YES_OPTION;
        while(Check==JOptionPane.YES_OPTION){
            Scoop scoops = onCreateScoop();
            servings.addScoop(scoops);
            Check = JOptionPane.showConfirmDialog(null, "Another scoop?", null, JOptionPane.YES_NO_OPTION);
        }
        if(JOptionPane.showConfirmDialog(null, "More toppings?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            MixInFlavor MIF = (MixInFlavor)JOptionPane.showInputDialog(null, "Mixin?","New Scoop", JOptionPane.INFORMATION_MESSAGE, null, emporium.mixInFlavors(),null);
            Object amount[] = MixInAmount.values();
            MixInAmount MIA = (MixInAmount)JOptionPane.showInputDialog(null, "Amount?","New Scoop", JOptionPane.INFORMATION_MESSAGE, null, amount,null);
            servings.addTopping(new MixIn(MIF, MIA));
            while(true){
                int newMixin = JOptionPane.showConfirmDialog(null, "Another mixin?",null, JOptionPane.YES_NO_OPTION);
                if(newMixin==0){
                    MIF = (MixInFlavor)JOptionPane.showInputDialog(null, "Mixin?", "New Mix In Flavor", JOptionPane.INFORMATION_MESSAGE, null, emporium.mixInFlavors(),null);
                    MIA = (MixInAmount)JOptionPane.showInputDialog(null, "Amount?", "New Min In Amount", JOptionPane.INFORMATION_MESSAGE, null, amount,null);
                    servings.addTopping(new MixIn(MIF, MIA));
                }
                else{
                    break;
                }
            }
        }
        return servings;
    }

    public void onCreateOrderClick(){
        try{
            Order orders = new Order();
            int option = JOptionPane.showConfirmDialog(null, "Do you want to add a serving to the order?", null, JOptionPane.YES_NO_OPTION);
            while(option==JOptionPane.YES_OPTION)
            {
                orders.addServing(onCreateServing());
                option = JOptionPane.showConfirmDialog(null, "Do you want to add ANOTHER serving to the order?", null, JOptionPane.YES_NO_OPTION);
            }
            emporium.addOrder(orders);
            //view(Screen.ORDERS); 
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "No containers, therefore order cannot be made.");
        }
    }
    
    

    
   
    
    // File I/O Methods
    
   protected void onOpenClick() { 
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileFilter miceFiles = new FileNameExtensionFilter("MICE files", EXTENSION);
        fc.addChoosableFileFilter(miceFiles);         // Add "Mice file" filter
        fc.setFileFilter(miceFiles);                  // Show Mice files only by default
        
        int result = fc.showOpenDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();        // Obtain the selected File object
            
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String magicCookie = br.readLine();
                if(!magicCookie.equals(MAGIC_COOKIE)) throw new RuntimeException("Not a MICE file");
                String fileVersion = br.readLine();
                if(!fileVersion.equals(FILE_VERSION)) throw new RuntimeException("Incompatible MICE file format");
                
                emporium = new Emporium(br);                   // Open a new emporium
                //view(Screen.SCOOPS);                           // Update the user interface
                setScoopAvailable();
                setDirty(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Unable to load " + filename + '\n' + e, 
                    "Failed", JOptionPane.ERROR_MESSAGE); 
             }
        }
    }

    protected void onSaveClick() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(MAGIC_COOKIE + '\n');
            bw.write(FILE_VERSION + '\n');
            emporium.save(bw);
            setDirty(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to write " + filename + '\n' + e,
                "Failed", JOptionPane.ERROR_MESSAGE); 
        }
    }

    protected void onSaveAsClick() {
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileFilter miceFiles = new FileNameExtensionFilter("MICE files", EXTENSION);
        fc.addChoosableFileFilter(miceFiles);         // Add "MICE file" filter
        fc.setFileFilter(miceFiles);                  // Show MICE files only by default
        
        int result = fc.showSaveDialog(this);         // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) {  // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();          // Obtain the selected File object
            if(!filename.getAbsolutePath().endsWith("." + EXTENSION))  // Ensure it ends with ".mice"
                filename = new File(filename.getAbsolutePath() + "." + EXTENSION);
            onSaveClick();                           // Delegate to Save method
        }
    }

    
    // About and miscellaneous
    
    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog(this, "Mavs Ice Cream Emporium");
        about.setLayout(new BoxLayout(about.getContentPane(), BoxLayout.PAGE_AXIS));
/*              
        try {
            BufferedImage myPicture = ImageIO.read(new File("gui/logo.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }
*/
        Canvas logo = new Canvas("gui/logo.png", "gui/spiropic.txt");
        logo.setAlignmentX(Canvas.LEFT_ALIGNMENT);
        about.add(logo);
        
        JPanel text = new JPanel();
        text.setLayout(new BoxLayout(text, BoxLayout.PAGE_AXIS));
        JLabel title = new JLabel("<html>"
          + "<br/><p><font size=+4>MICE</font></p>"
          + "</html>", JLabel.CENTER);
        text.add(title);

        JLabel subTitle = new JLabel("<html>"
          + "<br/><p><font size=+1>Mavs Ice Cream Emporium</font></p>"
          + "</html>", JLabel.CENTER);
        text.add(subTitle);

        JLabel artists = new JLabel("<html>"
          + "<br/><p>Version 0.3</p>"
          + "<p>Copyright 2022 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "Logo by Schmidsi, per the Pixabay License"
          + "<p><font size=-2>https://pixabay.com/en/ice-ice-cream-cone-ice-ball-pink-1429596/</font></p>"
          + "<p>Ice cream icons created by Freepik - Flaticon</p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icons/</font></p>"
          + "<p>File icons created by Pixel perfect - Flaticon</p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icons/direct-download</font></p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icons/file-upload</font></p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icons/ui</font></p>"
          + "<p><font size=-2>https://www.flaticon.com/free-icons/</font></p>"
          + "<br/></html>", JLabel.CENTER);
        text.add(artists);
        about.add(text);
        
        JPanel panel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        panel.add(ok);
        about.add(panel);
        
        about.add(Box.createVerticalStrut(10));
        
        about.pack();
        about.setVisible(true);
     }
     
    private enum Screen {ICE_CREAM_FLAVORS, MIX_IN_FLAVORS,CONTAINERS,ORDERS}
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
            case CONTAINERS: 
                 title = "CONTAINERS";
                 for(var t : emporium.containers()) s.append(t.toString() + "<br/>");
                 break;
            case ORDERS: 
                 title = "ORDERS";
                 for(var t : emporium.orders()) s.append(t.toString() + "<br/>");
                 break;
             default:
                 display.setText("PANIC: Invalid Displays type: " + display);
        }
        display.setText("<html><font size=+4>" + title + "<br/></font><font size=+2>" + s.toString() + "</font></html>");
    }
     
    private void setDirty(boolean isDirty) {
        save.setEnabled(isDirty);
        saveAs.setEnabled(isDirty);
        saveButton.setEnabled(isDirty);
        saveAsButton.setEnabled(isDirty);
    };
     
    private void setScoopAvailable() {
        boolean scoopIsAvailable = (emporium.iceCreamFlavors().length > 0);
        createOrder.setEnabled(scoopIsAvailable); // until an ice cream flavor is defined
        createScoopButton.setEnabled(scoopIsAvailable);
    }
    
    private Emporium emporium;
    private File filename;

    private JLabel display;                 // Main data display

    private JMenuItem save;
    private JMenuItem saveAs;
    private JButton saveButton;
    private JButton saveAsButton;

    private JMenuItem createOrder;  // defined here so we can disable and enable it
    private JButton createScoopButton;

    // private JLabel msg;                     // Status message display
}
