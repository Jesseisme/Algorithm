package gogogo;


import java.util.*;

public class Offer {

	// ListNode
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}

        public ListNode() {
        }
    }

	// TreeNode
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	// 质数
	public void getZhishu(int n) {
		boolean[] isprime = new boolean[100];
		for (int i = 0; i < isprime.length; i++) {
			isprime[i] = true;
		}
		for (int i = 2; i < isprime.length; i++) {
			for (int k = i; i * k < isprime.length; k++) {
				isprime[i * k] = false;
			}
		}

		for (int i = 2; i < isprime.length; i++){
			if (isprime[i]){
				System.out.print(i + " ");
			}
		}

	}

	// 输入一个链表，从尾到头打印链表每个节点的值。
	ArrayList<Integer> a = new ArrayList<Integer>();

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode != null) {
			printListFromTailToHead(listNode.next);
			a.add(listNode.val);
		}
		return a;
	}

    //翻转链表
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;//一个引用记录下一个节点
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
    }

	// 两个栈实现队列
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int a) {
		stack1.push(a);
	}

	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return (int) stack2.pop();
	}

	// 旋转数组的最小数字
	public int minNumberInRotateArray(int[] numbers) {
		int lo = 0;
		int hi = numbers.length - 1;
		int mid = lo;
		while (lo < hi) {
			mid = lo + (hi - lo) / 2;
			if (numbers[mid] > numbers[hi]) {
				lo = mid + 1;
			} else if (numbers[mid] < numbers[hi]) {
				hi = mid;
			} else {
				hi--;
			}
		}
		return numbers[hi];
	}

	// 跳台阶
	public int JumpFloor(int target) {
		int a[] = new int[target + 1];
		if (target == 1){
			return 1;
		}
		if (target == 2){
			return 2;
		}

		a[1] = 1;
		a[2] = 2;
		for (int i = 3; i <= target; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}
		return a[target];
	}

	// 二进制中1的个数
	public int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = (n - 1) & n;
		}
		return count;
	}

	// 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
	public double Power(double base, int exponent) {
		double res = 1, cur = base;
		int n = exponent;
		if (exponent > 0) {
			n = exponent;
		} else if (exponent < 0) {
			n = -exponent;
		} else {
			return 1;
		}
		while (n != 0) {
			if ((n & 1) == 1) {
				res *= cur;
			}
			cur *= cur;
			n >>= 1;
		}
		return exponent > 0 ? res : 1 / res;
	}

	// 奇数位于偶数之前
	public void reOrderArray(int[] array) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			
			for (int j = 1; j < n - i; j++) {
				if ((array[j - 1] & 1) != 1 && (array[j] & 1) == 1) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

    //求根到叶子节点数字之和
        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        public int dfs(TreeNode root, int prevSum) {
            if (root == null) {
                return 0;
            }
            int sum = prevSum * 10 + root.val;
            if (root.left == null && root.right == null) {
                return sum;
            } else {
                return dfs(root.left, sum) + dfs(root.right, sum);
            }
        }


	// 链表 倒数第k个数
	public ListNode FindKthToTail(ListNode head, int k) {
		ListNode fast = head;
		ListNode slow = head;
		if (head == null || k == 0) {
			return null;
		}
		while ((k - 1) != 0) {
			if (fast.next != null) {
				fast = fast.next;
				k--;
			} else {
				return null;
			}

		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	public int FindKthToTailWithRe(ListNode head,int k){
		if(head!=null){
			FindKthToTailWithRe(head.next,k);
			k--;
			if(k==0){
				return head.val;
			}
		}
		return -1;
	}

	// 合并两个排序的链表
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode prehead = new ListNode(-1);

		ListNode prev = prehead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}

		// 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
		prev.next = l1 == null ? l2 : l1;

		return prehead.next;
	}


	// A树hasB树
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean res = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val)
				res = is1equal2(root1, root2);
			if (!res)
				HasSubtree(root1.right, root2);
			if (!res)
				HasSubtree(root1.left, root2);
		}
		return res;
	}

	private boolean is1equal2(TreeNode root1, TreeNode root2) {
		if (root2 == null)
			return true;
		if (root1 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return is1equal2(root1.right, root2.right) && is1equal2(root1.left, root2.left);
	}

	// 入栈 出栈
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		Stack<Integer> stack = new Stack<>();
		int index = 0;
		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while (!stack.isEmpty() && stack.peek() == popA[index]) {
				stack.pop();
				index++;
			}
		}
		return stack.isEmpty();
	}

	// 二叉树的镜像 反转二叉树
	public void Mirror(TreeNode root) {
		if (root == null)
			return;
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;

		Mirror(root.right);
		Mirror(root.left);
	}

	// 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<>();
		find(root, target, res, path);
		return res;
	}

	// 遍历
	private void find(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path) {
		if (root == null)
			return;
		path.add(root.val);
		if (root.left == null && root.right == null && target - root.val == 0)
			res.add(new ArrayList<>(path));
		find(root.right, target - root.val, res, path);
		find(root.left, target - root.val, res, path);
		path.remove(path.size() - 1);
	}

	// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
	// 中序遍历
	TreeNode cur = null;
	TreeNode head = null;

	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return null;
		Convert(pRootOfTree.left);
		if (cur == null) {
			head = cur = pRootOfTree;
		} else {
			cur.right = pRootOfTree;
			pRootOfTree.left = cur;
			cur = pRootOfTree;
		}
		Convert(pRootOfTree.right);
		return head;
	}

	// 重排序
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<String>();
		if (str == null || str.length() > 9 || str.length() == 0) {
			return result;
		}
		str = str.trim();
		Permutation(str.toCharArray(), 0, result);
		//       HashSet<String> hs = new HashSet<String>(result);  //此仅去重，没有字典序排列，可能错误
		//       new ArrayList<String>(hs);
		Collections.sort(result);// 字典序排列  有些oj要求
		return result;
	}

	// A B C
	// A B C
	// A B C
	public static void Permutation(char[] data, int beginIdx, ArrayList<String> result) {
		if (beginIdx == data.length) {
			result.add(new String(data));
		} else {
			for (int i = beginIdx; i < data.length; i++) {
				// 有重复字符时，跳过
				if (i != beginIdx && data[i] == data[beginIdx])
					continue;
				// 当i==begin时，也要遍历其后面的所有字符;
				// 当i!=begin时，先交换，使第begin位取到不同的可能字符，再遍历后面的字符
				swap(data, beginIdx, i);

				Permutation(data, beginIdx + 1, result);

				// 为了防止重复的情况，还需要将begin处的元素重新换回来           恢复打扫战场，恢复为原来子串， data共享
				swap(data, beginIdx, i);

			}
		}

	}

	private static void swap(char[] data, int i, int j) {
		if (i != j) {
			char temp = data[j];
			data[j] = data[i];
			data[i] = temp;
		}

	}

	// find k in array
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		findkth(input, k);
		for (int i = 0; i < k; i++) {
			res.add(input[i]);
		}
		return res;
	}

	private void findkth(int[] input, int k) {
		int lo = 0;
		int hi = input.length - 1;
		int j = partion(input, lo, hi);
		while (j != (k - 1)) {
			if (j < k - 1) {
				partion(input, j + 1, hi);
			} else {
				partion(input, lo, j - 1);
			}
		}
	}

	private int partion(int[] input, int lo, int hi) {
		int v = input[lo];
		int i = lo, j = hi + 1;
		if (lo == hi)
			return lo;
		while (true) {
			while (v > input[++i])
				if (i >= hi)
					break;
			while (v < input[--j])
				if (j <= lo)
					break;
			if (i >= j)
				break;
			swap(input, i, j);
		}
		swap(input, lo, j);
		return j;
	}

	private void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	// 数组中连续数字最大和 最大子序列
	public int FindGreatestSumOfSubArray(int[] array) {
		if (array.length == 0){
			return 0;
		}

		int total = array[0], maxSum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (total >= 0){
				total += array[i];
			}
			else{
				total = array[i];
			}
			if (total > maxSum){
				maxSum = total;
			}
		}
		return maxSum;

	}

	// 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
	public String PrintMinNumber(int[] numbers) {
		int n = numbers.length;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(numbers[i]);
		}
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer str1, Integer str2) {
				String s1 = str1 + "" + str2;
				String s2 = str2 + "" + str1;
				return s1.compareTo(s2);
			}

		});
		String res = "";
		for (int i : list) {
			res += i;
		}
		return res;
	}

	// 丑数
	public int GetUglyNumber_Solution(int index) {
		if (index < 7)
			return index;
		int t2 = 0, t3 = 0, t5 = 0;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0, 1);
		for (int i = 1; i < index; i++) {
			int min = Math.min(list.get(t2) * 2, Math.min(list.get(t3) * 3, list.get(t5) * 5));
			list.add(i, min);
			if (min == list.get(t2) * 2)
				t2++;
			if (min == list.get(t3) * 3)
				t3++;
			if (min == list.get(t5) * 5)
				t5++;
		}
		return list.get(index - 1);
	}

	// 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
	public int FirstNotRepeatingChar(String str) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 2);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		int pos = -1;
		for (int i = 0; i < str.length(); i++) {
			Integer time = map.get(str.charAt(i));
			if (time == 1)
				return i;
		}
		return pos;
	}

	// 数组中的逆序对
	private static int[] aux;
	int count = 0;

	public int InversePairs(int[] array) {

		aux = new int[array.length];
		int lo = 0, hi = array.length - 1;
		Sort(array, lo, hi);
		return count;
	}

	private void Sort(int[] array, int lo, int hi) {
		if (lo >= hi)
			return;
		int mid = lo + (hi - lo) / 2;
		Sort(array, lo, mid);
		Sort(array, mid + 1, hi);
		Merge(array, lo, mid, hi);
	}

	private void Merge(int[] array, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = array[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				array[k] = aux[j++];
			else if (j > hi)
				array[k] = aux[i++];
			else if (aux[i] > aux[j]) {
				count += mid - i + 1;
				count %= 1000000007;
				array[k] = aux[j++];

			} else
				array[k] = aux[i++];
		}
	}

	// 统计一个数字在排序数组中出现的次数。 二分
	public int GetNumberOfK(int[] array, int k) {
		if (array.length == 0)
			return 0;
		int first = getFirstKth(array, 0, array.length - 1, k);
		int last = getLastKth(array, 0, array.length - 1, k);
		if (first == -1 || last == -1) {
			return 0;
		} else {
			return last - first + 1;
		}
	}

	private int getLastKth(int[] array, int lo, int hi, int k) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (array[mid] > k)
				hi = mid - 1;
			else if (array[mid] < k) {
				lo = mid + 1;
			} else {
				if ((mid < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1) {
					return mid;
				} else {
					lo = mid + 1;
				}
			}
		}
		return -1;
	}

	private int getFirstKth(int[] array, int lo, int hi, int k) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (array[mid] > k)
				hi = mid - 1;
			else if (array[mid] < k) {
				lo = mid + 1;
			} else {
				if ((mid > 0 && array[mid - 1] != k) || mid == 0) {
					return mid;
				} else {
					hi = mid - 1;
				}
			}
		}
		return -1;
	}

	// 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
	public int TreeDepth(TreeNode pRoot) {
		if (pRoot == null)
			return 0;
		int left = TreeDepth(pRoot.left);
		int right = TreeDepth(pRoot.right);
		return Math.max(left, right) + 1;
	}

	// 是否为平衡二叉树
	boolean flag = true;

	public boolean IsBalanced_Solution(TreeNode root) {
		depth(root);
		return flag;
	}

	public int depth(TreeNode root) {// 后序遍历
		if (root == null)
			return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		if (Math.abs(left - right) > 1)
			flag = false;
		return Math.max(left, right) + 1;
	}

	//

	/**
	 *      * 数组中有两个出现一次的数字，其他数字都出现两次，找出这两个数字      * @param array      * @param num1
	 *      * @param num2      
	 */
	public static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array == null || array.length <= 1) {
			num1[0] = num2[0] = 0;
			return;
		}
		int len = array.length, index = 0, sum = 0;
		for (int i = 0; i < len; i++) {
			sum ^= array[i];
		}
		for (index = 0; index < 32; index++) {
			if ((sum & (1 << index)) != 0)
				break;
		}
		for (int i = 0; i < len; i++) {
			if ((array[i] & (1 << index)) != 0) {
				num2[0] ^= array[i];
			} else {
				num1[0] ^= array[i];
			}
		}
	}

	// 和为s的连续正数序列
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (sum < 3)
			return res;
		int mid = (sum + 1) / 2;
		int lo = 1, hi = 2, pursum = 3;
		while (lo < mid) {
			while (pursum < sum) {
				hi++;
				pursum += hi;
			}
			if (pursum == sum) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int i = lo; i <= hi; i++) {
					list.add(i);
				}
				res.add(list);
			}
			pursum -= lo;
			lo++;
		}
		return res;
	}

	// 和为s的两个数字
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		int i = 0, j = array.length - 1;
		ArrayList<Integer> list = new ArrayList<>();
		while (i < j) {
			int cursum = array[i] + array[j];
			if (cursum > sum) {
				j--;
			} else if (cursum < sum) {
				i++;
			} else {
				list.add(array[i]);
				list.add(array[j]);
				return list;
			}
		}
		return list;
	}

	// 左旋转字符串
	public String LeftRotateString(String str, int n) {
		if (str.length() == 0 || str == null)
			return "";
		return LeftRotateString(str.toCharArray(), 0, str.length() - 1, n);

	}

	private String LeftRotateString(char[] charArray, int lo, int hi, int n) {
		reverse(charArray, lo, hi);
		reverse(charArray, lo, hi - n);
		reverse(charArray, hi - n + 1, hi);
		String res = new String(charArray);
		return res;
	}

	// “student. a am I”翻转“I am a student.”。
	public String ReverseSentence(String str) {
		char[] chars = str.toCharArray();
		reverse(chars, 0, chars.length - 1);
		int blank = -1;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				int nextblank = i;
				reverse(chars, blank + 1, nextblank - 1);
				blank = nextblank;
			}
		}
		reverse(chars, blank + 1, chars.length - 1);
		return new String(chars);
	}

	private void reverse(char[] chars, int lo, int hi) {
		while (lo < hi) {
			char temp = chars[hi];
			chars[hi] = chars[lo];
			chars[lo] = temp;
			lo++;
			hi--;
		}
	}

	// 扑克牌顺子
	public static boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length != 5) {
			return false;
		}
		// 对元素进行排序
		Arrays.sort(numbers);
		int numberOfZero = 0;
		int numberOfGap = 0;
		for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
			numberOfZero++;
		}
		for (int i = numberOfZero + 1; i < numbers.length; i++) {
			if (numbers[i] == numbers[i - 1])
				return false;
			numberOfGap += numbers[i] - numbers[i - 1] - 1;
		}

		return numberOfGap <= numberOfZero;
	}

	// 圆圈中最后剩下的数字(约瑟夫环问题)
	// 模拟环
	public int LastRemaining_Solution(int n, int m) {
		if (m == 0 || n == 0) {
			return -1;
		}
		LinkedList<Integer> data = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			data.add(i);
		}
		int index = -1;
		while (data.size() > 1) {
			//           System.out.println(data);
			index = (index + m) % data.size();
			//           System.out.println(data.get(index));
			data.remove(index);
			index--;
		}
		return data.get(0);
	}

	// 两个数的和
	public int Add(int num1, int num2) {
		if (num2 == 0)
			return num1;
		int temp = num1 ^ num2;
		num2 = (num1 & num2) << 1;
		num1 = temp;
		return Add(num1, num2);
	}

	// 第一个重复的数字
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		if (numbers.length == 0)
			return false;
		HashSet<Integer> h = new HashSet<>();
		for (int i = 0; i < numbers.length; i++) {
			if (h.contains(numbers[i])) {
				duplication[0] = numbers[i];
				return true;
			} else {
				h.add(numbers[i]);
			}

		}
		return false;
	}

	// 输入两个链表，找出它们的第一个公共结点。
	// a+n+b=b+n+a
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode p1 = pHead1;
		ListNode p2 = pHead2;
		while (p1 != p2) {
			if (p1 != null) {
				p1 = p1.next;
			} else {
				p1 = pHead2;
			}
			if (p2 != null) {
				p2 = p2.next;
			} else {
				p2 = pHead1;
			}
		}
		return p1;
	}

	// 环的入口
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null || pHead.next == null)
			return null;
		ListNode slow = pHead;
		ListNode fast = pHead;
		while (true) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				fast = pHead;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;

				}
				if (slow == fast) {
					return slow;
				}
			}
		}
	}

	// 去除链表中重复的节点
	public ListNode deleteDuplication(ListNode pHead) {
		ListNode res = new ListNode(0);
		ListNode slow = res;
		slow.next = pHead;
		ListNode fast = pHead;

		while (fast != null) {
			while (fast.next != null && fast.next.val == fast.val) {
				fast = fast.next;
			}
			if (slow.next != fast) {
				slow.next = fast.next;
				fast = fast.next;
			} else {
				fast = fast.next;
				slow = slow.next;
			}
		}
		return res.next;
	}

	// 二叉树的下一个节点
	// 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
	// 1、有右子树的，那么下个结点就是右子树最左边的点；（eg：D，B，E，A，C，G）
	// 2、没有右子树的，也可以分成两类，a)是父节点左孩子（eg：N，I，L） ，那么父节点就是下一个节点 ；
	// b)是父节点的右孩子（eg：H，J，K，M）找他的父节点的父节点的父节点...直到当前结点是其父节点的左孩子位置。如果没有eg：M，那么他就是尾节点。
	public class TreeLinkNode {
		int val;
		TreeLinkNode left = null;
		TreeLinkNode right = null;
		TreeLinkNode next = null;

		TreeLinkNode(int val) {
			this.val = val;
		}
	}

	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode.right != null) {
			pNode = pNode.right;
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		} else {
			while (pNode.next != null) {
				if (pNode.next.left == pNode) {
					return pNode.next;
				} else {
					pNode = pNode.next;
				}
			}
		}

		return null;
	}

	// 对称二叉树
	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null)
			return true;

		return f(pRoot.left, pRoot.right);
	}

	boolean f(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;

		if (left != null && right != null)
			return left.val == right.val && f(left.left, right.right) && f(left.right, right.left);

		return false;
	}

	// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();// 队列
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = (TreeNode) queue.pop();
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
			}
			res.add(cur.val);
		}
		return res;
	}

	// 之字形打印二叉树
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null)
			return res;

		Stack<TreeNode> s1 = new Stack<TreeNode>();// 栈
		s1.add(pRoot);
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (!s1.isEmpty()) {
				ArrayList<Integer> aList = new ArrayList<Integer>();
				while (!s1.isEmpty()) {
					TreeNode p = s1.pop();
					aList.add(p.val);
					if (p.left != null)
						s2.add(p.left);
					if (p.right != null)
						s2.add(p.right);
				}
				res.add(aList);

			} else {
				ArrayList<Integer> aList2 = new ArrayList<Integer>();
				while (!s2.isEmpty()) {

					TreeNode p = s2.pop();
					if (p.right != null)
						s1.add(p.right);
					if (p.left != null)
						s1.add(p.left);
					aList2.add(p.val);

				}
				res.add(aList2);
			}
		}
		return res;
	}

	// 按层打印
	ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null)
			return res;
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<TreeNode> layer = new LinkedList<>();
		layer.offer(pRoot);
		int start = 0;
		int end = 1;
		while (!layer.isEmpty()) {
			TreeNode remove = layer.remove();
			list.add(remove.val);
			start++;
			if (remove.left != null) {
				layer.offer(remove.left);
			}
			if (remove.right != null) {
				layer.offer(remove.right);
			}
			if (start == end) {
				res.add(list);
				start = 0;
				end = layer.size();
				list = new ArrayList<>();
			}
		}
		return res;
	}

	// 二叉搜索树的第k个节点
	// 中序遍历
	TreeNode result = null;
	int count1 = 0;

	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k <= 0)
			return null;
		if (pRoot.left != null)
			KthNode(pRoot.left, k);
		if (++count1 == k) {
			result = pRoot;
			return result;
		}
		if (result == null && pRoot.right != null)
			KthNode(pRoot.right, k);
		return result;
	}

	public void treePrint(TreeNode root){
		if(root.left!=null){
			treePrint(root.left);
		}
		System.out.println(root.val);
		if(root.right!=null){
			treePrint(root.right);
		}
	}

	// 矩阵中的路径
	// a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		boolean[] visited = new boolean[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (hasPathCore(matrix, rows, cols, str, i, j, visited, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int i, int j, boolean[] visited, int k) {
		int index = i * cols + j;
		if (i < 0 || i >= rows || j < 0 || j >= cols || visited[index] || str[k] != matrix[index]) {
			return false;
		}
		visited[index] = true;
		if (k == str.length - 1)
			return true;
		if (hasPathCore(matrix, rows, cols, str, i + 1, j, visited, k + 1)
				|| hasPathCore(matrix, rows, cols, str, i - 1, j, visited, k + 1)
				|| hasPathCore(matrix, rows, cols, str, i, j + 1, visited, k + 1)
				|| hasPathCore(matrix, rows, cols, str, i, j - 1, visited, k + 1)) {
			return true;
		} else {
			k--;
			visited[index] = false;
			return false;
		}
	}

	// 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
	// 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 =
	// 19。请问该机器人能够达到多少个格子？
	int count2 = 0;

	public int movingCount(int threshold, int rows, int cols) {
		int array[][] = new int[rows][cols];
		int a[][] = new int[Integer.MAX_VALUE][Integer.MAX_VALUE];
		movingCount(threshold, rows, cols, 0, 0, array);
		return count2;
	}

	private int movingCount(int threshold, int rows, int cols, int i, int j, int array[][]) {
		if (i < 0 || i >= rows || j < 0 || j >= cols || (getSum(i) + getSum(j)) > threshold || array[i][j] == 1) {
			return 0;
		}
		array[i][j] = 1;
		count2++;
		movingCount(threshold, rows, cols, i + 1, j, array);
		movingCount(threshold, rows, cols, i - 1, j, array);
		movingCount(threshold, rows, cols, i, j + 1, array);
		movingCount(threshold, rows, cols, i, j - 1, array);
		return count;
	}

	private int getSum(int i) {
		int sum = 0;
		while (i > 0) {
			sum += i % 10;
			i = i / 10;
		}
		return sum;
	}
	//中序遍历
	public void inOrderTraverse1(TreeNode root) {
		if (root != null) {
			inOrderTraverse1(root.left);
			System.out.print(root.val+"  ");
			inOrderTraverse1(root.right);
		}
	}

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        int j = nums2.length - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[i + j + 1] = nums1[i];
                i--;
            } else {
                nums1[i + j + 1] = nums2[j];
                j--;
            }
        }
        while (j >= 0) {
            nums1[j] = nums2[j];
            j--;
        }
    }

	//最长不含重复字符的子字符串
	public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int res = -1;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)),i);

            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }

    public static void main(String[] args) {
        Offer offer = new Offer();

        offer.lengthOfLongestSubstring("abba");
    }

    //凑硬币   最少个数
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        int[] dp=new int[amount+1];
        dp[0]=0;
        for(int i = 1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0;j<coins.length;j++){
                if(i-coins[j]>=0 && dp[i-coins[j]] < min){
                    min = dp[i-coins[j]];
                }
            }
            dp[i]=(min==Integer.MAX_VALUE?Integer.MAX_VALUE:min+1);
        }
        return dp[amount]==Integer.MAX_VALUE ? -1:dp[amount];
    }
    //凑硬币   一个额度几种组合方法

    //不同路径
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }

        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                f[x][y] = f[x - 1][y] + f[x][y-1];
            }
        }
        return f[m][n];


    }

    //路径总和
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null) {
            return res;
        }
        findPathSum(root, sum, res, path);
        return res;
    }

    private void findPathSum(TreeNode root, int sum, List<List<Integer>> res, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if(root.right==null&&root.left==null&&sum-root.val==0){
            res.add(new ArrayList<>(path));
        }
        findPathSum(root.right, sum - root.val, res, path);
        findPathSum(root.left, sum - root.val, res, path);
        path.remove(path.size() - 1);
	}

	//股票最佳时机
    public int maxProfit(int[] prices) {
        int res = 0;
        int j = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] - prices[j] > 0) {
                res = Math.max(prices[i] - prices[j], res);
            } else {
                j = i;
            }
        }
        return res;
    }
}




