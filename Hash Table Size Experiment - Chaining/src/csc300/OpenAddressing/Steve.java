package csc300.OpenAddressing;

enum NodeState{
	empty_since_start, //0
	empty_after_delete, //1
	regular; //2
}

public class Steve {
	public HashNodeOpen[] buckets;
	public int Size;
	public int Count;
	private final float Threashold = 0.7f;
	private final int initialSize = 16;
	
	public Steve() {
		this.buckets = new HashNodeOpen[initialSize];
		this.Size = this.initialSize;
		for(int i = 0; i < buckets.length; i++) {
			buckets[i] = HashNodeOpen.emptySinceStartNode(i);
		}
	}
	
	private int GetHash(String key) {
		int hashValue = key.hashCode();
		return hashValue % this.Size;
	}
	
	//add
	public void HashInsert(String key, String value) throws Exception {
		int hashCode = this.GetHash(key);
		HashNodeOpen newNode = new HashNodeOpen(key, value, hashCode);
		HashNodeOpen bucket = this.buckets[hashCode];
		if (bucket.State == NodeState.empty_since_start ||
			bucket.State == NodeState.empty_after_delete) {
			this.buckets[hashCode] = newNode;
			this.Count++;
			System.out.println("new node added");
			//resize if needed
			this.Resize();
		} else {
			int nextkey = hashCode;
			do {
				nextkey = ((hashCode) + 1) % this.Size;
				bucket = this.buckets[nextkey];
			} while (!(bucket.State == NodeState.regular ||
					nextkey == hashCode));
			if (nextkey != hashCode) {
				this.buckets[nextkey] = newNode;
				this.Count++;
				System.out.println("new node added");
				//resize if needed
				this.Resize();
			} else {
				throw new Exception("The hash table is full.");
			}
		}
	}
	
	
	//get
	public HashNodeOpen Get(String key) {
		//get hash code
		int hashCode = this.GetHash(key);
		//look up on the array
		HashNodeOpen curr = this.buckets[hashCode];
		int nextKey = hashCode;
		if (curr.State == NodeState.empty_since_start) {
			return null;
		} else if (curr.State == NodeState.empty_after_delete || 
				!curr.Key.equals(key)) {
			//we need to check the next opening address
			nextKey = (nextKey + 1) % this.Size;
			curr = this.buckets[nextKey];
			while (curr.State != NodeState.empty_since_start && 
					nextKey != hashCode) {
				if (curr.State == NodeState.empty_after_delete ||
						!curr.Key.equals(key)) {
					nextKey = (nextKey + 1) % this.Size;
					curr = this.buckets[nextKey];
				} else {
					return curr;
				}
			}
			return null;
		} else {
			return curr;
		}
		//check the key and the key on the bucket
		//if not, look at the next position
		//keep on searching until we searched all the positions or
		//until we meet empty-since-start
	}
	
	
	//remove
	public void Remove(String key) {
		int hashCode = this.GetHash(key);
		int nextkey = hashCode;
		HashNodeOpen curr = this.buckets[nextkey];
		if (curr.State == NodeState.empty_since_start) {
			return;
		} else if (curr.State == NodeState.regular &&
				curr.Key.equals(key)) {
			this.buckets[nextkey] = HashNodeOpen.emptyAfterDeleteNode(nextkey);
			return;
		} else {
			nextkey = (nextkey + 1) % this.Size;
			curr = this.buckets[nextkey];
			while (curr.State == NodeState.empty_after_delete ||
					(curr.State == NodeState.regular && curr.Key
					!= key) || nextkey == hashCode){
				nextkey = (nextkey + 1) % this.Size;
				curr = this.buckets[nextkey];
			}
			if (nextkey == hashCode) {
				return;
			} else if (curr.State == NodeState.empty_since_start) {
				return;
			} else {
				this.buckets[nextkey] = HashNodeOpen.emptyAfterDeleteNode(nextkey);
				return;
			}
		}
	}
	
	
	//resize
	void Resize() throws Exception {
		if (!this.IsChunky()) {
			return;
		}
		System.out.println("have to resize... begin process.");
		HashNodeOpen[] originalBuckets = this.buckets;
		this.Count = 0;
		this.Size = this.Size * 2;
		this.buckets = new HashNodeOpen[this.Size];
		for(int i = 0; i < this.Size; i++) {
			this.buckets[i] = HashNodeOpen.emptySinceStartNode(i);
		}
		for(int i = 0; i < originalBuckets.length; i++) {
			HashNodeOpen curr = originalBuckets[i];
			if (curr.State == NodeState.regular) {
				this.HashInsert(curr.Key, curr.Value);
			}
		}
		System.out.println("resize completed.");
	}
	
	
	//check the capacity
	private boolean IsChunky() {
		return ((float)this.Count / (float)this.Size) >= this.Threashold;
	}
}
