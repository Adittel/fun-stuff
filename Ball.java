//Adithya Telang

//ballslife.java

//


import java.io.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Ballslife extends JFrame {

 private File questionfile;
 private File buttonline;
 private Scanner input, input2;
 private String[] images = new String[20];
 private String[] questionsline = new String[20];
 private String[] image = new String[10];
 private String[] txtlineforbutton = new String[20];
 private int universalqnumb = 0;
 private boolean button = false;
 private boolean correct = false;
 private int lives = 5;
 private int qasked = 9;


 private CardBallPanel cardpanel;
 private CardPanel1 card1;
 private CardPanel2 card2;
 private CardPanel3 card3;
 private CardPanel4 card4;
 private String placeholder = "";
 private CardLayout cards;
 private Font font;

 public static void main(String[] args)

 {

  Ballslife bl = new Ballslife();

  //store image names in an array to use

  //store question lines in an array

  //store the right answers in an array , wrong answers

  //will be picked randomly from a different array

  //make wrong answers array

 }

 public Ballslife()

 {

  super("JFrame holding 3 cards.  Grid Layout ");
  font = new Font("Serif", Font.BOLD, 20);

  setSize(1620, 1200);

  setLocation(50, 50);
  // sets location of panel on thecomputer screen

  setDefaultCloseOperation(DISPOSE_ON_CLOSE);

  setResizable(true);

  setLayout(new GridLayout(1, 1));

  // 1a.

  /////////////////////////////////////////////////////////

  // 4. make JLabels for cards

  JLabel cardLabel1, cardLabel2, cardLabel4, cardLabel3;

  //////////////////////////////////////////////

  // 3

  questionfile = new File("Questionanswer.txt");

  buttonline = new File("wrongAnswer.txt");

  image[0] = "IMG_1231.JPG";
  image[1] = "IMG_1231.JPG";
  image[2] = "IMG_1231.JPG";
  image[3] = "IMG_1231.JPG";
  image[4] = "IMG_1231.JPG";
  image[5] = "IMG_1231.JPG";
  image[6] = "IMG_1231.JPG";
  image[7] = "IMG_1231.JPG";
  image[8] = "IMG_1231.JPG";
  image[9] = "IMG_1231.JPG";

  cardpanel = new CardBallPanel();

  cards = new CardLayout(); // make cardLayout

  cardpanel.setLayout(cards);
  // makeholder panel

  card1 = new CardPanel1(); // setLayout

  card2 = new CardPanel2(); // create the cards

  card3 = new CardPanel3();

  card4 = new CardPanel4();

  card2.setLayout(new GridLayout(2, 1));

  // change background of cards

  cardpanel.add(card1, "Start panel");

  cardpanel.add(card2, "main quiz");

  cardpanel.add(card3, "right/wrong");

  cardpanel.add(card4, "end panel");


  add(cardpanel);

  setVisible(true);

 }

 //card panels

 class CardBallPanel extends JPanel

 {

  public CardBallPanel()

  {

   int w = 0;

   try

   {
    input = new Scanner(buttonline);
   } catch (FileNotFoundException n)

   {

    System.out.println("error : cant open file
     txt ");

     System.exit(2);

    }

    do {

     questionsline[w] = input.nextLine();

     w++;

    } while (input.hasNextLine() && w <= 19);

    ///////////////////////////////////////////////////////////////
    int m = 0;
    try

    {

     input2 = new Scanner(questionfile);

    } catch (FileNotFoundException t)

    {

     System.out.println("error : cant open file
      txt ");

      System.exit(2);

     }

     do {

      txtlineforbutton[m] = input2.nextLine();
      m++;

     } while (input2.hasNextLine() && m <= 10);
    }

   }

   ///////////////////////////////////////////////////////////////////

   class CardPanel1 extends JPanel

   {

    public CardPanel1()

    {

     setLayout(new GridLayout(1, 2));

     setBackground(Color.CYAN);

     Rightpanel direction = new Rightpanel();

     Leftpanel startquit = new Leftpanel();

     add(startquit);

     add(direction);

    }

    public void paintComponent(Graphics g)

    {

     super.paintComponent(g);

     //start panel

     //have 2 panels on it

     //have 2 buttons start and quit,

     //start will move the card to the next panel

     // use a different panel to show directions







    }

   }

   class Leftpanel extends JPanel

   {

    //  make the panel with all the directions

    public Leftpanel()

    {

     setBackground(Color.CYAN);

     //add the directions to this panel

     JButton startbutton;

     startbutton = new JButton("start");

     setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

     StartButtonHandler sb1hand = new
     StartButtonHandler();

     startbutton.addActionListener(sb1hand);

     add(startbutton);

     JButton quitbutton;

     quitbutton = new JButton("quit");

     //setLayout(new FlowLayout(FlowLayout.CENTER,0,100) );

     quitbuttonHandler qbhand = new
     quitbuttonHandler();

     quitbutton.addActionListener(qbhand);

     add(quitbutton);

    }

    public void paintComponent(Graphics g)

    {

     super.paintComponent(g);

     //add the button handlers and everything else

    }

   }

   class StartButtonHandler implements ActionListener

   {

    public void actionPerformed(ActionEvent e)

    {

     String command =  e.getActionCommand();

     if (command.equals("start"))

     {

      cards.show(cardpanel, "main quiz");

      repaint();

     }

    }

   }

   class quitbuttonHandler implements ActionListener

   {

    public void actionPerformed(ActionEvent e)

    {

     String command = e.getActionCommand();

     if (command.equals("quit"))

     {

      System.exit(1);

      //setDefaultCloseOperation(DISPOSE_ON_CLOSE) = true;


     }

    }

   }

   class Rightpanel extends JPanel

   {

    //  the this one has all the directions. this one will have no butons

    public Rightpanel()

    {

     setBackground(Color.YELLOW);

    }

    public void paintComponent(Graphics g)

    {


     super.paintComponent(g);

     //add the button handlers
     else
      g.setFont(font);
     g.drawString("this is where the
      directions are ",50,100);

     }

    }

    class CardPanel2 extends JPanel

    {

     public CardPanel2()

     {

      setBackground(Color.ORANGE);

      box1panel b1 = new box1panel();

      box2panel b2 = new box2panel();

      add(b1);

      add(b2);

      //use a grid layout and have it 2x1

     }

     public void paintComponent(Graphics g)

     {

      super.paintComponent(g);

      //this is the games panel most code is here

      //add a menubar with different positions

      //menubar handler and the specifics for that

      //use the positions to update a panel that will be added 4 th

      //the next grid is covered by an image of the court that will be

      // updated as it goes

     }

    }

    class box1panel extends JPanel

    {

     //  the panel has an image and will update
     it based on question
     public box1panel()

     {
      universalqnumb = (int)(Math.random() * 9 + 0);
     }



     public void paintComponent(
      Graphics g)

     {
      g.setFont(font);
      super.paintComponent(g);
      String go =
       txtlineforbutton[universalqnumb];
      String that =
       image[universalqnumb];
      g.drawString(go, 700, 30);
      Image image = Toolkit.getDefaultToolkit().getImage(that);
      g.drawImage(image, 5, 50, 1600, 600, this);
      //add image here using toolkit and ther other methods
      if (lives == 5)
       g.drawString("5 lives", 1000, 30);
      if (lives == 4)
       g.drawString("4 lives", 1000, 30);
      if (lives == 3)
       g.drawString("3 lives", 1000, 30);
      if (lives == 2)
       g.drawString("2 lives", 1000, 30);
      if (lives == 1)
       g.drawString("1 lives", 1000, 30);
     }

    }

    class box2panel extends JPanel

    {

     //  the panel will have the menu bar an will also have a variables

     ButtonGroup group;

     JMenuBar menuBar;

     JMenu menu, menu2;

     JRadioButtonMenuItem rbMenuItem, rbMenuItem2;

     JRadioButtonMenuItem
     rbMenuItem3, rbMenuItem4, rbMenuItem5,
     rbMenuItem6;

     JRadioButtonMenuItem
     rbMenuItem7, rbMenuItem8, rbMenuItem9;

     JButton submit;

     public box2panel()

     {

      input = null;

      setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));

      setBackground(Color.RED);

      menuBar = new JMenuBar();

      menu = new JMenu("list of
       positions ");


       menu.getAccessibleContext().setAccessibleDescription("" +

        " list of positions");

       menuBar.add(menu);

       menu2 = new JMenu("list of rules");


       menu2.getAccessibleContext().setAccessibleDescription("" +

        " list of rules");

       menuBar.add(menu2);

       group = new ButtonGroup();

       rbMenuItem = new JRadioButtonMenuItem("point guard");

       rbMenuItem.setSelected(false);

       group.add(rbMenuItem);

       ButtonHandler bh = new ButtonHandler();

       rbMenuItem.addActionListener(bh);

       menu.add(rbMenuItem);


       rbMenuItem2 = new JRadioButtonMenuItem("shooting guard");

       group.add(rbMenuItem2);

       ButtonHandler2 bh2 = new ButtonHandler2();

       rbMenuItem2.addActionListener(bh2);

       menu.add(rbMenuItem2);


       rbMenuItem3 = new JRadioButtonMenuItem("center");

       group.add(rbMenuItem3);

       ButtonHandler3 bh3 = new ButtonHandler3();

       rbMenuItem3.addActionListener(bh3);

       menu.add(rbMenuItem3);


       rbMenuItem4 = new JRadioButtonMenuItem("power forward");

       group.add(rbMenuItem4);

       ButtonHandler4 bh4 = new ButtonHandler4();

       rbMenuItem4.addActionListener(bh4);

       menu.add(rbMenuItem4);

       rbMenuItem5 = new JRadioButtonMenuItem("small forward");

       group.add(rbMenuItem5);

       ButtonHandler5 bh5 = new ButtonHandler5();

       rbMenuItem5.addActionListener(bh5);

       menu.add(rbMenuItem5);

       rbMenuItem6 = new JRadioButtonMenuItem("travel");

       rbMenuItem6.setSelected(false);

       group.add(rbMenuItem6);

       ButtonHandler6 bh6 = new ButtonHandler6();

       rbMenuItem6.addActionListener(bh6);

       menu2.add(rbMenuItem6);





       rbMenuItem7 = new JRadioButtonMenuItem("shot clock");

       rbMenuItem7.setSelected(false);

       group.add(rbMenuItem7);

       ButtonHandler7 bh7 = new ButtonHandler7();

       rbMenuItem6.addActionListener(bh7);

       menu2.add(rbMenuItem7);



       rbMenuItem8 = new JRadioButtonMenuItem("boundry");

       rbMenuItem8.setSelected(false);

       group.add(rbMenuItem8);

       ButtonHandler8 bh8 = new ButtonHandler8();

       rbMenuItem8.addActionListener(bh8);

       menu2.add(rbMenuItem8);



       rbMenuItem9 = new JRadioButtonMenuItem("something");

       rbMenuItem9.setSelected(false);

       group.add(rbMenuItem9);

       ButtonHandler9 bh9 = new ButtonHandler9();

       rbMenuItem9.addActionListener(bh9);

       menu2.add(rbMenuItem9);

       add(menuBar);

       submit = new JButton("submit");

       submitHandler bhand = new submitHandler();

       submit.addActionListener(bhand);

       add(submit);




      }

      class ButtonHandler extends JPanel implements ActionListener

      {
       public void actionPerformed(ActionEvent e)

       {
        if (rbMenuItem.isSelected()) {
         placeholder =
          questionsline[0];

         correct = false;
         if (universalqnumb == 0)
          correct = true;
         repaint();

        }
       }
      }

      class ButtonHandler2 extends JPanel implements ActionListener

      {

       public void actionPerformed(ActionEvent e)

       {

        if (rbMenuItem2.isSelected())

        {

         placeholder =
          questionsline[1];


         correct = false;
         if (universalqnumb == 1)
          correct = true;
         repaint();

        }

       }

      }

      class ButtonHandler3 extends JPanel implements ActionListener

      {

       public void actionPerformed(ActionEvent e)

       {

        if (rbMenuItem3.isSelected())

        {

         placeholder = questionsline[2];
         correct = false;
         if (universalqnumb == 2)
          correct = true;
         repaint();

        }

       }

      }

      class ButtonHandler4 extends JPanel implements ActionListener

      {

       public void actionPerformed(ActionEvent e)

       {

        if (rbMenuItem4.isSelected())

        {

         placeholder =
          questionsline[3];
         correct = false;
         if (universalqnumb == 3)
          correct = true;
         repaint();

        }

       }

      }

      class ButtonHandler5 extends JPanel implements ActionListener

      {

       public void actionPerformed(ActionEvent e)

       {

        if (rbMenuItem5.isSelected())

        {

         placeholder =
          questionsline[4];
         correct = false;
         if (universalqnumb == 4)
          correct = true;
         repaint();

        }


       }

      }

      class ButtonHandler6 extends JPanel implements ActionListener

      {

       public void actionPerformed(ActionEvent e)

       {

        if (rbMenuItem6.isSelected())

        {

         placeholder =
          questionsline[5];
         correct = false;
         if (universalqnumb == 5)
          correct = true;
         repaint();

        }

       }

      }

      class ButtonHandler7 extends JPanel implements ActionListener

      {

       public void actionPerformed(ActionEvent e)

       {

        if (rbMenuItem7.isSelected())

        {

         placeholder =
          questionsline[6];
         correct = false;
         if (universalqnumb == 6)
          correct = true;
         repaint();

        }

       }

      }

      class ButtonHandler8 extends JPanel implements ActionListener

      {

       public void actionPerformed(ActionEvent e)

       {

        if (rbMenuItem8.isSelected())

        {

         placeholder =
          questionsline[7];
         correct = false;
         if (universalqnumb == 7)
          correct = true;
         repaint();

        }

       }

      }

      class ButtonHandler9 extends JPanel implements ActionListener

      {

       public void actionPerformed(ActionEvent e)

       {

        if (rbMenuItem9.isSelected())

        {

         placeholder =
          questionsline[8];
         correct = false;
         if (universalqnumb == 8)
          correct = true;
         repaint();

        }

       }

      }

      class submitHandler implements ActionListener {
       public void   actionPerformed(ActionEvent e) {

        String command =
         e.getActionCommand();

        if (command.equals("submit")) {

         cards.show(cardpanel, "right/wrong");
         repaint();
        }
       }
      }

      public void paintComponent(Graphics g)

      {

       super.paintComponent(g);
       g.setFont(font);
       //add the bar then the other stuff

       g.setColor(Color.BLACK);

       g.drawString(placeholder, 50, 50);

       repaint();

      }

     }


     class CardPanel3 extends JPanel

     {
      String printed = "";
      String line2 = "";
      JButton backbutton;
      public CardPanel3()

      {

       setBackground(Color.ORANGE);
       if (correct == true) {
        printed = "Nice job keep getting them right";
       }
       if (correct == false) {

        printed = "sorry but the right answer is ";
        line2 = questionsline[universalqnumb];
        lives -= 1;
       }

       backbutton = new JButton("ok(continue)");

       setLayout(new FlowLayout(FlowLayout.CENTER, 300, 700));

       backHandler bhand = new backHandler();

       backbutton.addActionListener(bhand);

       add(backbutton);

      }
      public void paintComponent(Graphics g)

      {

       super.paintComponent(g);
       //after all of this the last pannel has a
       //right and wrong part that tells if you were right and
       g.setFont(font);
       //add the bar then the other stuff

       g.setColor(Color.BLACK);

       g.drawString(printed, 50, 50);
       g.drawString(line2, 80, 80);


      }

     }
     class backHandler implements ActionListener {
      public void
      actionPerformed(ActionEvent e) {
       String command =
        e.getActionCommand();
       qasked -= 1;

       if (command.equals("ok(continue)")) {
        if (qasked >= 1 && lives >= 1) {
         CardPanel2 x = new CardPanel2();
         cards.show(cardpanel, "main quiz");
        }
        if (qasked == 0) {
         cards.show(cardpanel, "end panel");
        }rgb(28,236,216)
       }
      }
     }
     class CardPanel4 extends JPanel

     {

      public CardPanel4()

      {

		  setBackground(Color.RED);
      if (lives == 5)
       g.drawString(" you had 5 lives! nice job, 100%", 1000, 30);
      if (lives == 4)
       g.drawString("4 lives, that's only 1 mistake", 1000, 30);
      if (lives == 3)
       g.drawString("3 lives, good job try harded next time", 1000, 30);
      if (lives == 2)
       g.drawString("2 lives, nice try but you should go again", 1000, 30);
      if (lives == 1)
       g.drawString("1 lives, you need to go again to learn more", 1000, 30);
		  if (lives == 0)
       g.drawString("No lives, You have ''died'' ,you need to go again to learn more", 1000, 30);
JButton quitbutton;

     quitbutton = new JButton("quit");

     //setLayout(new FlowLayout(FlowLayout.CENTER,0,100) );

     redoHandler qbhand = new redoHandler();

     quitbutton.addActionListener(qbhand);

     add(quitbutton);
      }

      public void paintComponent(Graphics g)

      {

       super.paintComponent(g);

       //this panel is 1x1 and it has nothing but a end screen with changing colors

       //then the panel will have an exit buttonand then a retry

       // button that will reset all values and restart the game

      }

     }

     ///////////////////////////////////////////////

class redoHandler implements ActionListener {
       public void actionPerformed(ActionEvent e) {

        String command =
         e.getActionCommand();

        if (command.equals("end")) {

         System.exit(2);
        }
       }
      }



     class box3panel extends JPanel

     {

      //  the panel is an panel where text is displayed based on options

      //selected from the user

      public box3panel()

      {

      }

      public void paintComponent(Graphics g)

      {

       super.paintComponent(g);

       //add the text lines and have them wrap to fit the box

      }

     }


     ///////these are added to the next card panel

     class box4panel extends JPanel

     {

      //  this panel uses lives and will

      public box4panel()

      {

      }

      public void paintComponent(Graphics g)

      {

       super.paintComponent(g);

       //add the life bar here it can be an image

      }

     }

     class box6panel extends JPanel

     {

      //  the panel displays the right info form the different places add a

      //scanner that will read files from the different places and
      talkabout them

      public box6panel()

      {

      }

      public void paintComponent(Graphics g)

      {

       super.paintComponent(g);

       //add a scanner to get the right ifo from under
       thequestion

       //the wrong answer is taken from a different one
       and it has its own txtfile

      }

     }

    }