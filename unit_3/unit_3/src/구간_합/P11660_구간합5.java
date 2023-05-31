package 구간_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660_구간합5 {
    public static void out() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] D = new int[N+1][N+1]; //N+1 까먹지 말기!
        int[][] S = new int[N+1][N+1];

        for(int i = 1; i <= N ; i++){
            //한 줄씩 받아오기
            st = new StringTokenizer(bf.readLine());
            for(int j = 1; j<=N;j++){
                D[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N ; i++){
            for(int j = 1; j<=N;j++){
                S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + D[i][j];
            }
        }
        //구간합 구하기
        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(S[x2][y2] - S[x1-1][y2] -S[x2][y1-1] + S[x1-1][y1-1]);
        }
    }
}