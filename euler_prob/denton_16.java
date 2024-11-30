
 import java.math.BigInteger;

 public final class denton_16  {
     
     public static void main(String[] args) {
         System.out.println(new denton_16().run());
     }
     //ez pz gg gamer get gud (i was cunfuzed)
     public String run() {
         String temp = BigInteger.ONE.shiftLeft(1000).toString();
         int sum = 0;
         for (int i = 0; i < temp.length(); i++)
             sum += temp.charAt(i) - '0';
         return Integer.toString(sum);
     }
     
 }
 