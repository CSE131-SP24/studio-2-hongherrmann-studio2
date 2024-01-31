package studio2;

public class Ruin {

	public static void main(String[] args) {
		double startAmount = 2;
		double winChance = .7;
		double winLimit = 10;
		double losses = 0;
		int simulationTimes = 1;
		double expectedRuin = (((1-startAmount)/startAmount) - (1-winLimit)/winLimit) / (1 - ((1-winLimit)/winLimit));
		while(simulationTimes <= 500)
		{
			simulationTimes++;
			int money = (int) startAmount;
			int playTimes = 0;
			while (0 < money && money < winLimit)
			{
				playTimes ++;
				double play = Math.random();
				if (play <= winChance) 
				{
					money ++;
				}
				else 
				{
					money --;
				}
			}
			if (money <= 0) 
			{
				losses ++;
				System.out.print("LOSE! ");
			}
			else 
			{
				System.out.print("WIN!  ");
			}
		System.out.println("Simulation: " + simulationTimes + " Plays: " + playTimes);
		}
		System.out.println(" ");
		System.out.println("Ruin Rate from Simulation: " + Math.round((losses/simulationTimes)*100)/100.0);
		System.out.println("Expected ruin rate: " + expectedRuin);
	}

}	
