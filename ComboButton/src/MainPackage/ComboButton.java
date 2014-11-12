package MainPackage;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

public class ComboButton {
//--------------------------------------------------------------------------------------------
	public static String[] DAYS = { "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
			"20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
			"31" };
	public static int[] YEARS = { 2009, 2010, 2011, 2012, 2013, 2014, 2015,
			2016, 2017, 2018, 2019 };
	private JFrame frame;

//--------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboButton window = new ComboButton();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//--------------------------------------------------------------------------------------------
	public ComboButton() {
		initialize();
	}


//--------------------------------------------------------------------------------------------
	private void initialize() {
		Scanner input = new Scanner(System.in);
		Calendar now = Calendar.getInstance();
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DATE);
		final int year = now.get(Calendar.YEAR);
		frame = new JFrame("ComboButton");
		frame.setBounds(100, 100, 330, 272);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		HashMap<Integer, String> MONTH = new HashMap();

		MONTH.put(1, "January");
		MONTH.put(2, "February");
		MONTH.put(3, "March");
		MONTH.put(4, "April");
		MONTH.put(5, "May");
		MONTH.put(6, "June");
		MONTH.put(7, "July");
		MONTH.put(8, "August");
		MONTH.put(9, "September");
		MONTH.put(10, "October");
		MONTH.put(11, "November");
		MONTH.put(12, "December");
		
	
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(106, 30, 120, 39);
		frame.getContentPane().add(comboBox);
		int w=1;
		while (w<MONTH.size()+1)
		{
			comboBox.addItem(MONTH.get(w));			
			w++;
		}
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(106, 82, 120, 40);
		frame.getContentPane().add(comboBox_1);
		int v=0;
		while (v< DAYS.length)
		{
			comboBox_1.addItem(DAYS[v]);
			v++;
		}
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(106, 134, 120, 40);
		frame.getContentPane().add(comboBox_2);
		int x=0;
		while (x < YEARS.length)
		{
			comboBox_2.addItem(YEARS[x]);
			x++;
		}
		for (int i = 1; i < MONTH.size() + 1; i++) {
			if (month == i) {
				comboBox.setSelectedItem(MONTH.get(i));
			}
		}
		for (int i = 0; i < DAYS.length; i++) {
			if (day == i) {
				comboBox_1.setSelectedItem(DAYS[i - 1]);
			}
		}
		for (int i = 0; i < YEARS.length; i++) {
			if (year == YEARS[i]) {
				comboBox_2.setSelectedItem(YEARS[i]);
			}
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object choosen = comboBox.getSelectedItem();
				if (choosen.toString() == "November"
						|| choosen.toString() == "September"
						|| choosen.toString() == "June"
						|| choosen.toString() == "April") {
					comboBox_1.removeAllItems();
					for (int x = 0; x < DAYS.length - 1; x++) {
						comboBox_1.addItem(DAYS[x]);
					}
				} else if (choosen.toString() == "January"
						|| choosen.toString() == "March"
						|| choosen.toString() == "May"
						|| choosen.toString() == "July"
						|| choosen.toString() == "August"
						|| choosen.toString() == "October"
						|| choosen.toString() == "December") {
					comboBox_1.removeAllItems();
					for (int x = 0; x < DAYS.length; x++) {
						comboBox_1.addItem(DAYS[x]);
					}
				}
//--------------------------------------------------------------------------------------------
				else if ((year % 4 == 0) && year % 100 != 0) {
					if (choosen.toString() == "February") {
						comboBox_1.removeAllItems();
						for (int x = 0; x < DAYS.length - 2; x++) {
							comboBox_1.addItem(DAYS[x]);
						}
					}
				} else if ((year % 4 == 0) && (year % 100 == 0)
						&& (year % 400 == 0)) {
					if (choosen.toString() == "February") {
						comboBox_1.removeAllItems();
						for (int x = 0; x < DAYS.length - 2; x++) {
							comboBox_1.addItem(DAYS[x]);
						}
					}
				} else {
					comboBox_1.removeAllItems();
					for (int x = 0; x < DAYS.length - 3; x++) {
						comboBox_1.addItem(DAYS[x]);
					}
				}
			}
		});
//--------------------------------------------------------------------------------------------
		JLabel lblmonth = new JLabel("Month");
		lblmonth.setFont(new Font("Verdana", Font.BOLD, 16));
		lblmonth.setBounds(36, 33, 60, 14);
		frame.getContentPane().add(lblmonth);
		JLabel lblyear = new JLabel("Year");
		lblyear.setFont(new Font("Verdana", Font.BOLD, 16));
		lblyear.setBounds(36, 137, 60, 14);
		frame.getContentPane().add(lblyear);
		JLabel lblday = new JLabel("Day");
		lblday.setFont(new Font("Verdana", Font.BOLD, 16));
		lblday.setBounds(36, 85, 60, 17);
		frame.getContentPane().add(lblday);
	}
}