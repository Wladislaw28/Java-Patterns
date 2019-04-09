package javapatterns;


import java.util.*;


class KeyGeneration
{
  private int[] key = new int[10];
  private int[] k1 = new int[8];
  private int[] k2 = new int[8];
  private boolean flag = false;
  
  KeyGeneration()
  {
    
  }
  
  void GenerateKeys(String inputkey )
  {
    int[] key = new int[10];

	
	char c1;
	String ts ;
	
	try
	{
	for(int i=0;i<10;i++)
    {
       c1 = inputkey.charAt(i);
       ts = Character.toString(c1);
       key[i] = Integer.parseInt(ts);
	   
	   if(key[i] !=0 && key[i]!=1)
	   {
		Print.msg("\n .. Invalid Key ..");
		System.exit(0);
		return ;
	   }
    }
	}
	catch(Exception e)
	{
		Print.msg("\n .. Invalid Key .. ");
		System.exit(0);
		return ;
		
	}
    this.key = key;
    
	  Print.msg("Input Key : ");
      Print.array(this.key,10);
      Print.msg("\n");
    
      permutationP10();
    
      Print.msg("After P10 Key : ");
      Print.array(this.key,10);
      Print.msg("\n");
    
      leftshiftLS1();
    
      Print.msg("After LS-1 Key : ");
      Print.array(this.key,10);
      Print.msg("\n");
    
    
      this.k1 = permutationP8();

     Print.msg("Subkey K1: ");
     Print.array(this.k1,8);
     Print.msg("\n");
    
      leftshiftLS2();
  
     Print.msg("After LS-2 Key : ");
     Print.array(this.key,10);
	 Print.msg("\n");
    
     this.k2 = permutationP8();
     Print.msg("Subkey K2: ");
     Print.array(this.k2,8);
     Print.msg("\n"); 
    
    flag = true;

}
  
   
  private void permutationP10()
  {
    int[] temp = new int[10];
    
    temp[0] = key[2];
    temp[1] = key[4];
    temp[2] = key[1];
    temp[3] = key[6];
    temp[4] = key[3];
    temp[5] = key[9];
    temp[6] = key[0];
    temp[7] = key[8];
    temp[8] = key[7];
    temp[9] = key[5];
    
    
    key = temp;
        
  }
  

  private void leftshiftLS1()
  {
    int[] temp = new int[10];
    
    temp[0] = key[1];
    temp[1] = key[2];
    temp[2] = key[3];
    temp[3] = key[4];
    temp[4] = key[0];
    
    temp[5] = key[6];
    temp[6] = key[7];
    temp[7] = key[8];
    temp[8] = key[9];
    temp[9] = key[5];
    
    key = temp;
    
  }
  
  private int[] permutationP8()
  {
    int[] temp = new int[8];
    
    temp[0] = key[5];
    temp[1] = key[2];
    temp[2] = key[6];
    temp[3] = key[3];
    temp[4] = key[7];
    temp[5] = key[4];
    temp[6] = key[9];
    temp[7] = key[8];
    
    return temp;
        
  }
  
  
  private void leftshiftLS2()
  {
    int[] temp = new int[10];
    
    temp[0] = key[2];
    temp[1] = key[3];
    temp[2] = key[4];
    temp[3] = key[0];
    temp[4] = key[1];
    
    temp[5] = key[7];
    temp[6] = key[8];
    temp[7] = key[9];
    temp[8] = key[5];
    temp[9] = key[6];
    
    key = temp;
    
  }


public int[] getK1()
{
  if(!flag)
    {
      Print.msg("\nError Occured: Keys are not generated yet ");
      return null;
    }
    return k1;
}

public int[] getK2()
{
  if(!flag)
    {
      Print.msg("\nError Occured: Keys are not generated yet ");
      return null;
    }
    return k2;
}  

}


class Encryption
{
  private int[] K1 = new int[8];
  private int[] K2 = new int[8];
  private int[] pt = new int[8];
  
  void SaveParameters(String plaintext , int[] k1, int[] k2)
  {
	int[] pt = new int[8];
	

		
	char c1;
	String ts ;
	
	try
	{
	for(int i=0;i<8;i++)
    {
       c1 = plaintext.charAt(i);
       ts = Character.toString(c1);
       pt[i] = Integer.parseInt(ts);
	   
	   if(pt[i] !=0 && pt[i]!=1)
	   {
		Print.msg("\n .. Invalid symbol ..");
		System.exit(0);
		return ;
	   }
    }
	}
	catch(Exception e)
	{
		Print.msg("\n .. Invalid symbol .. ");
		System.exit(0);
		return ;
		
	}
	
    this.pt = pt;
    
     Print.msg("Symbol array : ");
     Print.array(this.pt,8);
	 Print.msg("\n");
	
    this.K1 = k1;
    this.K2 = k2;
    
 
  }
  
 
  void InitialPermutation()
  {
    int[] temp = new int[8];
    
    temp[0] = pt[1];
    temp[1] = pt[5];
    temp[2] = pt[2];
    temp[3] = pt[0];
    temp[4] = pt[3];
    temp[5] = pt[7];
    temp[6] = pt[4];
    temp[7] = pt[6];
    
    pt = temp;
	
	 Print.msg("IP: ");
     Print.array(this.pt,8);
	 Print.msg("\n");
	
  } 
  void InverseInitialPermutation()
  {
    int[] temp = new int[8];
    
    temp[0] = pt[3];
    temp[1] = pt[0];
    temp[2] = pt[2];
    temp[3] = pt[4];
    temp[4] = pt[6];
    temp[5] = pt[1];
    temp[6] = pt[7];
    temp[7] = pt[5];
    
    pt = temp;
	
	
  }
  
