import java.text.*;
import java.util.*;
public class JbabLauncher {
	private static ArrayList<String> varNames = new ArrayList<>();
	private static ArrayList<String> values = new ArrayList<>();
	private static ArrayList<String> codeblocknames = new ArrayList<>();
	private static ArrayList<String> codeblockstatements = new ArrayList<>();
	public static boolean echo = true;
 	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("欢迎来到张浩扬博士研发的JBAB CMD");
		System.out.println("JBAB 1.1.0");
		System.out.println("输入help以获得更多信息");
		printPrompt();
		while (true) {
			Scanner s = new Scanner(System.in);
			String a = s.nextLine();
			runcomm(a);
		}
	}
	public static void runcomm(String str) {
		if (str.equals("help")) {
			System.out.println("JBAB是张浩扬博士综合JVAV和JABA开发的");
			System.out.println("命令大全");
			System.out.println("--- 1.0.0 ---");
			System.out.println("help - 查看帮助");
			System.out.println("exit - 退出CMD");
			System.out.println("calculator - 更改至计算器");
			System.out.println("callUI - 显示JBAB UI");
			System.out.println("print?str/int/float/var_[varname] - 显示消息/变量值（当显示变量值时前面要加var）");
			System.out.println("ejz?int - 将整数转成二进制");
			System.out.println("run?str - 运行文件中的JBAB代码");
			System.out.println("--- 1.0.1 ---");
			System.out.println("version - 显示当前版本与第一版及其发布时间");
			System.out.println("time - 显示当前时间（格式：时:分 年/月/日）");
			System.out.println("update_record - 显示更新日志");
			System.out.println("--- 1.0.3 ---");
			System.out.println("var?[variable]=[value] - 给变量赋值（不可有空格！）");
			System.out.println("use?[variable] - 查找变量值，如不存在会提示");
			System.out.println("del?[variable] - 删除变量及其对应值");
			System.out.println("--- 1.0.4 ---");
			System.out.println("for!times = [int] : loopbody(statement1[/statement2/statement3/...]) - for循环");
			System.out.println("--- 1.0.6 ---");
			System.out.println("def![codeblockname] {codeblockstatement1/codeblockstatement2/...} - 定义代码块");
			System.out.println("call?[codeblockname] - 调用代码块");
			System.out.println("blockdel?[codeblockname] - 删除代码块");
			System.out.println("blockcontent?[codeblockname] - 查看代码块内容");
			System.out.println("blocklist - 列出所有代码块");
			System.out.println("--- 1.1.0 ---");
			System.out.println("wiki - 用默认首页打开Jbab Wiki");
			System.out.println("wiki?[pagename] - 用给定的页面打开Jbab Wiki");
			System.out.println("eval?[expression] - 计算表达式的值");
			System.out.println("wait?[second] - 等待指定的秒数");
			System.out.println("ide - 打开Jbab IDE");
			printPrompt();
		} else if (str.equals("exit")) {
			System.out.println("感谢您使用张浩扬博士开发的JBAB CMD");
			System.exit(0);
		} else if (str.equals("callUI")) {
			new JbabUI();
			printPrompt();
		} else if (str.equals("calculator")) {
			new JbabCalculator();
		} else if (str.startsWith("print")) {
			if (str.equals("print") || str.equals("print?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String[] as = str.split("\\?");
				String message = as[1];
				message = message.replace("\\n", "\n");
				if (message.startsWith("var")) {
					String s[] = message.split("_");
					String name;
					try {
						name = s[1];
						if (!varNames.contains(name)) {
							System.out.print("变量" + name + "不存在或已被删除");
						} else {
							String value = values.get(varNames.indexOf(name));
							if (value.equals("nil")){
								System.out.println();
							} else {
								System.out.print(value);
							}
						}
					} catch (Exception e) {
						name = "";
						System.out.print(message);
					}
				} else {
					System.out.print(message);
				}
				printPrompt();
			}
		} else if (str.startsWith("ejz")) {
			if (str.equals("ejz") || str.equals("ejz?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String[] ss = str.split("\\?");
				String s = ss[1];
				try {
					System.out.println("正在尝试将" + s + "转成二进制");
					int i = Integer.parseInt(s);
					String bi = Integer.toBinaryString(i);
					System.out.println("已将" + s + "转化为二进制" + bi);
				} catch (Exception e) {
					System.out.println(s + "不是一个合法的数");
					System.out.println("合法的数是[-2147483648, 2147483647]中的整数");
				}
				printPrompt();
			}
		} else if (str.startsWith("run")) {
			if (str.equals("run") || str.equals("run?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String[] ss = str.split("\\?");
				if (ss[1] == null || ss[1].equals("")) {
					System.out.println("文件名不能为空");
					printPrompt();
				} else {
					String[] statements = JbabUI.getStatements(ss[1]);
					boolean orig_echo = echo;
					echo = false;
					for (String statement: statements) {
						runcomm(statement);
					}
					echo = orig_echo;
					printPrompt();
				}
			}		
		} /*else if (str.equals("version")) {
			System.out.println("最初JBAB版本：JBAB1.0.0");
			System.out.println("发布于 13:37 2020/7/28");
			System.out.println("当前JBAB版本：JBAB1.0.6");
			System.out.println("发布于 15:17 2020/8/31");
			printPrompt();
		}*/ else if (str.equals("time")) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm yyyy/MM/dd");
			System.out.println("当前时间：" + sdf.format(new Date()));
			printPrompt();
		} else if (str.equals("update_record")) {
			System.out.println("1.0.0 - 加入了print、ejz、run、help、exit、calculator、callUI命令，加入了JBAB UI、JBAB CMD、JBAB CALCULATOR组件。");
			System.out.println("1.0.1 - 加入了time、version、update record命令，修改了help命令，使1.0.0与1.0.1的命令隔开，更新了JBAB UI的内容，添加了“关于JBAB”按钮。");
			System.out.println("1.0.2a - 因为1.0.2更新因为BUG被撤回，所以在JBAB UI中添加了为什么撤回更新的公告；虽然名为1.0.2a，但实际上与更新1.0.1并在一起。");
			System.out.println("1.0.3 - 加入了var和use命令，加入了变量的设置与使用功能，修改了print命令，当调用print?var x时会输出x的值，加入了特殊值nil，print?nil会输出空行，use?x(x为nil)会输出x = nil");
			System.out.println("1.0.4 - 加入了for循环，但for循环中不支持定义变量的操作（var）。");
			System.out.println("1.0.5 - 更改update record命令为update_record命令，var?x = [value]改为var?x=[value]，print?var x改为print?var_x（为支持1.0.4中加入的for循环）");
			System.out.println("1.0.6 - 加入了def、call、blockcontent、blockdel、blocklist命令。");
			System.out.println("1.1.0 - 加入了ide、wiki、wait、eval命令和Jbab IDE组件。");
			printPrompt();
		} else if (str.startsWith("var")) {
			if (str.equals("var") || str.equals("var?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String sa[] = str.split("\\?");
				String sa2[] = sa[1].split("\\=");
				String name = sa2[0];
				name = name.trim();
				String value;
				try {
					value = sa2[1];
					value = value.trim();
					if (value.startsWith("var ")) {
						String src = value.substring(4);
						String dest = name;
						String srcvalue = values.get(varNames.indexOf(src));
						if (varNames.contains(dest)) {
							values.set(varNames.indexOf(dest), srcvalue);
						} else {
							varNames.add(dest);
							values.add(srcvalue);
						}
					} else {
						if (varNames.contains(name)) {
							values.set(varNames.indexOf(name), value);
						} else {
							varNames.add(name);
							values.add(value);
						}
					}
				} catch (Exception e) {
					value = "nil";
					System.out.println("变量值未填写，将自动设为nil");
					if (varNames.contains(name)) {
						values.set(varNames.indexOf(name), value);
					} else {
						varNames.add(name);
						values.add(value);
					}
				}
				System.out.println("设置成功");
				printPrompt();
			}
		} else if (str.startsWith("use")) {
			if (str.equals("use") || str.equals("use?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String sa[] = str.split("\\?");
				String name = sa[1];
				if (varNames.contains(name)) {
					String value = values.get(varNames.indexOf(name));
					System.out.println(name + " = " + value);
				} else {
					System.out.println(name + "变量不存在或已被删除");
				}
				printPrompt();
			}
		} else if (str.startsWith("del")) {
			if (str.equals("del") || str.equals("del?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String sa[] = str.split("\\?");
				String name = sa[1];
				if (!varNames.contains(name)) {
					System.out.println("变量" + name + "不存在或已被删除");
					printPrompt();
				} else {
					int index = varNames.indexOf(name);
					varNames.remove(index);
					values.remove(index);
					System.out.println("删除成功");
					printPrompt();
				}
			}
		} else if (str.startsWith("for")) {
			if (str.equals("for") || str.equals("for?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String[] sa = str.split("\\!");
				String[] information = sa[1].split(" ");
				int count;
				try {
					boolean orig_echo = echo;
					echo = false;
					count = Integer.parseInt(information[2]);
					String[] statements = information[4].split("/");
					for (int i = 0; i < count; i++) {
						for (String statement: statements) {
							runcomm(statement);
						}
					}
					echo = orig_echo;
					printPrompt();
				} catch (NumberFormatException e) {
					count = 0;
					System.out.println("for循环不能有非整数次执行次数");
					printPrompt();
				}
			}
		} else if (str.startsWith("#") || str.equals("")) {
			printPrompt();
		} else if (str.startsWith("echo")) {
			if (str.equals("echo") || str.equals("echo?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String[] sa = str.split("\\?");
				String option = sa[1];
				if (option.equals("on")) {
					echo = true;
				} else if (option.equals("off")) {
					echo = false;
				} else {
					System.out.println("设置不正确");
				}
				printPrompt();
			}
		} else if (str.startsWith("def")) {
			try {
				String[] informations = str.split("\\!")[1].split(" ");
				String name = informations[0];
				String statements_un_handled = str.substring(6+name.length());
				int end = statements_un_handled.length();
				String statements = statements_un_handled.substring(0, end-1);
				if (codeblocknames.contains(name)) {
					int ind = codeblocknames.indexOf(name);
					codeblockstatements.set(ind, statements);
					System.out.println("定义成功");
					printPrompt();
				} else {
					codeblocknames.add(name);
					codeblockstatements.add(statements);
					System.out.println("定义成功");
					printPrompt();
				}
			} catch (Exception e) {
				System.out.println("语法错误");
				printPrompt();
			}
		} else if (str.startsWith("call")) {
			if (str.equals("call") || str.equals("call?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String name = str.split("\\?")[1];
				if (!codeblocknames.contains(name)) {
					System.out.println("不存在名为" + name + "的代码块");
					printPrompt();
				} else {
					String[] statements = codeblockstatements.get(codeblocknames.indexOf(name)).split("/");
					boolean orig_echo = echo;
					echo = false;
					for (String statement: statements) {
						runcomm(statement);
					}
					echo = orig_echo;
					printPrompt();
				}
			}
		} else if (str.startsWith("blockdel")) {
			if (str.equals("blockdel") || str.equals("blockdel?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String name = str.split("\\?")[1];
				if (!codeblocknames.contains(name)) {
					System.out.println("代码块" + name + "不存在或已被删除");
					printPrompt();
				} else {
					int i = codeblocknames.indexOf(name);
					codeblocknames.remove(i);
					codeblockstatements.remove(i);
					System.out.println("删除成功");
					printPrompt();
				}
			}
		} else if (str.startsWith("blockcontent")){
			if (str.equals("blockcontent") || str.equals("blockcontent?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String name = str.split("\\?")[1];
				if (!codeblocknames.contains(name)) {
					System.out.println("代码块" + name + "不存在或已被删除");
					printPrompt();
				} else {
					String[] statements = codeblockstatements.get(codeblocknames.indexOf(name)).split("/");
					System.out.println("代码块" + name + "有" + String.valueOf(statements.length) + "条语句");
					System.out.println("分别是：");
					for (String statement: statements) {
						System.out.println(statement);
					}
					printPrompt();
				}
			}
		} else if (str.equals("blocklist")) {
			String blocks[] = codeblocknames.toArray(new String[] {});
			System.out.println("共有" + blocks.length + "个代码块，分别为：");
			for (String name: blocks) {
				System.out.println(name);
			}
			printPrompt();
		} else if (str.startsWith("wait")) {
			if (str.equals("wait") || str.equals("wait?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				double time = Double.parseDouble(str.split("\\?")[1]);
				try {
					Thread.sleep((long)(time * 1000));
					printPrompt();
				} catch (InterruptedException e) {
					System.out.println("等待被中断");
					printPrompt();
				}
			}
		} else if (str.startsWith("eval")) {
			if (str.equals("eval") || str.equals("eval?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String as[] = str.split("\\?")[1].split(" ");
				if (as.length != 3) {
					System.out.println("错误！每次只能计算带有两个操作数的算式！");
					printPrompt();
				} else {
					try {
						double result = JbabCalculator.evaluate(as);
						if ((int) result == result) {
							System.out.println((int) result);
						} else {
							System.out.println(result);
						}
						printPrompt();
					} catch (RuntimeException e) {
						System.out.println("错误！");
						System.out.print("原因：");
						if (e.getMessage().equals("为零的除数")) {
							System.out.println("除数为0");
						} else if (e.getMessage().equals("运算符错误")) {
							System.out.println("错误的运算符");
						} else {
							System.out.println("其他错误");
						}
						printPrompt();
					}
				}
			}
		} else if (str.equals("ide")) {
			System.out.println("正在打开Jbab IDE...");
			new JbabIDE();
			printPrompt();
		} else if (str.equals("wiki")) {
			System.out.println("正在打开Jbab Wiki...");
			new JbabWiki();
			printPrompt();
		} else if (str.startsWith("wiki")) {
			if (str.equals("wiki?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String address = str.split("\\?")[1];
				System.out.println("正在用特定网址" + address + "打开Jbab Wiki...");
				new JbabWiki(address);
				printPrompt();
			}
		} else {
			System.out.println(str + "不是合法的JBAB命令");
			printPrompt();
		}
	}
	public static void printPrompt() {
		if (echo) {
			System.out.print("JBAB CMD> ");
		}
	}
}
