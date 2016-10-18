package county;

public class Clinton extends County {
	public Clinton()	{
		super("Illinois");
		this.borders.add(washington);
		this.borders.add(stClair);
		this.borders.add(madison);
		this.borders.add(bond);
	}
}
