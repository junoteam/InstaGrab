package linuxspace.org;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Application extends JFrame {

	private URLParser parser;
	private JTextField fldInsertLinlk;
	private Font font;

	public Application() {
		this.font = new Font("Segoe UI", Font.PLAIN, 12);
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
		btnGetLink.setFont(font);

		// Create label
		JLabel lblEnterLinkTo = new JLabel("Insert link to picture here");
		lblEnterLinkTo.setBounds(158, 77, 118, 14);
		lblEnterLinkTo.setFont(font);

		final DefaultListModel model = new DefaultListModel();
		
		// create scroll conainer
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 189, 255, 251);

		// create list
		JList list = new JList(model);
		list.setBounds(89, 189, 255, 251);
		scrollPane.setViewportView(list);
		scrollPane.setVisible(true);
				
		// Create menu bar
		JMenuBar bar = new JMenuBar();
		bar.setBounds(0, 0, 434, 21);

		// open button
		JButton btnOpenPicture = new JButton("Open pic");
		btnOpenPicture.setBounds(172, 463, 89, 23);
		btnOpenPicture.setFont(font);

		btnGetLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				if (fldInsertLinlk.getText().isEmpty()) {
					return;
				}

				// Parce Instagram's HTML
				String getUrlFromParser = parser.mainParser(fldInsertLinlk
						.getText());

				// Download picture
				String fileName = URLDownloader.getInstance().getImageFile(
						getUrlFromParser);

				model.add(0, fileName);
 
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
		panel.add(scrollPane);
		panel.add(bar);
		panel.add(btnOpenPicture);

	}

	public static void main(String[] args) {

		// Main App created here
		Application appIntagrab = new Application();
		appIntagrab.setVisible(true);
	}

}