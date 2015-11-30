
public class Problem10 {
	//10. Grayscale image histogram

	//int[] histogram(short[][] image)

	//A histogram is a representation of distribution of some data.

	//Here you receive a grayscale image matrix (image). Each of the matrix's values will be between 0 and 255. Return an array result, which is a histogram of image => the value of result[i] should be the ammount of times i is in the matrix image. 

	public static int[] histogram(short[][] image) {
		int height = image.length;
		int width = image[0].length;
		int[] result = new int[256];

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				result[image[i][j]]++;

			}
		}
		return result;
	}

	public static void main(String[] args) {

		short[][] image_test = { { 1, 1, 2 }, { 2, 2, 2 }, { 1, 2, 1 } };
		int[] result = histogram(image_test);
		for (int i = 0; i < result.length; i++) {
			System.out.println(i + ":" + result[i]);
		}
	}
}
