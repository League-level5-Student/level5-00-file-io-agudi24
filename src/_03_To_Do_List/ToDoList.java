package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	JFrame frame = new JFrame("To Do List");
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Add Task");
	JButton button2 = new JButton("View Tasks");
	JButton button3 = new JButton("Remove Task");
	JButton button4 = new JButton("Save List");
	JButton button5 = new JButton("Load List");
	ArrayList<String> tasks = new ArrayList<String>();

	void setup() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
		tdl.setup();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (button1 == e.getSource()) {
			String input = JOptionPane.showInputDialog("Enter a task:");
			tasks.add(input);
		}
		if (button2 == e.getSource()) {
			JOptionPane.showMessageDialog(null, Arrays.toString(tasks.toArray()));
		}
		if (button3 == e.getSource()) {
			String number = JOptionPane.showInputDialog("Enter which numbered task from 0 to infinity you want to remove:");
			int num = Integer.parseInt(number);
			tasks.remove(num);
		}
		if (button4 == e.getSource()) {
			try {
				FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/todolist.txt");
				
				/*
				NOTE: To append to a file that already exists, add true as a second parameter when calling the
				      FileWriter constructor.
				      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
				*/
				
				fw.write(Arrays.toString(tasks.toArray()));
					
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		if (button5 == e.getSource()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_00_Intro_To_File_Input_and_Output/todolist.txt"));
				
				String line = br.readLine();
				while(line != null){
					JOptionPane.showMessageDialog(null, line);
					line = br.readLine();
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

