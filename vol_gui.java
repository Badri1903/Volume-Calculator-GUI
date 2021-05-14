//Event handling, GUI
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
class vol_gui extends JFrame implements ActionListener{
  DecimalFormat df = new DecimalFormat("0.#");
  Container cont;
  JPanel p1, p2, p3;
  JTextField tf1, tf2, tf3;
  JLabel l1, l2, l3, res;
  JRadioButton rb1, rb2, rb3;
  JButton calc;
  ButtonGroup bg = new ButtonGroup();
  int num1, num2, num3;
  Double r = 0.0;
  int check =0;
  vol_gui(){
    cont = getContentPane();
    cont.setLayout(new BorderLayout());

//*************************PLANE 1*************************//
    p1 = new JPanel();
    p1.setLayout(new GridLayout(3,2));

    l1 = new JLabel("Dimension");
    l1.setHorizontalAlignment(JLabel.CENTER);
    p1.add(l1);

    tf1 = new JTextField();
    tf1.setHorizontalAlignment(SwingConstants.RIGHT);
    tf1.addKeyListener(new KeyAdapter()
    {
      public void keyTyped(KeyEvent keyevent){
        char c = keyevent.getKeyChar();
        if(c >= '0' && c <= '9'){}
        else{
          keyevent.consume();
        }
      }
    });
    p1.add(tf1);

    l2 = new JLabel("Dimension");
    l2.setHorizontalAlignment(JLabel.CENTER);
    p1.add(l2);

    tf2 = new JTextField();
    tf2.setHorizontalAlignment(SwingConstants.RIGHT);
    tf2.addKeyListener(new KeyAdapter()
    {
      public void keyTyped(KeyEvent keyevent){
        char ch = keyevent.getKeyChar();
        if(ch >= '0' && ch <= '9'){}
        else{
          keyevent.consume();
        }
      }
    });
    p1.add(tf2);

    l3 = new JLabel("Dimension");
    l3.setHorizontalAlignment(JLabel.CENTER);
    p1.add(l3);

    tf3 = new JTextField();
    tf3.setHorizontalAlignment(SwingConstants.RIGHT);
        tf3.addKeyListener(new KeyAdapter()
    {
      public void keyTyped(KeyEvent keyevent){
        char cr = keyevent.getKeyChar();
        if(cr >= '0' && cr <= '9'){}
        else{
          keyevent.consume();
        }
      }
    });
    p1.add(tf3);

//*************************PLANE 2*************************//
    p2 = new JPanel();
    p2.setLayout(new GridLayout(1,3));

    rb1 = new JRadioButton("Cube",false);
    p2.add(rb1);
    rb1.addActionListener(this);

    rb2 = new JRadioButton("Cuboiod",false);
    p2.add(rb2);
    rb2.addActionListener(this);

    rb3 = new JRadioButton("Sphere",false);
    p2.add(rb3);
    rb3.addActionListener(this);

    bg.add(rb1);
    bg.add(rb2);
    bg.add(rb3);

//*************************PLANE 3*************************//
    p3 = new JPanel();
    p3.setLayout(new GridLayout(1,2));

    calc = new JButton("CALCULATE");
    p3.add(calc);
    calc.addActionListener(this);

    res = new JLabel("RESULT");
    res.setHorizontalAlignment(JLabel.CENTER);
    p3.add(res);

//********************END OF CONTAINER*********************//
    cont.add(p1,BorderLayout.NORTH);
    cont.add(p2,BorderLayout.CENTER);
    cont.add(p3,BorderLayout.SOUTH);

  }

  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    double num1=0, num2=0, num3=0;

    if(e.getSource()==rb1){
      check = 1;
      l1.setText("");
      l1.setText("Enter sides:");
      l2.setText("");
      l3.setText("");
      tf1.setText("");
      tf2.setText("");
      tf3.setText("");
      tf2.setEditable(false);
      tf3.setEditable(false);
    }
    if(e.getSource()==rb2){
      check = 2;
      tf2.setEditable(true);
      tf3.setEditable(true);
      l1.setText("");
      l1.setText("Enter length:");
      l2.setText("");
      l2.setText("Enter breadth:");
      l3.setText("");

      l3.setText("Enter height:");
      tf1.setText("");
      tf1.setText(tf1.getText());
      tf2.setText("");
      tf2.setText(tf2.getText());
      tf3.setText("");
      tf3.setText(tf3.getText());
    }
    if(e.getSource()==rb3){
      check = 3;
      tf2.setEditable(false);
      tf3.setEditable(false);
      l1.setText("");
      l2.setText("");
      l3.setText("");
      l1.setText("Enter radius:");
      tf1.setText("");
      tf2.setText("");
      tf3.setText("");
      tf3.setText(tf3.getText());
    }
    if(s.equals("CALCULATE")){
      try {
        if(check == 1){
          num1 = Integer.parseInt(tf1.getText());
          r = num1 * num1 * num1;
          res.setText("");
          res.setText("RESULT : "+ df.format(r));
        }
        else if(check == 2){
          num1 = Integer.parseInt(tf1.getText());
          num2 = Integer.parseInt(tf2.getText());
          num3 = Integer.parseInt(tf3.getText());
          r = num1 * num2 * num3;
          res.setText("");
          res.setText("RESULT : "+ df.format(r));
        }
        else if(check == 3){
          num1 = Integer.parseInt(tf1.getText());
          r = (4/3) * 3.14 * num1 * num1 * num1;
          res.setText("");
          res.setText("RESULT IS: "+ df.format(r));
        }
      }
      catch (NumberFormatException nfe) {
        res.setText("RESULT");
        JOptionPane.showMessageDialog(this, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  public static void main(String[] args){
    vol_gui vg = new vol_gui();
    vg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    vg.setTitle("Volume Calculator");
    vg.setVisible(true);
    vg.setSize(300,180);

  }
}
