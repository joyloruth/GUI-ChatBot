package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener  {

	JFrame frame;
	JTextField field = new JTextField();
	JPanel panel;
	
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton additionButton, subtractionButton,multiplyButton,divideButton;
	JButton decimalButton, equalButton, deleteButton, clearButton;
	
	ImageIcon icon = new ImageIcon("CALC.png");
	
	Font font = new Font("Monospaced", Font.BOLD,30);
	
	double number1 = 0, number2=0, total=0;
	char operator;
	

	Calculator(){
		
		frame = new JFrame("Calculator App");
		//set JFrame background color
		frame.getContentPane().setBackground(Color.black);
		//set JFrame dimension width and height
		frame.setSize(420, 550);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		//sets that frame will not be able to be resized
		frame.setResizable(false);
		
		field.setBounds(50,40,300,50);
		field.setFont(font);
				
		additionButton = new JButton("+");
		subtractionButton = new JButton("-");
		multiplyButton = new JButton("*");
		divideButton = new JButton("/");
		decimalButton = new JButton(".");
		equalButton = new JButton("=");
		deleteButton = new JButton("<<<");
		clearButton = new JButton("AC");
		
		functionButtons[0] = additionButton;
		functionButtons[1] = subtractionButton;
		functionButtons[2] = multiplyButton;
		functionButtons[3] = divideButton;
		functionButtons[4] = decimalButton;
		functionButtons[5] = equalButton;
		functionButtons[6] = deleteButton;
		functionButtons[7] = clearButton;
		
		for(int i = 0; i<8; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(font);
			functionButtons[i].setFocusable(false);
			
		}
		
		for(int i = 0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(font);
			
		}
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.BLACK);
		
		
//****FUNCTION BUTTONS
		
		//ADDITION BUTTON
			additionButton.setBackground(Color.orange);
		
		//SUBTRACTION BUTTON
			subtractionButton.setBackground(Color.orange);	
			
		//MULTPLY BUTTON
			multiplyButton.setBackground(Color.orange);
		
		//DIVISION BUTTON
			divideButton.setBackground(Color.orange);
			
		//EQUAL BUTTON
			equalButton.setBackground(Color.orange);
		
		//DECIMAL BUTTON
			decimalButton.setBackground(Color.orange);
		
			
		//DELETE BUTTON
			deleteButton.setBounds(50, 430, 145, 50);
			//deleteButton.setBackground(Color.black);
		
		//CLEAR BUTTON
			clearButton.setBounds(205, 430, 145, 50);
			//clearButton.setBackground(Color.black);
			
			//ADD PANEL TO FRAME		
			frame.add(panel);
			
			frame.add(field);
			
			//ADD DELETE BUTTON TO FRAME
			frame.add(deleteButton);
			
			//ADD CLEAR BUTTON TO FRAME
			frame.add(clearButton);
			
			//ICON TO FRAME
			frame.setIconImage(icon.getImage());
			
		
		//ADDING BUTTONS TO THE FRAME
			
			panel.add(numberButtons[1]);
			panel.add(numberButtons[2]);
			panel.add(numberButtons[3]);
			panel.add(additionButton);
			
			panel.add(numberButtons[4]);
			panel.add(numberButtons[5]);
			panel.add(numberButtons[6]);
			panel.add(subtractionButton);
			
			panel.add(numberButtons[7]);
			panel.add(numberButtons[8]);
			panel.add(numberButtons[9]);
			panel.add(multiplyButton);
			
			panel.add(decimalButton);
			panel.add(numberButtons[0]);
			panel.add(equalButton);
			panel.add(divideButton);
			
			
			frame.setVisible(true);
	
	}

	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 10; i++)
		{
			
			if(e.getSource() == numberButtons[i])
			{
				field.setText(field.getText().concat(String.valueOf(i)));
			}
		
		}	
			if(e.getSource() == decimalButton) {
				field.setText(field.getText().concat("."));
			}
			
			if(e.getSource() == additionButton)
			{
				number1 = Double.parseDouble(field.getText());
				operator = '+';
				field.setText("");
			}
			
			if(e.getSource() == subtractionButton) 
			{
				number1 = Double.parseDouble(field.getText());
				operator = '-';
				field.setText("");
			}
			
			if(e.getSource() == multiplyButton) 
			{
				number1 = Double.parseDouble(field.getText());
				operator = '*';
				field.setText("");
			}
			
			if(e.getSource() == divideButton) 
			{	
				number1 = Double.parseDouble(field.getText());
				operator = '/';
				field.setText("");
			}
			
			if(e.getSource() == equalButton) 
			{	
				number2 = Double.parseDouble(field.getText());
				
			
			//SWITCH STMT 
			switch(operator) {
			
			//CASE + ADDS NUMBER 1 TO NUMBER 2 
			case'+':
				total = number1 + number2;
				break;
				
			//CASE - SUBTRACTS NUMBER 1 TO NUMBER 2 
			case'-':
				total = number1 - number2;
				break;
				
			//CASE MULTIPLES NUMBER 1 TO NUMBER 2
			case '*':
				total = number1 * number2;
				break;
			//CASE NUMBER 
			case '/':
				total = number1 / number2;
				break;
				
			}
			
			field.setText(String.valueOf(total));
			number1 = total;
			}
			
			if(e.getSource() == clearButton)
			{
				field.setText("");
			}
			
			if(e.getSource() == deleteButton) {
				String string = field.getText();
				field.setText("");
				
				for(int i =0; i < string.length()-1; i++ ) 
				{
					field.setText(field.getText() + string.charAt(i));
				}
			}
		
		
	}
	
}
	
