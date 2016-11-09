import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class NoteCardGUI implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private NoteCard ex;
	private JButton study, drill, doNotKnow, exit; // buttons on the panel

	public static Box box1 = new Box(), box2 = new Box(), box3 = new Box();
	
	public static void p(String s) {
		System.out.println(s);
	}

	/**
	 * Constructor creates frame and panel of the notecard, and provides either
	 * the front or the back of the card The program will only run granted that
	 * the box has cards in it.
	 */
	public NoteCardGUI() {

		frame = new JFrame("Flash Card");
		panel = new JPanel();

		study = new JButton("Study");
		drill = new JButton("Drill");
		doNotKnow = new JButton("Do Not Know");
		exit = new JButton("Exit");

		panel.add(study);
		panel.add(drill);
		panel.add(exit);

		// frame.add(label, BorderLayout.SOUTH);

		frame.add(panel);
		frame.setSize(300, 70);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// Initiates the study when the user presses the button.

		study.addActionListener(new ActionListener() {
			String input;
			NoteCard ex;

			public void actionPerformed(ActionEvent e) {
				while (Box.size(box1) > 0 || Box.size(box2) > 0 || Box.size(box3) > 0) { //will run until all boxes are empty

					LeitnerREV run = LeitnerREV.createLeitner(box1, box2, box3);

					if (run.chosen == box1) {

						this.ex = LeitnerREV.pickCard(run);

						String chal = this.ex.getChallenge();
						String resp = this.ex.getResponse();

						if (chal.contains(".png")) {
							ImageIcon photo = new ImageIcon(chal);
							input = JOptionPane.showInputDialog(null, photo); //displays the challenge as an image
						} else {
							input = JOptionPane.showInputDialog(null, chal); // displays the challenge as a string
													}

						if (resp.compareTo(input) == 0) {
							JOptionPane.showMessageDialog(null, "Correct!");
							box2.addCard(ex); //moves the card into the next box
						} else
							JOptionPane.showMessageDialog(null, "Incorrect");
					}

					if (run.chosen == box2) {

						this.ex = LeitnerREV.pickCard(run);

						String chal = this.ex.getChallenge();
						String resp = this.ex.getResponse();

						System.out.println(chal);
						System.out.println(resp);

						if (chal.contains(".png")) {
							ImageIcon photo = new ImageIcon(chal);
							input = JOptionPane.showInputDialog(null, photo); //displays the challenge as a photo
						} else {
							input = JOptionPane.showInputDialog(null, chal); // displays the challenge as a string
						}

						if (resp.compareTo(input) == 0) {
							JOptionPane.showMessageDialog(null, "Correct!");
							box3.addCard(ex);//moves the card into the next box
						} else
							JOptionPane.showMessageDialog(null, "Incorrect");
							box1.addCard(ex); //moves it the previous box
					}

					if (run.chosen == box3) {

						this.ex = LeitnerREV.pickCard(run);

						String chal = this.ex.getChallenge();
						String resp = this.ex.getResponse();

						System.out.println(chal);
						System.out.println(resp);

						if (chal.contains(".png")) {
							ImageIcon photo = new ImageIcon(chal);
							input = JOptionPane.showInputDialog(null, photo);
						} else {
							input = JOptionPane.showInputDialog(null, chal); // displays
							// the
						}
						
						System.out.println(input);
						if (resp.compareTo(input) == 0) {
							JOptionPane.showMessageDialog(null, "Correct!");
						} else
							JOptionPane.showMessageDialog(null, "Incorrect");
							box2.addCard(ex);//moves the card into the next box
					}
				}

			}
		});
		
		// Initiates the drill method when the user presses the button.
		//runs until the box is empty
		drill.addActionListener(new ActionListener() {
			
			
			String input1;
			NoteCard p;
			public void actionPerformed(ActionEvent e) {
				while (Box.size(box1) > 0) {
					
					
					try {
						
						
						Scanner input = new Scanner(new File("Capitols"));

						p = new NoteCard("","");

						while (input.hasNext()) {
							String line = input.nextLine();
							String[] details = line.split(",");
							String front = details[0];
							String back = details[1];
							p = new NoteCard(front, back);
							box1.addCard(p);
						}
						
						LeitnerREV run = LeitnerREV.createLeitner(box1, box2, box3);

						this.p = LeitnerREV.pickCard(run);
						String resp = this.p.getResponse();
						String chal = this.p.getChallenge();

						if (chal.contains(".png")) {
							ImageIcon photo = new ImageIcon(chal);
							this.input1 = JOptionPane.showInputDialog(null, photo); //displays challenge as a photo
						} else if (chal.contains(".png") == false) {
							this.input1 = JOptionPane.showInputDialog(null, chal); // displays the challenge as a string
																		
						} 

						if (resp.compareTo(this.input1) == 0) {
							JOptionPane.showMessageDialog(null, "Correct!");
							box1.removeCard(0);
						} else
							JOptionPane.showMessageDialog(null, "Incorrect");
							
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		exit.addActionListener(new ActionListener() { // exits and closes the
														// programs
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) throws IOException {

		int count = 0;

		Scanner input = new Scanner(new File("Capitols"));

		NoteCard p = new NoteCard("", "");

		while (input.hasNext()) {

			String line = input.nextLine();
			String[] details = line.split(",");
			String front = details[0];
			String back = details[1];
			p = new NoteCard(front, back);

			double random = Math.random() * 6;
			if (random < 2) {
				box1.addCard(p);
			} else if (random > 2 && random < 4) {
				box2.addCard(p);
			} else if (random > 4) {
				box3.addCard(p);
			}
			count++;
		}

		new NoteCardGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
