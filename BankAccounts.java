import java.util.*;
import java.util.ArrayList;

public class BankAccounts 
{
	
	static String feeOrUpfront(int n, int k, int x, int d, int[] p) 
	{
        // Complete this function
		String upFront = "upfront";
		String fee = "fee";
		List<Float> transactionFeeArray = new ArrayList<Float>();

		BankAccounts solution = new BankAccounts();	
		
		for (int j = 0; j < p.length; j++) 
		{
			transactionFeeArray.add(solution.simpleValueCalculator(k, x, p[j]));
		}
		
		float addedTransactionFee = solution.addAllValuesInList(transactionFeeArray);
		
		if (addedTransactionFee == d) 
		{
			return fee;
		}
		else if (addedTransactionFee > d) 
		{
			return upFront;
		}
		else
		{
			return fee;
		}
		
    }

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt(); //Number of scenarios to handle
        for(int a0 = 0; a0 < q; a0++)
        {
            int n = in.nextInt(); //Number of payments
            int k = in.nextInt(); //Would charge this if % isnt past this value
            int x = in.nextInt(); //Percent charged per pi
            int d = in.nextInt(); //Upfront payment amount
            int[] p = new int[n];
            for(int p_i = 0; p_i < n; p_i++)
            {
                p[p_i] = in.nextInt(); //a payment amount which can be a certain number
            }
            String result = feeOrUpfront(n, k, x, d, p);
            System.out.println(result);
        }
        in.close();
    }
    
    private float addAllValuesInList(List<Float> arrayList)
    {
    	float addedTransactions = 0.0f;
    	for (Float transactFee : arrayList) 
    	{
    		addedTransactions = addedTransactions + transactFee;
		}
    	return addedTransactions;
    }
    
    private float simpleValueCalculator(int k_preferredValue, int x_percent, int paymentAmount_p)
    {
    	float queryValue = 0;
    	queryValue = paymentAmount_p * ((float) x_percent/100);
    	
    	if(k_preferredValue > queryValue)
    	{
    		return k_preferredValue;
    	}
    	
    	return (float)queryValue;
    }
    

}
