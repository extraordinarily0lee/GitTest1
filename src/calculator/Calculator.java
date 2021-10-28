package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class Calculator {
    private int num;
    private int caler1 = -1;
    private int caler2 = -1;
    private String calor = null;
    private float result = 0;
	Frame frame = new Frame("计算器");
	Panel aPanel = new Panel(new GridLayout(4, 4, 5, 5));
	TextField aField = new TextField(20);
	TextField bField = new TextField(20);
	Button[] aButtons = new Button[16];
	Dialog aDialog = new Dialog(frame, "提示", true);
	public void run(){
		for(int a=0;a<10;a++) {
			aButtons[a] = new Button(""+a);
		}
		aButtons[10] = new Button("+");
		aButtons[11] = new Button("-");
		aButtons[12] = new Button("*");
		aButtons[13] = new Button("/");
		aButtons[14] = new Button(".");
		aButtons[15] = new Button("=");
		for(int a = 0;a<16;a++) {
			aPanel.add(aButtons[a]);
		}
		aDialog.add(bField);
		frame.add(aField,BorderLayout.NORTH);
		frame.add(aPanel,BorderLayout.CENTER);
		aField.setFont(new Font("实验字体",Font.BOLD, 60));
		bField.setFont(new Font("实验字体",Font.BOLD, 20));
		aField.setEditable(false);
		bField.setEditable(false);
		//关闭窗口
		frame.addWindowListener(new WindowListener() {
			
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
		aDialog.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				aDialog.setVisible(false);
			}
		});
		
		//数字
		for(num = 0;num<10;num++) {
			aButtons[num].addActionListener(new ActionListener() {
				int n = num;
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					aField.setText(""+n);
					if(caler1==-1) {
						caler1 = n;
					}
					else {
						caler2 = n;
					}
					if(caler1!=-1&&caler2!=-1&&calor==null) {
						bField.setText("只能算一位数");
						aDialog.setVisible(true);
						caler1 = -1;
						caler2 = -1;
						calor = null;
						aField.setText("");
					}
				}
			});
		}
		//符号
		for(num = 0;num<4;num++) {
			aButtons[num+10].addActionListener(new ActionListener() {
			    String nowcalor = aButtons[num+10].getLabel();
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					aField.setText(nowcalor);
					calor = nowcalor;
					if(caler1==-1) {
						bField.setText("语法错误");
						aDialog.setVisible(true);
						calor = null;
						aField.setText("");
					}
				}
			});
		}
		
		//等号
		aButtons[15].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(calor==null||caler1==-1||caler2==-1) {
					bField.setText("语法错误");
					aDialog.setVisible(true);
					caler1 = -1;
					caler2 = -1;
					calor = null;
					aField.setText("");
					return;
				}
				switch (calor) {
				case "+":
					result = caler1+caler2;
					aField.setText(""+result);
					break;
				case "-":
					result = caler1-caler2;
					aField.setText(""+result);
					break;
				case "*":
					result = caler1*caler2;
					aField.setText(""+result);
					break;
				case "/":
					result = (float)caler1/caler2;
					aField.setText(""+result);
					break;
				default:
					break;
				}
				caler1 = -1;
				caler2 = -1;
				calor = null;
			}
		});
		
		
		//小数点
		aButtons[14].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bField.setText("功能暂未添加");
				aDialog.setVisible(true);
			}
		});
		frame.pack();
		aDialog.pack();
		frame.setBounds(300, 200, 600, 300);
		aDialog.setBounds(300, 200, 600, 80);
		frame.setVisible(true);
	}
}
