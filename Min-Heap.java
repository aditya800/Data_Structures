/* Notes: static heap can be converted to dynamic by checking while inserting if current size is exceeding max size. If true,
a new array can be created with double the capacity with a copy of the original elements */

public class PriorityQueue {
	
	private int[] heapArray;
	private int size;
	private int cur;
	private int root;

	public PriorityQueue(int s) {
		size = s;
		cur = 0;
		heapArray = new int[size + 1];
	}

	public int Peek-MIN() {
		if(cur > size) {
			throw new Exception("InvalidException");
		} else {
			return heapArray[1];
		}
	}

	public int getSize() {
		return cur;
	}

	public void insert(int n) {

		heapArray[++cur] = n;
		child = cur;
		parent = cur - 1 / 2;

		while(parent > 0 && heapArray[parent] > heapArray[child]) {

				swap(heapArray[parent], heapArray[child]);	
				child = parent;
				parent = Math.floor(parent - 1 / 2);

		}

	}

	public int Extract-MIN() {

		int root = heapArray[1];
		heapArray[0] = heapArray[cur--];
		int left = 2;
		int right = 3;

		while(right <= cur && (heapArray[parent] > heapArray[left] || heapArray[parent] > heapArray[right])) {

			if(heapArray[left] < heapArray[right]) {
				swap(heapArray[left], heapArray[parent]);
				parent = left;
			} else {
				swap(heapArray[right], heapArray[parent]);
				parent = right;
			}

			left = 2*parent + 1;
			right = 2*parent + 2;
		}

		return root;
	}
}