  /** mappingF . arguments 4-bit right-half of plaintext & 8-bit subkey **/ 
  int[] mappingF(int[] R, int[] SK)
  {
    int[] temp = new int[8];
    
    // EXPANSION/PERMUTATION [4 1 2 3 2 3 4 1] 
    temp[0]  = R[3];
    temp[1]  = R[0];
    temp[2]  = R[1];
    temp[3]  = R[2];
    temp[4]  = R[1];
    temp[5]  = R[2];
    temp[6]  = R[3];
    temp[7]  = R[0];
    
	 Print.msg("E/P: ");
     Print.array(temp,8);
	 Print.msg("\n");
	 
    // Bit by bit XOR with sub-key
    temp[0] = temp[0] ^ SK[0];
    temp[1] = temp[1] ^ SK[1];
    temp[2] = temp[2] ^ SK[2];
    temp[3] = temp[3] ^ SK[3];
    temp[4] = temp[4] ^ SK[4];
    temp[5] = temp[5] ^ SK[5];
    temp[6] = temp[6] ^ SK[6];
    temp[7] = temp[7] ^ SK[7];
    
	 Print.msg("XOR With Key : ");
     Print.array(temp,8);
	 Print.msg("\n");
	 
    
//    final int[][] S0 = { {1,0,3,2} , {3,2,1,0} , {0,2,1,3} , {3,1,3,2} } ;
//    final int[][] S1 = { {0,1,2,3},  {2,0,1,3}, {3,0,1,0}, {2,1,0,3}} ;

    final int[][] S0 = { {1,0,3,2} , {3,2,1,0} , {0,2,1,3} , {3,1,3,1} } ;
    final int[][] S1 = { {1,1,2,3},  {2,0,1,3}, {3,0,1,0}, {2,1,0,3}} ;
    
   
      int d11 = temp[0]; 
      int d14 = temp[3]; 
      
	  int row1 = BinaryOp.BinToDec(d11,d14); 
      
	  
      int d12 = temp[1]; 
      int d13 = temp[2];     
      int col1 = BinaryOp.BinToDec(d12,d13); 
      
	  
      int o1 = S0[row1][col1]; 
	      
	  int[] out1 = BinaryOp.DecToBinArr(o1);
	 
	 Print.msg("SL: ");
     Print.array(out1,2);
 	 Print.msg("\n");

	 int d21 = temp[4]; // first bit of second half
      int d24 = temp[7]; // fourth bit of second half
      int row2 = BinaryOp.BinToDec(d21,d24);
	  
	  int d22 = temp[5]; 
	  int d23 = temp[6]; 
	  int col2 = BinaryOp.BinToDec(d22,d23);
	  
	  int o2 = S1[row2][col2];
	  	 
	  int[] out2 = BinaryOp.DecToBinArr(o2); 

	 Print.msg("SR: ");
     Print.array(out2,2);
	 Print.msg("\n");
		

	  int[] out = new int[4];
	  out[0] = out1[0];
      out[1] = out1[1];
	  out[2] = out2[0];
	  out[3] = out2[1];
	  
	  
	  int [] O_Per = new int[4];
	  O_Per[0] = out[1];
	  O_Per[1] = out[3];
	  O_Per[2] = out[2];
      O_Per[3] = out[0];
	  
     Print.msg("P4: ");
     Print.array(O_Per,4);
	 Print.msg("\n");  
	 
	 return O_Per;
  }
  
  int[] functionFk(int[] L, int[] R,int[] SK)
  {	
	int[] temp = new int[4];
	int[] out = new int[8];
	
	
	temp = mappingF(R,SK);
	

	out[0] = L[0] ^ temp[0];
	out[1] = L[1] ^ temp[1];
	out[2] = L[2] ^ temp[2];
	out[3] = L[3] ^ temp[3];
	
	out[4] = R[0];
	out[5] = R[1];
	out[6] = R[2];
	out[7] = R[3];
	
	
	return out;
	
	
  }
  

  int[] switchSW(int[] in)
  {
	
	int[] temp = new int[8];
	
	temp[0] = in[4];
	temp[1] = in[5];
	temp[2] = in[6];
	temp[3] = in[7];
  
    temp[4] = in[0];
	temp[5] = in[1];
	temp[6] = in[2];
	temp[7] = in[3];	
	
	return temp;
  }

