import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalibrationSolution_PARTONE {
  public static void main(String[] args) {
    // String text = """
    // 1abc2
    // pqr3stu8vwx
    // a1b2c3d4e5f
    // treb7uchet
    // """;

    try (BufferedReader br = new BufferedReader(new FileReader("CalibrationCoordinates.txt"))) {
      int total = 0;
      String line;
      while ((line = br.readLine()) != null) {
        if (!line.isEmpty()) { // Check if the line is not empty
          int firstD = -1;
          int lastD = -1;
          for (String s : line.split("")) {
            if (Character.isDigit(s.charAt(0))) {
              if (firstD == -1) {
                firstD = Integer.parseInt(s);
              }
              lastD = Integer.parseInt(s);
            }
          }
          firstD *= 10;
          total += firstD + lastD;
        }
      }
      System.out.println("Total: " + total);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
