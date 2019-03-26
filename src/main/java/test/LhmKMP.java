package test;

/**
 * 实现kmp算法
 * 
 * @author 指键花下
 *
 */
public class LhmKMP {

	/**
	 * 获取主串中有几个匹配串,打印位置，以及匹配次数
	 * 
	 * @param modelStr
	 * @param mainstr
	 * @return int
	 */
	public static int KmpMatching(String modelStr, String mainstr) {
		return KmpMatche(modelStr.toCharArray(), mainstr.toCharArray());
	}

	private static int KmpMatche(char[] modelStr, char[] mainStr) {
		int count = 0;
		int[] next=getNext(modelStr);
		int i = 0,j = 0;
		while(i<modelStr.length&&j<mainStr.length) {	
			//如果next[i]=-1 或者 当前的字符匹配相同，同时向后移一位
			if (i==-1||modelStr[i]==mainStr[j]) {
				if (i==modelStr.length-1) {//如果i的值等于长度，说明匹配到了,打印此时的主串下标，结束匹配
					System.out.println("匹配成功!"+"起始位置下标："+(j-i)+" 结束位置下标："+j+" 匹配次数："+count);
					i=-1;
				}
				j++;
				i++;
				count++;	
			}else {//如果不相等，令i=next[i]，j不变，再次比较
				i=next[i];
			}
		}
		return count;
	}

	public static int[] getNextArray(String modelStr) {
		return getNext(modelStr.toCharArray());
	}

	private static int[] getNext(char[] arr) {
		int[] next = new int[arr.length];
		next[0] = -1;
		next[1] = 0;
		for (int i = 2; i < arr.length; i++) {
			int k = next[i - 1];
			next[i] = isEqual(i, k, arr, next);
		}
		return next;
	}

	private static int isEqual(int j, int k, char[] T, int[] next) {
		if (T[j - 1] == T[k]) {
			return next[j] = k + 1;
		}
		k = next[k];
		if (k == -1) {
			return 0;
		}
		return isEqual(j, k, T, next);
	}
	public static void main(String[] args) {
		KmpMatching("abc", "ababababcabcabc");
	}
}
