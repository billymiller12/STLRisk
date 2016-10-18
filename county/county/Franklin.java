package county;

public class Franklin extends County {
	public Franklin()	{
		super("Missouri");
		this.borders.add(stCharles);
		this.borders.add(warren);
		this.borders.add(stLouis);
		this.borders.add(jefferson);
	}
}
