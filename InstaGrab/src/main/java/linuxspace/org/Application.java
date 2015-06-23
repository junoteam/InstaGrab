package linuxspace.org;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Application extends JFrame {
	
	private LinkParser parser;
	private JTextField fldInsertLinlk;

	public Application() {
		this.initUI();
		this.parser = new LinkParser();
		
	}

	public void initUI() {
		setTitle("Instagrab Window");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Create panel
        JPanel panel = new JPanel();
	    getContentPane().add(panel);
        panel.setLayout(null);

		// Button create
		JButton btnGetLink = new JButton("Get Photo");
		btnGetLink.setBounds(240, 180, 90, 30);
		
		btnGetLink.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent event) {
		        parser.mainParser(fldInsertLinlk.getText());
		  }
		});
		
		//Create edit text
		fldInsertLinlk = new JTextField();
		fldInsertLinlk.setBounds(240, 140, 160, 30);
				
		// Set to layout
		panel.add(btnGetLink);
		panel.add(fldInsertLinlk);
	}
	
	public static void main(String[] args) {
		Application app = new Application();
		app.setVisible(true);
	}

}