  int[] encrypt(String plaintext , int[] LK, int[] RK)
  {
	
		
	SaveParameters(plaintext,LK,RK);
	
	Print.msg("\n---------------------------------------\n");
	InitialPermutation();
	Print.msg("\n---------------------------------------\n");

	int[] LH = new int[4];
	int[] RH = new int[4];
	LH[0] = pt[0];
	LH[1] = pt[1];
	LH[2] = pt[2];
	LH[3] = pt[3];
	

	RH[0] = pt[4];
	RH[1] = pt[5];
	RH[2] = pt[6];
	RH[3] = pt[7];
	
	
	 Print.msg("First Round L : ");
     Print.array(LH,4);
	 Print.msg("\n");
	 
	 Print.msg("First Round R: ");
     Print.array(RH,4);
	 Print.msg("\n");
	 

	int[] r1 = new int[8];
	r1 = functionFk(LH,RH,K1);
	
	 Print.msg("After First Round : ");
     Print.array(r1,8);
	 Print.msg("\n");
	Print.msg("\n---------------------------------------\n");

	int[] temp = new int[8];
	temp = switchSW(r1);
	
	 Print.msg("After SW : ");
     Print.array(temp,8);
	 Print.msg("\n");
	 Print.msg("\n---------------------------------------\n");

	LH[0] = temp[0];
	LH[1] = temp[1];
	LH[2] = temp[2];
	LH[3] = temp[3];
	
	RH[0] = temp[4];
	RH[1] = temp[5];
	RH[2] = temp[6];
	RH[3] = temp[7];

	
	 Print.msg("Second Round L : ");
     Print.array(LH,4);
	 Print.msg("\n");
	 
	 Print.msg("Second Round R: ");
     Print.array(RH,4);
	 Print.msg("\n");
	 

	int[] r2 = new int[8];
	r2 = functionFk(LH,RH,K2);
	
	pt = r2;
	
	 Print.msg("After Second Round : ");
     Print.array(this.pt,8);
	 Print.msg("\n");
	 Print.msg("\n---------------------------------------\n");
	 
	InverseInitialPermutation();
	
	 Print.msg("After IP-1(Result) : ");
     Print.array(this.pt,8);
	 Print.msg("\n");
	 

	return pt;
	
	
	
	
  }
 
}


public class Decorator
{
  public static void main(String[] args)
  {
    
    KeyGeneration KG = new KeyGeneration();
    Encryption enc  = new Encryption();
    Scanner sc = new Scanner(System.in);
    
	String pt ;
	String key;
	int[] ct = new int[8];
    
    try
    {


	System.out.print("Enter 8-bit symbol: ");
	pt = sc.next();
	
		
    System.out.print("Enter 10-bit Key : ");
    key = sc.next();

	Print.msg("---------------------------------------\n");
	KG.GenerateKeys(key);
	Print.msg("\n---------------------------------------\n");
	ct = enc.encrypt( pt ,KG.getK1(),KG.getK2());
	
	Print.msg("\n---------------------------------------\n");
	System.out.println(" \n Decryption  ");
	

	System.out.print("Enter 8-bit cipher : ");
	pt = sc.next();
	
		
    System.out.print("Enter 10-bit Key : ");
    key = sc.next();
    
	

	KG.GenerateKeys(key);
	Print.msg("---------------------------------------\n");
	
	ct = enc.encrypt( pt ,KG.getK2(),KG.getK1());
	
	Print.msg("\n---------------------------------------\n");
	
	
	  
	
	
    }
    catch(InputMismatchException e)
    {
      System.out.println("-- Error Occured : Invalid Input ");
    }
    catch(Exception e)
    {
      System.out.println("-- Error Occured : "+e);
    }
    
  }
  
}


class Print
{

  static void array(int[] arr,int len)
  {

   
    for(int i=0;i<len;i++)
    {
      System.out.print(arr[i] + "");
    }
  }
  
  static void msg(String msg)
  {
    System.out.print(msg);
  }
}

class BinaryOp
{

  static int BinToDec(int...bits)
  {
  
         
     int temp=0;
     int base = 1;
     for(int i=bits.length-1 ; i>=0;i--)
     {
        temp = temp + (bits[i]*base);
        base = base * 2 ;
     }
      
      return temp;
  }
  

  static int[] DecToBinArr(int no)
  {
    // 13 1
    // 6  0
    // 3  1
    // 1  1
    // 0  
    
	
	if(no==0)
	{
		int[] zero = new int[2];
		zero[0] = 0;
		zero[1] = 0;
		return zero;	
	}
    int[] temp = new int[10] ;
	
    
	int count = 0 ;
    for(int i= 0 ; no!= 0 ; i++)
    {
      temp[i] = no % 2;
      no = no/2;
	  count++;
    }
    
	
	int[] temp2 = new int[count];
	
	
	for(int i=count-1, j=0;i>=0 && j<count;i--,j++)
	{
		temp2[j] = temp[i];
	}
	

    if(count<2)
	{
		temp = new int[2];
		temp[0] = 0;
		temp[1] = temp2[0];
		return temp;
	}
	 
	return temp2;
  }
}


