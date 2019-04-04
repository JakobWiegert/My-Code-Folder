package ads.set7.labyrinth;

/**
 * A location consists of an x-coordinate and a y-coordinate. A location is
 * immutable.
 */
public class Location {

	/** The x-coordinate of the location */
	private final int x;
	/** The y-coordinate of the location */
	private final int y;

	/**
	 * Creates a new {@code Location} with the given x- and y-coordinate.
	 */
	public Location(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter for the x-coordinate of the location.
	 */
	public int x() {
		return x;
	}

	/**
	 * Getter for the y-coordinate of the location.
	 */
	public int y() {
		return y;
	}

	/**
	 * Two locations are considered equal if the x- and y-coordinates are the same.
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Location 
				&& this.x == ((Location) obj).x 
				&& this.y == ((Location) obj).y;
	}

	@Override
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}
	
	public static void main(String[] arg) {

		boolean[][] lab = new boolean[4][5];

		lab[0][0] = false;
		lab[0][1] = false;
		lab[0][2] = false;
		lab[0][3]=false;
		lab[1][0] = false;
		lab[1][1] = false;
		lab[1][2] = true;
		lab[1][3]=false;
		lab[2][0] = false;
		lab[2][1] = true;
		lab[2][2] = true;
		lab[2][3]=false;
		lab[3][0]=false;
		lab[3][1]=false;
		lab[3][2]=false;
		lab[3][3]=false;
		lab[0][4]=false;
		lab[1][4]=true;
		lab[2][4]=true;
		lab[3][4]=true;
		
		boolean[][] dab = new boolean[3][4];
		dab[0][0]=false;
		dab[0][1]=false;
		dab[0][2]=false;
		dab[0][3]=false;
		dab[1][0]=false;
		dab[1][1]=true;
		dab[1][2]=false;
		dab[1][3]=true;
		dab[2][0]=false;
		dab[2][1]=false;
		dab[2][2]=false;
		dab[2][3]=true;
		
		boolean[][] server= new boolean[5][5];
		server[0][0]=true;
		server[0][1]=true;
		server[0][2]=true;
		server[0][3]=true;
		server[0][4]=true;
		server[1][0]=false;
		server[1][1]=false;
		server[1][2]=true;
		server[1][3]=false;
		server[1][4]=true;
		server[2][0]=true;
		server[2][1]=false;
		server[2][2]=true;
		server[2][3]=false;
		server[2][4]=true;
		server[3][0]=true	;
		server[3][1]=false;
		server[3][2]=false;
		server[3][3]=false;
		server[3][4]=false;
		server[4][0]=true;
		server[4][1]=true;
		server[4][2]=true;
		server[4][3]=true;
		server[4][4]=true;
		
		boolean[][] test= {{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, },
				{true, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, },
				{true, true, true, false, true, true, true, true, true, false, true, false, true, true, true, false, true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, false, true, false, true, true, true, false, true, },
				{true, false, false, false, false, false, false, false, true, false, true, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, true, false, false, false, true, false, false, },
				{true, false, true, true, true, false, true, true, true, false, true, true, true, false, true, false, true, false, true, true, true, false, true, true, true, false, true, true, true, false, true, true, true, false, true, true, true, false, true, true, true, },
				{true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, false, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, false, false, false, true, },
				{true, true, true, false, true, false, true, false, true, true, true, false, true, true, true, false, true, false, true, false, true, true, true, false, true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, false, true, },
				{true, false, false, false, true, false, true, false, true, false, false, false, false, false, true, false, true, false, true, false, true, false, true, false, false, false, true, false, true, false, true, false, false, false, false, false, false, false, false, false, true, },
				{true, false, true, true, true, true, true, false, true, false, true, true, true, false, true, true, true, true, true, false, true, false, true, true, true, false, true, true, true, false, true, false, true, false, true, true, true, true, true, false, true, },
				{false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, false, false, false, true, false, true, false, false, false, false, false, true, },
				{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, },
				}  ;

		//findPath(test, new Location(0, 9), new Location(41, 9));

		
		
	}
}
