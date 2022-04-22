package threeDimensionalArrays;
import java.util.Arrays;

public class Movie {

	public static void main(String[] args) {
		/* 1440 frames in a one minute video
		 * 1080 pixels for height
		 * 1920 pixels for width
		 * 3 RGB values
		 */
		//int [][][][] movie = new int [1440][1080][1920][3];
		
		int [][][][] smallerMovie = new int [2][5][7][3];
		
		int rValue;
		int gValue;
		int bValue;
		
		for (int frames = 0; frames < smallerMovie.length; frames++) {
			for (int height = 0; height < smallerMovie[frames].length; height++) {
				for (int width = 0; width < smallerMovie[frames][height].length; width++) {
					
					rValue = (int) (Math.random() * 255);
					gValue = (int) (Math.random() * 255);
					bValue = (int) (Math.random() * 255);
					
					smallerMovie[frames][height][width] = new int [] {rValue, gValue, bValue};
				}
			}
		}
		
		for (int frames = 0; frames < smallerMovie.length; frames++) {
			for (int height = 0; height < smallerMovie[frames].length; height++) {
				for (int width = 0; width < smallerMovie[frames][height].length; width++) {
					
					System.out.print(Arrays.toString(smallerMovie[frames][height][width]) + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
