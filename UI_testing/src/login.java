
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUserNmae;
	private JTextField name_UserName;
	private JTextField name_Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUserNmae = new JLabel("UserName    : ");
		lblUserNmae.setBounds(116, 68, 80, 14);
		contentPane.add(lblUserNmae);
		
		JLabel lblPassword = new JLabel("Password   : ");
		lblPassword.setBounds(116, 93, 80, 14);
		contentPane.add(lblPassword);
		
		name_UserName = new JTextField();
		name_UserName.setBounds(206, 65, 86, 20);
		contentPane.add(name_UserName);
		name_UserName.setColumns(10);
		
		name_Password = new JTextField();
		name_Password.setColumns(10);
		name_Password.setBounds(206, 90, 86, 20);
		contentPane.add(name_Password);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = name_UserName.getText();
				String password = name_Password.getText();
				try {
				DBManager objMgr = new DBManager();
				String query = "INSERT INTO login VALUES ('" + id + "', '" + password + "')";
				objMgr.insertUpdateDelete (query);
				JOptionPane.showMessageDialog(login.this, "Data Saved Sucessfully!");
				welcome welcomePage = new welcome();
				welcomePage.setVisible(true);
				} catch (Exception ex) {
				}
			}
		});
		btnNewButton.setBounds(248, 135, 89, 23);
		contentPane.add(btnNewButton);
	}

	public JLabel getLblNewLabel() {
		return lblUserNmae;
	}
}
