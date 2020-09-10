
public class Lottoex {
	public static void main(String[] args)
	{
	 int n=45;
	 int k=6;
	 double A=1;
	 double B=1;
	 
	   for(int i=0;i<k;i++)
	   {
	   A=A*n;
	   n--;
	   B=B*(i+1);
	   }

	 double combination=A/B;
	 double Probability=combination;

	 System.out.println("로또 1등 당첨확률: 1/"+Probability);
	 System.out.println(A);
	 System.out.println(B);
	}

}
