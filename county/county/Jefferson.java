package county;

public class Jefferson extends County {
	public Jefferson()	{
		super("Missouri");
		this.borders.add(franklin);
		this.borders.add(stLouis);
		this.borders.add(monroe);	
	}
}
