


import java.util.Arrays;
import java.util.Scanner;


public class RiskAttackSimulator {
	//This is a program to simulate an all-or-none invasion in the Risk board game.
	//the invasions are calculated until either the attacker has no remaining armies to attack with
	//or the defending armies have been completely eliminated.
	//The return will provide the number of wins over a given number of simulations
	//and the average number of armies the winning force has left after the battles are decided.

	//helper methods:

	//randomly roll a die
	public static int diceRoll()	{
		int roll;
		double rando=Math.random();
		if (rando<=1/6.0)		{
			roll=1;
		}	else
			if(rando<=2/6.0)	{
				roll=2;
			}else
				if(rando<=3/6.0)	{
					roll=3;
				}else
					if(rando<=4/6.0)	{
						roll=4;
					}else
						if(rando<=5/6.0)	{
							roll=5;
						}else
						{
							roll=6;
						}
		return roll;
	}
	//players' turn thrower
	private static int[]	playerTurn(int a)	{
		int[] rolls = new int[a];
		for (int i=0;i<rolls.length;i++)	{		
			rolls[i]=diceRoll();					
		}		
		Arrays.sort(rolls);
		return rolls;
	}


	//the battle simulator:
	private static String battle(int offense, int defense, int numSims)	{
		//tools
		int armies;
		int o = offense-1, d = defense;
		String result, winner;
		int attackerWon=0, defenderWon=0, defenderTally=0, attackerTally=0;
		//make sure there are enough armies to fight;
		if (offense <=1)	{
			result="Offense can not attack without at least 2 armies";
		}	else	if(defense<= 1)	{
			result="defense must have at least one army";	
		}	else	{
			//all initial conditions are ok to begin			
			for	(int i=0;i<numSims; i++)	{
				o = offense-1;			d = defense;
				while (o>0&&d>0)	{
					//determine the number of dice each player will roll
					int a,c;
					if	(o>=3)	{
						a=3;
					}	else {
						a=o;
					}
					if	(d>=2)	{
						c=2;
					}	else {
						c=d;
					}
					//both players roll their dice
					int[]	aRolls= playerTurn(a);
					int[]	dRolls=	playerTurn(c);				
					//determine the winner and adjust accordingly
					if (o>=3)	{//attacker has 3 or more armies that are mobile
						if	(d>=2)	{
							if (aRolls[1]>dRolls[0])	{
								d--;
							}	else	{
								o--;
							}
							if (aRolls[2]>dRolls[1])	{
								d--;
							}	else	{
								o--;
							}
						}	else	{
							if (aRolls[2]>dRolls[0])	{
								d--;
							}	else	{
								o--;
							}
						}
					}	else	if(o==2)	{//attacker has 2 mobile armies
						if	(d>=2)	{
							if (aRolls[1]>dRolls[1])	{
								d--;
							}	else	{
								o--;
							}
							if (aRolls[0]>dRolls[0])	{
								d--;
							}	else	{
								o--;
							}
						}	else	{
							if (aRolls[1]>dRolls[0])	{
								d--;
							}	else	{
								o--;
							}
						}
					}	else	{	//attacker has 1 mobile army here
						if	(d>=2)	{
							if (aRolls[0]>dRolls[1])	{
								d--;
							}	else	{
								o--;
							}
						}	else	{
							if (aRolls[0]>dRolls[0])	{
								d--;
							}	else	{
								o--;
							}
						}
					}
				}
				if	(o==0)	{
					defenderWon++;
					defenderTally+=d;
				}	else	{
					attackerWon++;
					attackerTally+=o;
				}
			}
			int winTimes;
			if	(defenderWon>attackerWon)	{
				winner = "defending force";
				winTimes = defenderWon; 
				armies=defenderTally/numSims;
			}	else	{
				winner = "attacking force";
				winTimes = attackerWon;
				armies=attackerTally/numSims;
			}
			if	(defenderWon==attackerWon)	{
				result="tie";
			}	else	{
				result="The " + winner + " won "+ winTimes + " out of " + numSims + " simulations. This player had an average of " + armies + " armies remaining.";
			}
		}
		return result;
	}

	public static void main(String[] args)	{
		Scanner in=new Scanner(System.in);
		System.out.println("How many armies does the attacker have?");
		int offense= in.nextInt();
		System.out.println("How many armies does the defender have?");
		int defense=in.nextInt();
		System.out.println("How many simulations shall I run for you human?");
		int numSims=in.nextInt();

		System.out.println(battle(offense, defense, numSims));
		in.close();


	}
}


