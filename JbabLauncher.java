import java.util.*;
import java.text.*;
public class JbabLauncher {
	private static ArrayList<String> varNames = new ArrayList<>();
	private static ArrayList<String> values = new ArrayList<>();
	private static ArrayList<String> types = new ArrayList<>();
	private static ArrayList<String> allowtypes = new ArrayList<>();
	private static ArrayList<String> codeblocknames = new ArrayList<>();
	private static ArrayList<String> codeblockstatements = new ArrayList<>();
	public static boolean echo = true;
	public static boolean fromJAPF = false;
	static {
		allowtypes.add("int");
		allowtypes.add("long");
		allowtypes.add("None");
		allowtypes.add("string");
	}
 	@SuppressWarnings("resource")
	public static void main(String[] args) {
		if (!fromJAPF) {
			System.out.println("��ӭ�����ź��ﲩʿ�з���JBAB CMD");
			System.out.println("JBAB 1.1.3");
			System.out.println("����help�Ի�ø�����Ϣ");
		}
		printPrompt();
		while (true) {
			Scanner s = new Scanner(System.in);
			String a = s.nextLine();
			runcomm(a);
		}
	}
	/**
	 * @param str
	 */
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
			System.out.println("--- 1.1.2 ---");
			System.out.println("blockadd?[codeblockname]:[statements] - �ڴ���������һ�����");
			System.out.println("--- 1.1.3 ---");
			System.out.println("aprilfoolmode - ף����ÿ���");
			System.out.println("execute?[command] - ִ������");
			printPrompt();
		} else if (str.equals("exit")) {
			System.out.println("��л��ʹ���ź��ﲩʿ������JBAB CMD");
			System.exit(0);
		} else if (str.equals("callUI")) {
			new JbabUI();
			printPrompt();
		} /*else if (str.equals("calculator")) {
			new JbabCalculator();
		}*/ else if (str.startsWith("print")) {
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
					System.out.println("�Ϸ�������[1, 2147483647]�е�����");
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
		}/* else if (str.equals("update_record")) {
			System.out.println("1.0.0 - ������print��ejz��run��help��exit��calculator��callUI���������JBAB UI��JBAB CMD��JBAB CALCULATOR�����");
			System.out.println("1.0.1 - ������time��version��update record����޸���help���ʹ1.0.0��1.0.1�����������������JBAB UI�����ݣ�����ˡ�����JBAB����ť��");
			System.out.println("1.0.2a - ��Ϊ1.0.2������ΪBUG�����أ�������JBAB UI�������Ϊʲô���ظ��µĹ��棻��Ȼ��Ϊ1.0.2a����ʵ���������1.0.1����һ��");
			System.out.println("1.0.3 - ������var��use��������˱�����������ʹ�ù��ܣ��޸���print���������print?var xʱ�����x��ֵ������������ֵnil��print?nil��������У�use?x(xΪnil)�����x = nil");
			System.out.println("1.0.4 - ������forѭ������forѭ���в�֧�ֶ�������Ĳ�����var����");
			System.out.println("1.0.5 - ����update record����Ϊupdate_record���var?x = [value]��Ϊvar?x=[value]��print?var x��Ϊprint?var_x��Ϊ֧��1.0.4�м����forѭ����");
			System.out.println("1.0.6 - ������def��call��blockcontent��blockdel��blocklist���");
			System.out.println("1.1.0 - ������ide��wiki��wait��eval�����Jbab IDE�����");
			System.out.println("1.1.1 - ������var������﷨��");
			System.out.println("1.1.2 - ������blockadd��������blockadd���ͣ��Ƴ���use���");
			printPrompt();
		}*/ else if (str.startsWith("var")) {
			if (str.equals("var") || str.equals("var?")) {
				System.out.println("�﷨����");
				printPrompt();
			} else {
				String sa[] = str.split("\\?");
				String sa2[] = sa[1].split("\\=");
				String name = sa2[0];
				String value, type;
				try {
					value = sa2[1];
					value = value.trim();
					String val = value.split(":")[1];
					type = value.split(":")[0];
					if (val.startsWith("var_")) {
						String src = val.substring(4);
						String dest = name;
						String srcvalue = values.get(varNames.indexOf(src));
						if (varNames.contains(dest)) {
							if (!types.get(varNames.indexOf(dest)).equals(type)) {
								System.out.println("���Ͳ�ƥ�䣬ֵ����Ϊnil");
							}
							else values.set(varNames.indexOf(dest), srcvalue);
						} else {
							varNames.add(dest);
							values.add(srcvalue);
							if (!allowtypes.contains("type")) {
								System.out.println("���Ͳ�����");
							} else {
								if (type.equals("int")) {
									try {
										Integer.parseInt(srcvalue);
									} catch (Exception e) {
										System.out.println("���Ͳ�ƥ�䣬ֵ���Զ���Ϊnil");
										values.set(values.indexOf(srcvalue), "nil");
										types.add("None");
									}
								} else if (type.equals("long")) {
									try {
										Long.parseLong(srcvalue);
									} catch (Exception e) {
										System.out.println("���Ͳ�ƥ�䣬ֵ���Զ���Ϊnil");
										values.set(values.indexOf(srcvalue), "nil");
										types.add("None");
									}
								}
								else types.add(type);
							}
						}
					} else {
						if (varNames.contains(name)) {
							values.set(varNames.indexOf(name), val);
							if (allowtypes.contains(type)) {
								if (type.equals("int")) {
									try {
										Integer.parseInt(val);
									} catch (Exception e) {
										System.out.println("���Ͳ�ƥ�䣬ֵ���Զ���Ϊnil");
										values.set(varNames.indexOf(name), "nil");
										types.set(varNames.indexOf(name), "None");
									}
								} else if (type.equals("long")) {
									try {
										Long.parseLong(val);
									} catch (Exception e) {
										System.out.println("���Ͳ�ƥ�䣬ֵ���Զ���Ϊnil");
										values.set(varNames.indexOf(name), "nil");
										types.set(varNames.indexOf(name), "None");
									}
								}
								else types.set(varNames.indexOf(name), type);
							}
						} else {
							varNames.add(name);
							values.add(val);
							if (allowtypes.contains(type)) {
								if (type.equals("int")) {
									try {
										Integer.parseInt(val);
									} catch (Exception e) {
										System.out.println("���Ͳ�ƥ�䣬ֵ���Զ���Ϊnil");
										values.set(values.indexOf(val), "nil");
										types.add("None");
									}
								} else if (type.equals("long")) {
									try {
										Long.parseLong(val);
									} catch (Exception e) {
										System.out.println("���Ͳ�ƥ�䣬ֵ���Զ���Ϊnil");
										values.set(values.indexOf(val), "nil");
										types.add("None");
									}
								}
								else types.add(type);
							} else System.out.println("���Ͳ�����");
						}
					}
				} catch (Exception e) {
					type = str.split(":")[1];
					name = str.split("\\?")[1].split(":")[0];
					if (type.equals("codeblock")) {
						codeblocknames.add(name);
						codeblockstatements.add("");
					} else {
						value = "nil";
						System.out.println("���ִ���ֵ���Զ���Ϊnil"); 
						if (varNames.contains(name)) { 
							values.set(varNames.indexOf(name), value);
						    types.set(varNames.indexOf(name), "None"); 
						} else { 
							varNames.add(name);
						    values.add(value);
						    types.add("None"); 
						}
					}
				}
				System.out.println("���óɹ�");
				printPrompt();
			}
		}/* else if (str.startsWith("use")) {
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
		}*/ else if (str.startsWith("del")) {
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
		} else if (str.startsWith("type")) {
			if (str.equals("type") || str.equals("type?")) {
				System.out.println("�﷨����");
			} else {
				String name = str.split("\\?")[1];
				if (codeblocknames.contains(name)) {
					System.out.println("����������Ϊ�������");
				} else if (varNames.contains(name)) {
					System.out.print("����������Ϊ��");
					String type = types.get(varNames.indexOf(name));
					System.out.println(type);
				} else {
					System.out.println("���������ڻ��ѱ�ɾ��");
				}
			}
			printPrompt();
		} else if (varNames.contains(str)) {
			System.out.println(values.get(varNames.indexOf(str)));
			printPrompt();
		} else if (codeblocknames.contains(str)) {
			System.out.println("<code block " + str + ">");
			printPrompt();
	    } else if (str.startsWith("blockadd")) {
	    	if (str.equals("blockadd") || str.equals("blockadd?")) {
	    		System.out.println("�﷨����");
	    	} else {
	    		String inf = str.substring(9);
	    		String blockname = inf.split(":")[0];
	    		String blockstate = inf.split(":")[1];
	    		if (!codeblocknames.contains(blockname)) {
	    			System.out.println("����鲻���ڻ��ѱ�ɾ��");
	    		} else {
	    			int id = codeblocknames.indexOf(blockname);
	    			String val = codeblockstatements.get(id);
	    			if (val.equals("")) {
	    				codeblockstatements.set(id, blockstate);
	    			} else {
	    				codeblockstatements.set(id, val + "/" + blockstate);
	    			}
	    			System.out.println("�����ӳɹ�");
	    		}
	    	}
	    	printPrompt();
	    } /*else if (str.contains("+") || str.contains("-") || str.contains("*") || str.contains("/")) {
	    	ScriptEngineManager manager = new ScriptEngineManager();
	    	ScriptEngine scriptEngine = manager.getEngineByName("nashorn");
	    	try {
	    		String result = String.valueOf(scriptEngine.eval(str));
	    		System.out.println(result);
	    	} catch (ScriptException e) {
	    		System.out.println("���ʽ��ʽ����");
	    	}
	    	printPrompt();
	    }*/ else if (str.startsWith("execute")) {
	    	if (str.equals("execute") || str.equals("execute?")) {
	    		System.out.println("�﷨����");
	    	} else {
	    		String comm = str.split("\\?")[1];
	    		try {
	    			Runtime.getRuntime().exec("cmd /c " + comm);
	    		} catch (Exception e) {
	    			System.out.println("�����г��ִ���");
	    		}
	    	}
	    	printPrompt();
	    } else if (str.equals("aprilfoolsmode")) {
	    	System.out.println("��ÿ���");
	    	JbabAprilFools.main(new String[] {"april"});
	    	System.exit(0);
	    } /*else if (str.startsWith("input")) {
	    	if (str.equals("input") || str.equals("input?")) {
	    		System.out.println("�﷨����");
	    	} else {
	    		String varname = str.split("\\?")[1];
	    		if (varNames.contains(varname)) {
	    			Scanner s = new Scanner(System.in);
	    			String value = s.nextLine();
	    			if (types.get(varNames.indexOf(varname)).equals("int") || types.get(varNames.indexOf(varname)).equals("long")) {
	    				try {
	    					Integer.parseInt(value);
	    				} catch (Exception e) {
	    					System.out.println("ֵ������Ҫ��");
	    				}
	    			}
	    			s.close();
	    		} else {
	    			System.out.println("����������");
	    		}
	    	}
	    	printPrompt();
	    } else if (str.startsWith("varadd")) {
	    	
	    }*/ else {
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
