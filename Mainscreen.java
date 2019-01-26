package application;



import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Mainscreen{
	private static JTextField textField;
	private static JTextField textField_1;
	
	public static void seqconcat(ArrayList<String> x, ArrayList<String> y, ArrayList<String> z, JTextArea ta) {
		
		//add elements from both loops to a result array
		for (int i=0; i<x.size(); i++)
		{
			z.add(x.get(i));
		}
		
		for (int i=0; i<y.size(); i++)
		{
			z.add(y.get(i));
		}
		//<1,2,3,4>
		//<2,3,4,5>
		
		//This is the loop to print all the items of the z variable
		ta.setText("< ");
		for (int i=0; i<z.size(); i++)
		{
			ta.append(z.get(i)+" ");
		}
		ta.append(">");
	};
	
	public static void seqfilter(ArrayList<String> x, ArrayList<String> y, ArrayList<String> z, JTextArea ta) {
		
		//Add elements from set 1 is they are present in the set 2
		for (int i=0; i<x.size(); i++)
		{
			for (int j=0; j<y.size(); j++)
			{
				if (x.get(i).equals(y.get(j)))
				{
					z.add(x.get(i));
				}
			}
		}
		
		
		//This is the loop to print all the items of the results array list
		ta.setText("< ");
		for (int i=0; i<z.size(); i++)
		{
			ta.append(z.get(i)+" ");
		}
		ta.append(">");
	};
	
	//Function definition of the union set operation
	public static void union(ArrayList<String> x, ArrayList<String> y, ArrayList<String> z, JTextArea ta) {
		
		//This is the loop to add items from list 1 to results array, after checking they are not already present
		for (int i=0; i<x.size(); i++)
		{
			if(!z.contains(x.get(i))) 	
			{
				
				z.add(x.get(i));
			}
		}
		
		//This is the loop to add items from list 2 to results array, after checking they are not already present
		for (int i=0; i<y.size(); i++)
		{
			if(!z.contains(y.get(i)))
			{
				z.add(y.get(i));
			}
		}
		
		//This is the loop to print all the items of the z variable
		ta.setText("{ ");
		for (int i=0; i<z.size(); i++)
		{
			ta.append(z.get(i)+" ");
		}
		ta.append("}");
	};
	
	//Function definition of the intersection set operation
	public static void intersection(ArrayList<String> x, ArrayList<String> y, ArrayList<String> z, JTextArea ta) {
		
		//This is the loop to add items from list 1 to results array, if the elements are present in both the lists
		for (int i=0; i<x.size(); i++)
		{
			for (int j=0; j<y.size(); j++)
			{
				if (x.get(i).equals(y.get(j))&&!z.contains(x.get(i)))
				{
					z.add(x.get(i));
				}
			}
		}
		
		
		//This is the loop to print all the items of the results array list
		ta.setText("{ ");
		for (int i=0; i<z.size(); i++)
		{
			ta.append(z.get(i)+" ");
		}
		ta.append("}");
	};
	
	public static void subtraction(ArrayList<String> x, ArrayList<String> y, ArrayList<String> z, JTextArea ta) {
		
		//This is the loop to add items from list 1 to results array, after checking they are not already present in set 2
		for (int i=0; i<x.size(); i++)
		{
			for (int j=0; j<y.size(); j++)
			{
				if (!y.contains(x.get(i))&&!z.contains(x.get(i)))
				{
					z.add(x.get(i));
				}
			}
		}
		
		//This is the loop to print all the items of the results array list
		ta.setText("{ ");
		for (int i=0; i<z.size(); i++)
		{
			ta.append(z.get(i)+" ");
		}
		ta.append("}");
	};
	
	public static void product(ArrayList<String> x, ArrayList<String> y, ArrayList<String> z, JTextArea ta) {
		
		ArrayList<String> x1 = new ArrayList<String>();	
		ArrayList<String> y1 = new ArrayList<String>();	
		ArrayList<String> z1 = new ArrayList<String>();
		
		for(int i=0; i<x.size(); i++)
		{
			if(!x1.contains(x.get(i)))
			{
				x1.add(x.get(i));
			}
		}
		
		for(int i=0; i<y.size(); i++)
		{
			if(!y1.contains(y.get(i)))
			{
				y1.add(y.get(i));
			}
		}
		
		ta.setText("");
		
		for (int i=0; i<x1.size(); i++)
		{
			for (int j=0; j<y1.size(); j++)
			{
				ta.append( "("+ x1.get(i) + "," +y1.get(j)+ ")\n");
			}
		}
	};
	
	public static void complement(ArrayList<String> x, ArrayList<String> y, ArrayList<String> z, JTextArea ta) {
		
		
		for (int i=0; i<x.size(); i++)
		{
			for (int j=0; j<y.size(); j++)
			{
				if (!y.contains(x.get(i))&&!z.contains(x.get(i)))
				{
					z.add(x.get(i));
				}
			}
		}
		
		
		//This is the loop to print all the items of the results array list
		ta.setText("{ ");
		for (int i=0; i<z.size(); i++)
		{
			ta.append(z.get(i)+" ");
		}
		ta.append("}");
	};
	
	public static void powerset(ArrayList<String> x, ArrayList<String> z, JTextArea ta) {
		
		ta.setText("");
		ArrayList<String> arrangement = new ArrayList<>();
		double numberofsubsets = Math.pow(2, x.size());
		for(int i=0; i<numberofsubsets; i++)
		{
			int count = x.size();
			String zeroes = String.format("%" + count + "c",'0').replace(' ', '0');
			
			zeroes += Integer.toBinaryString(i);
			
			arrangement.add(zeroes.substring(Integer.toBinaryString(i).length()));
		}
		
		for(int i=0; i<arrangement.size(); i++) //32
		{
			ta.append("{ ");
			for (int j=0; j<x.size(); j++)
			{
				if(arrangement.get(i).charAt(j)=='1')
				{
					ta.append(x.get(j)+" ");
				}
			}
			ta.append("}\n");
		}
		
	};
	
	public static void main(String args[])
	{
		Button calculate;
		JTextArea result;
		
		JFrame mainscreen = new JFrame("Set Calculator");
		JMenuBar menubar = new JMenuBar();
		
		mainscreen.setSize(800, 600);
		mainscreen.setResizable(false);
		
		JMenu helpmenu = new JMenu("Help");
		menubar.add(helpmenu);
		
		JMenuItem howto = new JMenuItem("How to use");
		helpmenu.add(howto);
		
		JMenuItem about = new JMenuItem("About");
		helpmenu.add(about);
		
		howto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(mainscreen, "User must enter the sets in the boxes on the left (without brackets), select an opration and click on calculate. \nResult will be shown in the result box on the right. It can be copied, pasted and edited.\n\nSome important points:\nIn case of complement, the set 1 will be the Universal set\nIn case of Power Set, only set 1 will be used");
			}
		});
		
		about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(mainscreen, "Created by Saadia Aman and Ammar Israr");
			}
		});
		
		mainscreen.setJMenuBar(menubar);
		mainscreen.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(102, 108, 222, 20);
		mainscreen.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 250, 222, 20);
		mainscreen.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSet = new JLabel("Set 1");
		lblSet.setBounds(10, 111, 82, 14);
		mainscreen.getContentPane().add(lblSet);
		
		JLabel lblSet_1 = new JLabel("Set 2");
		lblSet_1.setBounds(10, 253, 82, 14);
		mainscreen.getContentPane().add(lblSet_1);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(235, 420, 89, 23);
		mainscreen.getContentPane().add(btnCalculate);
		//mainscreen.getContentPane().add(textArea);
		
		JLabel lblNewLabel = new JLabel("Result");
		lblNewLabel.setBounds(414, 111, 48, 14);
		mainscreen.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Union", "Intersection", "Subtraction", "Product", "Complement", "Power Set", "Sequence Concatenation", "Sequence Filter Operation"}));
		comboBox.setBounds(102, 180, 222, 22);
		mainscreen.getContentPane().add(comboBox);
		
		JLabel lblOperation = new JLabel("Operation");
		lblOperation.setBounds(10, 184, 82, 14);
		mainscreen.getContentPane().add(lblOperation);
		
		JTextArea textArea = new JTextArea();
		mainscreen.getContentPane().add(textArea);
		textArea.setLineWrap(true);
		textArea.setBounds(472, 112, 295, 335);
		mainscreen.setVisible(true);
		
		btnCalculate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String set1input = textField.getText();
				String set2input = textField_1.getText();
				
				ArrayList<String> list1 = new ArrayList<String>(Arrays.asList(set1input.split(",")));
				
				ArrayList<String> list2 = new ArrayList<String>(Arrays.asList(set2input.split(",")));
				
				//Let this be the array where the members from both sets will be added as a result
				ArrayList<String> result = new ArrayList<String>();
				
				switch(comboBox.getSelectedItem().toString())
				{
				case "Union":
					union(list1, list2, result, textArea);
					break;
				
				case "Intersection":
					intersection(list1, list2, result, textArea);
					break;
				
				case "Subtraction":
					subtraction(list1, list2, result, textArea);
					break;
				
				case "Product":
					product(list1, list2, result, textArea);
					break;
				
				case "Complement":
					complement(list1, list2, result, textArea);
					break;
					
				case "Power Set":
					powerset(list1, list2, textArea);
					break;
				
				case "Sequence Concatenation":
					seqconcat(list1, list2, result, textArea);
					break;
				
				case "Sequence Filter Operation":
					seqfilter(list1, list2, result, textArea);
					break;
				}
			}
		});
	}
}
