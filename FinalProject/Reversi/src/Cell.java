
public class Cell {
	

	
	private Chip place = Chip.EMPTY;
	
	public Cell()
	{
		Chip place = Chip.EMPTY;
	}
	public Cell(Chip C)
	{
		this.place = C;  
	}

	public String toString()
	{
		return place.toString();
	}
}


