package assignment_4.again.Part2;

public class Test
{
    public static void main(String[] args)
    {
       System.out.println("whatever"); 
    }

    public void checkLocker(int x)
    {
                boolean state = false;
                int checker = x;
                boolean [] locker = new boolean [checker];
		int []student = new int [checker];

                for (int i = 0; i < checker ; i++)
                {
                        student[i] = i + 1;
                        locker[i] = state;
		System.out.println("Locker " + student[i] + " is " + locker[i]);
                }
    }
}
