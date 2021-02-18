package Test;


import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		String s = "abc";
		ArrayList<String> permutation = Permutation(s);
		for (String string : permutation) {
			System.out.println(string);
		}
	}

	public static ArrayList<String> Permutation(String str) {
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

	public static void Permutation(char[] data, int beginIdx, ArrayList<String> result) {
		if (beginIdx == data.length) {
			result.add(new String(data));
		} else {
			for (int i = beginIdx; i < data.length; ++i) {
				// 有重复字符时，跳过
				if (i != beginIdx && data[i] == data[beginIdx])
					continue;
				// 当i==begin时，也要遍历其后面的所有字符;
				// 当i!=begin时，先交换，使第begin位取到不同的可能字符，再遍历后面的字符
				swap(data, beginIdx, i);
				Permutation(data, beginIdx + 1, result);
				// 为了防止重复的情况，还需要将begin处的元素重新换回来           恢复打扫战场，恢复为原来子串， data共享
				swap(data, beginIdx, i);
				/*
				 * 举例来说“b(acd)” acd排列 ，为什么使用了两次swap函数?    函数栈变化恢复 ， 
				 * "acd第一次输出 cda后，完全退栈 返回data应该还是acd"
				 *                                              交换栈                       退栈
				 *                         bacd       bacd                         bcad      
				 * bcad                         bcda 打印  -> bcda                 
				 */
			}
		}
	}
	public static void swap(char[] str, int i, int j) {
		if (i != j) {
		char t = str[i];
		str[i] = str[j];
		str[j] = t;
		}
	}
}