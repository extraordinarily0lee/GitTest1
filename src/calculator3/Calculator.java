package calculator3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
	int num = 0;
	String result = null;
	String memory = "";
	boolean flag = false;
	StringBuilder aBuilder = new StringBuilder();
	Analyzer analyzer;
	
	JFrame aFrame = new JFrame("计算器");
	JPanel aJPanel = new JPanel(new GridLayout(5, 4, 2, 2));
	JPanel bJPanel = new JPanel();
	JTextField area = new JTextField();
	JButton[] a = new JButton[20];
	
	
	public void run() {
		
		analyzer = new AnalyzerImpl2();
		
		for(num = 0;num<10;num++) {
			a[num] = new JButton(""+num);
		}
		a[10] = new JButton("+");
		a[11] = new JButton("-");
		a[12] = new JButton("*");
		a[13] = new JButton("/");
		a[14] = new JButton(".");
		a[15] = new JButton("=");	
		a[16] = new JButton("MC");	
		a[17] = new JButton("MR");	
		a[18] = new JButton("MS");	
		a[19] = new JButton("DE");
		
		
		for (int i = 0; i < 4; i++) {
			aJPanel.add(a[16+i]);
		}
		for(num = 0;num<20;num++) {
			if(num<10) {
				a[num].setBackground(Color.white);
			}
			else if(num!=15) {
				a[num].setBackground(new Color(232,232,232));
			}
			else {
				a[num].setBackground(new Color(126,192,238));
			}
			a[num].setForeground(Color.black);
			a[num].setBorderPainted(false);
			a[num].setFont(new Font(Font.SERIF, Font.PLAIN, 18));
			a[num].setFocusPainted(false);
			if(num<16) {
				aJPanel.add(a[num]);
			}
		}
		
		
		
		area.setEditable(false);
		area.setFont(new Font("楷体", Font.BOLD, 63));
		area.setHorizontalAlignment(JTextField.RIGHT);
		area.setBorder(null);
		area.setBackground(new Color(181,181,181));
		bJPanel.setLayout(new BorderLayout());
		bJPanel.add(area);
		
		
		
		aFrame.getContentPane().add("North",bJPanel);
		aFrame.getContentPane().add("Center",aJPanel);
		aFrame.setLayout(null);
		aJPanel.setSize(586, 487);
		aJPanel.setLocation(0, 175);
		bJPanel.setSize(586, 175);
	    bJPanel.setLocation(0, 0);
		bJPanel.setBorder(BorderFactory.createMatteBorder(25, 3, 1, 3, new Color(181,181,181)));
		aJPanel.setBorder(BorderFactory.createMatteBorder(6, 3, 3, 3, new Color(181,181,181)));
		
		//关闭
		aFrame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		//数字
		for(num = 0;num<10;num++) {
			a[num].addActionListener(new ActionListener() {
				int n = num;
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(flag==true) {
						aBuilder.delete(0, aBuilder.length());
						area.setText(""+n);
						aBuilder.append(n);
						flag = false;
						return;
					}
					area.setText(area.getText()+n);
					aBuilder.append(n);
				}
			});
			
		}
		
		//符号
		a[15].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag = true;
/*测试*/		System.out.println("前台传入字符串："+aBuilder.toString());
				result = analyzer.cal(aBuilder.toString());
				if(result.equalsIgnoreCase("false")) {
					area.setText("语法错误！");
					return;
				}
				area.setText(result);
				aBuilder.delete(0, aBuilder.length());
				aBuilder.append(result);
			}
		});
		a[14].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(flag==true) {
					aBuilder.delete(0, aBuilder.length());
					area.setText(".");
					aBuilder.append(".");
					flag = false;
					return;
				}
				area.setText(area.getText()+".");
				aBuilder.append(".");
			}
		});
		a[10].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag = false;
				area.setText(area.getText()+"+");
				aBuilder.append("+");
			}
		});
		a[11].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag = false;
				area.setText(area.getText()+"-");
				aBuilder.append("-");
			}
		});
		a[12].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag = false;
				area.setText(area.getText()+"*");
				aBuilder.append("*");
			}
		});
		a[13].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag = false;
				area.setText(area.getText()+"/");
				aBuilder.append("/");
			}
		});
		a[16].addActionListener(new ActionListener() {         //MC
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				memory = "";
			}
		});
		a[17].addActionListener(new ActionListener() {        //MR
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aBuilder.append(memory);
				area.setText(area.getText()+memory);
			}
		});
		a[18].addActionListener(new ActionListener() {        //MS
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				memory = area.getText();
			}
		});
		a[19].addActionListener(new ActionListener() {       //DE
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tempString = area.getText();
				if(tempString.length()==0) {
					return;
				}
				area.setText(tempString.substring(0, tempString.length()-1));
				aBuilder.delete(0, aBuilder.length());
				aBuilder.append(tempString.substring(0, tempString.length()-1));
			}
		});
		a[18].addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				a[17].setBackground(new Color(126,192,238));
			}
		});
		a[16].addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				a[17].setBackground(new Color(232,232,232));
			}
		});
		
		
		
		
		//总
		for (num = 0; num < 20; num++) {
			a[num].addMouseListener(new MouseListener() {
				
				int n = num;
				Color tempColor = null;
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					if(n<10) {
						a[n].setBackground(Color.white);
					}
					else if(n!=15&&n!=17) {
						a[n].setBackground(new Color(232,232,232));
					}
					else if(n==15){
						a[n].setBackground(new Color(126,192,238));	
					}
					else if(n==17){
						a[n].setBackground(tempColor);	
					}
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					if(n==17) {
						tempColor = a[n].getBackground();
					}
					a[n].setBackground(new Color(255,245,225));
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		
		aFrame.pack();
		aFrame.setSize(600, 700);
		aFrame.setLocation(400, 100);
		aFrame.setVisible(true);
		aFrame.setResizable(false);
	}
}
