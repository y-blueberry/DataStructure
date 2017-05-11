package linkedlist;

public class link1 {

	Node head = null;

	class Node {
		Node next = null;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	/**
	 * 向表中插入数据
	 */
	public void addNode(int d) {
		Node newNode = new Node(d);// 实例化一个节点
		if (head == null) {
			head = newNode;
			return;
		}
		Node tmp = head;

		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = newNode;

	}

	/**
	 * 删除第index个节点
	 */
	public boolean deleteNode(int index) {
		if (index < 1 || index > length()) {
			return false;
		}
		if (index == 1) {
			head = head.next;
			return true;
		}
		int i = 1;
		Node preNode = head;
		Node curNode = preNode.next;
		while (curNode != null) {
			if (i == index) {
				preNode.next = curNode.next;
				return true;
			}
			preNode = curNode;
			curNode = curNode.next;
			i++;
		}
		return false;
	}

	// 长度
	public int length() {
		int length = 0;
		Node tmp = head;
		while (tmp != null) {
			length++;
			tmp = tmp.next;
		}
		return length;
	}

	// 不知道头指针的情况下删除指定节点
	public boolean deleteNode1(Node n) {
		if (n == null || n.next == null)
			return false;
		int tmp = n.data;
		n.data = n.next.data;
		n.next.data = tmp;
		n.next = n.next.next;
		System.out.println("删除成功！");
		return true;
	}

	public void printList() {
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}

	public Node ReverseIteratively(Node head) {
		Node pReversedHead = head;
		Node pNode = head;
		Node pPrev = null;
		while (pNode != null) {
			Node pNext = pNode.next;
			if (pNext == null) {
				pReversedHead = pNode;
			}
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = pNext;
		}
		this.head = pReversedHead;
		return this.head;
	}

	public Node SearchMid(Node head) {
		Node p = this.head, q = this.head;
		while (p != null && p.next != null && p.next.next != null) {
			p = p.next.next;
			q = q.next;
		}
		System.out.println("Mid:" + q.data);
		return q;
	}

	// 查找倒数第k个元素
	public Node findElem(Node head, int k) {
		if (k < 1 || k > this.length()) {
			return null;
		}
		Node p1 = head;
		Node p2 = head;
		// 前移k步
		for (int i = 0; i < k; i++)
			p1 = p1.next;
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	// 排序
	public Node orderList() {
		Node nextNode = null;
		int tmp = 0;
		Node curNode = head;
		while (curNode.next != null) {
			nextNode = curNode.next;
			while (nextNode != null) {
				if (curNode.data > nextNode.data) {
					tmp = curNode.data;
					curNode.data = nextNode.data;
					nextNode.data = tmp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
		return head;
	}

	// 删除重复节点
	public void deleteDuplecate(Node head) {
		Node p = head;
		while (p != null) {
			Node q = p;
			while (q.next != null) {
				if (p.data == q.next.data) {
					q.next = q.next.next;
				} else {
					q = q.next;
				}
				p = p.next;
			}
		}
	}

	// 从尾到头输出单链表，采用递归方式实现
	public void printListReversely(Node pListHead) {
		if (pListHead != null) {
			printListReversely(pListHead.next);
			System.out.println("printListReversely:" + pListHead.data);
		}
	}

	// 判断链表是否有环，单向链表有环时，为节点相同
	public boolean IsLoop(Node head) {
		Node fast = head, slow = head;
		if (fast == null) {
			return false;
		}
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				System.out.println("该链表有环");
				return true;
			}
		}
		return !(fast == null || fast.next == null);
	}

	// 找出链表环的入口
	public Node FindLoopPort(Node head) {
		Node fast = head, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		if (fast == null || fast.next == null)
			return null;
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
