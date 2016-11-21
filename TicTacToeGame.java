import java.util.*;
import java.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame extends JFrame{
	
	//variables for the gui layout
	JLabel title,name;
	JPanel startPanel,gamePanel,leftPanel,rightPanel;
	JButton start,exit1,uvu,uvc,cva,avu,exit2;
	JTextField jf;
	JDialog jd;
	
	GridGame gg;
	JButton j1,j2,j3,j4,j5,j6,j7,j8, j9;
	
	JLabel usr1,usr2;
	JTextField jfusr1,jfusr2;
	JButton jb;
	
	int charCount = 0;
	
	String strUsr1 = "",strUsr2 = "";
	
	int mode=-1,turn,fulb=0;
	
	
	public static void main(String args[])
	{
		TicTacToeGame ttt = new TicTacToeGame();
		
		ttt.pack();
		ttt.setDefaultLookAndFeelDecorated(true);
		//ttt.setSize(300,300);
		ttt.setVisible(true);
		ttt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ttt.setTitle("Testiong");
		
	}
	
	public TicTacToeGame()
	{
		startPanel = new JPanel();
		startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.Y_AXIS));
		startPanel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));

		
		title = new JLabel("Tic-Tac-Toe!");
		title.setFont(new Font("Sherif",Font.BOLD,22));
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		startPanel.add(title);
		//gamePanel.add(title);
		
		startPanel.add(Box.createRigidArea(new Dimension(0, 80)));

		//Dimension d = new Dimension(200,200);
		start = new JButton("Start Game");
		//start.setPreferredSize(d);
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		startPanel.add(start);
		
		startPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		
		exit1 = new JButton("Exit");
		exit1.setAlignmentX(Component.CENTER_ALIGNMENT);
		startPanel.add(exit1);
		
		startPanel.add(Box.createRigidArea(new Dimension(80, 120)));
		
		name = new JLabel("Shreyash Arya (2015097)");
		name.setFont(new Font("Sherif",Font.ITALIC,12));
		name.setAlignmentX(Component.CENTER_ALIGNMENT);
		startPanel.add(name);
		
		add(startPanel);
		
		gamePanel = new JPanel();
		gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.X_AXIS));
		gamePanel.setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));
		
		leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.setBorder(new EmptyBorder(new Insets(50, 0, 50, 50)));
		
		uvu = new JButton("User vs. User");
		//start.setPreferredSize(d);
		uvu.setAlignmentX(Component.CENTER_ALIGNMENT);
		leftPanel.add(uvu);
		
		leftPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		
		uvc = new JButton("User vs. Computer");
		//start.setPreferredSize(d);
		uvc.setAlignmentX(Component.CENTER_ALIGNMENT);
		leftPanel.add(uvc);
		
		leftPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		
		cva = new JButton("Computer vs. AI");
		//start.setPreferredSize(d);
		cva.setAlignmentX(Component.CENTER_ALIGNMENT);
		leftPanel.add(cva);
		
		leftPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		
		avu = new JButton("AI vs. User");
		//start.setPreferredSize(d);
		avu.setAlignmentX(Component.CENTER_ALIGNMENT);
		leftPanel.add(avu);
		
		leftPanel.add(Box.createRigidArea(new Dimension(0, 160)));

		exit2 = new JButton("Exit");
		exit2.setAlignmentX(Component.CENTER_ALIGNMENT);
		leftPanel.add(exit2);
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.setBorder(new EmptyBorder(new Insets(50, 0, 50, 50)));
		
		gg = new GridGame();
		gg.setLayout(new GridLayout(3,3));
		rightPanel.add(gg);
		
		rightPanel.add(Box.createRigidArea(new Dimension(0, 60)));
		
		jf = new JTextField();
		rightPanel.add(jf);
		
		gamePanel.add(leftPanel);
		gamePanel.add(rightPanel);
		
		
		exitEvent event = new exitEvent();
		exit1.addActionListener(event);
		exit2.addActionListener(event);
		
		startEvent sevent = new startEvent();
		start.addActionListener(sevent);
		
		uvuEvent event1 = new uvuEvent();
		uvu.addActionListener(event1);
		
		uvcEvent event2 = new uvcEvent();
		uvc.addActionListener(event2);
		
		uvaEvent event4 = new uvaEvent();
		avu.addActionListener(event4);
		
		cvaEvent event3 = new cvaEvent();
		cva.addActionListener(event3);
		
		gg.resetGame();
	
		
	
		
		
	}
	
	
	public class uvaEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			avu.setBackground(Color.GREEN);
			cva.setBackground(null);
			uvu.setBackground(null);
			uvc.setBackground(null);
			
			gg.reset();
			
			jd = new JDialog(TicTacToeGame.this,"Names",true);
			
			jd.setLayout(new FlowLayout());
			
			usr1 = new JLabel("User: ");
			jd.add(usr1);

			jfusr1 = new JTextField(10);
			jd.add(jfusr1);
		
			jb = new JButton("OK");
			jb.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			jb.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(!jfusr1.getText().equals(null))
					{
						strUsr1 = jfusr1.getText();
					}
					
					jf.setText("   "+ strUsr1 + " vs. AI ");
					
					jd.dispose();
				}
			});
			jd.add(jb);
			
			jd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			jd.setSize(200,100);
			jd.setLocation(300,300);
			jd.setVisible(true);
			
			
			mode = 4;
			
			charCount=1;
			
			gg.tileClickedAI();
			
		}
		
	}
	
	public class uvcEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			uvc.setBackground(Color.GREEN);
			avu.setBackground(null);
			cva.setBackground(null);
			uvu.setBackground(null);
			
			
			gg.reset();
			
			jd = new JDialog(TicTacToeGame.this,"Names",true);
			
			jd.setLayout(new FlowLayout());
			
			usr1 = new JLabel("User: ");
			jd.add(usr1);

			jfusr1 = new JTextField(10);
			jd.add(jfusr1);
		
			jb = new JButton("OK");
			jb.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			jb.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int flag=0;
					
					if(!jfusr1.getText().equals(""))
					{
						strUsr1 = jfusr1.getText();
						flag=1;
					}
					
					else
					{
						JOptionPane.showMessageDialog(gamePanel, "Empty name not allowed");
					}
					
					if(flag==1)
					{
						jf.setText("   "+ strUsr1 + " vs. Computer ");
					
						jd.dispose();
					}
				}
			});
			jd.add(jb);
			
			jd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			jd.setSize(200,100);
			jd.setLocation(300,300);
			jd.setVisible(true);
			
			
			mode = 2;
			
			Random r = new Random();
			
			charCount = r.nextInt(2);
			System.out.println("first random charCount: " + charCount);
			
			if(charCount%2!=0)
			{
				gg.tileClickedRandom();
				//charCount++;
			}
			
			
		}
		
	}
	public class uvuEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			uvu.setBackground(Color.GREEN);
			avu.setBackground(null);
			cva.setBackground(null);
			uvc.setBackground(null);
			
			gg.reset();
			
			mode = 1;
			
			jd = new JDialog(TicTacToeGame.this,"Names",true);
			
			//super(frame,"Names",true);
			jd.setLayout(new FlowLayout());
			
			usr1 = new JLabel("User 1: ");
			jd.add(usr1);
			
			jfusr1 = new JTextField(10);
			jd.add(jfusr1);
			
			usr2 = new JLabel("User 2: ");
			jd.add(usr2);
			
			jfusr2 = new JTextField(10);
			jd.add(jfusr2);
		
			jb = new JButton("OK");
			jb.setAlignmentX(Component.CENTER_ALIGNMENT);
			jb.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					int flag1=0,flag2=0;
					
					if(!jfusr1.getText().equals(""))
					{
						strUsr1 = jfusr1.getText();
						flag1=1;
					}
					
					else
					{
						JOptionPane.showMessageDialog(gamePanel, "Empty name not allowed");
					}
					
					if(!jfusr2.getText().equals(""))
					{
						strUsr2 = jfusr2.getText();
						flag2=1;
					}
					
					else
					{
						JOptionPane.showMessageDialog(gamePanel, "Empty name not allowed");
					}
					
					if(flag1==1 && flag2==1){
					
						jf.setText("   "+ strUsr1 + "'s turn");
					
					
						jd.dispose();
					}
				}
			});
			jd.add(jb);
			
			jd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			jd.setSize(200,100);
			jd.setLocation(300,300);
			jd.setVisible(true);
			
			
		}
		
		
	}
	
	public class cvaEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			avu.setBackground(null);
			cva.setBackground(Color.GREEN);
			uvu.setBackground(null);
			uvc.setBackground(null);
			
			gg.reset();
			gg.timerCpuAi();
			
			
		}
		
	}
	
	public class exitEvent implements ActionListener{
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stube
			
			System.exit(0);
			
		}
	}
	
	public class startEvent implements ActionListener{
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stube
			
			setContentPane(gamePanel);
			revalidate();
			
		}
	}
	
	public class GridGame extends JPanel
	{
		//JPanel gridPanel = new JPanel(new GridLayout(3,3));
		
		board b = new board();
		
		int stat,counter;
		String put;
		
		public GridGame()
		{
			j1 = new JButton("");
			j1.setPreferredSize(new Dimension(100,100));
			add(j1);
			
			j2 = new JButton("");
			//j2.setPreferredSize(new Dimension(50,50));
			add(j2);
			
			j3 = new JButton("");
			//j3.setPreferredSize(new Dimension(50,50));
			add(j3);
			
			j4 = new JButton("");
			//j4.setPreferredSize(new Dimension(50,50));
			add(j4);
			
			j5 = new JButton("");
			//j5.setPreferredSize(new Dimension(50,50));
			add(j5);
			
			j6 = new JButton("");
			//j6.setPreferredSize(new Dimension(50,50));
			add(j6);
			
			j7 = new JButton("");
			//j7.setPreferredSize(new Dimension(50,50));
			add(j7);
			
			j8 = new JButton("");
			//j8.setPreferredSize(new Dimension(50,50));
			add(j8);
			
			j9 = new JButton("");
			//j9.setPreferredSize(new Dimension(50,50));
			add(j9);
			
			jbevent event = new jbevent();
			j1.addActionListener(event);
			j2.addActionListener(event);
			j3.addActionListener(event);
			j4.addActionListener(event);
			j5.addActionListener(event);
			j6.addActionListener(event);
			j7.addActionListener(event);
			j8.addActionListener(event);
			j9.addActionListener(event);
		}
		
		//JButton j1 = new JButton("");
		
		
		public void reset()
		{
			j1.setText("");
			j2.setText("");
			j3.setText("");
			j4.setText("");
			j5.setText("");
			j6.setText("");
			j7.setText("");
			j8.setText("");
			j9.setText("");
			
			j1.setEnabled(true);
			j2.setEnabled(true);
			j3.setEnabled(true);
			j4.setEnabled(true);
			j5.setEnabled(true);
			j6.setEnabled(true);
			j7.setEnabled(true);
			j8.setEnabled(true);
			j9.setEnabled(true);
			
			j1.setBackground(null);
			j2.setBackground(null);
			j3.setBackground(null);
			j4.setBackground(null);
			j5.setBackground(null);
			j6.setBackground(null);
			j7.setBackground(null);
			j8.setBackground(null);
			j9.setBackground(null);
			
			charCount=0;
		}
		
		public void resetGame()
		{
			j1.setText("");
			j2.setText("");
			j3.setText("");
			j4.setText("");
			j5.setText("");
			j6.setText("");
			j7.setText("");
			j8.setText("");
			j9.setText("");
			
			j1.setEnabled(false);
			j2.setEnabled(false);
			j3.setEnabled(false);
			j4.setEnabled(false);
			j5.setEnabled(false);
			j6.setEnabled(false);
			j7.setEnabled(false);
			j8.setEnabled(false);
			j9.setEnabled(false);
			
			uvu.setBackground(null);
			uvc.setBackground(null);
			avu.setBackground(null);
			cva.setBackground(null);
			
			
			charCount=0;
			mode=-1;
		}
		
		public void checkWin()
		{
			stat = b.checkState();
			
			System.out.println("checkWin : " + stat);
			
			if(stat==1 || stat==2)
			{
			
				if(stat==1)
				{
					if(put.equals("O"))
					{
						jf.setText(" Computer  "+  "(O Wins!)");
						//System.out.println();
					}
					
					else
					{
						jf.setText("   " + strUsr1+"(X Wins!)");
						//System.out.println("X Wins!");
						//System.out.println();
					}
				}
				
				else
				{
					jf.setText("    Tie");
				}
				
				//gg.resetGame();
				return;
			}
		}
		
		public void tileClickedRandom()
		{
			put="O";
			charCount++;
			System.out.println("charCount inside tileRandom: "+ charCount);
			
			Random r =  new Random();
			
			int i = r.nextInt((9-1)+1) + 1;
			
			boolean flag = true;
			
			while(flag)
			{
			
				if(i==1)
				{
					if(j1.getText()=="")
					{
						j1.setText("O");
						j1.setEnabled(false);
						checkWin();
						return;
					}
				}
				
				else if(i==2)
				{
					if(j2.getText()=="")
					{
						j2.setText("O");
						j2.setEnabled(false);
						checkWin();
						return;
					}
				}
				
				else if(i==3)
				{
					if(j3.getText()=="")
					{
						j3.setText("O");
						j3.setEnabled(false);
						checkWin();
						return;
					}
				}
				
				else if(i==4)
				{
					if(j4.getText()=="")
					{
						j4.setText("O");
						j4.setEnabled(false);
						checkWin();
						return;
					}
				}
				
				else if(i==5)
				{
					if(j5.getText()=="")
					{
						j5.setText("O");
						j5.setEnabled(false);
						checkWin();
						return;
					}
				}
				
				else if(i==6)
				{
					if(j6.getText()=="")
					{
						j6.setText("O");
						j6.setEnabled(false);
						checkWin();
						return;
					}
				}
				
				else if(i==7)
				{
					if(j7.getText()=="")
					{
						j7.setText("O");
						j7.setEnabled(false);
						checkWin();
						return;
					}
				}
				
				else if(i==8)
				{
					if(j8.getText()=="")
					{
						j8.setText("O");
						j8.setEnabled(false);
						checkWin();
						return;
					}
				}
				
				else 
				{
					if(j9.getText()=="")
					{
						j9.setText("O");
						j9.setEnabled(false);
						checkWin();
						return;
					}
				}
				
				i = r.nextInt((9-1)+1) + 1;
				
			}
				
				
			
		}
		
		public void tileClickedAI()
		{
			put="X";
			charCount++;
			System.out.println("charCount in AI tile func---------"+ charCount);
			
			counter = 0;
			
			if(j1.getText()=="")
			{
				counter++;
			}
			
			if(j2.getText()==(""))
			{
				counter++;
			}
			
			if(j3.getText()==(""))
			{
				counter++;
			}
			
			if(j4.getText()==(""))
			{
				counter++;
			}
			
			if(j5.getText()==(""))
			{
				counter++;
			}
			
			if(j6.getText()==(""))
			{
				counter++;
			}
			
			if(j7.getText()==(""))
			{
				counter++;
			}
			
			if(j8.getText()==(""))
			{
				counter++;
			}
			
			if(j9.getText()==(""))
			{
				counter++;
			}
			
			System.out.println(counter);
			
			if(j1.getText()==(""))
			{
				//System.out.println("1");
				j1.setText(put);
				j1.setEnabled(false);
				checkWin();
				
			}
			
			else if((j5.getText()==("O") && j9.getText()==("") && counter>6))
			{
				//System.out.println("2");
				j9.setText(put);
				j9.setEnabled(false);
				checkWin();
			}
			
			else if((j5.getText()==("O") && j9.getText()==("X") && j3.getText()==("O") && counter==5) || (j5.getText()==("O") && j9.getText()==("X") && j7.getText()==("O") && counter==5) )
			{
				//System.out.println("3");
				if(j7.getText()==(""))
				{
					j7.setText(put);
					j7.setEnabled(false);
					checkWin();
				}
				
				else
				{
					j3.setText(put);
					j3.setEnabled(false);
					checkWin();
				}
			}
			
			else if((j5.getText()==("O") && j9.getText()==("X") && j3.getText()==("O") && j7.getText()==("X") && counter==3) || (j5.getText()==("O") && j9.getText()==("X") && j7.getText()==("O") && j3.getText()==("X") &&  counter==3) )
			{
				//System.out.println("4");
				if(j7.getText()==("X"))
				{
					if(j8.getText()==(""))
					{
						j8.setText(put);
						j8.setEnabled(false);
						checkWin();
					}
					
					else
					{
						j4.setText(put);
						j4.setEnabled(false);
						checkWin();
					}
				}
				
				else
				{
					if(j6.getText()==(""))
					{
						j6.setText(put);
						j6.setEnabled(false);
						checkWin();
					}
					
					else
					{
						j2.setText(put);
						j2.setEnabled(false);
						checkWin();
					}
				}
			}
			
			else if((j5.getText()==("O") && j9.getText()==("X") && j4.getText()==("O") && counter==5) || (j5.getText()==("O") && j9.getText()==("X") && j6.getText()==("O") && counter==5))
			{
				//System.out.println("5");
				if(j4.getText()==("O"))
				{
					j6.setText(put);
					j6.setEnabled(false);
					checkWin();
				}
				
				else
				{
					j4.setText(put);
					j4.setEnabled(false);
					checkWin();
				}
			}
			
			else if((j5.getText()==("O") && j9.getText()==("X") && j4.getText()==("O") && j6.getText()==("X") && counter==3) || (j5.getText()==("O") && j9.getText()==("X") && j4.getText()==("X") && j6.getText()==("O") && counter==3))
			{
				//System.out.println("6");
				//System.out.println("Second Last");
				if(j4.getText()==("O") && j3.getText()==(""))
				{
					j3.setText(put);
					j3.setEnabled(false);
					checkWin();
				}
				
				else if(j6.getText()==("O") && j7.getText()==(""))
				{
					j7.setText(put);
					j7.setEnabled(false);
					checkWin();
				}
				
				else if(j6.getText()==("O") && j7.getText()==("O") && j3.getText()==(""))
				{
					j3.setText(put);
					j3.setEnabled(false);
					checkWin();
					
				}
				
				else if(j4.getText()==("O") && j3.getText()==("O") && j7.getText()==(""))
				{
					j7.setText(put);
					j7.setEnabled(false);
					checkWin();
				}
				

			}
			
			else if((j5.getText()==("O") && j9.getText()==("X") && j4.getText()==("O") && j6.getText()==("X") && j7.getText()==("X") && counter==1) || (j5.getText()==("O") && j9.getText()==("X") && j6.getText()==("O") && j4.getText()==("X") && j3.getText()==("X") && counter==1))
			{
				//System.out.println("7");
				//System.out.println("Last");
				if(j2.getText()==(""))
				{
					j2.setText(put);
					j2.setEnabled(false);
					checkWin();
				}
				
				else 
				{
					j8.setText(put);
					j8.setEnabled(false);
					checkWin();
				}
			}
			
			else if((j5.getText()==("O") && j9.getText()==("X") && j2.getText()==("O") && j8.getText()==("") && counter==5) || (j5.getText()==("O") && j9.getText()==("X") && j2.getText()==("") && j8.getText()==("O")  && counter==5) )
			{
				//System.out.println("8");
				if(j2.getText()==("O"))
				{
					j8.setText(put);
					j8.setEnabled(false);
					checkWin();
				}
				
				else
				{
					j2.setText(put);
					j2.setEnabled(false);
					checkWin();
				}
			}
			
			else if((j5.getText()==("O") && j9.getText()==("X") && j2.getText()==("O") && j8.getText()==("X") && counter==3) || (j5.getText()==("O") && j9.getText()==("X") && j2.getText()==("X") && j8.getText()==("O") && counter==3) )
			{
				//System.out.println("9");
				if(j2.getText()==("O") && j7.getText()==(""))
				{
					j7.setText(put);
					j7.setEnabled(false);
					checkWin();
				}
				
				else if(j8.getText()==("O") && j3.getText()==(""))
				{
					j3.setText(put);
					j3.setEnabled(false);
					checkWin();
				}
				
				else if(j2.getText()==("O") && j7.getText()==("O") && j3.getText()==(""))
				{
					j3.setText(put);
					j3.setEnabled(false);
					checkWin();
				}
				
				else if(j8.getText()==("O") && j3.getText()==("O") && j7.getText()==(""))
				{
					j7.setText(put);
					j7.setEnabled(false);
					checkWin();
				}
			}
			
			else if((j5.getText()==("O") && j9.getText()==("X") && j2.getText()==("O") && j8.getText()==("X")  && j3.getText()==("X") && counter==1) || (j5.getText()==("O") && j9.getText()==("X") && j2.getText()==("X") && j8.getText()==("O") && j3.getText()==("X") && counter==1))
			{
				//System.out.println("10");
				if(j6.getText()==(""))
				{
					j6.setText(put);
					j6.setEnabled(false);
					checkWin();
				}
				
				else 
				{
					j4.setText(put);
					j4.setEnabled(false);
					checkWin();
				}
			}
			
			
			
			else if((j9.getText()==("O") && j3.getText()==("") && j7.getText()==("")))
			{
				//System.out.println("11");
				j3.setText(put);
				j3.setEnabled(false);
				checkWin();
			}
			
			else if((j9.getText()==("O") && j3.getText()==("X") && j2.getText()==("O")  && counter>3))
			{
				
				//System.out.println("12");
					j7.setText(put);
					j7.setEnabled(false);
					checkWin();
				
			
			}
			
			else if((j9.getText()==("O") && j3.getText()==("X") && j2.getText()==("")))
			{
				//System.out.println("13");
				
					j2.setText(put);
					j2.setEnabled(false);
					checkWin();
				
			
			}
			
			
			else if(j9.getText()==("O") && j2.getText()==("O") && j3.getText()==("X") && j7.getText()==("X") && counter<=3)
			{
				//System.out.println("14");
				if(j4.getText()==(""))
				{
					j4.setText(put);
					j4.setEnabled(false);
					checkWin();
				}
				
				else if(j5.getText()==(""))
				{
					j5.setText(put);
					j5.setEnabled(false);
					checkWin();
				}
			}
			
			else if((j6.getText()==("O") && j8.getText()==("") && j7.getText()==("") && j5.getText()==("") && counter>6) || (j8.getText()==("O") && j6.getText()==("") && j3.getText()==("") && j5.getText()==("") && counter>6))
			{
				//System.out.println("15");
				if(j6.getText()==("O"))
				{
					j7.setText(put);
					j7.setEnabled(false);
					checkWin();
				}
				
				else
				{
					j3.setText(put);
					j3.setEnabled(false);
					checkWin();
				}
			}
			
			else if((j6.getText()==("O")  && j7.getText()==("X") && j5.getText()==("")) || (j8.getText()==("O")  && j3.getText()==("X") && j5.getText()==("")))
			{
				//System.out.println("16");
				if(j4.getText()==("O") || j2.getText()==("O") )
				{
					j5.setText(put);
					j5.setEnabled(false);
					checkWin();
				}
				
				else if(j7.getText()==("X"))
				{
					j4.setText(put);
					j4.setEnabled(false);
					checkWin();
				}
				
				else if(j3.getText()==("X"))
				{
					j2.setText(put);
					j2.setEnabled(false);
					checkWin();
				}
			}
			
			else if((j6.getText()==("O") && j4.getText()==("O") && j7.getText()==("X") && j5.getText()==("X")) || (j6.getText()==("O") && j2.getText()==("O") && j3.getText()==("X") && j5.getText()==("X")))
			{
				//System.out.println("17");
				if(j6.getText()==("O") && j3.getText()==(""))
				{
					j3.setText(put);
					j3.setEnabled(false);
					checkWin();
				}
				
				else if(j6.getText()==("O") && j9.getText()==(""))
				{
					j9.setText(put);
					j9.setEnabled(false);
					checkWin();
				}
				
				else if(j8.getText()==("O") && j7.getText()==(""))
				{
					j7.setText(put);
					j7.setEnabled(false);
					checkWin();
				}
				
				else if(j8.getText()==("O") && j9.getText()==(""))
				{
					j9.setText(put);
					j9.setEnabled(false);
					checkWin();
				}
				
				
			}
			
			else if((j2.getText()==("O") && j4.getText()==("") && j7.getText()==("")) || (j2.getText()==("") && j4.getText()==("O") &&  j3.getText()==("")) || (j3.getText()==("O") && j7.getText()==("")) || (j3.getText()==("") && j7.getText()==("O")))
			{
				//System.out.println("18");
				if(j2.getText()==("O") || j3.getText()==("O"))
				{
					j7.setText(put);
					j7.setEnabled(false);
					checkWin();
				}
				
				else
				{
					j3.setText(put);
					j3.setEnabled(false);
					checkWin();
				}
			}
			
			else if((j2.getText()==("O") && j4.getText()==("O") && j9.getText()==("")) || (j3.getText()==("O") && j4.getText()==("O") && j9.getText()==("")) || (j2.getText()==("O") && j7.getText()==("O") && j9.getText()==("")) || (j7.getText()==("X") && j4.getText()==("")) || (j3.getText()==("X") && j2.getText()==("")))
			{
				//System.out.println("19");
				//System.out.println("Func 3");
				
				if((j7.getText()==("X") && j4.getText()==("")) || (j3.getText()==("X") && j2.getText()==("")))
				{
					if(j4.getText()==(""))
					{
						j4.setText(put);
						j4.setEnabled(false);
						checkWin();
					}
					
					else
					{
						j2.setText(put);
						j2.setEnabled(false);
						checkWin();
					}
				}
				
				else
				{
					j9.setText(put);
					j9.setEnabled(false);
					checkWin();
				}
				
			}
			
			else if((j2.getText()==("O") && j4.getText()==("O") && j9.getText()==("X")) || (j3.getText()==("O") && j4.getText()==("O") && j9.getText()==("X")) || (j2.getText()==("O") && j7.getText()==("O") && j9.getText()==("X")))
			{
				//System.out.println("20");
				if(j5.getText()==("O") && j7.getText()==("X"))
				{
					j8.setText(put);
					j8.setEnabled(false);
					checkWin();
				}
				
				else if(j5.getText()==("O") && j3.getText()==("X"))
				{
					j6.setText(put);
					j6.setEnabled(false);
					checkWin();
				}
				
				else if(j8.getText()==("O") || j6.getText()==("X"))
				{
					j5.setText(put);
					j5.setEnabled(false);
					checkWin();
				}
				
				else
				{
					j5.setText(put);
					j5.setEnabled(false);
					checkWin();
				}
				
			}
			
		}
		
		public void timerCpuAi() {
			// TODO Auto-generated method stub
			
			Random r = new Random();
			
			fulb = r.nextInt((6-0)+1) + 0;
			
			if(fulb==0)
			{
				j1.setText("X");
				j1.setEnabled(false);
				j1.setBackground(Color.RED);
				
				j4.setText("X");
				j4.setEnabled(false);
				j4.setBackground(Color.RED);
				
				j7.setText("X");
				j7.setEnabled(false);
				j7.setBackground(Color.RED);
				
				j3.setText("O");
				j3.setEnabled(false);
				
				j5.setText("O");
				j5.setEnabled(false);
				
				j2.setEnabled(false);
				j6.setEnabled(false);
				j8.setEnabled(false);
				j9.setEnabled(false);
				
				
			}
			
			else if(fulb==1)
			{
				j5.setText("X");
				j5.setEnabled(false);
				j5.setBackground(Color.RED);
				
				j4.setText("X");
				j4.setEnabled(false);
				j4.setBackground(Color.RED);
				
				j6.setText("X");
				j6.setEnabled(false);
				j6.setBackground(Color.RED);
				
				j1.setText("O");
				j1.setEnabled(false);
				
				j2.setText("O");
				j2.setEnabled(false);
				
				j3.setText("X");
				j3.setEnabled(false);
				
				j7.setText("O");
				j7.setEnabled(false);
				
				j8.setEnabled(false);
				j9.setEnabled(false);
			}
			
			else if(fulb==2)
			{
				j3.setText("X");
				j3.setEnabled(false);
				j3.setBackground(Color.RED);
				
				j9.setText("X");
				j9.setEnabled(false);
				j9.setBackground(Color.RED);
				
				j6.setText("X");
				j6.setEnabled(false);
				j6.setBackground(Color.RED);
				
				j1.setText("X");
				j1.setEnabled(false);
				
				j4.setText("O");
				j4.setEnabled(false);
				
				j7.setText("O");
				j7.setEnabled(false);
				
				j2.setText("O");
				j2.setEnabled(false);
				
				j5.setEnabled(false);
				j8.setEnabled(false);
				
			}
			
			else if(fulb==3)
			{
				j3.setText("X");
				j3.setEnabled(false);
				j3.setBackground(Color.RED);
				
				j2.setText("X");
				j2.setEnabled(false);
				j2.setBackground(Color.RED);
				
				j1.setText("X");
				j1.setEnabled(false);
				j1.setBackground(Color.RED);
				
				j9.setText("O");
				j9.setEnabled(false);
				
				j7.setText("O");
				j7.setEnabled(false);
				
				j4.setEnabled(false);
				j6.setEnabled(false);
				j8.setEnabled(false);
				j5.setEnabled(false);
			}
			
			else if(fulb==4)
			{
				j5.setText("X");
				j5.setEnabled(false);
				j5.setBackground(Color.RED);
				
				j9.setText("X");
				j9.setEnabled(false);
				j9.setBackground(Color.RED);
				
				j1.setText("X");
				j1.setEnabled(false);
				j1.setBackground(Color.RED);
				
				j4.setText("O");
				j4.setEnabled(false);
				
				j7.setText("O");
				j7.setEnabled(false);
				
				j2.setEnabled(false);
				j3.setEnabled(false);
				j8.setEnabled(false);
				j6.setEnabled(false);
			}
			
			else if(fulb==5)
			{
				j4.setText("X");
				j4.setEnabled(false);
				j4.setBackground(Color.RED);
				
				j7.setText("X");
				j7.setEnabled(false);
				j7.setBackground(Color.RED);
				
				j1.setText("X");
				j1.setEnabled(false);
				j1.setBackground(Color.RED);
				
				j3.setText("O");
				j3.setEnabled(false);
				
				j5.setText("O");
				j5.setEnabled(false);
				
				j9.setText("O");
				j9.setEnabled(false);
				
				j6.setText("X");
				j6.setEnabled(false);
				
				j8.setEnabled(false);
			}
			
			else if(fulb==6)
			{
				j3.setText("X");
				j3.setEnabled(false);
				j3.setBackground(Color.RED);
				
				j2.setText("X");
				j2.setEnabled(false);
				j2.setBackground(Color.RED);
				
				j1.setText("X");
				j1.setEnabled(false);
				j1.setBackground(Color.RED);
				
				j5.setText("O");
				j5.setEnabled(false);
				
				j7.setText("O");
				j7.setEnabled(false);
				
				j4.setEnabled(false);
				j6.setEnabled(false);
				j8.setEnabled(false);
				j9.setEnabled(false);
			}
			
			jf.setText("     AI Wins!");
			
			fulb++;
			
			//resetGame();
		}
		
		public class jbevent implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int stat;
				
				//System.out.println("charCount inside jbevent: "+ charCount);
				
				if(mode==1)
				{
					System.out.println("mode 1");
					
					put = "";
					if(charCount%2==0)
					{
						put = "X";
						jf.setText("   " + strUsr2+"'s turn");
					}
					
					else
					{
						put = "O";
						jf.setText("   " + strUsr1+"'s turn");
					}
					
					charCount++;
					
					if(e.getSource()==j1)
					{
						j1.setText(put);
						j1.setEnabled(false);
					}
					
					else if(e.getSource()==j2)
					{
						j2.setText(put);
						j2.setEnabled(false);
					}
					
					else if(e.getSource()==j3)
					{
						j3.setText(put);
						j3.setEnabled(false);
					}
					else if(e.getSource()==j4)
					{
						j4.setText(put);
						j4.setEnabled(false);
					}
					else if(e.getSource()==j5)
					{
						j5.setText(put);
						j5.setEnabled(false);
					}
					else if(e.getSource()==j6)
					{
						j6.setText(put);
						j6.setEnabled(false);
					}
					else if(e.getSource()==j7)
					{
						j7.setText(put);
						j7.setEnabled(false);
					}
					else if(e.getSource()==j8)
					{
						j8.setText(put);
						j8.setEnabled(false);
					}
					else 
					{
						j9.setText(put);
						j9.setEnabled(false);
					}
					
					stat = b.checkState();
					
					if(stat==1 || stat==2)
					{
					
						if(stat==1)
						{
							if(put.equals("O"))
							{
								jf.setText("   "+ strUsr2 + "(O Wins!)");
								//System.out.println();
							}
							
							else
							{
								jf.setText("   " + strUsr1+"(X Wins!)");
								//System.out.println("X Wins!");
								//System.out.println();
							}
						}
						
						else
						{
							jf.setText("    Tie");
						}
						
						gg.resetGame();
					}
				}
				
				else if(mode==2)
				{
					System.out.println("mode 2");
					
					put = "";
					if(charCount%2==0)
					{
						put = "X";
						
						//jf.setText("  Computer turn");
					}
					
					else
					{
						put = "O";
						
						//jf.setText("   " + strUsr1+"turn");
					}
					
					charCount++;
					
					if(e.getSource()==j1)
					{
						j1.setText(put);
						j1.setEnabled(false);
						
					}
					
					else if(e.getSource()==j2)
					{
						j2.setText(put);
						j2.setEnabled(false);
					}
					
					else if(e.getSource()==j3)
					{
						j3.setText(put);
						j3.setEnabled(false);
					}
					else if(e.getSource()==j4)
					{
						j4.setText(put);
						j4.setEnabled(false);
					}
					else if(e.getSource()==j5)
					{
						j5.setText(put);
						j5.setEnabled(false);
					}
					else if(e.getSource()==j6)
					{
						j6.setText(put);
						j6.setEnabled(false);
					}
					else if(e.getSource()==j7)
					{
						j7.setText(put);
						j7.setEnabled(false);
					}
					else if(e.getSource()==j8)
					{
						j8.setText(put);
						j8.setEnabled(false);
					}
					else 
					{
						j9.setText(put);
						j9.setEnabled(false);
					}
					
					stat = b.checkState();
					
					if(stat==1 || stat==2)
					{
					
						if(stat==1)
						{
							if(put.equals("O"))
							{
								jf.setText(" Computer  "+  "(O Wins!)");
								//System.out.println();
							}
							
							else
							{
								jf.setText("   " + strUsr1+"(X Wins!)");
								//System.out.println("X Wins!");
								//System.out.println();
							}
						}
						
						else
						{
							jf.setText("    Tie");
						}
						
						gg.resetGame();
						return;
					}
					
					gg.tileClickedRandom();
					
				}
				
				else if(mode==4)
				{
					
					System.out.println("mode 4");
					
					put = "";
					if(charCount%2==0)
					{
						put = "O";
						
						//jf.setText("  Computer turn");
					}
					
					else
					{
						put = "X";
						
						//jf.setText("   " + strUsr1+"turn");
					}
					
					charCount++;
					
					if(e.getSource()==j1)
					{
						j1.setText(put);
						j1.setEnabled(false);
						
					}
					
					else if(e.getSource()==j2)
					{
						j2.setText(put);
						j2.setEnabled(false);
					}
					
					else if(e.getSource()==j3)
					{
						j3.setText(put);
						j3.setEnabled(false);
					}
					else if(e.getSource()==j4)
					{
						j4.setText(put);
						j4.setEnabled(false);
					}
					else if(e.getSource()==j5)
					{
						j5.setText(put);
						j5.setEnabled(false);
					}
					else if(e.getSource()==j6)
					{
						j6.setText(put);
						j6.setEnabled(false);
					}
					else if(e.getSource()==j7)
					{
						j7.setText(put);
						j7.setEnabled(false);
					}
					else if(e.getSource()==j8)
					{
						j8.setText(put);
						j8.setEnabled(false);
					}
					else 
					{
						j9.setText(put);
						j9.setEnabled(false);
					}
					
					stat = b.checkState();
					
					if(stat==1 || stat==2)
					{
					
						if(stat==1)
						{
							if(put.equals("O"))
							{
								jf.setText(" AI "+  "(O Wins!)");
								//System.out.println();
							}
							
							else
							{
								jf.setText("   " + strUsr1+"(X Wins!)");
								//System.out.println("X Wins!");
								//System.out.println();
							}
						}
						
						else
						{
							jf.setText("    Tie");
						}
						
						gg.resetGame();
						return;
					}
					
					gg.tileClickedAI();
				}
					
				
				
				//gg.reset();
							
				
				
			}
			
		}
		
		
		
	}
	

	public class board
	{		
			char[][] grid = new char[3][3];

			public board()
			{
				for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{
						grid[i][j] = '-';
					}
				}
			}
			
			public char put(int x,int y,char val)
			{
				if(x>2 || y>2 || grid[x][y]!='-')
				{
					System.out.println("Invalid coordinates. Please enter again");
					
					return 'Y';
				}
				
				else
				{
					grid[x][y] = val;
					
					print();
					
					System.out.print("\n");
					
					return val;
				}
				
				
			}
			
			
			
			public char[][] get()
			{
				return grid;
			}
			
			public void print()
			{
				for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{
						System.out.print(grid[i][j] + " ");
					}
					
					System.out.println();
				}
			}
			
			public int checkState()
			{
				
				
				
				
				if((j1.getText() == "X" && j1.getText() == j2.getText() && j2.getText()==j3.getText() )|| 
					(j4.getText()=="X" && j4.getText() == j5.getText() && j5.getText()==j6.getText()) ||
					(j7.getText()=="X" && j7.getText() == j8.getText() && j8.getText()==j9.getText()))
				{
					if(j1.getText() == "X" && j1.getText() == j2.getText() && j2.getText()==j3.getText() )
					{
						j1.setBackground(Color.RED);
						j2.setBackground(Color.RED);
						j3.setBackground(Color.RED);
					}
					
					else if(j4.getText()=="X" && j4.getText() == j5.getText() && j5.getText()==j6.getText())
					{
						j4.setBackground(Color.RED);
						j5.setBackground(Color.RED);
						j6.setBackground(Color.RED);
					}
					
					else
					{
						j7.setBackground(Color.RED);
						j8.setBackground(Color.RED);
						j9.setBackground(Color.RED);
					}
					
					return 1;
				}
				
				if((j1.getText() == "O" && j1.getText() == j2.getText() && j2.getText()==j3.getText() )|| 
					(j4.getText()=="O" && j4.getText() == j5.getText() && j5.getText()==j6.getText()) ||
					(j7.getText()=="O" && j7.getText() == j8.getText() && j8.getText()==j9.getText()))
				{
					
					if(j1.getText() == "O" && j1.getText() == j2.getText() && j2.getText()==j3.getText() )
					{
						j1.setBackground(Color.RED);
						j2.setBackground(Color.RED);
						j3.setBackground(Color.RED);
					}
					
					else if(j4.getText()=="O" && j4.getText() == j5.getText() && j5.getText()==j6.getText())
					{
						j4.setBackground(Color.RED);
						j5.setBackground(Color.RED);
						j6.setBackground(Color.RED);
					}
					
					else
					{
						j7.setBackground(Color.RED);
						j8.setBackground(Color.RED);
						j9.setBackground(Color.RED);
					}
					
					return 1;
				}
					
				
				
				if((j1.getText() == "X" && j1.getText() == j4.getText() && j4.getText()==j7.getText() )|| 
					(j2.getText()=="X" && j2.getText() == j5.getText() && j5.getText()==j8.getText()) ||
					(j3.getText()=="X" && j3.getText() == j6.getText() && j6.getText()==j9.getText()))
				{
					if(j1.getText() == "X" && j1.getText() == j4.getText() && j4.getText()==j7.getText())
					{
						j1.setBackground(Color.RED);
						j4.setBackground(Color.RED);
						j7.setBackground(Color.RED);
					}
					
					else if(j2.getText()=="X" && j2.getText() == j5.getText() && j5.getText()==j8.getText())
					{
						j2.setBackground(Color.RED);
						j5.setBackground(Color.RED);
						j8.setBackground(Color.RED);
					}
					
					else
					{
						j3.setBackground(Color.RED);
						j6.setBackground(Color.RED);
						j9.setBackground(Color.RED);
					}
					return 1;
				}
				
				if((j1.getText() == "O" && j1.getText() == j4.getText() && j4.getText()==j7.getText() )|| 
					(j2.getText()=="O" && j2.getText() == j5.getText() && j5.getText()==j8.getText()) ||
					(j3.getText()=="O" && j3.getText() == j6.getText() && j6.getText()==j9.getText()))
				{
					
					if(j1.getText() == "O" && j1.getText() == j4.getText() && j4.getText()==j7.getText())
					{
						j1.setBackground(Color.RED);
						j4.setBackground(Color.RED);
						j7.setBackground(Color.RED);
					}
					
					else if(j2.getText()=="O" && j2.getText() == j5.getText() && j5.getText()==j8.getText())
					{
						j2.setBackground(Color.RED);
						j5.setBackground(Color.RED);
						j8.setBackground(Color.RED);
					}
					
					else
					{
						j3.setBackground(Color.RED);
						j6.setBackground(Color.RED);
						j9.setBackground(Color.RED);
					}
					
					return 1;
				}
		
				
				if(j1.getText() == "X" && j1.getText()==j5.getText() && j5.getText()==j9.getText())
				{
					j1.setBackground(Color.red);
					j5.setBackground(Color.red);
					j9.setBackground(Color.red);
					
					return 1;
				}
				
				if(j1.getText() == "O" && j1.getText()==j5.getText() && j5.getText()==j9.getText())
				{
					j1.setBackground(Color.red);
					j5.setBackground(Color.red);
					j9.setBackground(Color.red);
			
					return 1;
				}
				
				if(j3.getText() == "X" && j3.getText()==j5.getText() && j5.getText()==j7.getText())
				{
					j3.setBackground(Color.red);
					j5.setBackground(Color.red);
					j7.setBackground(Color.red);
					return 1;
				}
				
				if(j3.getText() == "O" && j3.getText()==j5.getText() && j5.getText()==j7.getText())
				{
					j3.setBackground(Color.red);
					j5.setBackground(Color.red);
					j7.setBackground(Color.red);
					return 1;
				}
				
				if(!(j1.getText()=="") && !(j2.getText()=="") && !(j3.getText()=="") && !(j4.getText()=="") && !(j5.getText()=="") && !(j6.getText()=="") && !(j7.getText()=="") && !(j8.getText()=="") && !(j9.getText()==""))
				{
					return 2;
				}
				
				return 0;
	}
	

	
	
	}
	

}
	

	



