package linuxspace.org;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Application extends JFrame {

	private URLParser parser;
	private JTextField fldInsertLinlk;

	public Application() {
		this.initUI();
		this.parser = new URLParser();

	}

	public void initUI() {
		setTitle("Instagrab - download pictures from Instagram");
		setBounds(100, 100, 450, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Create panel
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);

		// Button create
		JButton btnGetLink = new JButton("Get Photo");
		btnGetLink.setBounds(172, 143, 89, 23);

		// Create label
		JLabel lblEnterLinkTo = new JLabel("Insert link to pic..");
		lblEnterLinkTo.setBounds(158, 77, 118, 14);

		// create list
		JList list = new JList();
		list.setBounds(89, 196, 255, 242);

		// Create menu bar
		JMenuBar bar = new JMenuBar();
		bar.setBounds(0, 0, 434, 21);

		btnGetLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new Thread(new Runnable() {

					public void run() {
						parser.mainParser(fldInsertLinlk.getText());

					}
				}).run();
				;

			}
		});

		// Create edit text
		fldInsertLinlk = new JTextField();
		fldInsertLinlk.setToolTipText("Enter link here");
		fldInsertLinlk.setBounds(89, 102, 255, 20);

		// Set to layout
		panel.add(btnGetLink);
		panel.add(fldInsertLinlk);
		panel.add(lblEnterLinkTo);
		panel.add(list);
		panel.add(bar);
	}

	public static void main(String[] args) {

		// Main App created here
		Application appIntagrab = new Application();
		appIntagrab.setVisible(true);
	}

}