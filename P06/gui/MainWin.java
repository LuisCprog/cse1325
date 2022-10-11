package gui;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.lang.module.ModuleDescriptor.Builder;
import java.util.Arrays;

import javax.swing.*;
import javax.imageio.ImageIO;

import emporium.*;
import product.*;

public class MainWin extends JFrame {// implements ActionListener {
    private Emporium Emp=new Emporium();
    public MainWin(String title) {
        
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        

        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar         = new JMenuBar(); 
        JMenu     file           = new JMenu("File");
        JMenuItem quit           = new JMenuItem("Quit");
        JMenu     view           = new JMenu("View");
        JMenuItem VIceCreamFlavor= new JMenuItem("Ice Cream Flavor");
        JMenuItem VMixInFlavor   = new JMenuItem("Mix In Flavor");
        JMenuItem VScoop         = new JMenuItem("Scoop");
        JMenu     Create         =new JMenu("Create");
        JMenuItem CICeCreamFlavor= new JMenuItem("Ice Cream Flavor");
        JMenuItem CMixInFlavor   = new JMenuItem("Mix In Flavor");
        JMenuItem CScoop         =new JMenuItem("Scoop");
        JMenu     help           = new JMenu("Help");
        JMenuItem about          = new JMenuItem("About");

        /*VIceCreamFlavor.addActionListener(null);
        VMixInFlavor.addActionListener(null);*/
        VScoop.addActionListener(event-> OnViewScoop());
        VMixInFlavor.addActionListener(event-> OnViewMixInFlavor());
        VIceCreamFlavor.addActionListener(event->OnViewIceCrenFlavor());
        CScoop.addActionListener(event-> OnCreateScoopClock());
        CICeCreamFlavor.addActionListener(event->onCreateIceCremFlavorClick());
        CMixInFlavor.addActionListener(event-> onCreatMixInFlavorClick());
        quit .addActionListener(event -> onQuitClick());
        about.addActionListener(event -> onAboutClick());

        
        file.add(quit);
        view.add(VIceCreamFlavor);
        view.add(VMixInFlavor);
        view.add(VScoop);
        Create.add(CICeCreamFlavor);
        Create.add(CMixInFlavor);
        Create.add(CScoop);
    
        help.add(about);
        
        menubar.add(file);
        menubar.add(view);
        menubar.add(Create);
        menubar.add(help);
        setJMenuBar(menubar);
        setVisible(true);
    }
   
    protected void OnCreateScoopClock(){
      MixIn          viewMix;
      IceCreamFlavor icecreamF;
      MixInFlavor    mixFlavor;
      MixInAmount    mixAmount;
      Scoop newScoops;
      try{
      Object[] value= (Object [])Emp.iceCreamFlavors();
        Object n = JOptionPane.showInputDialog(null, "Flavor of the scoop??", 
                "Creat", JOptionPane.QUESTION_MESSAGE, null, value, value[0]);
                icecreamF=(IceCreamFlavor)n;
      }
      catch(Exception nulException){
        icecreamF=null;
      }
      newScoops=new Scoop(icecreamF);
      
      int i=0;
      while (i==0){
        try{
            Object[] value= (Object [])Emp.mixInFlavors();
              Object n = JOptionPane.showInputDialog(null, "Flavor of the MixIn??", 
                      "Creat", JOptionPane.QUESTION_MESSAGE, null, value, value[0]);
                      mixFlavor=(MixInFlavor)n;
          }
          catch(Exception nulException){
            mixFlavor=null;
          }
          if(mixFlavor==null){
            i++;
            break;
          }
          try{
              Object n = JOptionPane.showInputDialog(null, "MixIn Amount??", 
                      "Creat", JOptionPane.QUESTION_MESSAGE, null, MixInAmount.values() , MixInAmount.values());
                      mixAmount=(MixInAmount)n;
            }
          catch(Exception nulException){
              mixAmount=null;
            }
            MixIn newMixin=new MixIn(mixFlavor,mixAmount);
            newScoops.addMixIn(newMixin);
        }
        System.out.println(newScoops);
        Emp.addScoop(newScoops);
    }
    
    
    protected void onCreateIceCremFlavorClick(){
        String name=JOptionPane.showInputDialog(null,"Name?");
        String description=JOptionPane.showInputDialog(null,"Description?");
        int price= Integer.parseInt(JOptionPane.showInputDialog(null, "Price?"));
        int cost = Integer.parseInt(JOptionPane.showInputDialog(null, "cost?"));
        //make it actulay do stuff
        IceCreamFlavor IceCreamMake=new IceCreamFlavor(name, description, cost, price);
        Emp.addiceCreamFlavors(IceCreamMake);
    }

    protected void onCreatMixInFlavorClick(){
        String name=JOptionPane.showInputDialog(null,"Name?");
        String description=JOptionPane.showInputDialog(null,"Description?");
        int price= Integer.parseInt(JOptionPane.showInputDialog(null, "Price?"));
        int cost = Integer.parseInt(JOptionPane.showInputDialog(null, "cost?"));
        //make it actulay do stuff
        MixInFlavor ReMix=new MixInFlavor(name, description, cost, price);
        Emp.addMixInFlavor(ReMix);
    }


    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Mavs Ice Cream Emporuim");
        
        try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>Nim</font></p>"
          + "</html>");
        about.add(title);

        JLabel artists = new JLabel("<html>"
          + "<p>Version 0.2</p>"
          + "<p>Copyright 2022 by Luis A. Contreras</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<p>Logo by M0tty, licensed under CC BY-SA 3.0</p>"
          + "<p><font size=-2>https://commons.wikimedia.org/wiki/File:Pyramidal_matches.svg</font></p>"
          + "<p>Robot by FreePik.com, licensed for personal</p><p>and commercial purposes with attribution</p>"
          + "<p><font size=-2>https://www.freepik.com/free-vector/grey-robot-silhouettes_714902.htm</font></p>"
          + "</html>");
        about.add(artists);

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.setSize(450,400);
        about.setVisible(true);
     }
    protected void onQuitClick() {System.exit(0);}   // Exit the game

    protected void OnViewScoop(){


      Object[] value= (Object [])Emp.scoops();
      String print="";
      for(int i=0;i<value.length;i++){
        print+=(value[i].toString()+" or ");
      }
      print="Scoop Flavors: "+print;
      JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Mavs Ice Cream Emporuim:Flavors");

      JLabel label=new JLabel(print);
      about.add(label);

      JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.setSize(450,400);
        about.setVisible(true);
    }
    protected void OnViewMixInFlavor(){
      Object[] value= (Object [])Emp.mixInFlavors();
      String print="";
      for(int i=0;i<value.length;i++){
        print+=(value[i].toString()+" or ");
      }
      print="MIXIN's: "+print;
      JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Mavs Ice Cream Emporuim:MIXIN's");

      JLabel label=new JLabel(print);
      about.add(label);

      JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.setSize(450,400);
        about.setVisible(true);
    }
    protected void OnViewIceCrenFlavor(){
      Object[] value= (Object [])Emp.iceCreamFlavors();
      String print="";
      for(int i=0;i<value.length;i++){
        print+=(value[i].toString()+" or ");
      }
      print="IceCreamFlavor's: "+print;
      JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Mavs Ice Cream Emporuim:IceCreamFlavor's");

      JLabel label=new JLabel(print);
      about.add(label);

      JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.setSize(450,400);
        about.setVisible(true);
    }
    
    /*public static void main(String[] args) {
        MainWin myApp = new MainWin("Mavs Ice Cream Emporuim");
        myApp.setVisible(true);
    } */

  


}
