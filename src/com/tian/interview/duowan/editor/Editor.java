package com.tian.interview.duowan.editor;

import java.util.Stack;

public class Editor {

	public static void main(String[] args) {
		
		Editor et= new Editor();
		
		String[] cmds={"type a","type c","type b","undo 1"};
		int[] times={1,1,1,0};
		String s=et.getText(cmds, times);
		System.out.println(s);
	}
	
	private String getText(String[] cmds, int[] times) {

		Stack<CmdVo> s=new Stack<Editor.CmdVo>();
		for (int i = 0; i < cmds.length; i++) {
			CmdVo cv = parseCmd(cmds[i], times[i]);
			if (cv != null) {
				textBuilder(s, cv);
			}
		}
		return printData(s);
	}
	
	
	private String printData(Stack<CmdVo> cv){
		
		StringBuffer buffer=new StringBuffer();
		
		while (!cv.isEmpty()) {
			CmdVo c=cv.pop();
			if("type".equals(c.getType())){
				buffer.append(c.getData());
			}
		}
//		数据翻转
		return buffer.reverse().toString();
	}
	
	private void textBuilder(Stack<CmdVo> s,CmdVo cv){
		
		if("type".equals(cv.getType())){
			s.push(cv);
		}
		else if("undo".equals(cv.getType())){
			String tm=cv.getData();
			int time=Integer.parseInt(tm);
//			出栈
			while(time>0&&!s.isEmpty()){
				CmdVo p_cv=s.pop();
				time=time-p_cv.getExec();
			}
		}
		else{
			System.out.println("undefine ~");
		}
	}

	// 命令解析类
	private CmdVo parseCmd(String cmd, int time) {

		String[] s_cmd = cmd.split(" ");

		if (s_cmd.length > 1) {

			if ("type".equals(s_cmd[0])) {
				//
				String data = cmd.substring(4, cmd.length()).trim();
				if (data.length() == 1 && data.toCharArray()[0] >= 'a'
						&& data.toCharArray()[0] <= 'z') {
					CmdVo cv = new CmdVo(s_cmd[0], time, data);
					return cv;
				}
			} else if ("undo".equals(s_cmd[0])) {
				String data = cmd.substring(4, cmd.length()).trim();
				CmdVo cv = new CmdVo(s_cmd[0], time, data);
				return cv;
			}

		} else {
			System.out.println("undefined cmd ~!");
		}
		return null;
	}

	class CmdVo {

		public CmdVo(String type, int exec, String data) {
			super();
			this.type = type;
			this.exec = exec;
			this.data = data;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getExec() {
			return exec;
		}

		public void setExec(int exec) {
			this.exec = exec;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		private String type;
		private int exec;
		private String data;
	}

}
