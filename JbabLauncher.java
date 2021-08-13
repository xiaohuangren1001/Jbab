import java.util.*;
import java.text.*;
public class JbabLauncher {
	private static ArrayList<String> varNames = new ArrayList<>();
	private static ArrayList<String> values = new ArrayList<>();
	private static ArrayList<String> types = new ArrayList<>();
	private static ArrayList<String> allowtypes = new ArrayList<>();
	private static ArrayList<String> codeblocknames = new ArrayList<>();
	private static ArrayList<String> codeblockstatements = new ArrayList<>();
	private static Scanner s = new Scanner(System.in);
	public static boolean echo = true;
	public static boolean fromJAPF = false;
	static {
		allowtypes.add("int");
		allowtypes.add("long");
		allowtypes.add("string");
	}
	public static void main(String[] args) {
		if (!fromJAPF) {
			System.out.println("欢迎来到张浩扬博士研发的JBAB CMD");
			System.out.println("JBAB 1.1.4");
			System.out.println("输入help以获得更多信息");
		}
		printPrompt();
		while (true) {
			String a = s.nextLine();
			runcomm(a);
		}
	}
	/**
	 * @param str
	 */
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
			System.out.println("--- 1.1.2 ---");
			System.out.println("blockadd?[codeblockname]:[statements] - 在代码块中添加一条语句");
			System.out.println("--- 1.1.3 ---");
			System.out.println("aprilfoolsmode - 祝你玩得开心");
			System.out.println("execute?[command] - 执行命令");
			System.out.println("--- 1.1.4 ---");
			System.out.println("input?[varname] - 输入数据至varname");
			System.out.println("addvar?[varname]:[num/var] - 加");
			System.out.println("subvar?[varname]:[num/var] - 减");
			System.out.println("mulvar?[varname]:[num/var] - 乘");
			System.out.println("divvar?[varname]:[num/var] - 除，注意是两个v");
			printPrompt();
		} else if (str.equals("exit")) {
			System.out.println("感谢您使用张浩扬博士开发的JBAB CMD");
			System.exit(0);
		} else if (str.equals("callUI")) {
			new JbabUI();
			printPrompt();
			return;
		}/* else if (str.equals("calculator")) {
				new JbabCalculator();
		}*/ else if (str.startsWith("print")) {
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
					System.out.println("合法的数是[1, 2147483647]中的整数");
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
		}/* else if (str.equals("update_record")) {
			System.out.println("1.0.0 - 加入了print、ejz、run、help、exit、calculator、callUI命令，加入了JBAB UI、JBAB CMD、JBAB CALCULATOR组件。");
			System.out.println("1.0.1 - 加入了time、version、update record命令，修改了help命令，使1.0.0与1.0.1的命令隔开，更新了JBAB UI的内容，添加了“关于JBAB”按钮。");
			System.out.println("1.0.2a - 因为1.0.2更新因为BUG被撤回，所以在JBAB UI中添加了为什么撤回更新的公告；虽然名为1.0.2a，但实际上与更新1.0.1并在一起。");
			System.out.println("1.0.3 - 加入了var和use命令，加入了变量的设置与使用功能，修改了print命令，当调用print?var x时会输出x的值，加入了特殊值nil，print?nil会输出空行，use?x(x为nil)会输出x = nil");
			System.out.println("1.0.4 - 加入了for循环，但for循环中不支持定义变量的操作（var）。");
			System.out.println("1.0.5 - 更改update record命令为update_record命令，var?x = [value]改为var?x=[value]，print?var x改为print?var_x（为支持1.0.4中加入的for循环）");
			System.out.println("1.0.6 - 加入了def、call、blockcontent、blockdel、blocklist命令。");
			System.out.println("1.1.0 - 加入了ide、wiki、wait、eval命令和Jbab IDE组件。");
			System.out.println("1.1.1 - 更改了var命令的语法。");
			System.out.println("1.1.2 - 加入了blockadd命令，添加了blockadd类型，移除了use命令。");
			printPrompt();
		}*/ else if (str.startsWith("var")) {
			if (str.equals("var") || str.equals("var?")) {
				System.out.println("语法错误");
				printPrompt();
			} else {
				String sa[] = str.split("\\?");
				String sa2[] = sa[1].split("\\=");
				String name = sa2[0];
				String value, type;
				try {
					value = sa2[1];
					value = value.trim();
					String val = value.split(":")[0];
					type = value.split(":")[1];
					if (val.startsWith("var_")) {
						String src = val.substring(4);
						String dest = name;
						String srcvalue = values.get(varNames.indexOf(src));
						if (varNames.contains(dest)) {
							if (!types.get(varNames.indexOf(dest)).equals(type)) {
								System.out.println("类型不匹配，值将设为nil");
							}
							else values.set(varNames.indexOf(dest), srcvalue);
						} else {
							varNames.add(dest);
							values.add(srcvalue);
							if (!allowtypes.contains(type)) {
								System.out.println("类型不存在");
							} else {
								if (type.equals("int")) {
									try {
										Integer.parseInt(srcvalue);
										types.set(varNames.indexOf(name), "int");
									} catch (Exception e) {
										System.out.println("类型不匹配，值将自动设为nil");
										values.set(values.indexOf(srcvalue), "nil");
										types.add("None");
									}
								} else if (type.equals("long")) {
									try {
										Long.parseLong(srcvalue);
										types.set(varNames.indexOf(name), "long");
									} catch (Exception e) {
										System.out.println("类型不匹配，值将自动设为nil");
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
										types.set(varNames.indexOf(name), "int");
									} catch (Exception e) {
										System.out.println("类型不匹配，值将自动设为nil");
										values.set(varNames.indexOf(name), "nil");
										types.set(varNames.indexOf(name), "None");
									}
								} else if (type.equals("long")) {
									try {
										Long.parseLong(val);
										types.set(varNames.indexOf(name), "long");
									} catch (Exception e) {
										System.out.println("类型不匹配，值将自动设为nil");
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
										types.add("int");
									} catch (Exception e) {
										System.out.println("类型不匹配，值将自动设为nil");
										values.set(values.indexOf(val), "nil");
										types.add("int");
									}
								} else if (type.equals("long")) {
									try {
										Long.parseLong(val);
										types.add("long");
									} catch (Exception e) {
										System.out.println("类型不匹配，值将自动设为nil");
										values.set(values.indexOf(val), "nil");
										types.add("long");
									}
								} else types.add(type);
							} else System.out.println("类型不存在");
						}
					}
				} catch (Exception e) {
					try {
						type = str.split(":")[1];
						name = str.split("\\?")[1].split(":")[0];
						if (type.equals("codeblock")) {
							codeblocknames.add(name);
							codeblockstatements.add("");
						} else {
							value = "nil";
							System.out.println("出现错误，值将自动设为nil"); 
							if (varNames.contains(name)) { 
								values.set(varNames.indexOf(name), value);
							    types.set(varNames.indexOf(name), type); 
							} else { 
								varNames.add(name);
							    values.add(value);
							    types.add(type); 
							}
						}
					} catch (Exception ex) {
						System.out.println("没有提供类型");
					}
				}
			}
			System.out.println("设置完成");
			printPrompt();
		}/* else if (str.startsWith("use")) {
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
		}*/ else if (str.startsWith("del")) {
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
		} else if (str.startsWith("type")) {
			if (str.equals("type") || str.equals("type?")) {
				System.out.println("语法错误");
			} else {
				String name = str.split("\\?")[1];
				if (codeblocknames.contains(name)) {
					System.out.println("变量的类型为：代码块");
				} else if (varNames.contains(name)) {
					System.out.print("变量的类型为：");
					String type = types.get(varNames.indexOf(name));
					System.out.println(type);
				} else {
					System.out.println("变量不存在或已被删除");
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
	    		System.out.println("语法错误");
	    	} else {
	    		String inf = str.substring(9);
	    		String blockname = inf.split(":")[0];
	    		String blockstate = inf.split(":")[1];
	    		if (!codeblocknames.contains(blockname)) {
	    			System.out.println("代码块不存在或已被删除");
	    		} else {
	    			int id = codeblocknames.indexOf(blockname);
	    			String val = codeblockstatements.get(id);
	    			if (val.equals("")) {
	    				codeblockstatements.set(id, blockstate);
	    			} else {
	    				codeblockstatements.set(id, val + "/" + blockstate);
	    			}
	    			System.out.println("语句添加成功");
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
	    		System.out.println("表达式格式错误");
	    	}
	    	printPrompt();
	    }*/ else if (str.startsWith("execute")) {
	    	if (str.equals("execute") || str.equals("execute?")) {
	    		System.out.println("语法错误");
	    	} else {
	    		String comm = str.split("\\?")[1];
	    		try {
	    			Runtime.getRuntime().exec("cmd /c " + comm);
	    		} catch (Exception e) {
	    			System.out.println("运行中出现错误");
	    		}
	    	}
	    	printPrompt();
	    } else if (str.equals("aprilfoolsmode")) {
	    	System.out.println("玩得开心");
	    	JbabAprilFools.main(new String[] {"april"});
	    	System.exit(0);
	    } else if (str.startsWith("input")) {
	    	if (str.equals("input") || str.equals("input?")) {
	    		System.out.println("语法错误");
	    	} else {
	    		String varname = str.split("\\?")[1];
	    		if (varNames.contains(varname)) {
	    			String value = s.nextLine();
	    			if (types.get(varNames.indexOf(varname)).equals("int") || types.get(varNames.indexOf(varname)).equals("long")) {
	    				try {
	    					Integer.parseInt(value);
	    					values.set(varNames.indexOf(varname), value);
	    				} catch (Exception e) {
	    					System.out.println("值不符合要求");
	    				}
	    			} else {
	    				values.set(varNames.indexOf(varname), value);
	    			}
	    		} else {
	    			System.out.println("变量不存在");
	    		}
	    	}
	    	printPrompt();
	    } else if (str.startsWith("addvar")) {
    		String s = str.split("\\?")[1];
    		if (!s.contains(":")) {
    			System.out.println("语法错误");
    		} else {
    			String varname = s.split(":")[0];
    			String val = s.split(":")[1];
    			int v;
    			if (varNames.contains(val)) {
    				String oval = val;
    				val = values.get(varNames.indexOf(val));
    				if (types.get(varNames.indexOf(oval)).equals("int") || types.get(varNames.indexOf(oval)).equals("long")) {
    					v = Integer.parseInt(val);
    				} else v = Integer.MIN_VALUE;
    				if ((types.get(varNames.indexOf(varname)).equals("int") || types.get(varNames.indexOf(varname)).equals("long")) && v != Integer.MIN_VALUE) {
    					int i = Integer.parseInt(values.get(varNames.indexOf(varname)));
    					i = i + v;
    					values.set(varNames.indexOf(varname), String.valueOf(i));
    				} else if (types.get(varNames.indexOf(varname)).equals("int") || types.get(varNames.indexOf(varname)).equals("long")) {
    					System.out.println("类型不匹配");
    				} else if (v == Integer.MIN_VALUE && !types.get(varNames.indexOf(varname)).equals("None")) {
    					String vval = values.get(varNames.indexOf(varname));
    					vval = vval + val;
    					values.set(varNames.indexOf(varname), vval);
    				}
    			} else if (!varNames.contains(varname)) {
    				System.out.println("变量不存在");
    			} else if (types.get(varNames.indexOf(varname)).equals("int") || types.get(varNames.indexOf(varname)).equals("long") ) {
    				try {
    					int i = Integer.parseInt(val);
    					int j = Integer.parseInt(values.get(varNames.indexOf(varname)));
    					j = i + j;
    					values.set(varNames.indexOf(varname), String.valueOf(j));
    				} catch (Exception e) {
    					System.out.println("类型不匹配");
    				}
    			} else {
    				String value = values.get(varNames.indexOf(varname));
    				value = value + val;
    				values.set(varNames.indexOf(varname), value);
    			}
    		}
	    	printPrompt();
	    } else if (str.startsWith("subvar")){
    		String var1 = str.split("\\?")[1].split(":")[0];
    		String var2 = str.split("\\?")[1].split(":")[1];
    		if (!varNames.contains(var1)) {
    			System.out.println("变量" + var1 + "不存在或已被删除");
    		} else if (!((types.get(varNames.indexOf(var1)).equals("int") && !(types.get(varNames.indexOf(var1)).equals("long"))))) {
    			System.out.println("变量" + var1 + "不是整型");
    		} else if (!varNames.contains(var2)) {
    			try {
    				int i = Integer.parseInt(var2);
    				int varval = Integer.parseInt(values.get(varNames.indexOf(var1)));
    				varval -= i;
    				values.set(varNames.indexOf(var1), String.valueOf(varval));
    			} catch (Exception e) {
    				System.out.println("只有整型可以进行加减法");
    			}
    		} else if (!(types.get(varNames.indexOf(var2))).equals("int") && !(types.get(varNames.indexOf(var2))).equals("long")) {
    			System.out.println("变量" + var2 + "不是整型");
    		} else {
    			int ivar1 = Integer.parseInt(values.get(varNames.indexOf(var1)));
    			int ivar2 = Integer.parseInt(values.get(varNames.indexOf(var2)));
    			ivar1 -= ivar2;
    			values.set(varNames.indexOf(var1), String.valueOf(ivar1));
    		}
	    	printPrompt();
	    } else if (str.startsWith("mulvar")){
    		String var1 = str.split("\\?")[1].split(":")[0];
    		String var2 = str.split("\\?")[1].split(":")[1];
    		if (!varNames.contains(var1)) {
    			System.out.println("变量" + var1 + "不存在或已被删除");
    		} else if (!types.get(varNames.indexOf(var1)).equals("int") && !types.get(varNames.indexOf(var1)).equals("long")) {
    			try {
    				int ivar2 = Integer.parseInt(var2);
    				String svar1 = values.get(varNames.indexOf(var1));
    				String copy = svar1;
    				svar1 = "";
    				for (int i = 0; i < ivar2; i++) {
    					svar1 += copy;
    				}
    				values.set(varNames.indexOf(var1), svar1);
    			} catch (Exception e) {
    				try {
    					int ivar2 = Integer.parseInt(values.get(varNames.indexOf(var2)));
    					String svar1 = values.get(varNames.indexOf(var1));
    					String copy = svar1;
    					svar1 = "";
    					for (int i = 0; i < ivar2; i++) {
    						svar1 += copy;
    					}
    					values.set(varNames.indexOf(var1), svar1);
    				} catch (Exception ex) {
    					System.out.println("字符串不能乘非整数次");
    				}
    			}
    		} else if (!varNames.contains(var2)) {
    			System.out.println("变量" + var2 + "不存在或已被删除");
    		} else if (!types.get(varNames.indexOf(var2)).equals("int") && !types.get(varNames.indexOf(var2)).equals("long")) {
    			System.out.println("整数不可以乘非整数");
    		} else {
    			int ivar1 = Integer.parseInt(values.get(varNames.indexOf(var1)));
    			int ivar2 = Integer.parseInt(values.get(varNames.indexOf(var2)));
    			ivar1 *= ivar2;
    			values.set(varNames.indexOf(var1), String.valueOf(ivar1));
    		}
	    	printPrompt();
		} else if (str.startsWith("divvar")){
    		String var1 = str.split("\\?")[1].split(":")[0];
    		String var2 = str.split("\\?")[1].split(":")[1];
    		if (!varNames.contains(var1)) {
    			System.out.println("变量" + var1 + "不存在或已被删除");
    		} else if (!((types.get(varNames.indexOf(var1)).equals("int") && !(types.get(varNames.indexOf(var1)).equals("long"))))) {
    			System.out.println("变量" + var1 + "不是整型");
    		} else if (!varNames.contains(var2)) {
    			try {
    				int i = Integer.parseInt(var2);
    				int varval = Integer.parseInt(values.get(varNames.indexOf(var1)));
    				varval /= i;
    				values.set(varNames.indexOf(var1), String.valueOf(varval));
    			} catch (Exception e) {
    				System.out.println("只有整型可以进行加减法");
    			}
    		} else if (!(types.get(varNames.indexOf(var2))).equals("int") && !(types.get(varNames.indexOf(var2))).equals("long")) {
    			System.out.println("变量" + var2 + "不是整型");
    		} else {
    			int ivar1 = Integer.parseInt(values.get(varNames.indexOf(var1)));
    			int ivar2 = Integer.parseInt(values.get(varNames.indexOf(var2)));
    			ivar1 /= ivar2;
    			values.set(varNames.indexOf(var1), String.valueOf(ivar1));
    		}
	    	printPrompt();
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
