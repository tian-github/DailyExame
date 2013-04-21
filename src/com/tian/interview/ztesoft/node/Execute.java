package com.tian.interview.ztesoft.node;

import java.util.ArrayList;
import java.util.List;

public class Execute {
	
	NodeHelper helper=new NodeHelper();
	
	public List<List<String>>  execute(){
		
		List<Node> roots =helper.getRootNode();
		
		List<List<String>> datas=new ArrayList<List<String>>();
		
		for(Node n: roots){
			List<String> list=new ArrayList<String>();
			list=loop(list, n);
			datas.add(list);
		}
		return datas;
	}
	
	public List<String> loop(List<String> data,Node n){
		
		data.add(n.getNodeId());
		
		if(helper.hasNext(n)){
			List<Node> c_list= helper.getChildren(n);
			for(Node c_n:c_list){
				loop(data, c_n);
			}
			return data;
		}
		else{
			return data;	
		}
		
		
		
	}
	

}
