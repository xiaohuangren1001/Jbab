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
	private JButton browse = new JButton("浏览");
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
			wiki.add("Jbab是 张浩扬博士 结合 Jvav和Jaba开发的一种脚本语言。");
			wiki.add("由于Jbab结合了Jvav和Jaba，所以功能介于两者之间。");
			wiki.add("一、历史");
			wiki.add("2020年7月28日     Jbab 1.0.0与1.0.1更新分别于13:37和13:51发布。");
			wiki.add("2020年7月29日     Jbab 1.0.2更新发布。");
			wiki.add("2020年7月29日     因为发现了Jbab IDE的重大BUG，Jbab 1.0.2更新被撤回，更名为Jbab 1.0.2a，与Jbab 1.0.1合并。");
			wiki.add("2020年7月29日     Jbab 1.0.3更新（变量更新）发布。");
			wiki.add("2020年7月30日     Jbab 1.0.4更新（循环更新）发布。");
			wiki.add("2020年8月1日        Jbab 1.0.5更新（修补更新）发布。");
			wiki.add("2020年9月              Jbab 1.0.6更新（函数更新）发布。");
			wiki.add("2020年11月14日   Jbab 1.1.0更新（wiki更新）发布。");
			wiki.add("二、特性");
			wiki.add("Jbab吸Jaba之长、Jvav之短，融合后功能变得在两者中间。");
			wiki.add("Jbab未来可能还会更新Jbab.awt（Jbab废弃窗口工具集）来实现制作GUI。");
			wiki.add("因为Jbab 1.0.2（IDE更新）中的IDE出现BUG，所以记事本成为Jbab的官方IDE。");
			wiki.add("三、作者及联系方式");
			wiki.add("虽然Jbab的作者是 张浩扬博士 ，但是代码维护工作转交给了lenovo。");
			wiki.add("QQ：2276316223");
		}
		private static void addCommands_() {
			commands.clear();
			commands.add("命令");
			commands.add("命令是Jbab中最重要的组成部分之一（第一重要的是Java环境，然后才是Jbab Kits和Jbab Commands）。");
			commands.add("命令的格式通常为[commandname]?[arguments]，但是一些特殊的命令（如for、def）的格式更改为[commandname]![arguments]。");
			commands.add("更多内容参见命令的子页面（commands/help、commands/exit等）。");
		}
		private static void addHelp() {
			help.clear();
			help.add("命令help");
			help.add("一、用法");
			help.add("    help");
			help.add("二、条件");
			help.add("    总会成功。显示帮助信息。");
			help.add("三、历史");
			help.add("Jbab 1.0.0（基础更新）       加入了help。");
		}
		private static void addExit() {
			exit.clear();
			exit.add("命令exit");
			exit.add("一、用法");
			exit.add("   exit");
			exit.add("二、条件");
			exit.add("   总会成功。退出Jbab CMD。");
			exit.add("三、历史");
			exit.add("Jbab 1.0.0（基础更新）       加入了exit。");
		}
		private static void addCalculator() {
			calculator.clear();
			calculator.add("命令calculator");
			calculator.add("一、用法");
			calculator.add("   calculator");
			calculator.add("二、条件");
			calculator.add("   总会成功。转至Jbab Calculator。");
			calculator.add("三、历史");
			calculator.add("Jbab 1.0.0（基础更新）       加入了calculator。");
		}
		private static void addCallUI() {
			callUI.clear();
			callUI.add("命令callUI");
			callUI.add("一、用法");
			callUI.add("   callUI");
			callUI.add("二、条件");
			callUI.add("   总会成功。显示Jbab UI。");
			callUI.add("三、历史");
			callUI.add("Jbab 1.0.0（基础更新）       加入了callUI。");
		}
		private static void addPrint() {
			print.clear();
			print.add("命令print");
			print.add("一、用法");
			print.add("   print?[message]");
			print.add("   print?var_[varname]");
			print.add("二、条件");
			print.add("   在第一种用法中，总会成功。在屏幕上显示message的内容。");
			print.add("   在第二种用法中，当没有变量名对应的变量时会失败。成功时在屏幕上显示varname对应变量的值。");
			print.add("三、历史");
			print.add("Jbab 1.0.0（基础更新）       加入了print。此时的print只有第一种用法。");
			print.add("Jbab 1.0.3（变量更新）       加入了print的第二种用法。当时的第二种用法为print?var [varname]。");
			print.add("Jbab 1.0.5（修补更新）       修改了print的第二种用法（为兼容1.0.4中的for循环）。第二种用法改成了print?var_[varname]。");
		}
		private static void addEjz() {
			ejz.clear();
			ejz.add("命令ejz");
			ejz.add("一、用法");
			ejz.add("   ejz?[int]");
			ejz.add("二、条件");
			ejz.add("   当后面的int值不在[-2147483648, 2147483647]或不是整数是会失败。成功时将int值转为二进制");
			ejz.add("三、历史");
			ejz.add("Jbab 1.0.0（基础更新）       加入了ejz。");
		}
		private static void addRun() {
			run.clear();
			run.add("命令run");
			run.add("一、用法");
			run.add("   run?[filename]");
			run.add("二、条件");
			run.add("   当文件名对应的文件不存在时失败。成功时执行文件内的每一条命令。");
			run.add("三、历史");
			run.add("Jbab 1.0.0（基础更新）       加入了run。");
			run.add("Jbab 1.0.6（函数更新）       修改了run的细节，使其支持回显值的设置。");
		}
		private static void addVersion() {
			version.clear();
			version.add("命令version");
			version.add("（此部分内容已从Jbab移除，但您仍可以通过使用旧版本的方式来使用它）");
			version.add("一、用法");
			version.add("   version");
			version.add("二、条件");
			version.add("   总会成功。显示当前版本及其发布时间、最初版本及其发布时间。");
			version.add("三、历史");
			version.add("Jbab 1.0.1（UI更新）       加入了version。");
			version.add("Jbab 1.1.0（wiki更新）  移除了version。（因为我们的 张浩扬博士 太懒）");
		}
		private static void addTime() {
			time.clear();
			time.add("命令time");
			time.add("一、用法");
			time.add("   time");
			time.add("二、条件");
			time.add("   总会成功。显示当前时间（格式：年/月/日 时:分:秒");
			time.add("三、历史");
			time.add("Jbab 1.0.1（UI更新）       加入了time。");
			time.add("Jbab 1.0.3（变量更新）     修改了time，使其显示的消息更加美观。");
		}
		private static void addUpdateRecord() {
			update_record.clear();
			update_record.add("命令update_record");
			update_record.add("一、用法");
			update_record.add("   update_record");
			update_record.add("二、条件");
			update_record.add("   总会成功。显示更新记录。");
			update_record.add("三、历史");
			update_record.add("Jbab 1.0.1（UI更新）       加入了update record。");
			update_record.add("Jbab 1.0.5（修补更新）     为兼容1.0.4中的for循环，update record更名为update_record。");
		}
		private static void addVar() {
			var.clear();
			var.add("命令var");
			var.add("一、用法");
			var.add("   var?[varname]=[value]:[type]");
			var.add("   var?[varname]=var [anothervarname]:[type]");
			var.add("   var?[varname]");
			var.add("二、条件");
			var.add("   这三种都是总会成功。");
			var.add("   第一种会把值赋给变量。若varname与之前的重复会重新赋值。");
			var.add("   第二种会把第二个变量内的值赋给第一个变量内。允许自己给自己赋值。");
			var.add("   第三种会把变量内的值设为nil。");
			var.add("三、历史");
			var.add("Jbab 1.0.3（变量更新）      加入了var。此时的var只有第一和第三种用法，且var的第一种用法当时为var?[varname] = [value]。");
			var.add("Jbab 1.0.5（修补更新）      为兼容1.0.4中加入的for循环，修改var的第一种用法为var?[varname]=[value]。");
			var.add("Jbab 1.1.0（wiki更新）    加入了var的第二种用法。即var?[varname]=var [anothervarname]。");
			var.add("Jbab 1.1.1                             加入了变量的类型，导致第一和第二种用法的格式修改。");
		}
		private static void addUse() {
			use.clear();
			use.add("命令use");
			use.add("一、用法");
			use.add("   use?[varname]");
			use.add("二、条件");
			use.add("   当变量名对应的变量不存在时失败。成功时显示[varname] = value。");
			use.add("三、历史");
			use.add("Jbab 1.0.3（变量更新）      加入了use。");
		}
		private static void addDel() {
			del.clear();
			del.add("命令del");
			del.add("一、用法");
			del.add("   del?[varname]");
			del.add("二、条件");
			del.add("   当变量不存在时失败。成功时删除对应的变量。");
			del.add("三、历史");
			del.add("Jbab 1.0.3（变量更新）      加入了del。");
		}
		private static void addFor() {
			for_.clear();
			for_.add("命令for");
			for_.add("一、用法");
			for_.add("   for!times = [int] : {statement1/statement2/...}");
			for_.add("二、条件");
			for_.add("   当次数不是整数值时失败。成功时执行大括号内所有语句整数次。");
			for_.add("三、历史");
			for_.add("Jbab 1.0.4（循环更新）      加入了for。");
			for_.add("Jbab 1.0.6（函数更新）      修改了for的细节，使其支持回显值的设置。");
		}
		private static void addDef() {
			def.clear();
			def.add("命令def");
			def.add("一、用法");
			def.add("   def![name] {statement1/statement2/...}");
			def.add("二、条件");
			def.add("   总会成功（明面）。实际上当后面的语句中含有空格时会编译失败。");
			def.add("三、历史");
			def.add("Jbab 1.0.6（函数更新）       加入了def。");
		}
		private static void addCall() {
			call.clear();
			call.add("命令call");
			call.add("一、用法");
			call.add("   call?[blockname]");
			call.add("二、条件");
			call.add("   当代码块不存在时失败。成功时运行代码块中每一条语句。");
			call.add("三、历史");
			call.add("Jbab 1.0.6（函数更新）       加入了call。");
		}
		private static void addBlockDel() {
			blockdel.clear();
			blockdel.add("命令blockdel");
			blockdel.add("一、用法");
			blockdel.add("   blockdel?[codeblockname]");
			blockdel.add("二、条件");
			blockdel.add("   当代码块不存在时失败。成功时删除代码块。");
			blockdel.add("三、历史");
			blockdel.add("Jbab 1.0.6（函数更新）       加入了blockdel。");
		}
		private static void addBlockContent() {
			blockcontent.clear();
			blockcontent.add("命令blockcontent");
			blockcontent.add("一、用法");
			blockcontent.add("   blockcontent?[codeblockname]");
			blockcontent.add("二、条件");
			blockcontent.add("   当代码块不存在时失败。成功时显示其中的所有语句。");
			blockcontent.add("三、历史");
			blockcontent.add("Jbab 1.0.6（函数更新）       加入了blockcontent。");
		}
		private static void addBlockList() {
			blocklist.clear();
			blocklist.add("命令blocklist");
			blocklist.add("一、用法");
			blocklist.add("   blocklist");
			blocklist.add("二、条件");
			blocklist.add("   总会成功。列出所有代码块。");
			blocklist.add("三、历史");
			blocklist.add("Jbab 1.0.6（函数更新）       加入了blocklist。");
		}
		private static void addEcho() {
			echo.clear();
			echo.add("命令echo");
			echo.add("一、用法");
			echo.add("   echo?[on|off]");
			echo.add("二、条件");
			echo.add("   在提供值不为on或off时失败。成功时，若提供值为on则开启回显（显示JBAB CMD> ），为off则关闭回显。");
			echo.add("三、历史");
			echo.add("Jbab 1.0.6（函数更新）       加入了echo。");
			echo.add("Jbab 1.1.0（wiki更新）         修改了echo，使其在提供值不为on或off时失败。");
		}
		private static void addEval() {
			eval.clear();
			eval.add("命令eval");
			eval.add("一、用法");
			eval.add("   eval?[expression]");
			eval.add("二、条件");
			eval.add("   当后面的表达式有两个以上运算符时、运算符不正确时、除以0时失败。成功时计算出表达式的值并输出。");
			eval.add("三、历史");
			eval.add("Jbab 1.1.0（wiki更新）       加入了eval。");
		}
		private static void addWiki_() {
			wiki_.clear();
			wiki_.add("命令wiki");
			wiki_.add("一、用法");
			wiki_.add("   wiki");
			wiki_.add("   wiki?[page]");
			wiki_.add("二、条件");
			wiki_.add("   总会成功。在wiki中打开对应的页面。");
			wiki_.add("三、历史");
			wiki_.add("Jbab 1.1.0（wiki更新）       加入了wiki。");
		}
		private static void addWait() {
			wait.clear();
			wait.add("一、用法");
			wait.add("   wait?[sec]");
			wait.add("二、条件");
			wait.add("   当秒数不为整数时失败。成功时等待对应秒。");
			wait.add("三、历史");
			wait.add("Jbab 1.1.0（wiki更新）       加入了wait。");
		}
		private static void addNil() {
			nil.clear();
			nil.add("特殊值nil");
			nil.add("nil是Jbab 1.0.3（变量更新）中加入的替代空值的特殊值。它的类型是None。");
			nil.add("历史");
			nil.add("Jbab 1.0.3（变量更新）       加入了nil。");
		}
		private static void addIDE() {
			ide.clear();
			ide.add("命令ide");
			ide.add("一、用法");
			ide.add("   ide");
			ide.add("二、条件");
			ide.add("   总会成功。打开Jbab IDE。");
			ide.add("三、历史");
			ide.add("Jbab 1.0.2（IDE更新）       加入了ide。");
			ide.add("Jbab 1.0.2a（临时更新）    因为Jbab IDE的大BUG移除了IDE。");
			ide.add("Jbab 1.1.0（wiki更新）     Jbab IDE的BUG修补完成，所以重新加回了ide。");
		}
		private static void addKits_() {
			kits.add("组件");
			kits.add("组件（kit）是Jbab三大组成部分之一（Jbab三大组成部分：Java SE、Jbab命令、Jbab组件），共有4个：CMD、UI、wiki和calculator。");
			kits.add("关于这些组件的更多信息请参见子页面");
		}
		private static void addCmd() {
			cmd.clear();
			cmd.add("Jbab CMD");
			cmd.add("Jbab CMD是Jbab的主体。它其实就是Jbab文件夹下的start.bat。");
		}
		private static void addUI() {
			ui.clear();
			ui.add("Jbab UI");
			ui.add("Jbab UI是Jbab的一个组件，有编译运行、前往Jbab的github的功能，以及两篇公告。");
			ui.add("历史");
			ui.add("Jbab 1.0.1（UI更新）       加入了Jbab UI。");
		}
		private static void addCalculator_() {
			calculator_.clear();
			calculator_.add("Jbab Calculator");
			calculator_.add("Jbab Calculator是Jbab的一个组件，就是个普通的计算器。");
			calculator_.add("目前Jbab Calculator已停更。（不会加新的东西）");
		}
		private static void addWiki__() {
			wiki__.clear();
			wiki__.add("Jbab Wiki");
			wiki__.add("Jbab Wiki是Jbab 1.1.0中加入的组件。详细介绍了Jbab的命令、组件和更新。");
			wiki__.add("Jbab Wiki将持续更新。");
		}
		private static void addIDE_() {
			ide_.clear();
			ide_.add("Jbab IDE");
			ide_.add("Jbab IDE是Jbab 1.0.2更新的主题，但是因为有重大BUG在1.0.2a中移除了。后修补BUG后于1.1.0加回。");
			ide_.add("张浩扬博士并不打算为Jbab IDE添加代码高亮，并宣布其已经停更。");
		}
		private static void addU100() {
			u100.clear();
			u100.add("Jbab 1.0.0更新");
			u100.add("Jbab 1.0.0更新（又名“基础更新”）是Jbab的第一个版本，其中包括了print、ejz、run、callUI等命令。");
			u100.add("在刚制作完成时，Jbab 1.0.0并不开源，且没有开放下载；一周后才提供了Jbab 1.0.0的下载。");
			u100.add("当时代码管理者lenovo立刻发了一个视频展示这个新项目。");
		}
		private static void addU101() {
			u101.clear();
			u101.add("Jbab 1.0.1更新");
			u101.add("Jbab 1.0.1更新（又名“UI更新”）是Jbab的第2个正式版。添加了version、time和update record命令。");
			u101.add("1.0.1更新与1.0.0更新在同一天完成。");
		}
		private static void addU102() {
			u102.clear();
			u102.add("Jbab 1.0.2更新");
			u102.add("Jbab 1.0.2更新（又名“IDE更新”）是Jbab的第3个正式版。添加了ide命令和Jbab IDE。");
			u102.add("但是1.0.2很快就被撤回了，因为出现了time命令无法运行的BUG（当时Jbab还只有十几个命令）。");
			u102.add("现在代码管理者lenovo仍存有Jbab 1.0.2的start.bat。");
		}
		private static void addU102a() {
			u102a.clear();
			u102a.add("Jbab 1.0.2a更新");
			u102a.add("Jbab 1.0.2a更新（又名“临时更新”）是Jbab的第4个正式版。移除了ide命令和Jbab IDE。");
			u102a.add("虽然其名为Jbab 1.0.2a，但其实它与Jbab 1.0.1是一个版本，这也是为什么github上没有Jbab 1.0.2a。");
			u102a.add("虽然叫临时更新，但一直临时到了现在……");
		}
		private static void addU103() {
			u103.clear();
			u103.add("Jbab 1.0.3更新");
			u103.add("Jbab 1.0.3更新（又名“变量更新”）是Jbab的第5个正式版。加入了var、use、del命令以及print?var [varname]（详见它们自己的wiki）。");
			u103.add("Jbab 1.0.3更新是一个里程碑，因为从这个版本开始，Jbab的主题开始发往github。");
		}
		private static void addU104() {
			u104.clear();
			u104.add("Jbab 1.0.4更新");
			u104.add("Jbab 1.0.4更新（又名“循环更新”）是Jbab的第6个正式版。本来 张浩扬博士 是想把for和while一起加入的，但是因为Jbab尚未更新布尔表达式，所以只加入了for循环。");
			u104.add("因为Jbab 1.0.4导致了很多BUG，所以Jbab 1.0.5就用来修复这些BUG。");
		}
		private static void addU105() {
			u105.clear();
			u105.add("Jbab 1.0.5更新");
			u105.add("Jbab 1.0.5更新（又名“修补更新”）是Jbab的第7个正式版。修改了一些命令的格式（如update record->update_record, print?var [varname]->print?var_[varname]");
			u105.add("Jbab 1.0.5更新中没有加入任何新东西，只是修改了一些命令格式以兼容Jbab 1.0.4中的for循环。");
		}
		private static void addU106() {
			u106.clear();
			u106.add("Jbab 1.0.6更新");
			u106.add("Jbab 1.0.6更新（又名“函数更新”）是Jbab的第8个正式版。加入了def、call、blockdel、blocklist、blockcontent命令。");
			u106.add("由于加入blocklist、blockcontent和blockdel的时候已经有一些Jbab 1.1.0的内容了，所以可以在Jbab 1.0.6中抢跑一些Jbab 1.1.0的内容（如eval、wait等），但因为当时Jbab Wiki还没开发完成，所以wiki命令并不能在1.0.6中抢跑。");
		}
		private static void addU110() {
			u110.clear();
			u110.add("Jbab 1.1.0更新");
			u110.add("Jbab 1.1.0更新（又名“wiki更新”）是Jbab的第9个正式版。加入了wiki、eval、wait命令，加回了ide命令和Jbab IDE。");
			u110.add("这个更新标志着Jbab的1.0时代结束，同时Jbab也有了自己的wiki和官网。");
			u110.add("官网网址：xiaohuangren1001.orgs.ml");
		}
		private static void addU111() {
			u111.clear();
			u111.add("Jbab 1.1.1更新");
			u111.add("Jbab 1.1.1更新（又名“变量扩充更新（第一部分）”），是Jbab的第10个正式版。更改了创建变量的语法，为后面变量间的运算打好了基础。");
			u111.add("并没有添加什么新命令。");
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
