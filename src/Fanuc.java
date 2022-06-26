import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fanuc {
    public static void main(String[] args) {
        List<Integer> coordinates = new ArrayList<>(Arrays.asList(5,0,7,-1,7,-10,15,-10,19,-12,19,-30));
        Block block = new Block(new Tool(NameOfTool.PROHODNOY), new Blank(20,20));
        System.out.println(block.createBlockOfCode(coordinates));
    }
}

