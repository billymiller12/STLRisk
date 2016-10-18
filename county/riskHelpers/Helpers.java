package riskHelpers;

import county.County;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Helpers {
	//random integer generator(0to100)
	public static int randomInt()	{
		int b=(int)Math.random()*100;
		return b;
	}
	//random dice roller
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


	//Rotate a Country array randomly for shuffler
	private static County[] rotate(County[] b)	{
		County[] bHelper=new County[b.length];
		double t=Math.random();
		if	(t<.4)	{
			for	(int j=0;j<randomInt();j++)	{
				for (int i=0;i<b.length;i++)	{
					if (i<b.length-1)	{
						bHelper[i]=b[i+1];
					}	else	{
						bHelper[i]=b[0];
					}
				}
				for (int i=0;i<b.length;i++)	{
					b[i]=bHelper[i];
				}
			}
		}	else	{
			for	(int j=0;j<randomInt();j++)	{
				for (int i=0;i<b.length;i++)	{
					if (i==0)	{
						bHelper[i]=b[b.length-1];
					}	else	{
						bHelper[i]=b[i-1];
					}
				}
				for (int i=0;i<b.length;i++)	{
					b[i]=bHelper[i];
				}
			}
		}


		return b;
	}

	//zip 2 Country Arrays together

	private static County[] combine(County[] a, County[] b)	{
		int a2=0;int b2=0;
		County[] combinedArray=new County[a.length+b.length];
		for (int i=0;i<(a.length+b.length);++i)	{
			if	(i%2==0)	{
				combinedArray[i]=a[a2];
				a2++;
			}	else	{
				combinedArray[i]=b[b2];
				b2++;
			}
		}
		return combinedArray;
	}
	//Country array shuffler
	public static County[] shuffle(County[] deck)	{
		//cut the deck in half
		//shuffle tools

		County[] a=new County[deck.length/4];County[] b=new County[deck.length/4];
		County[] c=new County[deck.length/4];County[] d=new County[deck.length/4];
		County[] e=new County[deck.length/2];County[] f=new County[deck.length/2];
		County[] shuffledArray=new County[deck.length];
		int w=randomInt();int x=randomInt();
		for (int i=0;i<deck.length;i++)	{
			shuffledArray[i]=deck[i];
		}
		//complete the shuffle operation w times	
		for	(int h=0;h<w;h++)	{
			//cut the deck:make 4 arrays, each with 1/4 of the cards
			int a1=0;int b1=0;int c1=0;int d1=0;
			for (int i=0;i<shuffledArray.length;++i)	{			
				if	(i<shuffledArray.length*.25)	{
					a[a1]=shuffledArray[i];
					a1++;
				}	else	
					if	(i<shuffledArray.length*.5)	{
						b[b1]=shuffledArray[i];
						b1++;
					}	else
						if	(i<shuffledArray.length*.75)	{
							c[c1]=shuffledArray[i];
							c1++;
						}	else
						{
							d[d1]=shuffledArray[i];
							d1++;
						}	
			}

			//rotate quarter decks
			a=rotate(a);b=rotate(b);c=rotate(c);d=rotate(d);
			//randomly zip the 4 quarter decks into 2 half decks.
			if (x<33)	{
				e=combine(a,b);f=combine(c,d);
			}	else
				if	(x<66)	{
					e=combine(a,c);f=combine(b,d);	
				}	else	
				{
					e=combine(a,d);f=combine(b,c);
				}
			//rotate half decks
			e=rotate(e);f=rotate(f);
			shuffledArray=combine(e,f);
		}
		return shuffledArray;
	}


	public static void main(String[] args)	{
	
		//County[] a=new County[2];County[] b=new County[2];
		int a=0;int b=0;int c=0;int d=0;int e=0;int f=0;
		
		
	for (int i=0;i<100000000;i++)	{
		int roll=diceRoll();
		if (roll==1)	{
			a++;
		}
		if (roll==2)	{
			b++;
		}
		if (roll==3)	{
			c++;
		}
		if (roll==4)	{
			d++;
		}
		if (roll==5)	{
			e++;
		}
		if (roll==6)	{
			f++;
		}
		
		
	}
		System.out.println("the number 1 was rolled "+a+" times.");
		System.out.println("the number 2 was rolled "+b+" times.");
		System.out.println("the number 3 was rolled "+c+" times.");
		System.out.println("the number 4 was rolled "+d+" times.");
		System.out.println("the number 5 was rolled "+e+" times.");
		System.out.println("the number 6 was rolled "+f+" times.");
		
	
	     
	    

	}
}
