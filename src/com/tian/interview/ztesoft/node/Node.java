package com.tian.interview.ztesoft.node;

public class Node {
	
	public Node(String nodeId, String fromId, String toId) {
		super();
		this.nodeId = nodeId;
		this.fromId = fromId;
		this.toId = toId;
	}
	private String nodeId ;
	private String fromId ;
	private String toId ;
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	

}
