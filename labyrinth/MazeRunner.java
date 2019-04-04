package ads.set7.labyrinth;

import java.util.*;

/**
 * A Algorithmen that finds a path through a Labyrinth
 * 
 * @author Jakob Wiegert
 *
 */
public class MazeRunner {

	static Location[] alreadyVisited;
	static boolean[][] labyrinth;
	static int labyrinthLength;
	static int counter;
	static int counterTwo;
	static Location end;
	static int labyrinthLegthTwo;
	static ArrayList<Location> finalPath = new ArrayList<Location>();
	
	//Funktionsweise:
	//die methode findPath initialisiert zunächst alle Variablen, da der Testserver die Test alle in der selben Klasse startet, können diese nicht direkt in der Klasse initialisiert werden.
	//nun ruft findpath nur noch pathing und startet damit den Backtracking Algorithmus
	//pathing bekommt nun die Location übergeben zu der sich der Algorithmus als nächstes "Bewegen" soll, zurück gibt er ein true wenn es von dieser Location einen weg zum Ziel gibt, false wenn nicht
	//als erstes wird nun überprüft ob dieser Schritt überhaupt gültig ist, also es noch innerhalb des Labyrinths ist, er nicht in eine Wand läuft und er noch nicht dieses Feld betreten hat(da man nicht 2mal über dasselbe Feld darf)
	//wenn die Location nun betretbar ist ruft der Algorithmus per if bedingung die Methode in jede richtung (up,down,left,right) auf
	//wenn nun einer dieser Rekursionen ein true returned und damit zum Ziel führt, returned der "Vater" auch ein true an seinen "vater" usw. bis wir zum start zurück kommen(the magic of Recursion :) )
	//wenn mehrere ein true returnen würden spielt aber nur der erste (in der reinfolge in Algorithmus(left,right,up,down)) eine rolle und wird damit zum zielweg, da wir nie zu den anderen wegen kommen
	//sollten allerdings alle wege fehlschlagen wird die Location aus dem Path gelöscht(nicht aber aus dem "bereitsBesucht" array , da wir ja nicht nochmal hier hin wollen) und die Methode returned false , so das der Vater einen anderen Weg auspropiert(Backtracking!)
	//sollten alle Wege von allen möglichen Locations ein false zurück geben erhält auch irgendwann der Start ein false zurück
	//Damit ist dann das Ende des Algortihmus erreicht wenn das Backtracking nun ein true für den Start zurück gibt, existiert ein weg von Start zu Ziel , und wird von findPath returned, sollte er false zurück geben gibt es keinen Weg vom Start zum Ziel sodass findPath false returned

	/**
	 * Finds a path through the given labyrinth from the start position to the end
	 * position using a backtracking algorithm.
	 * 
	 * @param labyrinth
	 *            a two-dimensional array containing information about the walls of
	 *            the labyrinth. {@code labyrinth[row][column]} is {@code true} if
	 *            there is a wall at that position.
	 * @param start
	 *            the {@code Location} of the starting position
	 * @param end
	 *            the {@code Location} of the end position
	 * @return a list of {@code Location}s to get from the start position to the end
	 *         position, or {@code null} if no path exists. Should start with the
	 *         start location and end with the end location.
	 */
	public static Location[] findPath(boolean[][] labyrinth, Location start, Location end) {

		MazeRunner.labyrinth = labyrinth;
		MazeRunner.labyrinthLength = labyrinth.length;
		MazeRunner.end = new Location(end.y(), end.x()); // test from testserver is row>>col y>>x, my Algorithmen is row>>col x>>y
		MazeRunner.labyrinthLegthTwo = labyrinth[0].length;
		MazeRunner.alreadyVisited = new Location[labyrinthLength * labyrinthLegthTwo];
		MazeRunner.counter = 0;
		MazeRunner.counterTwo = 0;
		MazeRunner.finalPath.clear();

		/*
		 * DEBUG System.out.print(labyrinthLength); System.out.println();
		 * System.out.print(labyrinthLegthTwo); System.out.println();
		 */

		if (!pathing(new Location(start.y(), start.x()))) {

			System.out.print("No possible Path found");
			return null;

		} else {
			Location[] realFinalPath = new Location[finalPath.size()];
			for (int i = 0; i < finalPath.size(); i++) {
				realFinalPath[i] = finalPath.get(i);
			}
			System.out.print("returned possible Path");
			return realFinalPath;
		}
	}

	/**
	 * this method is the backtrackingpart, which solves the Labyrinth,
	 * 
	 * @param currentLocation
	 *            the current Position in the Labyrinth
	 * @return true if a path from here is possible, false if not
	 */
	private static boolean pathing(Location currentLocation) {

		if (!checkCurrent(currentLocation)) {
			return false;
		}

		/*
		 * DEBUG for (int j = 0; j < finalPath.size(); j++) {
		 * 
		 * if(finalPath.get(j)!=null) { System.out.print(finalPath.get(j).toString()); }
		 * } System.out.println();
		 * 
		 * for (int j = 0; j < alreadyVisited.length; j++) {
		 * 
		 * if(alreadyVisited[j]!=null) { System.out.print(alreadyVisited[j].toString());
		 * } } System.out.println();
		 */

		Location toAdd = new Location(currentLocation.y(), currentLocation.x());
		finalPath.add(toAdd);
		counter++;

		alreadyVisited[counterTwo] = new Location(currentLocation.x(), currentLocation.y());
		counterTwo++;

		// already at end
		if (currentLocation.equals(end)) {
			return true;

			// left
		} else if (pathing(new Location(currentLocation.x(), currentLocation.y() - 1))) {

			return true;

			// right
		} else if (pathing(new Location(currentLocation.x(), currentLocation.y() + 1))) {

			return true;

			// up
		} else if (pathing(new Location(currentLocation.x() - 1, currentLocation.y()))) {

			return true;

			// down
		} else if (pathing(new Location(currentLocation.x() + 1, currentLocation.y()))) {

			return true;

			// else
		} else {

			counter--;
			finalPath.remove(counter);

			return false;
		}

	}

	/**
	 * this method checks if the current location is usable for the path.
	 * 
	 * @param currentLocation
	 *            the current Location in the Labyrinth
	 * @return true if it could be a part of a possible path, false if it cannot be
	 *         entered(wall,not in the Labyrinth, already used)
	 */
	private static boolean checkCurrent(Location currentLocation) {

		if (currentLocation.y() >= 0 
				&& currentLocation.x() >= 0
				&& currentLocation.x() < labyrinthLength
				&& currentLocation.y() < labyrinthLegthTwo
				&& labyrinth[currentLocation.x()][currentLocation.y()] == false) {

			// no overlap
			for (int i = 0; i < alreadyVisited.length; i++) {
				if (currentLocation.equals(alreadyVisited[i])) {
					return false;
				}
			}

			return true;
		}
		return false;
	}

}
