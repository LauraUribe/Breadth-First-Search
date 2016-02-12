
public class hwk4_algorithmns {

 String a = "this is n-1";
 static int n = 4;
	// public final String a,b;
 
 	public static String matrix()
 	{
 		//int m = 5;
 		String yucca = "";
 				int[][] adj_matrix = new int[n][n];  // create matrix and new instance of it;
 				
 				adj_matrix[0][0] = 0;
 				adj_matrix[0][1] = 1;
 				adj_matrix[0][2] = 0;
 				adj_matrix[0][3] = 1;

 				adj_matrix[1][0] = 1;
 				adj_matrix[1][1] = 0;
 				adj_matrix[1][2] = 0;
 				adj_matrix[1][3] = 1;

 				adj_matrix[2][0] = 1;
 				adj_matrix[2][1] = 1;
 				adj_matrix[2][2] = 0;
 				adj_matrix[2][3] = 1;

 				adj_matrix[3][0] = 0;
 				adj_matrix[3][1] = 0;
 				adj_matrix[3][2] = 0;
 				adj_matrix[3][3] = 0;

 				// adjacency_matrix[n][m];  // created an adjacency matrix with arbitrary value of 5, 5
 				int num = 0;  // some number to start with
 				
 				for (int i = 0; i < n; i++)  // looks at column to see if they are zero
 				{
 					if (adj_matrix[num][i] == 0)  // needs one column to be all zeros
 					{
 						num = i;  
 						yucca = "This is Yucca";
 						// row and column has a zero;
 					}
 				}
 				//System.out.println("return num is: " + num);
 				//return num;
 				
 				for (int i = 0; i < n; i++)  // if indegree is zero
 				{
 					// String a = "this is n-1";
 					// if ((i != num) && (adj_matrix[i][num] == 1) || (return a));
 					if ((i == num && adj_matrix[num][i] == 1) || (i != num && (adj_matrix[i][num] == 1 || adj_matrix[num][i] == 0)))
 					// if 1 is not 0 and there is a one or a zero in a row/col or col/row, then:
 					{
 						// String b = "this is me"
 						//System.out.println("row and column has a 1 or 0");
 						yucca = "This is not Yucca";
 					}
 					//else System.out.println("row and column does not have a 1 or 0");
 						//return a;
 					}
 				return yucca;
		
 	}
 	
 	
 	
 
	public static void Main(String[] args)  
	{
		
		System.out.println(matrix());		
}
}
