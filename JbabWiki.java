import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
public class JbabWiki extends JFrame {
	private static final long serialVersionUID = 1L;
	private ArrayList<String[]> content = Properties.getContents();
	private ArrayList<String> address = Properties.getAddress();
	private JTextArea text = new JTextArea();
	private JTextField adf = new JTextField(20);
	private JButton browse = new JButton("���");
	private JScrollPane sp = new JScrollPane(text);
	private Container c = getContentPane();
	public void addBrowseListener() {
		adf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				browse.doClick();
			}
		});
		browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p = adf.getText();
				if (!address.contains(p)) {
					try {
						Desktop.getDesktop().browse(new URI(p));
					} catch (Exception ex) {
					}
				} else {
					int ind = address.indexOf(p);
					String text_[] = content.get(ind);
					Utils.setText(text, text_);
				}
			}
		});
	}
	private void initialize() {
		addBrowseListener();
		text.setEditable(false);
		c.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.add(adf);
		p.add(browse);
		c.add(p, BorderLayout.NORTH);
		c.add(sp, BorderLayout.CENTER);
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(2);
	}
	private static class Utils {
		public static void setText(JTextArea area, String[] contents) {
			area.setText("");
			for (String content: contents) {
				append(area, content);
				append(area, "\r\n");
			}
		}
		public static void append(JTextArea area, String content) {
			area.setText(area.getText() + content);
		}
	}
	public static class Properties {
		private static ArrayList<String> address = new ArrayList<>();
		private static ArrayList<String[]> contents = new ArrayList<>();
		private static ArrayList<String> wiki = new ArrayList<>();
		private static ArrayList<String> commands = new ArrayList<>();
		private static ArrayList<String> help = new ArrayList<>();
		private static ArrayList<String> exit = new ArrayList<>();
		private static ArrayList<String> calculator = new ArrayList<>();
		private static ArrayList<String> callUI = new ArrayList<>();
		private static ArrayList<String> print = new ArrayList<>();
		private static ArrayList<String> ejz = new ArrayList<>();
		private static ArrayList<String> run = new ArrayList<>();
		private static ArrayList<String> version = new ArrayList<>();
		private static ArrayList<String> time = new ArrayList<>();
		private static ArrayList<String> update_record = new ArrayList<>();
		private static ArrayList<String> var = new ArrayList<>();
		private static ArrayList<String> use = new ArrayList<>();
		private static ArrayList<String> del = new ArrayList<>();
		private static ArrayList<String> for_ = new ArrayList<>();
		private static ArrayList<String> def = new ArrayList<>();
		private static ArrayList<String> call = new ArrayList<>();
		private static ArrayList<String> blockdel = new ArrayList<>();
		private static ArrayList<String> blockcontent = new ArrayList<>();
		private static ArrayList<String> blocklist = new ArrayList<>();
		private static ArrayList<String> echo = new ArrayList<>();
		private static ArrayList<String> eval = new ArrayList<>();
		private static ArrayList<String> wiki_ = new ArrayList<>();
		private static ArrayList<String> wait = new ArrayList<>();
		private static ArrayList<String> nil = new ArrayList<>();
		private static ArrayList<String> ide = new ArrayList<>();
		private static ArrayList<String> kits = new ArrayList<>();
		private static ArrayList<String> cmd = new ArrayList<>();
		private static ArrayList<String> ui = new ArrayList<>();
		private static ArrayList<String> calculator_ = new ArrayList<>();
		private static ArrayList<String> wiki__ = new ArrayList<>();
		private static ArrayList<String> ide_ = new ArrayList<>();
		private static ArrayList<String> u100 = new ArrayList<>();
		private static ArrayList<String> u101 = new ArrayList<>();
		private static ArrayList<String> u102 = new ArrayList<>();
		private static ArrayList<String> u102a = new ArrayList<>();
		private static ArrayList<String> u103 = new ArrayList<>();
		private static ArrayList<String> u104 = new ArrayList<>();
		private static ArrayList<String> u105 = new ArrayList<>();
		private static ArrayList<String> u106 = new ArrayList<>();
		private static ArrayList<String> u110 = new ArrayList<>();
		private static ArrayList<String> u111 = new ArrayList<>();
		private static void initiateAddress() {
			address.clear();
			address.add("zhanghy://jbab.wikipebio.com/JbabWiki");
			addCommands();
			addKits();
			addUpdates();
		}
		private static void addCommands() {
			address.add("zhanghy://jbab.wikipebio.com/commands");
			address.add("zhanghy://jbab.wikipebio.com/commands/help");
			address.add("zhanghy://jbab.wikipebio.com/commands/exit");
			address.add("zhanghy://jbab.wikipebio.com/commands/calculator");
			address.add("zhanghy://jbab.wikipebio.com/commands/callUI");
			address.add("zhanghy://jbab.wikipebio.com/commands/print");
			address.add("zhanghy://jbab.wikipebio.com/commands/ejz");
			address.add("zhanghy://jbab.wikipebio.com/commands/run");
			address.add("zhanghy://jbab.wikipebio.com/commands/version");
			address.add("zhanghy://jbab.wikipebio.com/commands/time");
			address.add("zhanghy://jbab.wikipebio.com/commands/update_record");
			address.add("zhanghy://jbab.wikipebio.com/commands/var");
			address.add("zhanghy://jbab.wikipebio.com/commands/use");
			address.add("zhanghy://jbab.wikipebio.com/commands/del");
			address.add("zhanghy://jbab.wikipebio.com/commands/for");
			address.add("zhanghy://jbab.wikipebio.com/commands/def");
			address.add("zhanghy://jbab.wikipebio.com/commands/call");
			address.add("zhanghy://jbab.wikipebio.com/commands/blockdel");
			address.add("zhanghy://jbab.wikipebio.com/commands/blockcontent");
			address.add("zhanghy://jbab.wikipebio.com/commands/blocklist");
			address.add("zhanghy://jbab.wikipebio.com/commands/echo");
			address.add("zhanghy://jbab.wikipebio.com/commands/eval");
			address.add("zhanghy://jbab.wikipebio.com/commands/wiki");
			address.add("zhanghy://jbab.wikipebio.com/commands/wait");
			address.add("zhanghy://jbab.wikipebio.com/commands/value/nil");
			address.add("zhanghy://jbab.wikipebio.com/commands/ide");
		}
		private static void addKits() {
			address.add("zhanghy://jbab.wikipebio.com/kits");
			address.add("zhanghy://jbab.wikipebio.com/kits/cmd");
			address.add("zhanghy://jbab.wikipebio.com/kits/UI");
			address.add("zhanghy://jbab.wikipebio.com/kits/calculator");
			address.add("zhanghy://jbab.wikipebio.com/kits/wiki");
			address.add("zhanghy://jbab.wikipebio.com/kits/ide");
		}
		private static void addUpdates() {
			address.add("zhanghy://jbab.wikipebio.com/updates/1.0.0");
			address.add("zhanghy://jbab.wikipebio.com/updates/1.0.1");
			address.add("zhanghy://jbab.wikipebio.com/updates/1.0.2");
			address.add("zhanghy://jbab.wikipebio.com/updates/1.0.2a");
			address.add("zhanghy://jbab.wikipebio.com/updates/1.0.3");
			address.add("zhanghy://jbab.wikipebio.com/updates/1.0.4");
			address.add("zhanghy://jbab.wikipebio.com/updates/1.0.5");
			address.add("zhanghy://jbab.wikipebio.com/updates/1.0.6");
			address.add("zhanghy://jbab.wikipebio.com/updates/1.1.0");
			address.add("zhanghy://jbab.wikipebio.com/updates/1.1.1");
		}
		private static void initiateContents() {
			contents.clear();
			addWiki();
			addCommands_();
			addHelp();
			addExit();
			addCalculator();
			addCallUI();
			addPrint();
			addEjz();
			addRun();
			addVersion();
			addTime();
			addUpdateRecord();
			addVar();
			addUse();
			addDel();
			addFor();
			addDef();
			addCall();
			addBlockDel();
			addBlockContent();
			addBlockList();
			addEcho();
			addEval();
			addWiki_();
			addWait();
			addNil();
			addIDE();
			addKits_();
			addCmd();
			addUI();
			addCalculator_();
			addWiki__();
			addIDE_();
			addU100();
			addU101();
			addU102();
			addU102a();
			addU103();
			addU104();
			addU105();
			addU106();
			addU110();
			addU111();
			contents.add(wiki.toArray(new String[] {}));
			contents.add(commands.toArray(new String[] {}));
			contents.add(help.toArray(new String[] {}));
			contents.add(exit.toArray(new String[] {}));
			contents.add(calculator.toArray(new String[] {}));
			contents.add(callUI.toArray(new String[] {}));
			contents.add(print.toArray(new String[] {}));
			contents.add(ejz.toArray(new String[] {}));
			contents.add(run.toArray(new String[] {}));
			contents.add(version.toArray(new String[] {}));
			contents.add(time.toArray(new String[] {}));
			contents.add(update_record.toArray(new String[] {}));
			contents.add(var.toArray(new String[] {}));
			contents.add(use.toArray(new String[] {}));
			contents.add(del.toArray(new String[] {}));
			contents.add(for_.toArray(new String[] {}));
			contents.add(def.toArray(new String[] {}));
			contents.add(call.toArray(new String[] {}));
			contents.add(blockdel.toArray(new String[] {}));
			contents.add(blockcontent.toArray(new String[] {}));
			contents.add(blocklist.toArray(new String[] {}));
			contents.add(echo.toArray(new String[] {}));
			contents.add(eval.toArray(new String[] {}));
			contents.add(wiki_.toArray(new String[] {}));
			contents.add(wait.toArray(new String[] {}));
			contents.add(nil.toArray(new String[] {}));
			contents.add(ide.toArray(new String[] {}));
			contents.add(kits.toArray(new String[] {}));
			contents.add(cmd.toArray(new String[] {}));
			contents.add(ui.toArray(new String[] {}));
			contents.add(calculator_.toArray(new String[] {}));
			contents.add(wiki__.toArray(new String[] {}));
			contents.add(ide_.toArray(new String[] {}));
			contents.add(u100.toArray(new String[] {}));
			contents.add(u101.toArray(new String[] {}));
			contents.add(u102.toArray(new String[] {}));
			contents.add(u102a.toArray(new String[] {}));
			contents.add(u103.toArray(new String[] {}));
			contents.add(u104.toArray(new String[] {}));
			contents.add(u105.toArray(new String[] {}));
			contents.add(u106.toArray(new String[] {}));
			contents.add(u110.toArray(new String[] {}));
			contents.add(u111.toArray(new String[] {}));
		}
		private static void addWiki() {
			wiki.clear();
			wiki.add("Jbab");
			wiki.add("Jbab�� �ź��ﲩʿ ��� Jvav��Jaba������һ�ֽű����ԡ�");
			wiki.add("����Jbab�����Jvav��Jaba�����Թ��ܽ�������֮�䡣");
			wiki.add("һ����ʷ");
			wiki.add("2020��7��28��     Jbab 1.0.0��1.0.1���·ֱ���13:37��13:51������");
			wiki.add("2020��7��29��     Jbab 1.0.2���·�����");
			wiki.add("2020��7��29��     ��Ϊ������Jbab IDE���ش�BUG��Jbab 1.0.2���±����أ�����ΪJbab 1.0.2a����Jbab 1.0.1�ϲ���");
			wiki.add("2020��7��29��     Jbab 1.0.3���£��������£�������");
			wiki.add("2020��7��30��     Jbab 1.0.4���£�ѭ�����£�������");
			wiki.add("2020��8��1��        Jbab 1.0.5���£��޲����£�������");
			wiki.add("2020��9��              Jbab 1.0.6���£��������£�������");
			wiki.add("2020��11��14��   Jbab 1.1.0���£�wiki���£�������");
			wiki.add("��������");
			wiki.add("Jbab��Jaba֮����Jvav֮�̣��ںϺ��ܱ���������м䡣");
			wiki.add("Jbabδ�����ܻ������Jbab.awt��Jbab�������ڹ��߼�����ʵ������GUI��");
			wiki.add("��ΪJbab 1.0.2��IDE���£��е�IDE����BUG�����Լ��±���ΪJbab�Ĺٷ�IDE��");
			wiki.add("�������߼���ϵ��ʽ");
			wiki.add("��ȻJbab�������� �ź��ﲩʿ �����Ǵ���ά������ת������lenovo��");
			wiki.add("QQ��2276316223");
		}
		private static void addCommands_() {
			commands.clear();
			commands.add("����");
			commands.add("������Jbab������Ҫ����ɲ���֮һ����һ��Ҫ����Java������Ȼ�����Jbab Kits��Jbab Commands����");
			commands.add("����ĸ�ʽͨ��Ϊ[commandname]?[arguments]������һЩ����������for��def���ĸ�ʽ����Ϊ[commandname]![arguments]��");
			commands.add("�������ݲμ��������ҳ�棨commands/help��commands/exit�ȣ���");
		}
		private static void addHelp() {
			help.clear();
			help.add("����help");
			help.add("һ���÷�");
			help.add("    help");
			help.add("��������");
			help.add("    �ܻ�ɹ�����ʾ������Ϣ��");
			help.add("������ʷ");
			help.add("Jbab 1.0.0���������£�       ������help��");
		}
		private static void addExit() {
			exit.clear();
			exit.add("����exit");
			exit.add("һ���÷�");
			exit.add("   exit");
			exit.add("��������");
			exit.add("   �ܻ�ɹ����˳�Jbab CMD��");
			exit.add("������ʷ");
			exit.add("Jbab 1.0.0���������£�       ������exit��");
		}
		private static void addCalculator() {
			calculator.clear();
			calculator.add("����calculator");
			calculator.add("һ���÷�");
			calculator.add("   calculator");
			calculator.add("��������");
			calculator.add("   �ܻ�ɹ���ת��Jbab Calculator��");
			calculator.add("������ʷ");
			calculator.add("Jbab 1.0.0���������£�       ������calculator��");
		}
		private static void addCallUI() {
			callUI.clear();
			callUI.add("����callUI");
			callUI.add("һ���÷�");
			callUI.add("   callUI");
			callUI.add("��������");
			callUI.add("   �ܻ�ɹ�����ʾJbab UI��");
			callUI.add("������ʷ");
			callUI.add("Jbab 1.0.0���������£�       ������callUI��");
		}
		private static void addPrint() {
			print.clear();
			print.add("����print");
			print.add("һ���÷�");
			print.add("   print?[message]");
			print.add("   print?var_[varname]");
			print.add("��������");
			print.add("   �ڵ�һ���÷��У��ܻ�ɹ�������Ļ����ʾmessage�����ݡ�");
			print.add("   �ڵڶ����÷��У���û�б�������Ӧ�ı���ʱ��ʧ�ܡ��ɹ�ʱ����Ļ����ʾvarname��Ӧ������ֵ��");
			print.add("������ʷ");
			print.add("Jbab 1.0.0���������£�       ������print����ʱ��printֻ�е�һ���÷���");
			print.add("Jbab 1.0.3���������£�       ������print�ĵڶ����÷�����ʱ�ĵڶ����÷�Ϊprint?var [varname]��");
			print.add("Jbab 1.0.5���޲����£�       �޸���print�ĵڶ����÷���Ϊ����1.0.4�е�forѭ�������ڶ����÷��ĳ���print?var_[varname]��");
		}
		private static void addEjz() {
			ejz.clear();
			ejz.add("����ejz");
			ejz.add("һ���÷�");
			ejz.add("   ejz?[int]");
			ejz.add("��������");
			ejz.add("   �������intֵ����[-2147483648, 2147483647]���������ǻ�ʧ�ܡ��ɹ�ʱ��intֵתΪ������");
			ejz.add("������ʷ");
			ejz.add("Jbab 1.0.0���������£�       ������ejz��");
		}
		private static void addRun() {
			run.clear();
			run.add("����run");
			run.add("һ���÷�");
			run.add("   run?[filename]");
			run.add("��������");
			run.add("   ���ļ�����Ӧ���ļ�������ʱʧ�ܡ��ɹ�ʱִ���ļ��ڵ�ÿһ�����");
			run.add("������ʷ");
			run.add("Jbab 1.0.0���������£�       ������run��");
			run.add("Jbab 1.0.6���������£�       �޸���run��ϸ�ڣ�ʹ��֧�ֻ���ֵ�����á�");
		}
		private static void addVersion() {
			version.clear();
			version.add("����version");
			version.add("���˲��������Ѵ�Jbab�Ƴ��������Կ���ͨ��ʹ�þɰ汾�ķ�ʽ��ʹ������");
			version.add("һ���÷�");
			version.add("   version");
			version.add("��������");
			version.add("   �ܻ�ɹ�����ʾ��ǰ�汾���䷢��ʱ�䡢����汾���䷢��ʱ�䡣");
			version.add("������ʷ");
			version.add("Jbab 1.0.1��UI���£�       ������version��");
			version.add("Jbab 1.1.0��wiki���£�  �Ƴ���version������Ϊ���ǵ� �ź��ﲩʿ ̫����");
		}
		private static void addTime() {
			time.clear();
			time.add("����time");
			time.add("һ���÷�");
			time.add("   time");
			time.add("��������");
			time.add("   �ܻ�ɹ�����ʾ��ǰʱ�䣨��ʽ����/��/�� ʱ:��:��");
			time.add("������ʷ");
			time.add("Jbab 1.0.1��UI���£�       ������time��");
			time.add("Jbab 1.0.3���������£�     �޸���time��ʹ����ʾ����Ϣ�������ۡ�");
		}
		private static void addUpdateRecord() {
			update_record.clear();
			update_record.add("����update_record");
			update_record.add("һ���÷�");
			update_record.add("   update_record");
			update_record.add("��������");
			update_record.add("   �ܻ�ɹ�����ʾ���¼�¼��");
			update_record.add("������ʷ");
			update_record.add("Jbab 1.0.1��UI���£�       ������update record��");
			update_record.add("Jbab 1.0.5���޲����£�     Ϊ����1.0.4�е�forѭ����update record����Ϊupdate_record��");
		}
		private static void addVar() {
			var.clear();
			var.add("����var");
			var.add("һ���÷�");
			var.add("   var?[varname]=[value]:[type]");
			var.add("   var?[varname]=var [anothervarname]:[type]");
			var.add("   var?[varname]");
			var.add("��������");
			var.add("   �����ֶ����ܻ�ɹ���");
			var.add("   ��һ�ֻ��ֵ������������varname��֮ǰ���ظ������¸�ֵ��");
			var.add("   �ڶ��ֻ�ѵڶ��������ڵ�ֵ������һ�������ڡ������Լ����Լ���ֵ��");
			var.add("   �����ֻ�ѱ����ڵ�ֵ��Ϊnil��");
			var.add("������ʷ");
			var.add("Jbab 1.0.3���������£�      ������var����ʱ��varֻ�е�һ�͵������÷�����var�ĵ�һ���÷���ʱΪvar?[varname] = [value]��");
			var.add("Jbab 1.0.5���޲����£�      Ϊ����1.0.4�м����forѭ�����޸�var�ĵ�һ���÷�Ϊvar?[varname]=[value]��");
			var.add("Jbab 1.1.0��wiki���£�    ������var�ĵڶ����÷�����var?[varname]=var [anothervarname]��");
			var.add("Jbab 1.1.1                             �����˱��������ͣ����µ�һ�͵ڶ����÷��ĸ�ʽ�޸ġ�");
		}
		private static void addUse() {
			use.clear();
			use.add("����use");
			use.add("һ���÷�");
			use.add("   use?[varname]");
			use.add("��������");
			use.add("   ����������Ӧ�ı���������ʱʧ�ܡ��ɹ�ʱ��ʾ[varname] = value��");
			use.add("������ʷ");
			use.add("Jbab 1.0.3���������£�      ������use��");
		}
		private static void addDel() {
			del.clear();
			del.add("����del");
			del.add("һ���÷�");
			del.add("   del?[varname]");
			del.add("��������");
			del.add("   ������������ʱʧ�ܡ��ɹ�ʱɾ����Ӧ�ı�����");
			del.add("������ʷ");
			del.add("Jbab 1.0.3���������£�      ������del��");
		}
		private static void addFor() {
			for_.clear();
			for_.add("����for");
			for_.add("һ���÷�");
			for_.add("   for!times = [int] : {statement1/statement2/...}");
			for_.add("��������");
			for_.add("   ��������������ֵʱʧ�ܡ��ɹ�ʱִ�д�������������������Ρ�");
			for_.add("������ʷ");
			for_.add("Jbab 1.0.4��ѭ�����£�      ������for��");
			for_.add("Jbab 1.0.6���������£�      �޸���for��ϸ�ڣ�ʹ��֧�ֻ���ֵ�����á�");
		}
		private static void addDef() {
			def.clear();
			def.add("����def");
			def.add("һ���÷�");
			def.add("   def![name] {statement1/statement2/...}");
			def.add("��������");
			def.add("   �ܻ�ɹ������棩��ʵ���ϵ����������к��пո�ʱ�����ʧ�ܡ�");
			def.add("������ʷ");
			def.add("Jbab 1.0.6���������£�       ������def��");
		}
		private static void addCall() {
			call.clear();
			call.add("����call");
			call.add("һ���÷�");
			call.add("   call?[blockname]");
			call.add("��������");
			call.add("   ������鲻����ʱʧ�ܡ��ɹ�ʱ���д������ÿһ����䡣");
			call.add("������ʷ");
			call.add("Jbab 1.0.6���������£�       ������call��");
		}
		private static void addBlockDel() {
			blockdel.clear();
			blockdel.add("����blockdel");
			blockdel.add("һ���÷�");
			blockdel.add("   blockdel?[codeblockname]");
			blockdel.add("��������");
			blockdel.add("   ������鲻����ʱʧ�ܡ��ɹ�ʱɾ������顣");
			blockdel.add("������ʷ");
			blockdel.add("Jbab 1.0.6���������£�       ������blockdel��");
		}
		private static void addBlockContent() {
			blockcontent.clear();
			blockcontent.add("����blockcontent");
			blockcontent.add("һ���÷�");
			blockcontent.add("   blockcontent?[codeblockname]");
			blockcontent.add("��������");
			blockcontent.add("   ������鲻����ʱʧ�ܡ��ɹ�ʱ��ʾ���е�������䡣");
			blockcontent.add("������ʷ");
			blockcontent.add("Jbab 1.0.6���������£�       ������blockcontent��");
		}
		private static void addBlockList() {
			blocklist.clear();
			blocklist.add("����blocklist");
			blocklist.add("һ���÷�");
			blocklist.add("   blocklist");
			blocklist.add("��������");
			blocklist.add("   �ܻ�ɹ����г����д���顣");
			blocklist.add("������ʷ");
			blocklist.add("Jbab 1.0.6���������£�       ������blocklist��");
		}
		private static void addEcho() {
			echo.clear();
			echo.add("����echo");
			echo.add("һ���÷�");
			echo.add("   echo?[on|off]");
			echo.add("��������");
			echo.add("   ���ṩֵ��Ϊon��offʱʧ�ܡ��ɹ�ʱ�����ṩֵΪon�������ԣ���ʾJBAB CMD> ����Ϊoff��رջ��ԡ�");
			echo.add("������ʷ");
			echo.add("Jbab 1.0.6���������£�       ������echo��");
			echo.add("Jbab 1.1.0��wiki���£�         �޸���echo��ʹ�����ṩֵ��Ϊon��offʱʧ�ܡ�");
		}
		private static void addEval() {
			eval.clear();
			eval.add("����eval");
			eval.add("һ���÷�");
			eval.add("   eval?[expression]");
			eval.add("��������");
			eval.add("   ������ı��ʽ���������������ʱ�����������ȷʱ������0ʱʧ�ܡ��ɹ�ʱ��������ʽ��ֵ�������");
			eval.add("������ʷ");
			eval.add("Jbab 1.1.0��wiki���£�       ������eval��");
		}
		private static void addWiki_() {
			wiki_.clear();
			wiki_.add("����wiki");
			wiki_.add("һ���÷�");
			wiki_.add("   wiki");
			wiki_.add("   wiki?[page]");
			wiki_.add("��������");
			wiki_.add("   �ܻ�ɹ�����wiki�д򿪶�Ӧ��ҳ�档");
			wiki_.add("������ʷ");
			wiki_.add("Jbab 1.1.0��wiki���£�       ������wiki��");
		}
		private static void addWait() {
			wait.clear();
			wait.add("һ���÷�");
			wait.add("   wait?[sec]");
			wait.add("��������");
			wait.add("   ��������Ϊ����ʱʧ�ܡ��ɹ�ʱ�ȴ���Ӧ�롣");
			wait.add("������ʷ");
			wait.add("Jbab 1.1.0��wiki���£�       ������wait��");
		}
		private static void addNil() {
			nil.clear();
			nil.add("����ֵnil");
			nil.add("nil��Jbab 1.0.3���������£��м���������ֵ������ֵ������������None��");
			nil.add("��ʷ");
			nil.add("Jbab 1.0.3���������£�       ������nil��");
		}
		private static void addIDE() {
			ide.clear();
			ide.add("����ide");
			ide.add("һ���÷�");
			ide.add("   ide");
			ide.add("��������");
			ide.add("   �ܻ�ɹ�����Jbab IDE��");
			ide.add("������ʷ");
			ide.add("Jbab 1.0.2��IDE���£�       ������ide��");
			ide.add("Jbab 1.0.2a����ʱ���£�    ��ΪJbab IDE�Ĵ�BUG�Ƴ���IDE��");
			ide.add("Jbab 1.1.0��wiki���£�     Jbab IDE��BUG�޲���ɣ��������¼ӻ���ide��");
		}
		private static void addKits_() {
			kits.add("���");
			kits.add("�����kit����Jbab������ɲ���֮һ��Jbab������ɲ��֣�Java SE��Jbab���Jbab�����������4����CMD��UI��wiki��calculator��");
			kits.add("������Щ����ĸ�����Ϣ��μ���ҳ��");
		}
		private static void addCmd() {
			cmd.clear();
			cmd.add("Jbab CMD");
			cmd.add("Jbab CMD��Jbab�����塣����ʵ����Jbab�ļ����µ�start.bat��");
		}
		private static void addUI() {
			ui.clear();
			ui.add("Jbab UI");
			ui.add("Jbab UI��Jbab��һ��������б������С�ǰ��Jbab��github�Ĺ��ܣ��Լ���ƪ���档");
			ui.add("��ʷ");
			ui.add("Jbab 1.0.1��UI���£�       ������Jbab UI��");
		}
		private static void addCalculator_() {
			calculator_.clear();
			calculator_.add("Jbab Calculator");
			calculator_.add("Jbab Calculator��Jbab��һ����������Ǹ���ͨ�ļ�������");
			calculator_.add("ĿǰJbab Calculator��ͣ������������µĶ�����");
		}
		private static void addWiki__() {
			wiki__.clear();
			wiki__.add("Jbab Wiki");
			wiki__.add("Jbab Wiki��Jbab 1.1.0�м�����������ϸ������Jbab���������͸��¡�");
			wiki__.add("Jbab Wiki���������¡�");
		}
		private static void addIDE_() {
			ide_.clear();
			ide_.add("Jbab IDE");
			ide_.add("Jbab IDE��Jbab 1.0.2���µ����⣬������Ϊ���ش�BUG��1.0.2a���Ƴ��ˡ����޲�BUG����1.1.0�ӻء�");
			ide_.add("�ź��ﲩʿ��������ΪJbab IDE��Ӵ�����������������Ѿ�ͣ����");
		}
		private static void addU100() {
			u100.clear();
			u100.add("Jbab 1.0.0����");
			u100.add("Jbab 1.0.0���£��������������¡�����Jbab�ĵ�һ���汾�����а�����print��ejz��run��callUI�����");
			u100.add("�ڸ��������ʱ��Jbab 1.0.0������Դ����û�п������أ�һ�ܺ���ṩ��Jbab 1.0.0�����ء�");
			u100.add("��ʱ���������lenovo���̷���һ����Ƶչʾ�������Ŀ��");
		}
		private static void addU101() {
			u101.clear();
			u101.add("Jbab 1.0.1����");
			u101.add("Jbab 1.0.1���£�������UI���¡�����Jbab�ĵ�2����ʽ�档�����version��time��update record���");
			u101.add("1.0.1������1.0.0������ͬһ����ɡ�");
		}
		private static void addU102() {
			u102.clear();
			u102.add("Jbab 1.0.2����");
			u102.add("Jbab 1.0.2���£�������IDE���¡�����Jbab�ĵ�3����ʽ�档�����ide�����Jbab IDE��");
			u102.add("����1.0.2�ܿ�ͱ������ˣ���Ϊ������time�����޷����е�BUG����ʱJbab��ֻ��ʮ���������");
			u102.add("���ڴ��������lenovo�Դ���Jbab 1.0.2��start.bat��");
		}
		private static void addU102a() {
			u102a.clear();
			u102a.add("Jbab 1.0.2a����");
			u102a.add("Jbab 1.0.2a���£���������ʱ���¡�����Jbab�ĵ�4����ʽ�档�Ƴ���ide�����Jbab IDE��");
			u102a.add("��Ȼ����ΪJbab 1.0.2a������ʵ����Jbab 1.0.1��һ���汾����Ҳ��Ϊʲôgithub��û��Jbab 1.0.2a��");
			u102a.add("��Ȼ����ʱ���£���һֱ��ʱ�������ڡ���");
		}
		private static void addU103() {
			u103.clear();
			u103.add("Jbab 1.0.3����");
			u103.add("Jbab 1.0.3���£��������������¡�����Jbab�ĵ�5����ʽ�档������var��use��del�����Լ�print?var [varname]����������Լ���wiki����");
			u103.add("Jbab 1.0.3������һ����̱�����Ϊ������汾��ʼ��Jbab�����⿪ʼ����github��");
		}
		private static void addU104() {
			u104.clear();
			u104.add("Jbab 1.0.4����");
			u104.add("Jbab 1.0.4���£�������ѭ�����¡�����Jbab�ĵ�6����ʽ�档���� �ź��ﲩʿ �����for��whileһ�����ģ�������ΪJbab��δ���²������ʽ������ֻ������forѭ����");
			u104.add("��ΪJbab 1.0.4�����˺ܶ�BUG������Jbab 1.0.5�������޸���ЩBUG��");
		}
		private static void addU105() {
			u105.clear();
			u105.add("Jbab 1.0.5����");
			u105.add("Jbab 1.0.5���£��������޲����¡�����Jbab�ĵ�7����ʽ�档�޸���һЩ����ĸ�ʽ����update record->update_record, print?var [varname]->print?var_[varname]");
			u105.add("Jbab 1.0.5������û�м����κ��¶�����ֻ���޸���һЩ�����ʽ�Լ���Jbab 1.0.4�е�forѭ����");
		}
		private static void addU106() {
			u106.clear();
			u106.add("Jbab 1.0.6����");
			u106.add("Jbab 1.0.6���£��������������¡�����Jbab�ĵ�8����ʽ�档������def��call��blockdel��blocklist��blockcontent���");
			u106.add("���ڼ���blocklist��blockcontent��blockdel��ʱ���Ѿ���һЩJbab 1.1.0�������ˣ����Կ�����Jbab 1.0.6������һЩJbab 1.1.0�����ݣ���eval��wait�ȣ�������Ϊ��ʱJbab Wiki��û������ɣ�����wiki���������1.0.6�����ܡ�");
		}
		private static void addU110() {
			u110.clear();
			u110.add("Jbab 1.1.0����");
			u110.add("Jbab 1.1.0���£�������wiki���¡�����Jbab�ĵ�9����ʽ�档������wiki��eval��wait����ӻ���ide�����Jbab IDE��");
			u110.add("������±�־��Jbab��1.0ʱ��������ͬʱJbabҲ�����Լ���wiki�͹�����");
			u110.add("������ַ��xiaohuangren1001.orgs.ml");
		}
		private static void addU111() {
			u111.clear();
			u111.add("Jbab 1.1.1����");
			u111.add("Jbab 1.1.1���£�����������������£���һ���֣���������Jbab�ĵ�10����ʽ�档�����˴����������﷨��Ϊ�����������������˻�����");
			u111.add("��û�����ʲô�����");
		}
		public static ArrayList<String> getAddress() {
			initiateAddress();
			return address;
		}
		public static ArrayList<String[]> getContents() {
			initiateContents();
			return contents;
		}
	}
	public JbabWiki(String page) {
		initialize();
		if (!address.contains(page)) {
			try {
				Desktop.getDesktop().browse(new URI(page));
			} catch (Exception e) {
			}
		} else {
			adf.setText(page);
			int i = address.indexOf(page);
			String[] c = content.get(i);
			Utils.setText(text, c);
		}
	}
	public JbabWiki() {
		this("zhanghy://jbab.wikipebio.com/JbabWiki");
	}
}
