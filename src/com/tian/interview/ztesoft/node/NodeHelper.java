package com.tian.interview.ztesoft.node;

import java.util.List;

public class NodeHelper {
	private NodeDao ndao=new NodeDao();
	
	public boolean hasNext(Node nv){
		String sql ="select count(0) from node where nv.fromid='"+nv.getNodeId()+"'";
		Object s=ndao.executeQuery(sql);
//		仅仅只是模拟
		if(Integer.parseInt((String)s)>0){
			return true;
		}
		
		return false;
	}
	
	public List<Node> getChildren(Node nv){
		
		String sql="select * from node where nv.fromid='"+nv.getNodeId()+"'";
		return 
		ndao.findNodeBySQL(sql);
		
	}
	
	public List<Node> getRootNode(){
		String sql="select * from node where nv.fromid is null ";
		return 
		ndao.findNodeBySQL(sql);
	} 
	
	
	
	
	
	
	
	

}
