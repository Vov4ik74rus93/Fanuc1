import java.util.ArrayList;

public class Fanuc {
    public static void main(String[] args) {
        Block block = new Block(new Tool(NameOfTool.PROHODNOY), new ArrayList<>(), new Blank(20,20));
        System.out.println(block.createBlockOfCode());
    }
}

