package com.epam.edu.observer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ObserverDemo {
	private JFrame frame = new JFrame("Observer Demo");
	private JButton ok = new JButton("OK");
	private JButton cancel = new JButton("Cancel");
	private JPanel panel = new JPanel();
	
	public void init() {
		panel.setLayout(new BorderLayout());
		panel.add(BorderLayout.NORTH,ok);
		panel.add(BorderLayout.CENTER,cancel);
		//panel.doLayout();
		frame.getContentPane().add(panel);
		frame.pack();
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("OK pressed: " + e.getSource());
			}
		});
		ok.addActionListener(new ColourChangerActionListener());
		cancel.addActionListener(new ColourChangerActionListener());
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("cancel pressed");
				
			}
		});
	}
	
	public static void main(String[] args) {
		ObserverDemo demo = new ObserverDemo();
		demo.init();
		demo.show();
	}
	
	
	
	public void show() {
		frame.setVisible(true);
	}
}
