package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements ActionListener{
	static JFrame frame = new JFrame("Clicker Game");
	JPanel panel = new JPanel();
	static JPanel buffs = new JPanel(new GridBagLayout());
	static JLabel label;
	JButton button;
	static int clicks = 0;
	JButton autoclicker = new JButton("Auto Clicker 1 | 100");;
	static boolean autoclickerBuff = false;
	boolean autoclickerBought = false;
	static JButton autoclicker2 = new JButton("Auto Clicker 2 | 500");
	static boolean autoclickerBuff2 = false;
	static boolean autoclickerBought2 = false;
	static JButton extraclick = new JButton(" Extra Click 1 | 200  ");
	static boolean extraclickerBuff = false;
	static boolean extraclickerBought = false;
	static JButton extraclick2 = new JButton(" Extra Click 2 | 300  ");
	static boolean extraclickerBuff2 = false;
	static boolean extraclickerBought2 = false;
	static int intColor = Integer.parseInt("3cb371", 16);
	static Color color = new Color(intColor);
	static int intColor2 = Integer.parseInt("007EDB", 16);
	static Color color2 = new Color(intColor2);
	GridBagConstraints c = new GridBagConstraints();
    public Main() {
      ImageIcon img = new ImageIcon("C:\\Users\\Elias\\Downloads\\cursor.png");
      frame.setIconImage(img.getImage());
	  frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	  frame.setVisible(true);
	  frame.setMinimumSize(new Dimension(500, 500));
	  frame.setExtendedState(frame.MAXIMIZED_BOTH);
	  button = new JButton("Click Me!");
	  panel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
	  button.setFocusable(false);
	  button.setBackground(color);
	  button.setBorderPainted(false);
	  frame.setResizable(true);
	  panel.setLayout(new GridLayout(0, 1));
	  panel.add(button);
	  autoclicker.setBackground(color2);
	  autoclicker.setForeground(Color.BLACK);
	  autoclicker.setFocusable(false);
	  autoclicker.setBorderPainted(false);
	  autoclicker.addActionListener(this);
	  autoclicker.setEnabled(false);
	  autoclicker2.setBackground(color2);
	  autoclicker2.setForeground(Color.BLACK);
	  autoclicker2.setFocusable(false);
	  autoclicker2.setBorderPainted(false);
	  autoclicker2.addActionListener(this);
	  autoclicker2.setEnabled(false);
	  extraclick.setBackground(color2);
	  extraclick.setForeground(Color.BLACK);
	  extraclick.setFocusable(false);
	  extraclick.setBorderPainted(false);
	  extraclick.addActionListener(this);
	  extraclick.setEnabled(false);
	  extraclick2.setBackground(color2);
	  extraclick2.setForeground(Color.BLACK);
	  extraclick2.setFocusable(false);
	  extraclick2.setBorderPainted(false);
	  extraclick2.addActionListener(this);
	  extraclick2.setEnabled(false);
	  c.insets = new Insets(10,5,5,5);
	  c.gridy = 0;
	  buffs.add(autoclicker, c);
	  c.gridy = 1;
	  buffs.add(autoclicker2, c);
	  c.gridy = 2;
	  buffs.add(extraclick, c);
	  c.gridy = 3;
	  buffs.add(extraclick2, c);
	  buffs.setBackground(Color.DARK_GRAY);
	  button.addActionListener(this);
	  frame.add(panel, BorderLayout.CENTER);
	  frame.add(buffs, BorderLayout.EAST);
	  label = new JLabel("Clicks: 0");
	  panel.add(label);
    }
	public static void main(String[] args) {
	  new Main();
	  int timeout = (int) System.currentTimeMillis() / 1000;
	  for(;;) {
		buffs.setBorder(BorderFactory.createEmptyBorder(0, 3, frame.getHeight() - 250, 3));
		if (clicks >= 500 && autoclickerBought2 == false) {
		  autoclicker2.setEnabled(true);
		}
		if (clicks >= 200 && extraclickerBought == false) {
		  extraclick.setEnabled(true);
	    }
		if (clicks >= 300 && extraclickerBought2 == false) {
		  extraclick2.setEnabled(true);
		}
		if(!(timeout == (int) (System.currentTimeMillis() * 2) / 1000)) {
		 if (autoclickerBuff) {
		  clicks++;
		  label.setText("Clicks: " + String.valueOf(clicks));
		 }
		 if (autoclickerBuff2) {
		   clicks += 2;
		   label.setText("Clicks: " + String.valueOf(clicks));
		 }
		 timeout = (int) (System.currentTimeMillis() * 2) / 1000;
	    }
		 timeout = (int) (System.currentTimeMillis() * 2) / 1000;
	  }
	}
	public void actionPerformed(ActionEvent e) {
	 if (e.getSource() == button) {
	  if (extraclickerBought) {
		clicks += 2;
	  }
	  else if (extraclickerBought2) {
	    clicks += 4;
	  }
	  else {
		clicks++;
	  }
	  label.setText("Clicks: " + clicks);
	  if (clicks >= 100 && autoclickerBought == false) {
		autoclicker.setEnabled(true);
	  }
	  else if (clicks >= 500 && autoclickerBought2 == false) {
		autoclicker2.setEnabled(true);
	  }
	  else if (clicks >= 200 && extraclickerBought == false) {
	    extraclick.setEnabled(true);
	  }
	  else if (clicks >= 300 && extraclickerBought2 == false) {
		extraclick2.setEnabled(true);
	  }
	 }
	 if (e.getSource() == autoclicker) {
	   autoclicker.setEnabled(false);
	   autoclickerBuff = true;
	   autoclickerBought = true;
	 }
	 if (e.getSource() == autoclicker2) {
	   autoclicker2.setEnabled(false);
	   autoclickerBuff2 = true;
	   autoclickerBought2 = true;
	 }
	 if (e.getSource() == extraclick) {
	   extraclick.setEnabled(false);
	   extraclickerBuff = true;
	   extraclickerBought = true;
	 }
	 if (e.getSource() == extraclick2) {
	   extraclick2.setEnabled(false);
	   extraclickerBuff2 = true;
	   extraclickerBought2 = true;
	 }
   }
}
