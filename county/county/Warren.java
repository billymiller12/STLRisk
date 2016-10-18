package county;

public class Warren extends County {
	public Warren()	{
		super("Missouri");
		this.borders.add(lincoln);
		this.borders.add(stCharles);
		this.borders.add(franklin);
	}
}
