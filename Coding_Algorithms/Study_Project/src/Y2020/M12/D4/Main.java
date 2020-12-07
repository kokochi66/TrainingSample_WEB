package Y2020.M12.D4;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution();
//		System.out.println(area(8, new int[]{2,0}, new int[]{6,7}));
	}
	public static void solution() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			char[][] carr = new char[n][n];
			for(int i=0;i<n;i++) {
				carr[i] = rd.readLine().toCharArray();
			}
//			for(int i=0;i<n;i++) System.out.println(Arrays.toString(carr[i]));
			int[] dp = new int [10];
			int[][] swit = new int[10][8];
			// 0-1 = left
			// 2-3 = right
			// 4-5 = top
			// 6-7 = bottom
			boolean[] used = new boolean[10];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++) {
					int c = carr[i][j] - '0';
					if(!used[c]) {
						used[c] = true;
						init(swit[c], i, j);
					}
					else {
						int cMax = Math.max(Math.max(area(n,new int[]{swit[c][0],swit[c][1]}, new int[]{i,j}), area(n,new int[]{swit[c][6],swit[c][7]}, new int[]{i,j})), 
								Math.max(area(n,new int[]{swit[c][2],swit[c][3]}, new int[]{i,j}), area(n,new int[]{swit[c][4],swit[c][5]}, new int[]{i,j})));
						if(cMax > dp[c]) dp[c] = cMax;
						check(swit[c],i,j);
					}
				}
			}
//			for(int i=0;i<10;i++) {
//				System.out.println(Arrays.toString(swit[i]));
////				dp[i] = Math.max(area(n,new int[]{swit[i][4],swit[i][5]}, new int[]{swit[i][6],swit[i][7]}), 
////						area(n,new int[]{swit[i][0],swit[i][1]}, new int[]{swit[i][2],swit[i][3]}));
//			}
			for(int i : dp) System.out.print(i+" ");
			System.out.println();
		}
	}
	public static void init(int[] swit, int x, int y) {
		for(int i=0;i<4;i++) {
			swit[i*2] = x;
			swit[(i*2)+1]=y;
		}
	}
	public static void check(int[] swit, int x, int y) {
		if(swit[1] > y) {
			swit[0] = x;
			swit[1] = y;
		}
		if(swit[3] < y) {
			swit[2] = x;
			swit[3] = y;
		}
		if(swit[4] > x) {
			swit[4] = x;
			swit[5] = y;
		}
		if(swit[6] < x) {
			swit[6] = x;
			swit[7] = y;
		}
	}
	
	public static int area(int n, int[] swit1, int[] swit2) {
		int max = Math.max(Math.abs(swit1[0]-swit2[0]) * Math.max(
				Math.max(swit1[1]-0, n-1-swit1[1]), Math.max(swit2[1]-0, n-1-swit2[1])),
				Math.abs(swit1[1]-swit2[1]) * Math.max(
						Math.max(swit1[0]-0, n-1-swit1[0]), Math.max(swit2[0]-0, n-1-swit2[0])));
		return max;
	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		for(int TT=0;TT<TestCase;TT++) {
//			int n = Integer.parseInt(rd.readLine());
//			tok = new StringTokenizer(rd.readLine());
//			int[] arr = new int[n];
//			long sum = 0;
//			for(int i=0;i<n;i++) {
//				arr[i] = Integer.parseInt(tok.nextToken());
//				if(i>0) sum += Math.abs(arr[i]-arr[i-1]);
//			}
//			long[] dp = new long[n];
//			dp[0] = sum - Math.abs(arr[0]-arr[1]);
//			dp[n-1] = sum - Math.abs(arr[n-2]-arr[n-1]);
//			for(int i=1;i<n-1;i++) {
//				dp[i] = sum - Math.abs(arr[i-1]-arr[i]) - Math.abs(arr[i]-arr[i+1])
//						+ Math.abs(arr[i-1]-arr[i+1]);
//			}
////			System.out.println(Arrays.toString(dp));
//			System.out.println(Arrays.stream(dp).min().getAsLong());
////			System.out.println(Arrays.toString(arr));
//			
//			
//			
//		}
//	}
//	public static void solution() throws Exception {
//		int TestCase = Integer.parseInt(rd.readLine());
//		for(int TT=0;TT<TestCase;TT++) {
//			tok = new StringTokenizer(rd.readLine());
//			int n = Integer.parseInt(tok.nextToken());
//			int m = Integer.parseInt(tok.nextToken());
//			int[] arrn = new int[n];
//			int[] arrm = new int[m];
//			tok = new StringTokenizer(rd.readLine());
//			for(int i=0;i<n;i++) {
//				arrn[i] = Integer.parseInt(tok.nextToken());
//			}
//			int count = 0;
//			tok = new StringTokenizer(rd.readLine());
//			for(int i=0;i<m;i++) {
//				arrm[i] = Integer.parseInt(tok.nextToken());
//			}
//			
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<m;j++) {
//					if(arrn[i] == arrm[j]) count++;
//				}
//			}
//			System.out.println(count);
//		}
//	}
}