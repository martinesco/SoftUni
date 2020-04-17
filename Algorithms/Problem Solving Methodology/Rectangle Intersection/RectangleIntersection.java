import java.util.*;

public class RectangleIntersection {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Rectangle> rectangles = new ArrayList<>();
        List<Integer> x = new ArrayList<>();
        long result = 0;

        while (n-- > 0) {

            int[] coordinates = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            x.add(coordinates[0]);
            x.add(coordinates[1]);

            rectangles.add(new Rectangle(
                    coordinates[0],
                    coordinates[1],
                    coordinates[2],
                    coordinates[3]));
        }
        Collections.sort(x);

        List<Rectangle>[] rect = new ArrayList[x.size()];   //da nema -1 che filipkirkorov
        for (int i = 0; i < x.size(); i++) {
            rect[i] = new ArrayList<>();
        }

        for (Rectangle rectangle : rectangles) {

            for (int i = 0; i < rect.length; i++) {
                if (rectangle.getMaxX() > x.get(i) && rectangle.getMinX() < x.get(i + 1)) {

                    rect[i].add(rectangle);
                }
            }
        }

        for (int i = 0; i < rect.length; i++) {
            if (rect[i].size() < 2) {
                continue;
            }

            List<Integer> y = new ArrayList<>();

            for (Rectangle rectangle : rect[i]) {
                y.add(rectangle.getMinY());
                y.add(rectangle.getMaxY());
            }

            Collections.sort(y);
            int[] overlapped = new int[y.size() - 1];
            for (Rectangle rectangle : rect[i]) {
                for (int j = 0; j < y.size(); j++) {
                    if (rectangle.getMaxY() <= y.get(j) || rectangle.getMinY() >= y.get(j + 1)) {
                        continue;
                    }
                    overlapped[j]++;
                }
            }
            for (int j = 0; j < overlapped.length; j++) {
                if (overlapped[j] >= 2) {
                    int xSide = x.get(i + 1) - x.get(i);
                    int ySide = y.get(j + 1) - y.get(j);
                    result += xSide * ySide;
                }
            }
        }
        System.out.println(result);

    }
}
