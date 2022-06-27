import java.util.ArrayList;
import java.util.List;

public class Fanuc {
    public static void main(String[] args) {
        // Координаты будут вычисляться приходить из GUI в зависимости от выбранных действий
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(5,0));
        coordinates.add(new Coordinate(7,-1));
        coordinates.add(new Coordinate(7,-10));
        coordinates.add(new Coordinate(15,-10));
        coordinates.add(new Coordinate(17,-11));
        coordinates.add(new Coordinate(17,-25));
        Block block = new Block(new Tool(NameOfTool.PROHODNOY), new Blank(20,20));
        System.out.println(block.createBlockOfCode(coordinates));
    }
}

