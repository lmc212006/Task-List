package com.laaksh.GUI;

import java.awt.event.*;
import javax.swing.*;

public class GUI implements ActionListener 
{    
	JButton sub;
	JFrame frame;
	JTextField edit;
	JPanel panel;
	JLabel head;
	JButton but;
	JButton addTask;
	int yPos = 50;
	boolean isEmptySpace = false;
	JTextField inp;
	JTextField tempLab;
	
	public GUI()
	{
	    head = new JLabel();
	    frame = new JFrame();
	    panel = new JPanel();
	    addTask = new JButton();
	
	    frame.setSize(100,100);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setAlwaysOnTop(true);
	    frame.setVisible(true);
	    frame.add(panel);
	
	    panel.setLayout(null);
	
	    head.setText("TODO LIST:");
	    head.setFont(head.getFont().deriveFont(20.0f));
	    head.setSize(100,100);
	    head.setBounds(0,10,125,20);
	    addTask.setText("Add Task");
	    addTask.setBounds(10,yPos,125,20);
	    addTask.addActionListener(this);
	    addTask.setActionCommand("add");
	    panel.add(head);
	    panel.add(addTask);
	}
	
	public static void main(String[] args) 
	{
	    new GUI();    
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	    if ("add".equals(e.getActionCommand()))
	    {
	        inp = new JTextField();
	        sub = new JButton();
	        sub.setText("Enter");
	        sub.setSize(10,10);
	        sub.setBounds(150,yPos,100,20);
	        sub.addActionListener(this);
	        sub.setActionCommand("selTask");
	        inp.setBounds(10,yPos,125,20);
	        panel.add(sub);
	        panel.add(inp);  
	        frame.setVisible(false);
	        frame.setVisible(true);
	        yPos += 30;
	        addTask.setEnabled(false);
	
	        addTask.setBounds(10,yPos,125,20);
	    }
	
	    if ("selTask".equals(e.getActionCommand()))
	    {
	        String task = inp.getText();
	        tempLab = new JTextField(task);
	        tempLab.setBounds(10,yPos - 25,125,20);
	        tempLab.addActionListener(this);
	
	        panel.remove(inp);
	        panel.remove(sub);
	        panel.add(tempLab);
	        addTask.setEnabled(true);
	        frame.setVisible(false);
	        frame.setVisible(true);
	    }
	    
	    if ("delete/edit".equals(e.getActionCommand()))
	    {
	        edit = new JTextField(tempLab.getText());
	        but = new JButton("Edit");
	        but.setBounds(150,tempLab.getBounds().y,100,20);
	        but.setSize(70,20);
	        but.addActionListener(this);
	        but.setActionCommand("edit");
	        edit.setBounds(tempLab.getBounds());
	        panel.remove(tempLab);
	        panel.add(edit);
	        panel.add(but);
	        frame.setVisible(false);
	        frame.setVisible(true);
	    }
	
	    if ("edit".equals(e.getActionCommand()))
	    {
	        String task = edit.getText();
	        if (task.isEmpty())
	        {
	            System.out.println("done");
	            panel.remove(but);
	            panel.remove(edit);
	            frame.setVisible(false);
	            frame.setVisible(true);
	            isEmptySpace = true;
	            return;
	
	        }
	        tempLab = new JTextField(task);
	        tempLab.setBounds(edit.getBounds());
	        tempLab.addActionListener(this);
	
	        System.out.println("dk");
	        panel.add(tempLab);
	        panel.remove(edit);
	        panel.remove(but);
	        frame.setVisible(false);
	        frame.setVisible(true);
	    }
	}
}
