import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class InputData {
    final int MATRIX_SIZE = 5;
    String filename;
    float[][] data;

    public InputData(String filename) {
        this.filename = filename;
        data = new float[MATRIX_SIZE][MATRIX_SIZE];
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            for (int i = 0; i < 5; i++) {
                String[] s = br.readLine().split(" ");
                System.out.println(Arrays.toString(s));
                for (int j = 0; j < 5; j++) {
                    data[i][j] = Float.valueOf(s[j]);

                }
            }
            br.close();
        } catch (IOException e){ //Ловим вместе с FileNotFoundException
            System.out.println("I/O Exception or File not found");
            System.exit(26);

        } catch (NullPointerException e) {
            System.out.println("Arrays size Exception");
            System.exit(25);
        }  catch (NumberFormatException e){
            System.out.println("Invalid data input (not a number)");
            System.exit(23);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Arrays size Exception");
            System.exit(24);
        }

    }

    public String calculateAndGenerate() {
        StringBuilder sb = new StringBuilder("Input File: " + filename + "\n=================================\n");
        float alpha, betta, delta;
        alpha = betta = delta = 0.0f;
        for (int i = 0; i < MATRIX_SIZE; i++) {
            alpha += data[0][i] * data[i][0];
        }
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                betta += data[i][j];
            }
        }
        delta = betta / alpha;
        sb.append("Calculation results:\n=================================\n");
        sb.append(String.format("alpha: %2f\nbetta: %2f\ndelta: %2f\n", alpha, betta, delta));
        sb.append("=================================\nReport generated by DocGenerator");
        return sb.toString();
    }
}
