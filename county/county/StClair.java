package county;


public class StClair extends County{
		
		public StClair()	{
			super("Illinois");
			this.borders.add(stLouis);
			this.borders.add(madison);
			this.borders.add(clinton);
			this.borders.add(washington);
			this.borders.add(monroe);
		}
}
