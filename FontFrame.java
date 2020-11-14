import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FontFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static int size = 16;
	private static int style = 0;
	private static Font font = new Font("Calibri", style, size);
	private GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private String[] fontNames = e.getAvailableFontFamilyNames();
	private String[] fontTypes = {"普通", "粗体", "斜体", "粗体和斜体"};
	private JList<String> fontNamesList = new JList<>(fontNames);
	private JList<String> fontTypesList = new JList<>(fontTypes);
	private JScrollPane fontNamesScroll = new JScrollPane(fontNamesList);
	private JScrollPane fontTypesScroll = new JScrollPane(fontTypesList);
	private Container c = getContentPane();
	private JButton ok = new JButton("确定");
	private JButton cancel = new JButton("取消");
	private JTextArea textarea;
	private JPanel pn = new JPanel();
	private JPanel okCelPn = new JPanel();
	private JPanel fontPn = new JPanel();
	private JPanel ptPn = new JPanel();
	private JLabel fontLabel = new JLabel("字体：");
	private JLabel styleLabel = new JLabel("风格：");
	private JLabel ptLabel = new JLabel("字号：");
	private SpinnerModel spinnerModel = new SpinnerNumberModel(size, 0, 100, 2);
	private JSpinner spinner = new JSpinner(spinnerModel);
	private int type() {
		if (fontTypesList.getSelectedValue().equals("普通")) {
			return 0;
		} else if (fontTypesList.getSelectedValue().equals("粗体")) {
			return 1;
		} else if (fontTypesList.getSelectedValue().equals("斜体")) {
			return 2;
		} else if (fontTypesList.getSelectedValue().equals("粗体和斜体")){
			return 3;
		} else {
			return 0;
		}
	}
	public FontFrame(JTextArea textarea) {
		this.textarea = textarea;
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				style = FontFrame.this.type();
				size = Integer.parseInt(spinner.getValue().toString());
				font = new Font((String)fontNamesList.getSelectedValue(), style, size);
				FontFrame.this.textarea.setFont(font);
				FontFrame.this.dispose();
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FontFrame.this.dispose();
			}
		});
		pn.setLayout(new GridLayout(2, 1));
		pn.add(fontPn);
		pn.add(ptPn);
		fontPn.add(fontLabel);
		fontPn.add(fontNamesScroll);
		fontPn.add(styleLabel);
		fontPn.add(fontTypesScroll);
		ptPn.add(ptLabel);
		ptPn.add(spinner);
		fontNamesList.setVisibleRowCount(5);
		fontNamesList.setFixedCellWidth(60);
		fontNamesList.setSelectedIndex(0);
		fontNamesList.setSelectedValue(font.getFontName(), true);
		fontTypesList.setVisibleRowCount(5);
		fontTypesList.setSelectedIndex(style);
		okCelPn.add(ok);
		okCelPn.add(cancel);
		okCelPn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		c.add(pn, BorderLayout.CENTER);
		c.add(okCelPn, BorderLayout.SOUTH);
		pack();
		setTitle("Font");
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
