import java.util.ArrayList;

public class Block {
    private Tool tool;
    private ArrayList<Integer> coordinates;
    Blank blank;

    public Block(Tool tool, ArrayList<Integer> coordinates, Blank blank) {
        this.tool = tool;
        this.coordinates = coordinates;
        this.blank = blank;
    }

    public String createBlockOfCode() {
        StringBuilder sb = new StringBuilder(tool.getName() + ";\n");
        String format = String.format("G97 S%d M03;\nM8;\nG0 G54 X%d. Z2.;\n", tool.getG97(), blank.getD()+2);
        sb.append(format);
        return sb.toString();
    }

}


