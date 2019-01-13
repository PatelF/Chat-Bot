import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bot extends JFrame{
	
	//Typing Area
	private JTextField txtEnter = new JTextField();
	
	//Chat Area
	private JTextArea txtChat = new JTextArea();
	
	public Bot() {
		
		//Frame Attributes
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(590, 600);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setTitle("Java AI");
		
		//txtEnter Attributes
		txtEnter.setLocation(2, 530);
		txtEnter.setSize(580, 30);
		
		//txtEnter Action
		txtEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uText = txtEnter.getText();
				txtChat.append("You :" + uText + "\n");
			
				if(uText.contains("hi")) {
					botSay("Hello there!");
				}
				else if(uText.contains("how are you")) {
					botSay("I'm doing well, thanks");
				}
				else {
//					int decider = (int) (Math.random()*3+1);
//					if (decider == 1) {
//						botSay("I didn't get that");
//					}
//					else if (decider == 2) {
//						botSay("Please rephrase that");
//					}
//					else {
//						botSay("??");
//					}
					
					Desktop d = Desktop.getDesktop();
					try {
						d.browse(new URI(uText));
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				txtEnter.setText("");
				
			}
		});
		//txtChat Attributes
		txtChat.setLocation(15, 15);
		txtChat.setSize(555,500);
		txtChat.setEditable(false);
		
		//Add Items to Frame
		this.add(txtEnter);
		this.add(txtChat);
	}
	
	public void botSay(String s) {
		txtChat.append("AI: " + s + "\n");
	}
	
	public static void main(String[] args) {
		
		new Bot();
	}

}
