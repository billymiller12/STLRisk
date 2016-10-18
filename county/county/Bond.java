package county;

public class Bond extends County {
	public Bond()	{
		super("Illinois");
		this.borders.add(madison);
		this.borders.add(clinton);
	}
}
