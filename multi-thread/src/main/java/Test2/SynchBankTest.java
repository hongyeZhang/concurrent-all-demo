package Test2;

/**
 * This program shows how multiple threads can safely access a data structure.
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 */
public class SynchBankTest
{
   public static final int NACCOUNTS = 10;
   public static final double INITIAL_BALANCE = 1000;

   public static void main(String[] args)
   {
      Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
      for (int i = 0; i < NACCOUNTS; i++)
      {
         TransferRunnable r = new TransferRunnable(b, i, 2*INITIAL_BALANCE);
         Thread t = new Thread(r);
         t.start();
      }
   }
}
