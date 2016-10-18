package county;

public class Monroe extends County {
	public Monroe()	{
		super("Illinois");
		this.borders.add(jefferson);
		this.borders.add(stLouis);
		this.borders.add(stClair);
	}
}
