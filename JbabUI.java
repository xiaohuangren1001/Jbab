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
		JLabel label = new JLabel("欢迎来到JBAB UI，请在下面的文本框内文件名以编译，Jbab版本：1.1.1");
		JButton button1 = new JButton("关于Jbab");
		JButton button2 = new JButton("Jbab1.0.2更新取消公告");
		JButton button3 = new JButton("前往Jbab github");
		JButton button4 = new JButton("编译");
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
				JOptionPane.showMessageDialog(getContentPane(), "因为Jbab IDE出现一处较大BUG无法修补，故撤回Jbab 1.0.2更新");
			}
		});
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				JOptionPane.showMessageDialog(getContentPane(), "Jbab 是张浩扬博士的又一力作，它结合了jvav和jaba，在2019年13月32日25时61分61秒发布。" + System.getProperty("line.separator") + "自从张浩扬博士开发Jbab IDE失败后，张浩扬博士决定用低调奢华的记事本作为Jbab的官方IDE。" + System.getProperty("line.separator") +  "Jbab作为一个命令行编程语言，已经达到了cmd都比它高的高度，是编写迷你世界的最好语言。" + System.getProperty("line.separator") + "张浩扬博士表示，新的Jbab 1.0.2更新将会发布，但是目前似乎并没有Jbab 1.0.2的计划。" + System.getProperty("line.separator") + "·全球有0.0001万人使用Jbab" + System.getProperty("line.separator") + "·全球97%的电脑没有Jbab");
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
