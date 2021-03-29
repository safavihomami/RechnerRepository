package at.bfi.test.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import at.kijane.hello.eingabe.oop.Operation;

public class MyApp extends JFrame {

	private JPanel panel_1, panel_2, panel_3;
	private JLabel lable_1, lable_2;
	private JTextField tf_1, tf_2;
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private JButton b_add, b_sub, b_multi, b_div;
	private JButton b_gleich;

	private Operation operator = Operation.ADD;
		
	private static StringBuilder sb = new StringBuilder();
	private int result;
	private int zahl;

	public MyApp() {

		init();

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				dispose();
			}

			@Override
			public void windowClosed(WindowEvent e) {

				System.exit(0);

			}

		});

		b0.addActionListener(l -> {
			String input = b0.getText();
			sb.append(input);
			tf_1.setText(sb.toString());
			zahl = Integer.parseInt(input);
			if (result == 0)
				tf_2.setText(String.valueOf(zahl));
			else {
				if (operator == Operation.ADD)
					result = result + zahl;
				else if (operator == Operation.SUBSTRACT)
					result = result - zahl;
				else if (operator == Operation.MULTIPLY)
					result = result * zahl;
				else if (operator == Operation.DIVIDE)
					result = result / zahl;
				else
					System.out.println("unknown");
				
				tf_2.setText(String.valueOf(result));
			}
				
			
		});

		b1.addActionListener(l -> {
			String input = b1.getText();
			sb.append(input);
			tf_1.setText(sb.toString());
			zahl = Integer.parseInt(input);
			
			if (result == 0)
				tf_2.setText(String.valueOf(zahl));
			else {
				if (operator == Operation.ADD)
					result = result + zahl;
				else if (operator == Operation.SUBSTRACT)
					result = result - zahl;
				else if (operator == Operation.MULTIPLY)
					result = result * zahl;
				else if (operator == Operation.DIVIDE)
					result = result / zahl;
				else
					System.out.println("unknown");
				
				//tf_2.setText(String.valueOf(result));
			}			
		});

		b2.addActionListener(l -> {
			String input = b2.getText();
			sb.append(input);			
			
			tf_1.setText(sb.toString());
			zahl = 2;
					
			if (operator.equals(Operation.ADD)) {
					result = result + zahl;
			}
					
			else if (operator.equals(Operation.SUBSTRACT)) {
					result = result -zahl;
			}
					
			else if (operator.equals(Operation.MULTIPLY))
					result = result * zahl;
			else if (operator.equals(Operation.DIVIDE))
					result = result / zahl;
			else
					System.out.println("unknown");
				
				
	
		});

		///////////////////////////////////////
		b_add.addActionListener(l -> {
			String input = b_add.getText();
			sb.append(input);
			tf_1.setText(sb.toString());
			
			operator = Operation.ADD;
			
			//tf_2.setText(String.valueOf(result));
			
			//zahl = 0;
		});

		b_sub.addActionListener(l -> {
			String input = b_sub.getText();
			sb.append(input);
			tf_1.setText(sb.toString());
			
			operator = Operation.SUBSTRACT;
			
			
			//tf_2.setText(String.valueOf(result));
			
			//zahl = 0;
		});

		b_multi.addActionListener(l -> {
			String input = b_multi.getText();
			sb.append(input);
			tf_1.setText(sb.toString());
			
			operator = Operation.MULTIPLY;
			
			//tf_2.setText(String.valueOf(result));
			
			//zahl = 0;
		});

		b_div.addActionListener(l -> {
			String input = b_div.getText();
			sb.append(input);
			tf_1.setText(sb.toString());
			
			operator = Operation.DIVIDE;
			
			//tf_2.setText(String.valueOf(result));
			
			//zahl = 0;
		});
		/////////////////////////////////////////////

		b_gleich.addActionListener(l -> {
			sb.append(b_gleich.getText());
			tf_1.setText(sb.toString());

			String str = evaluate(sb.toString());
			tf_2.setText(str);
			
			
			/*
			if (result == 0)
				tf_2.setText(String.valueOf(zahl));
			
			else if (result < 0)
				tf_2.setText("-" +String.valueOf(result));
			else
				tf_2.setText(String.valueOf(result));
			zahl = 0;
			*/
		});

		///////////////////
	}
	
	public static String evaluate(String expression) {
	      char[] arr = expression.toCharArray();
	      String operand1 = "";String operand2 = "";String operator = "";
	      double result = 0;

	      for (int i = 0; i < arr.length; i++) {
	         if (arr[i] >= '0' && arr[i] <= '9' || arr[i] == '.') {
	            if(operator.isEmpty()){
	               operand1 += arr[i];
	            }else{
	               operand2 += arr[i];
	            }
	         }  

	         if(arr[i] == '+' || arr[i] == '-' || arr[i] == '/' || arr[i] == '*') {
	            operator += arr[i];
	         }
	      }

	      if (operator.equals("+"))
	         result = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
	      else if (operator.equals("-"))
	         result = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
	      else if (operator.equals("/"))
	         result = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
	      else
	         result = (Double.parseDouble(operand1) * Double.parseDouble(operand2));          
	      return operand1 + operator + operand2 + "=" +result;
	   }    

	private void init() {

		setLocation(100, 100);
		setPreferredSize(new Dimension(600, 300));

		panel_1 = new JPanel();
		panel_2 = new JPanel();
		panel_3 = new JPanel();

		setLayout(new BorderLayout(30, 30));

		lable_1 = new JLabel("Eingabe Operationen: ");
		lable_2 = new JLabel("Ergebnis: ");

		tf_1 = new JTextField(150);
		tf_2 = new JTextField(30);

		panel_1.setLayout(new GridLayout(2, 2));

		panel_1.add(lable_1);
		panel_1.add(tf_1);

		panel_1.add(lable_2);
		panel_1.add(tf_2);

		add(panel_1, BorderLayout.NORTH);

		panel_2.setLayout(new GridLayout(4, 3, 10, 10));

		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");

		panel_2.add(b0);
		panel_2.add(b1);
		panel_2.add(b2);
		panel_2.add(b3);
		panel_2.add(b4);
		panel_2.add(b5);
		panel_2.add(b6);
		panel_2.add(b7);
		panel_2.add(b8);
		panel_2.add(b9);

		add(panel_2, BorderLayout.CENTER);

		panel_3.setLayout(new GridLayout(3, 2, 10, 10));
		b_add = new JButton("+");
		b_sub = new JButton("-");
		b_multi = new JButton("*");
		b_div = new JButton("/");
		b_gleich = new JButton("=");

		panel_3.add(b_add);
		panel_3.add(b_sub);
		panel_3.add(b_multi);
		panel_3.add(b_div);
		panel_3.add(b_gleich);

		add(panel_3, BorderLayout.EAST);

		pack();
		setVisible(true);

	}

}
