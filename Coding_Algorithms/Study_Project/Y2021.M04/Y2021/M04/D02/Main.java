package Y2021.M04.D02;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution2();
	}
	
	public static void solution2() throws Exception {
		int n = Integer.parseInt(rd.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		System.out.println(sol2_BFS(arr,0));
	}
	
	public static int sol2_BFS(int[][] arr, int count) {
		if(count >= 5) return sol2_findMax(arr);
		int n = arr.length;
		int[][] copy = new int[n][n];
		int max = 0;
		
		sol2_copyArr(arr,copy);
		sol2_move(copy,0);
		max = sol2_BFS(copy, count+1);
		
		sol2_copyArr(arr,copy);
		sol2_move(copy,1);
		max = Math.max(max , sol2_BFS(copy, count+1));
		
		sol2_copyArr(arr,copy);
		sol2_move(copy,2);
		max = Math.max(max , sol2_BFS(copy, count+1));
		
		sol2_copyArr(arr,copy);
		sol2_move(copy,3);
		max = Math.max(max , sol2_BFS(copy, count+1));
		
		return max;
	}
	
	public static void sol2_copyArr(int[][] arr1, int[][] arr2) {
		int n = arr1.length;
		int m = arr1[0].length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr2[i][j] = arr1[i][j];
			}
		}
	}
	public static int sol2_findMax(int[][] arr) {
		int n = arr.length;
		int max = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j] > max) max = arr[i][j]; 
			}
		}
		return max;
	}
	public static void sol2_move(int[][] arr, int dir) {
		ArrayList<ArrayList<Integer>> mv = new ArrayList<>();
		int n = arr.length;
		for(int i=0;i<n;i++) mv.add(new ArrayList<Integer>());
		int hw = dir == 2 || dir == 3 ? -1 : 1;
		int ww = dir == 1 || dir == 2 ? -1 : 1;
		int hi=0, wi=0;	
		if(dir == 0|| dir == 2) hi = dir == 2 || dir ==3 ? n-1 : 0;
		else wi = dir == 1 || dir == 2 ? n-1 : 0;
		for(int i=0;i<n;i++) {
			if(dir == 1 || dir == 3) hi = dir == 2 || dir ==3 ? n-1 : 0;
			else wi = dir == 1 || dir == 2 ? n-1 : 0;
			for(int j=0;j<n;j++) {
				if(arr[hi][wi] != 0) mv.get(i).add(arr[hi][wi]);
				if(dir == 1 || dir == 3) hi += hw;
				else wi += ww;
			}
			if(dir == 0 || dir == 2) hi += hw;
			else wi += ww;
		}	// ������ ������ ���Ͽ� �迭���¸� ����Ʈ ���·� �������
		// �� �� ���Ⱚ�� �ʱⰪ�� dir���� ���� �����ϰ� �������ָ�, ���� 0�� �߰����� ����
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<mv.get(i).size()-1;j++) {
				int left = mv.get(i).get(j);
				int right = mv.get(i).get(j+1);
				if(left == right) {
					mv.get(i).add(j, left + right);
					mv.get(i).remove(j+1);
					mv.get(i).remove(j+1);
				}
			}
		}	// ����Ʈ�� ����Ȱ��� �̵����Ѽ� ��ħ
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j >= mv.get(i).size()) arr[i][j] = 0;
				else arr[i][j] = mv.get(i).get(j);
			}
		}	// ����Ʈ�� ����Ǿ��� ���� �ٽ� �迭�� �������
		// �� ��, ����Ʈ�� �� ���� ��� 0���� ä��
		
//		for(int i=0;i<mv.size();i++) {
//			for(int j=0;j<mv.get(i).size();j++) {
//				System.out.print(mv.get(i).get(j)+" ");
//			}
//			System.out.println();
//		}
	}
	
	public static void solution() throws Exception {
		int a = Integer.parseInt(rd.readLine());
		int b = Integer.parseInt(rd.readLine());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=100;i++) {
			list.add((int)Math.pow(i, 2));
		}
		int left = Collections.binarySearch(list, a);
		left = left < 0 ? -left-1 : left;
		int right = Collections.binarySearch(list, b);
		right = right < 0 ? -right-2 : right;
		
		if(left > right) {
			System.out.println(-1);
		} else {
			int min = list.get(left);
			int sum = 0;
			for(int i=left;i<=right;i++) {
				sum += list.get(i);
			}
			System.out.println(sum);
			System.out.println(min);
		}
		
	}
}