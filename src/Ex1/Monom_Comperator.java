package Ex1;

import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {

	/* default ctor */
	public Monom_Comperator()
	{}

	public int compare(Monom o1, Monom o2) {
		int dp = o2.get_power() - o1.get_power();
		/*if power is equal in both */
		if(dp == 0)
		{
			dp = (int) (o2.get_coefficient() - o1.get_coefficient());
		}
		return dp;
	}
}
