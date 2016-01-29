package com.samirrk.trial;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GIUTest implements ActionListener
{
	JFrame frame;
	JButton btnColor;
	int x, y;
	
	public static void main(String[] args)
	{
		GIUTest gt = new GIUTest();
		gt.go();
	}
	
	public void go()
	{
		x = 70;
		y = 70;
		frame = new JFrame();
		btnColor = new JButton("Change colors");
		
		btnColor.addActionListener(this);
		
		AnimPanel drawPanel = new AnimPanel();
		
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.SOUTH, btnColor);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		for (int i=0 ; i < 1300 ;i++)
		{
			shiftBall();
			try
			{
				Thread.sleep(50);
			}
			catch(Exception ex)
			{
				
			}
		}
	}
	
	public void shiftBall()
	{
		x ++;
		y ++;
		if (x > 300 || y > 300)
		{
			x = 70;
			y = 70;
		}
		frame.repaint();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		frame.repaint();
	}
	
	class AnimPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.orange);
			g.fillOval(x, y, 100, 100);
		}
	}
}
