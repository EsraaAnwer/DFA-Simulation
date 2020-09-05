/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autumata;


import javax.swing.*;
import javax.swing.table.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Color;
public class aut extends JFrame implements ActionListener,  KeyListener{
	
	 
	JPanel panel;
	
	
	JButton but1,but2,but3,but4,but5;
	
	
	
	
	JLabel lab1,lab2,lab3,lab4,lab5;

	JTable tabel;
	
	//jtabel 
	
	File f=null;
	JFileChooser filech;
	///jFile chossser
	
	JTextArea area;
	// Jtextarea
	JTextField Field1,Field2,Field3;
	//jtextfield
	JScrollPane Spane;
	
	
			DefaultTableModel model;
			
	String col[]=new String[]{"State","Input Symbol","Next State"};
	
	String data[][]=new String[][]{{"","",""}};
	
	
	public aut(){
		
		setLayout(null);
		
		but1=new JButton("New");
		
		but2=new JButton("Load");
		
		but3=new JButton("Save");
		
		but5=new JButton("close");
		
		
		
		
		but4=new JButton("Accepted");
		
		lab1=new JLabel("Transition Function");
		lab2=new JLabel("Initial State");
		lab3=new JLabel("Final State");
		lab4=new JLabel("Input");
		lab5=new JLabel("Output");
		Field1=new JTextField();
		Field2=new JTextField();
		Field3=new JTextField();
		area=new JTextArea();				
		Spane=new JScrollPane();
		
		
		
		model = new DefaultTableModel(data, col);
		
		
		
		tabel=new JTable(model);
              		tabel.addKeyListener(this);
		
				JTableHeader header = tabel.getTableHeader();
		header.setBackground(Color.yellow);
		
		
			Spane=new JScrollPane(tabel);
			
		panel=new JPanel();
		
		panel.setBounds(20,80,480,430);
		panel.setVisible(true);
		panel.add(Spane);
		this.add(panel);
		but1.setBounds(60,20,100,30);
		
		but2.setBounds(170,20,100,30);
		but3.setBounds(280,20,100,30);
		but5.setBounds(390,20,100,30);
		but5.setEnabled(false);
		but3.setEnabled(false);
		this.add(but1);
		this.add(but2);
		this.add(but3);
		this.add(but5);
		
		but1.addActionListener(this);
		but2.addActionListener(this);
		but3.addActionListener(this);
		but5.addActionListener(this);		
						
		lab1.setBounds(20,50,480,20);
		lab1.setHorizontalTextPosition(JLabel.CENTER);
		lab1.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(lab1);
		lab2.setBounds(520,140,100,30);
		Field1.setBounds(650,140,100,30);
		this.add(lab2);
		this.add(Field1);
		lab3.setBounds(520,200,100,30);
		Field2.setBounds(650,200,100,30);
		this.add(lab3);
		this.add(Field2);
		lab4.setBounds(520,260,100,30);
		Field3.setBounds(650,260,100,30);		
		this.add(lab4);		
		this.add(Field3);
		but4.setBounds(610,320,120,30);
		this.add(but4);
		but4.addActionListener(this);
		lab5.setBounds(400,520,130,30);	
			this.add(lab5);	
		area.setBounds(20,550,940,100);
		
		area.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		
		this.add(area);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
		setSize(1000,700);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e){

		Methods m=new Methods();
		if(e.getSource()==but1){
			
			
			filech=new JFileChooser();
			
			int status=filech.showSaveDialog(this);
			
			if(status==JFileChooser.APPROVE_OPTION){
			
			
			but3.setEnabled(true);
			but5.setEnabled(true);
			but1.setEnabled(false);
			but2.setEnabled(false);
			
			
				f=filech.getSelectedFile();
				
				try{
				
				FileOutputStream ff=new FileOutputStream(f);
				System.out.println (f.getPath());
				}catch(Exception er){
					
				}			
								
			}
		 
		}
		if(e.getSource()==but2){
			filech=new JFileChooser();
			int status=filech.showOpenDialog(this);
			if(status==JFileChooser.APPROVE_OPTION){
							but3.setEnabled(true);
			but5.setEnabled(true);
			but1.setEnabled(false);
			but2.setEnabled(false);
			
				
			m.deserialzeAddress(model,filech.getSelectedFile());
			}
			
		}
		
		if(e.getSource()==but3){
			
			m.serializeAddress(tabel,f);
			but3.setEnabled(true);
			but5.setEnabled(true);
			but1.setEnabled(false);
			but2.setEnabled(false);
			
			
		}
		
		
		if(e.getSource()==but4){
			
		
	DFA d[]=m.readtab(tabel);
	
	String b=m.accepted(d,Field1.getText(),Field3.getText(),Field2.getText());
	area.setFont(new Font("Monospace",Font.BOLD,20));
	area.setForeground(Color.RED);
	area.setText(b);
	
	System.out.println (b);
	
		}
		if(e.getSource()==but5){
						but3.setEnabled(false);
			but5.setEnabled(false);
			but1.setEnabled(true);
			but2.setEnabled(true);
			
		}
	}
	
public void keyPressed(KeyEvent e) {
	
if (e.getKeyCode()==KeyEvent.VK_ENTER) {
	
model.addRow(new Object[]{"", "","",""}); } }
public void keyReleased(KeyEvent e) { }
public void keyTyped(KeyEvent e) { } 
	
}