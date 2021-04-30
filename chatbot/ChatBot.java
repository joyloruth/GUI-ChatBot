package chatbot;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatBot extends JFrame {
	
	
	
	private JTextArea chatarea = new JTextArea();
	private JTextField chatbox = new JTextField();
	
	public ChatBot(){
						
		
		ChatEntries ce = new ChatEntries();
		
		 				
		JFrame frame = new JFrame();
		
		frame.setTitle("Chat with Amazon Customer Service");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		frame.setLayout(null);
		
		frame.setResizable(false);
		frame.setSize(600,600);
		
		
		frame.add(chatarea);
		frame.add(chatbox);
		
		
		chatarea.setBackground(Color.white);
		chatarea.setSize(580, 500);
		chatarea.setLocation(2,2);
		
		//CHATBOX TX
		chatbox.setBackground(Color.white);
		chatbox.setSize(580, 40);
		chatbox.setLocation(2, 510);
		
		
		

		chatbox.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				String gtext = chatbox.getText();
				gtext.toUpperCase();
				chatarea.append("YOU: " + gtext + "\n" + "\n");
				
				chatbox.setText("");
				
				//for(int i = 0; i < ce.intro.length; i++ )
					
					
				for(int i = 0; i < ce.intro.length; i++ ) {
					if(gtext.contains(ce.intro[i])) 
						bot("Hi, thanks for contacting Amazon. I'm Amazon's chat helper. " + "\n" + "How may I help you?");
					if(gtext.contains(ce.refund[i])) 
						bot("You can review the payment method that was refunded."  + "\n" + "Then check the status of your refund by visting the orders page.");
					if(gtext.contains(ce.intro[i])) 
							bot("Hi, thanks for contacting Amazon. I'm Amazon's chat helper. " + "\n" + "How may I help you?");}
				
				
				
			}
			
			
		});
		
		
		}
	
	private void bot(String string){
		chatarea.append("AMAZON ASSISTANT : " + string + "\n" + "\n" );
	}

	

}
