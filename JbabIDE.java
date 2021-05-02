import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class JbabIDE extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textarea = new JTextArea();
	private JScrollPane sp = new JScrollPane(textarea);
	private Container c = getContentPane();
	private JMenuBar menubar = new JMenuBar();
	private JMenu file = new JMenu("文件");
	private JMenu debug = new JMenu("调试");
	private JMenu edit = new JMenu("编辑");
	private JMenu source = new JMenu("源码");
	private JMenuItem open = new JMenuItem("打开");
	private JMenuItem save = new JMenuItem("保存");
	private JMenuItem exit = new JMenuItem("退出");
	private JMenuItem saveAndRun = new JMenuItem("保存并运行");
	private JMenuItem fontSettings = new JMenuItem("字体设置");
	private JMenuItem addPrint = new JMenuItem("添加print?命令");
	private JMenuItem addTime = new JMenuItem("添加time命令");
	private JMenuItem addHelp = new JMenuItem("添加help命令");
	private JMenuItem addVar = new JMenuItem("添加var命令");
	private JMenuItem addDel = new JMenuItem("添加del命令");
	private JMenuItem addDef = new JMenuItem("添加def命令");
	private String filename = "Untitled";
	public static Font font;
	private void initialize() {
		setSize(400, 300);
		setTitle(filename + " -- Jbab IDE");
		setVisible(true);
		setDefaultCloseOperation(2);
	}
	private void addItemsToFile() {
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser;
    		    fileChooser = new JFileChooser();
    			FileNameExtensionFilter filter = new FileNameExtensionFilter("jbab file(*.jbab)", "jbab");
    			fileChooser.setFileFilter(filter);
    			int i = fileChooser.showOpenDialog(c);
    			if (i == JFileChooser.APPROVE_OPTION) {
    				File selectedFile = fileChooser.getSelectedFile();
    				try {
    					FileReader in = new FileReader(selectedFile);
    					char byt[] = new char[1024];
    					int len = in.read(byt);
    					textarea.setText(new String(byt, 0, len));
    					in.close();
    					filename = selectedFile.getName();
        				setTitle(filename + " -- Jbab IDE");
    				} catch (Exception ex) {
    					ex.printStackTrace();
    					JbabLauncher.printPrompt();
    				}
    			}
			}
		});
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (filename == "Untitled") {
					JFileChooser fileChooser;
	    		    fileChooser = new JFileChooser();
	    			FileNameExtensionFilter filter = new FileNameExtensionFilter("jbab file(*.jbab)", "jbab");
	    			fileChooser.setFileFilter(filter);
	    			int i = fileChooser.showSaveDialog(c);
	    			if (i == JFileChooser.APPROVE_OPTION) {
	    				File selectedFile = fileChooser.getSelectedFile();
	    				try {
	    					FileWriter out = new FileWriter(selectedFile);
	    					String s = textarea.getText();
	    					out.write(s);
	    					out.close();
	    					filename = selectedFile.getName();
	    					setTitle(filename + " -- Jbab IDE");
	    				} catch (Exception ex) {
	    					ex.printStackTrace();
	    					JbabLauncher.printPrompt();
	    				}
	    			}
				} else {
					try {
						FileWriter out = new FileWriter(new File(filename));
						String s = textarea.getText();
						out.write(s);
						out.close();
					} catch (Exception ex) {
						ex.printStackTrace();
						JbabLauncher.printPrompt();
					}
				}
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JbabIDE.this.dispose();
			}
		});
		file.add(open);
		file.add(save);
		file.add(exit);
	}
	private void addItemsToDebug() {
		saveAndRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (filename == "Untitled") {
					JFileChooser fileChooser;
	    		    fileChooser = new JFileChooser();
	    			FileNameExtensionFilter filter = new FileNameExtensionFilter("jbab file(*.jbab)", "jbab");
	    			fileChooser.setFileFilter(filter);
	    			int i = fileChooser.showSaveDialog(c);
	    			if (i == JFileChooser.APPROVE_OPTION) {
	    				File selectedFile = fileChooser.getSelectedFile();
	    				try {
	    					FileWriter out = new FileWriter(selectedFile);
	    					String s = textarea.getText();
	    					out.write(s);
	    					out.close();
	    					filename = selectedFile.getName();
	    					setTitle(filename + " -- Jbab IDE");
	    				} catch (Exception ex) {
	    					ex.printStackTrace();
	    					JbabLauncher.printPrompt();
	    				}
	    			}
				} else {
					try {
						FileWriter out = new FileWriter(new File(filename));
						String s = textarea.getText();
						out.write(s);
						out.close();
					} catch (Exception ex) {
						ex.printStackTrace();
						JbabLauncher.printPrompt();
					}
				}
				JOptionPane.showMessageDialog(c, "保存完成！");
				boolean orig_echo = JbabLauncher.echo;
				JbabLauncher.echo = false;
				String[] statements = JbabUI.getStatements(filename);
				for (String statement: statements) {
					JbabLauncher.runcomm(statement);
				}
				JbabLauncher.echo = orig_echo;
				JbabLauncher.printPrompt();
			}
		});
		debug.add(saveAndRun);
	}
	private void addItemsToEdit() {
		fontSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FontFrame(textarea);
			}
		});
		edit.add(fontSettings);
	}
	private void addItemsToSource() {
		addPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textarea.append("print?" + "\r\n");
			}
		});
		addTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textarea.append("time" + "\r\n");
			}
		});
		addHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textarea.append("help" + "\r\n");
			}
		});
		addVar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textarea.append("var?" + "\r\n");
			}
		});
		addDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textarea.append("del?" + "\r\n");
			}
		});
		addDef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textarea.append("def?[name] {}" + "\r\n");
			}
		});
		source.add(addPrint);
		source.add(addTime);
		source.add(addHelp);
		source.add(addVar);
		source.add(addDel);
		source.add(addDef);
	}
	private void addMenus() {
		menubar.add(file);
		menubar.add(debug);
		menubar.add(edit);
		menubar.add(source);
		addItemsToFile();
		addItemsToDebug();
		addItemsToEdit();
		addItemsToSource();
	}
	public JbabIDE() {
		c.add(sp);
		initialize();
		setJMenuBar(menubar);
		addMenus();
	}
}