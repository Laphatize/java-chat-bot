package chatbot.infra;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Chatbot {
	
	private String userName = "YOUR NAME HERE";
	private String botName = "BOT NAME HERE";
	
	
	public Chatbot(String userName, String botName) {
		
		this.userName = userName;
		this.botName = botName;
		
	}
	
	/*
	 * Task 3: Add a response in Chatbot.java to respond to user message
	 * 
	 * Please modify the getResponse() method in the Chatbot class to respond
	 * to three or more different user messages meaningfully. I provided one
	 * example in the getResponse().
	 */
	
	public String getResponse(String nowInputText) {
		
		String nowResponse = "Hmm, I didn't quite get that.";
		
		String temp = nowInputText.toLowerCase();
		
		
		if(temp.equals("we are")) {
			nowResponse = "Penn State!";
		}
		
		if(temp.equals("foo")) {
			nowResponse = "bar";
		}
		
		if (temp.equals("what building is IST 261 in?")) {
			nowResponse = "Willard Building";
		}
		
		double output = 0;
		
		boolean calculationFailed = false;
		
		if (temp.split(" ")[0].equals("calculate")) {
			
			try {
			double num1 = Double.parseDouble(temp.split(" ")[1]);
			
			
			String operation = temp.split(" ")[2];
			double num2 = Double.parseDouble(temp.split(" ")[3]);

			System.out.println(num1);
			System.out.println(operation);
			System.out.println(num2);


			if (operation.equals( "+")) {
				output = num1 + num2;
			}  else if (operation.equals("-")) {
				output = num1 - num2;
			} else if (operation.equals( "*" )) {
				output = num1 * num2;
			} else if (operation.equals( "/")) {
				output = num1 * num2;
			} else if (operation.equals("%")) {
				output = num1 % num2;
			} else {
				calculationFailed = true;
				output = 0;
			}
			
			
			
			if (calculationFailed) {
				nowResponse = "Invalid operation provided. (*, / , &, +, -)";
			} else {
				nowResponse = "Calculation run with output of: " + output;
				
			}
			
			
			
			
			} catch (Exception e) {
				nowResponse = "Something went wrong when attempting to try calculation. Make sure you space out the operations and numbers";
				return nowResponse;
			}
			
			
		}
		
		
		if (temp.equals("generate random number")) {
			nowResponse =  Double.toString((Math.random() * 10));
		}
		
		if (temp.equals("flip a coin")) {
		   if (Math.random() < .5) {
			   nowResponse = "Coin flipped Heads!";
		   } else {
			   nowResponse = "Coin flipped Tails!";
		   }
		}
		
		System.out.println("--------------");
		System.out.println("User Message: "+nowInputText);
	
		System.out.println("Chatbot Response: "+nowResponse);
		return nowResponse;
		
		
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBotName() {
		return botName;
	}

	public void setBotName(String botName) {
		this.botName = botName;
	}

	
	
	

}
