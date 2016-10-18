package county;

public class StLouis extends County {
		
	public StLouis()	{
		super("Missouri");
		this.borders.add(stClair);
		this.borders.add(stCharles);
		this.borders.add(franklin);
		this.borders.add(jefferson);
		this.borders.add(monroe);
		this.borders.add(madison);
	}
}
