package clock;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class GUI extends JFrame {

	JLabel time;

	public GUI(String title) {
		setWindowInfo();
		this.setTitle(title);
		time = new JLabel();
		time.setFont(new Font("Verdana", Font.PLAIN, 105));
		time.setForeground(Color.WHITE);
		time.setHorizontalAlignment(JLabel.CENTER);
		this.add(time);
	}

	public void setWindowInfo() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(650, 200);

		Color c = new ColorUIResource(24, 24, 24);
		this.getContentPane().setBackground(c);

		this.setResizable(false);
		this.setVisible(true);
	}

	public void updateLabel(String timeText) {
		this.time.setText(timeText);
	}

}
