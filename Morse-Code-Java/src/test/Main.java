package test;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {
	static char[] en = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	static String[] mo = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
			"...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
	
	Container c = getContentPane();
	
	JTextField inTF = new JTextField();
	JTextField outTF = new JTextField();
	
	JButton translate = new JButton("Translate");
	JButton reset = new JButton("Reset");
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Morse Code Translator");
		setVisible(true);
		setSize(500, 300);
		
		Font font = new Font("Consolas", Font.PLAIN, 15);
		
		c.setLayout(new FlowLayout());
		inTF.setPreferredSize(new Dimension(450, 100));
		inTF.setFont(font);
		inTF.requestFocusInWindow();
		outTF.setFont(font);
		outTF.setPreferredSize(new Dimension(450, 100));
		c.add(inTF);
		c.add(translate);
		c.add(reset);
		c.add(outTF);
		
		inTF.addActionListener(this);
		outTF.addActionListener(this);
		translate.addActionListener(this);
		reset.addActionListener(this);
	}

	static String motoen(String input) {
		for (int i = 0; i < 26; i++) {
			if (input.equals(mo[i])) {
				return String.valueOf(en[i]);
			} else if (input.equals("/")) {
				return " ";
			}
		}
		return "";
	}
	
	static String entomo(String input) {
		String text = new String();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == ' ') {
				text = text.concat("/ ");
			} else {
				for (int j = 0; j < 26; j++) {
					if (c == en[j] || c == en[j + 26]) {
						text = text.concat(mo[j] + " ");
					}
				}
			}
		}
		
		return text;
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Translate")) {
			String input = inTF.getText();
			if (input.charAt(0) == '.' || input.charAt(0) == '-') {
				StringTokenizer s = new StringTokenizer(input);
				String text = new String();
				while(s.hasMoreTokens()) {
					text = text.concat(motoen(s.nextToken(" ")));
				}
				outTF.setText(text);
			} else {
				String text = entomo(input);
				outTF.setText(text);
			}
		}
		
		if (e.getActionCommand().equals("Reset")) {
			inTF.setText("");
			inTF.requestFocusInWindow();
			outTF.setText("");
		}
	}
}