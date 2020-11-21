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
		System.out.println("��ӭ�����ź��ﲩʿ�з���JBAB CMD");
		System.out.println("JBAB 1.1.0");
		System.out.println("����help�Ի�ø�����Ϣ");
		printPrompt();
		while (true) {
			Scanner s = new Scanner(System.in);
			String a = s.nextLine();
			runcomm(a);
		}
	}
	public static void runcomm(String str) {
		if (str.equals("help")) {
			System.out.println("JBAB���ź��ﲩʿ�ۺ�JVAV��JABA������");
			System.out.println("�����ȫ");
			System.out.println("--- 1.0.0 ---");
			System.out.println("help - �鿴����");
			System.out.println("exit - �˳�CMD");
			System.out.println("calculator - ������������");
			System.out.println("callUI - ��ʾJBAB UI");
			System.out.println("print?str/int/float/var_[varname] - ��ʾ��Ϣ/����ֵ������ʾ����ֵʱǰ��Ҫ��var��");
			System.out.println("ejz?int - ������ת�ɶ�����");
			System.out.println("run?str - �����ļ��е�JBAB����");
			System.out.println("--- 1.0.1 ---");
			System.out.println("version - ��ʾ��ǰ�汾���һ�漰�䷢��ʱ��");
			System.out.println("time - ��ʾ��ǰʱ�䣨��ʽ��ʱ:�� ��/��/�գ�");
			System.out.println("update_record - ��ʾ������־");
			System.out.println("--- 1.0.3 ---");
			System.out.println("var?[variable]=[value] - ��������ֵ�������пո񣡣�");
			System.out.println("use?[variable] - ���ұ���ֵ���粻���ڻ���ʾ");
			System.out.println("del?[variable] - ɾ�����������Ӧֵ");
			System.out.println("--- 1.0.4 ---");
			System.out.println("for!times = [int] : loopbody(statement1[/statement2/statement3/...]) - forѭ��");
			System.out.println("--- 1.0.6 ---");
			System.out.println("def![codeblockname] {codeblockstatement1/codeblockstatement2/...} - ��������");
			System.out.println("call?[codeblockname] - ���ô����");
			System.out.println("blockdel?[codeblockname] - ɾ�������");
			System.out.println("blockcontent?[codeblockname] - �鿴���������");
			System.out.println("blocklist - �г����д����");
			System.out.println("--- 1.1.0 ---");
			System.out.println("wiki - ��Ĭ����ҳ��Jbab Wiki");
			System.out.println("wiki?[pagename] - �ø�����ҳ���Jbab Wiki");
			System.out.println("eval?[expression] - ������ʽ��ֵ");
			System.out.println("wait?[second] - �ȴ�ָ��������");
			System.out.println("ide - ��Jbab IDE");
			printPrompt();
		} else if (str.equals("exit")) {
			System.out.println("��л��ʹ���ź��ﲩʿ������JBAB CMD");
			System.exit(0);
		} else if (str.equals("callUI")) {
			new JbabUI();
			printPrompt();
		} else if (str.equals("calculator")) {
			new JbabCalculator();
		} else if (str.startsWith("print")) {
			if (str.equals("print") || str.equals("print?")) {
				System.out.println("�﷨����");
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
							System.out.print("����" + name + "�����ڻ��ѱ�ɾ��");
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
				System.out.println("�﷨����");
				printPrompt();
			} else {
				String[] ss = str.split("\\?");
				String s = ss[1];
				try {
					System.out.println("���ڳ��Խ�" + s + "ת�ɶ�����");
					int i = Integer.parseInt(s);
					String bi = Integer.toBinaryString(i);
					System.out.println("�ѽ�" + s + "ת��Ϊ������" + bi);
				} catch (Exception e) {
					System.out.println(s + "����һ���Ϸ�����");
					System.out.println("�Ϸ�������[-2147483648, 2147483647]�е�����");
				}
				printPrompt();
			}
		} else if (str.startsWith("run")) {
			if (str.equals("run") || str.equals("run?")) {
				System.out.println("�﷨����");
				printPrompt();
			} else {
				String[] ss = str.split("\\?");
				if (ss[1] == null || ss[1].equals("")) {
					System.out.println("�ļ�������Ϊ��");
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
			System.out.println("���JBAB�汾��JBAB1.0.0");
			System.out.println("������ 13:37 2020/7/28");
			System.out.println("��ǰJBAB�汾��JBAB1.0.6");
			System.out.println("������ 15:17 2020/8/31");
			printPrompt();
		}*/ else if (str.equals("time")) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm yyyy/MM/dd");
			System.out.println("��ǰʱ�䣺" + sdf.format(new Date()));
			printPrompt();
		} else if (str.equals("update_record")) {
			System.out.println("1.0.0 - ������print��ejz��run��help��exit��calculator��callUI���������JBAB UI��JBAB CMD��JBAB CALCULATOR�����");
			System.out.println("1.0.1 - ������time��version��update record����޸���help���ʹ1.0.0��1.0.1�����������������JBAB UI�����ݣ�����ˡ�����JBAB����ť��");
			System.out.println("1.0.2a - ��Ϊ1.0.2������ΪBUG�����أ�������JBAB UI�������Ϊʲô���ظ��µĹ��棻��Ȼ��Ϊ1.0.2a����ʵ���������1.0.1����һ��");
			System.out.println("1.0.3 - ������var��use��������˱�����������ʹ�ù��ܣ��޸���print���������print?var xʱ�����x��ֵ������������ֵnil��print?nil��������У�use?x(xΪnil)�����x = nil");
			System.out.println("1.0.4 - ������forѭ������forѭ���в�֧�ֶ�������Ĳ�����var����");
			System.out.println("1.0.5 - ����update record����Ϊupdate_record���var?x = [value]��Ϊvar?x=[value]��print?var x��Ϊprint?var_x��Ϊ֧��1.0.4�м����forѭ����");
			System.out.println("1.0.6 - ������def��call��blockcontent��blockdel��blocklist���");
			System.out.println("1.1.0 - ������ide��wiki��wait��eval�����Jbab IDE�����");
			printPrompt();
		} else if (str.startsWith("var")) {
			if (str.equals("var") || str.equals("var?")) {
				System.out.println("�﷨����");
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
					System.out.println("����ֵδ��д�����Զ���Ϊnil");
					if (varNames.contains(name)) {
						values.set(varNames.indexOf(name), value);
					} else {
						varNames.add(name);
						values.add(value);
					}
				}
				System.out.println("���óɹ�");
				printPrompt();
			}
		} else if (str.startsWith("use")) {
			if (str.equals("use") || str.equals("use?")) {
				System.out.println("�﷨����");
				printPrompt();
			} else {
				String sa[] = str.split("\\?");
				String name = sa[1];
				if (varNames.contains(name)) {
					String value = values.get(varNames.indexOf(name));
					System.out.println(name + " = " + value);
				} else {
					System.out.println(name + "���������ڻ��ѱ�ɾ��");
				}
				printPrompt();
			}
		} else if (str.startsWith("del")) {
			if (str.equals("del") || str.equals("del?")) {
				System.out.println("�﷨����");
				printPrompt();
			} else {
				String sa[] = str.split("\\?");
				String name = sa[1];
				if (!varNames.contains(name)) {
					System.out.println("����" + name + "�����ڻ��ѱ�ɾ��");
					printPrompt();
				} else {
					int index = varNames.indexOf(name);
					varNames.remove(index);
					values.remove(index);
					System.out.println("ɾ���ɹ�");
					printPrompt();
				}
			}
		} else if (str.startsWith("for")) {
			if (str.equals("for") || str.equals("for?")) {
				System.out.println("�﷨����");
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
					System.out.println("forѭ�������з�������ִ�д���");
					printPrompt();
				}
			}
		} else if (str.startsWith("#") || str.equals("")) {
			printPrompt();
		} else if (str.startsWith("echo")) {
			if (str.equals("echo") || str.equals("echo?")) {
				System.out.println("�﷨����");
				printPrompt();
			} else {
				String[] sa = str.split("\\?");
				String option = sa[1];
				if (option.equals("on")) {
					echo = true;
				} else if (option.equals("off")) {
					echo = false;
				} else {
					System.out.println("���ò���ȷ");
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
					System.out.println("����ɹ�");
					printPrompt();
				} else {
					codeblocknames.add(name);
					codeblockstatements.add(statements);
					System.out.println("����ɹ�");
					printPrompt();
				}
			} catch (Exception e) {
				System.out.println("�﷨����");
				printPrompt();
			}
		} else if (str.startsWith("call")) {
			if (str.equals("call") || str.equals("call?")) {
				System.out.println("�﷨����");
				printPrompt();
			} else {
				String name = str.split("\\?")[1];
				if (!codeblocknames.contains(name)) {
					System.out.println("��������Ϊ" + name + "�Ĵ����");
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
				System.out.println("�﷨����");
				printPrompt();
			} else {
				String name = str.split("\\?")[1];
				if (!codeblocknames.contains(name)) {
					System.out.println("�����" + name + "�����ڻ��ѱ�ɾ��");
					printPrompt();
				} else {
					int i = codeblocknames.indexOf(name);
					codeblocknames.remove(i);
					codeblockstatements.remove(i);
					System.out.println("ɾ���ɹ�");
					printPrompt();
				}
			}
		} else if (str.startsWith("blockcontent")){
			if (str.equals("blockcontent") || str.equals("blockcontent?")) {
				System.out.println("�﷨����");
				printPrompt();
			} else {
				String name = str.split("\\?")[1];
				if (!codeblocknames.contains(name)) {
					System.out.println("�����" + name + "�����ڻ��ѱ�ɾ��");
					printPrompt();
				} else {
					String[] statements = codeblockstatements.get(codeblocknames.indexOf(name)).split("/");
					System.out.println("�����" + name + "��" + String.valueOf(statements.length) + "�����");
					System.out.println("�ֱ��ǣ�");
					for (String statement: statements) {
						System.out.println(statement);
					}
					printPrompt();
				}
			}
		} else if (str.equals("blocklist")) {
			String blocks[] = codeblocknames.toArray(new String[] {});
			System.out.println("����" + blocks.length + "������飬�ֱ�Ϊ��");
			for (String name: blocks) {
				System.out.println(name);
			}
			printPrompt();
		} else if (str.startsWith("wait")) {
			if (str.equals("wait") || str.equals("wait?")) {
				System.out.println("�﷨����");
				printPrompt();
			} else {
				double time = Double.parseDouble(str.split("\\?")[1]);
				try {
					Thread.sleep((long)(time * 1000));
					printPrompt();
				} catch (InterruptedException e) {
					System.out.println("�ȴ����ж�");
					printPrompt();
				}
			}
		} else if (str.startsWith("eval")) {
			if (str.equals("eval") || str.equals("eval?")) {
				System.out.println("�﷨����");
				printPrompt();
			} else {
				String as[] = str.split("\\?")[1].split(" ");
				if (as.length != 3) {
					System.out.println("����ÿ��ֻ�ܼ��������������������ʽ��");
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
						System.out.println("����");
						System.out.print("ԭ��");
						if (e.getMessage().equals("Ϊ��ĳ���")) {
							System.out.println("����Ϊ0");
						} else if (e.getMessage().equals("���������")) {
							System.out.println("����������");
						} else {
							System.out.println("��������");
						}
						printPrompt();
					}
				}
			}
		} else if (str.equals("ide")) {
			System.out.println("���ڴ�Jbab IDE...");
			new JbabIDE();
			printPrompt();
		} else if (str.equals("wiki")) {
			System.out.println("���ڴ�Jbab Wiki...");
			new JbabWiki();
			printPrompt();
		} else if (str.startsWith("wiki")) {
			if (str.equals("wiki?")) {
				System.out.println("�﷨����");
				printPrompt();
			} else {
				String address = str.split("\\?")[1];
				System.out.println("�������ض���ַ" + address + "��Jbab Wiki...");
				new JbabWiki(address);
				printPrompt();
			}
		} else {
			System.out.println(str + "���ǺϷ���JBAB����");
			printPrompt();
		}
	}
	public static void printPrompt() {
		if (echo) {
			System.out.print("JBAB CMD> ");
		}
	}
}
