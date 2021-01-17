import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JbabUI extends JFrame {
	private static final long serialVersionUID = 1L;
	public JbabUI() {
		setSize(600, 300);
		setTitle("JBAB UI");
		setVisible(true);
		setDefaultCloseOperation(2);
		JLabel label = new JLabel("��ӭ����JBAB UI������������ı������ļ����Ա��룬Jbab�汾��1.1.1");
		JButton button1 = new JButton("����Jbab");
		JButton button2 = new JButton("Jbab1.0.2����ȡ������");
		JButton button3 = new JButton("ǰ��Jbab github");
		JButton button4 = new JButton("����");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		JTextField textField = new JTextField(20);
		JPanel panel2 = new JPanel();
		panel2.add(label);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(textField);
		panel.add(button4);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel2, BorderLayout.NORTH);
		getContentPane().add(buttonPanel, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean orig_echo = JbabLauncher.echo;
				JbabLauncher.echo = false;
				String[] statements = getStatements(textField.getText());
				textField.setText("");
				System.out.println();
				for (String statement: statements) {
					JbabLauncher.runcomm(statement);
				}
				JbabLauncher.echo = orig_echo;
				JbabLauncher.printPrompt();
			}
		});
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					URI url = new URI("https://www.github.com/xiaohuangren1001/Jbab");
					Desktop.getDesktop().browse(url);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				JOptionPane.showMessageDialog(getContentPane(), "��ΪJbab IDE����һ���ϴ�BUG�޷��޲����ʳ���Jbab 1.0.2����");
			}
		});
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				JOptionPane.showMessageDialog(getContentPane(), "Jbab ���ź��ﲩʿ����һ�������������jvav��jaba����2019��13��32��25ʱ61��61�뷢����" + System.getProperty("line.separator") + "�Դ��ź��ﲩʿ����Jbab IDEʧ�ܺ��ź��ﲩʿ�����õ͵��ݻ��ļ��±���ΪJbab�Ĺٷ�IDE��" + System.getProperty("line.separator") +  "Jbab��Ϊһ�������б�����ԣ��Ѿ��ﵽ��cmd�������ߵĸ߶ȣ��Ǳ�д���������������ԡ�" + System.getProperty("line.separator") + "�ź��ﲩʿ��ʾ���µ�Jbab 1.0.2���½��ᷢ��������Ŀǰ�ƺ���û��Jbab 1.0.2�ļƻ���" + System.getProperty("line.separator") + "��ȫ����0.0001����ʹ��Jbab" + System.getProperty("line.separator") + "��ȫ��97%�ĵ���û��Jbab");
			}
		});
	}
	public static String[] getStatements(String fileName) {
		try {
			FileInputStream is = new FileInputStream(new File(fileName));
			byte byt[] = new byte[(int) new File(fileName).length()];
			int len = is.read(byt);
			String message = new String(byt, 0, len);
			String[] statements = message.split("\\r?\\n");
			return statements;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
