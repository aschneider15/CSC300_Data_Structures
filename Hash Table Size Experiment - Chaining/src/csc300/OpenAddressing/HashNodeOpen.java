package csc300.OpenAddressing;

public class HashNodeOpen {
	public String Key;
	public String Value;
	public int Code;
	public NodeState State = NodeState.regular; //state: 0 empty since start, 1 empty after delete, 2 regular 
	
	public HashNodeOpen(String key, String value, int code) {
		this.Key = key;
		this.Value = value;
		this.Code = code;
		this.State = NodeState.regular;
	}
	
	public static HashNodeOpen emptySinceStartNode(int code) {
		HashNodeOpen value = new HashNodeOpen("", "", code);
		value.State = NodeState.empty_since_start;
		return value;
	}
	
	public static HashNodeOpen emptyAfterDeleteNode(int code) {
		HashNodeOpen value = new HashNodeOpen("", "", code);
		value.State = NodeState.empty_after_delete;
		return value;
	}
}


