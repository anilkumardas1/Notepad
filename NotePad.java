import javax.swing.*;

//import jdk.javadoc.internal.doclets.toolkit.FieldWriter;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
//import javax.swing.BorderFactory;
import java.awt.*;

class MyFrame2 /* extends JFrame */ implements ActionListener {
	Container c;
	JTextArea ta;
	JMenuItem i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23,
			i24, i25, i26, i27, i28;
	JMenuBar menubar;
	String filename;
	String fileaddres;
	JScrollPane scrollpane;
	JFrame frame;
	JMenu file, edit, format, help, subformat, subformat2, subformat3;

	MyFrame2() {
		frame = new JFrame();

		frame.setTitle("Notepad by Anil");
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon icon = new ImageIcon("fb_img_1578142050723.jpg");
		frame.setIconImage(icon.getImage());
		/*
		 * c=frame.getContentPane(); c.setLayout(null);
		 */
		menubar = new JMenuBar();
		menubar.setBackground(Color.GRAY);

		file = new JMenu("File");

		i1 = new JMenuItem("New ");
		i2 = new JMenuItem("Open...");
		i3 = new JMenuItem("Save");
		i4 = new JMenuItem("SaveAS...");
		i5 = new JMenuItem("Exit");
		file.add(i1);
		file.add(i2);
		file.add(i3);
		file.add(i4);
		file.add(i5);
		menubar.add(file);

		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);

		edit = new JMenu("Edit");

		i6 = new JMenuItem("Cut             ctrl+x");
		i7 = new JMenuItem("Copy            ctrl+c");
		i8 = new JMenuItem("Past            ctrl+v");
		i9 = new JMenuItem("SelectAll       ctrl+A");
		edit.add(i6);
		edit.add(i7);
		edit.add(i8);
		edit.add(i9);
		i6.addActionListener(this);
		i7.addActionListener(this);
		i8.addActionListener(this);
		i9.addActionListener(this);
		menubar.add(edit);

		format = new JMenu("Format");

		subformat2 = new JMenu("Char");
		subformat3 = new JMenu("Size");

		i10 = new JMenuItem("Bold");
		i11 = new JMenuItem("Plain");
		subformat2.add(i10);
		subformat2.add(i11);
		format.add(subformat2);
		format.add(subformat2);

		i12 = new JMenuItem("11");
		i13 = new JMenuItem("12");
		i14 = new JMenuItem("13");
		i15 = new JMenuItem("14");
		i16 = new JMenuItem("15");
		i17 = new JMenuItem("16");
		i18 = new JMenuItem("17");
		i19 = new JMenuItem("18");
		i20 = new JMenuItem("19");
		i21 = new JMenuItem("20");
		i22 = new JMenuItem("21");
		i23 = new JMenuItem("22");
		i24 = new JMenuItem("23");
		i25 = new JMenuItem("24");
		i26 = new JMenuItem("25");
		subformat3.add(i12);
		subformat3.add(i13);
		subformat3.add(i14);
		subformat3.add(i15);
		subformat3.add(i16);
		subformat3.add(i17);
		subformat3.add(i18);
		subformat3.add(i19);
		subformat3.add(i20);
		subformat3.add(i21);
		subformat3.add(i22);
		subformat3.add(i23);
		subformat3.add(i24);
		subformat3.add(i25);
		subformat3.add(i26);

		format.add(subformat3);
		format.add(subformat3);
		format.add(subformat3);
		format.add(subformat3);
		format.add(subformat3);
		format.add(subformat3);
		format.add(subformat3);
		format.add(subformat3);
		format.add(subformat3);
		format.add(subformat3);
		format.add(subformat3);
		format.add(subformat3);
		format.add(subformat3);
		format.add(subformat3);
		format.add(subformat3);
		format.add(subformat3);

		menubar.add(format);

		i10.addActionListener(this);
		i11.addActionListener(this);
		i12.addActionListener(this);
		i13.addActionListener(this);
		i14.addActionListener(this);
		i15.addActionListener(this);
		i16.addActionListener(this);
		i17.addActionListener(this);
		i18.addActionListener(this);
		i19.addActionListener(this);
		i20.addActionListener(this);
		i21.addActionListener(this);
		i22.addActionListener(this);
		i23.addActionListener(this);
		i24.addActionListener(this);
		i25.addActionListener(this);
		i26.addActionListener(this);

		help = new JMenu("About Developer");
		// i27=new JMenuItem("About Notepad");
		i28 = new JMenuItem("More About Notepad");
		// help.add(i27);
		// i27.addActionListener(this);
		help.add(i28);
		i28.addActionListener(this);
		menubar.add(help);

		frame.setJMenuBar(menubar); // menubar Action Performed

