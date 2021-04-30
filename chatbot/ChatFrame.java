package chatbot;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class ChatFrame extends JFrame {
	
	private JTextArea chatarea = new JTextArea();
	private JTextField chatbox = new JTextField();
	private JLabel label = new JLabel();
	private JFrame frame = new JFrame();
	private ChatEntries ce = new ChatEntries();
	private ImageIcon icon = new ImageIcon("bot.png");
	
	private JScrollPane scroll = new JScrollPane(chatarea);
	
	
	public ChatFrame(){
	
	frame.setTitle("Chat with Amazon Customer Service");
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.setLayout(null);
	frame.setResizable(false);
	frame.setSize(750,500);
	frame.getContentPane().setBackground(Color.darkGray);
	
	frame.add(chatarea);
		//CHATTEXT AREA
		chatarea.setBackground(Color.white);
		chatarea.setLocation(20,20);
		chatarea.setSize(690, 350);
	
	frame.add(chatbox);
		//CHATBOX TX
		chatbox.setBackground(Color.white);
		chatbox.setSize(690, 30);
		chatbox.setLocation(20, 400);
	
	frame.setIconImage(icon.getImage());
	
	
	
	frame.add(scroll);
	
	Actionlistner();}

	
	
	void Actionlistner(){
	//CHATBOX ACTION LISTENER
	chatbox.addActionListener(new ActionListener()
	{
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
		
			String gtext = chatbox.getText();
			gtext.toUpperCase();
			
			
			chatarea.append("  | YOU | : "  + gtext + "\n" + "\n");
			
			chatbox.setText("");
			
			for(int i = 0; i < ce.intro.length; i++ )
			{
				//BOT REPLIES WITH A GREETING WHEN PROMPTED
				if(gtext.contains(ce.intro[i])) 
				{
					bot("Hi, thanks for contacting Amazon. I'm Amazon's chat helper. How may I help you?");
				}
				
				//BOT REPONDS TO CUSTOMERS INQUIRYING ABOUT A REFUND
				else if(gtext.contains(ce.refund[i]))
				{
					bot("You can review the payment method that was refunded. Then check the status of your refund by visting the orders page.");
				}
					
				//BOT REPONDS TO CUSTOMERS INQUIRYING ABOUT RETURNING A ITEM
				else if(gtext.contains(ce.returns[i]))
				{
					bot("I can help you return an item.");
				}
				
				//BOT RESPONDS TO CUSTOMER WANTING AN LIVE AGENT
				else if(gtext.contains(ce.agent[i])) 
				{
					bot("Please hold while I connect you to a live agent.");
				}
	
				
				else 
				
					//bot("nuh cuh");
					System.out.println("I don't understand. How may I help you?");
					/*System.out.println("You can say things like.");
					System.out.println("I want a refund.");
					System.out.println("I want to return an item.");
					System.out.println("Live agent."); */
				
				
				
				}
				
			
	}
		
		
	}); 
	
	}
	
	private void bot(String string){
		chatarea.append("  | AMAZON ASSISTANT | : " + string + "\n" + "\n" ); 

	
}
	}

