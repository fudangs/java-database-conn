import java.awt.EventQueue;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class loginPage {

	private JFrame frame;
	private JTextField iLogin;
	private JPasswordField iSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPage window = new loginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		frame.setBounds(100, 100, 142, 207);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					autentica();
				}
			}
		});
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(10, 11, 46, 14);
		panel.add(lblLogin);
		
		iLogin = new JTextField();
		iLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					autentica();
				}
			}
		});
		lblLogin.setLabelFor(iLogin);
		iLogin.setBackground(Color.GRAY);
		iLogin.setForeground(Color.WHITE);
		iLogin.setBounds(10, 26, 103, 20);
		panel.add(iLogin);
		iLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(10, 57, 46, 14);
		panel.add(lblSenha);
		
		iSenha = new JPasswordField();
		iSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					autentica();
				}
			}
		});
		lblSenha.setLabelFor(iSenha);
		iSenha.setForeground(Color.WHITE);
		iSenha.setBackground(Color.GRAY);
		iSenha.setBounds(10, 71, 103, 20);
		panel.add(iSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					autentica();
				}
			}
		});

		JLabel lblRes = new JLabel("");
		lblRes.setBounds(252, 105, 172, 14);
		panel.add(lblRes);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				autentica();
			}
		});
		btnEntrar.setBounds(10, 102, 103, 51);
		panel.add(btnEntrar);
		
	}
	private void autentica() {
			try {
				int id = ConnectDb.auth(iLogin.getText(), String.valueOf(iSenha.getPassword()));
				String nome = ConnectDb.getNome(id);
				if(id != 0) {
					JOptionPane.showMessageDialog(null, "Usuário "+ nome +" autenticado com sucesso!");
					mainMenu.main(null);
//					System.exit(0);
				}else {
					JOptionPane.showMessageDialog(null, "Login ou Senha inválidos!");
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(null, "Não foi possivel buscar o usuário no momento");
			}
//			lblRes.setText(ConnectDb.getSql(rs));
	}
}