		ta = new JTextArea();
		// ta.setBounds(0,0,1350,660);
		scrollpane = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.add(scrollpane);
		// c.add(ta);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == i1) {
			ta.setText("");
			ta.setEditable(true);
		}
		if (e.getSource() == i2) {
			// ta.setText("Open");
			FileDialog fd = new FileDialog(frame, "Open", FileDialog.LOAD);
			fd.setVisible(true);

			if (fd.getFile() != null) {
				filename = fd.getFile();
				fileaddres = fd.getDirectory();
				frame.setTitle(filename);
			}
			System.out.println("file address" + fileaddres + filename); // set the direcotory
			try {
				BufferedReader br = new BufferedReader(new FileReader(fileaddres + filename)); // you readthe addres to
																								// read a file
				this.ta.setText("");
				String line = null;
				while ((line = br.readLine()) != null) {
					this.ta.append(line + "\n");
				}
				br.close();
			} catch (Exception ex) {
				System.out.println("Error!!!!!!!!!!1");
			}

		}
		if (e.getSource() == i3) {
			// ta.setText("save");
			if (filename == null) {
				if (e.getSource() == i4)
					;
			} else {
				try {
					FileWriter fw = new FileWriter(fileaddres + filename);
					fw.write(ta.getText());
					frame.setTitle(filename);
					fw.close();
				} catch (Exception exp2) {
					System.out.println("Somthing wrong!!!!");
				}
			}
		}
		if (e.getSource() == i4) {
			// ta.setText("SaveAs...");

			FileDialog fd = new FileDialog(frame, "Save", FileDialog.SAVE);
			fd.setVisible(true);

			if (fd.getFile() != null) {
				filename = fd.getFile();
				fileaddres = fd.getDirectory();
				frame.setTitle(filename);
			}
			try {
				FileWriter fw = new FileWriter(fileaddres + filename);
				fw.write(ta.getText());
				fw.close();
			} catch (Exception exc) {
				System.out.println("Somthing wrong!!!!");
			}
		}
		if (e.getSource() == i5) {
			System.exit(0);
		}
		if (e.getSource() == i6) {
			ta.cut();
		}
		if (e.getSource() == i7) {
			ta.copy();
		}
		if (e.getSource() == i8) {
			ta.paste();
		}
		if (e.getSource() == i9) {
			ta.selectAll();
		}

		if (e.getSource() == i10) {
			Font f1 = new Font("Arial", Font.BOLD, 11);
			ta.setFont(f1);
		}
		if (e.getSource() == i11) {
			Font f2 = new Font("Arial", Font.PLAIN, 11);
			ta.setFont(f2);
		}
		if (e.getSource() == i12) {
			Font f3 = new Font("Arial", Font.PLAIN, 11);
			ta.setFont(f3);
		}
		if (e.getSource() == i13) {
			Font f4 = new Font("Arial", Font.PLAIN, 12);
			ta.setFont(f4);
		}
		if (e.getSource() == i14) {
			Font f5 = new Font("Arial", Font.PLAIN, 13);
			ta.setFont(f5);
		}
		if (e.getSource() == i15) {
			Font f6 = new Font("Arial", Font.PLAIN, 14);
			ta.setFont(f6);
		}
		if (e.getSource() == i16) {
			Font f7 = new Font("Arial", Font.PLAIN, 15);
			ta.setFont(f7);
		}
		if (e.getSource() == i17) {
			Font f8 = new Font("Arial", Font.PLAIN, 16);
			ta.setFont(f8);
		}
		if (e.getSource() == i18) {
			Font f9 = new Font("Arial", Font.PLAIN, 17);
			ta.setFont(f9);
		}
		if (e.getSource() == i19) {
			Font f10 = new Font("Arial", Font.PLAIN, 18);
			ta.setFont(f10);
		}
		if (e.getSource() == i20) {
			Font f11 = new Font("Arial", Font.PLAIN, 19);
			ta.setFont(f11);
		}
		if (e.getSource() == i21) {
			Font f12 = new Font("Arial", Font.PLAIN, 20);
			ta.setFont(f12);
		}
		if (e.getSource() == i22) {
			Font f13 = new Font("Arial", Font.PLAIN, 21);
			ta.setFont(f13);
		}
		if (e.getSource() == i23) {
			Font f14 = new Font("Arial", Font.PLAIN, 22);
			ta.setFont(f14);
		}
		if (e.getSource() == i24) {
			Font f15 = new Font("Arial", Font.PLAIN, 23);
			ta.setFont(f15);
		}
		if (e.getSource() == i25) {
			Font f16 = new Font("Arial", Font.PLAIN, 24);
			ta.setFont(f16);
		}
		if (e.getSource() == i26) {
			Font f17 = new Font("Arial", Font.PLAIN, 25);
			ta.setFont(f17);
		}
		// if (e.getSource() == help) {
		// 	ta.setText("\t\tMr. Anil Kumar Das\n\t\tStudyAt:-Satyasai Enginerring Clg(Bls)\n\t\tBranch:-C.S.E");
		// 	ta.setEditable(false);
		// }
		if (e.getSource() == i28) {
			//ta.setText(
					//"\t\tMr. Anil Das\n\t\tStudyAT:-Satyasai Enginerring Clg (Bls)\n\t\tBranch:-C.S.E\n\t\tATPO:-Panisapada\n\t\tDist:-Balasore\n\t\tPin:-757055\n\t\tNotepade Develop date:-27.01.2020");
					JOptionPane.showMessageDialog(null, "\t\tMr. Anil Das\n\t\tStudyAT:-Satyasai Enginerring Clg (Bls)\n\t\tBranch:-C.S.E\n\t\tATPO:-Panisapada\n\t\tDist:-Balasore\n\t\tPin:-757055\n\t\tNotepade Develop date:-27.01.2020\n\t\tVersion:1.0");
			ta.setEditable(false);
		}

	}

}

class NotePad {
	public static void main(String... args) {
		MyFrame2 f = new MyFrame2();

	}
}