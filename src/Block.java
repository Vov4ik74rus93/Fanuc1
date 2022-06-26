import java.util.List;

public class Block {
    private final Tool tool;
    Blank blank;

    public Block(Tool tool, Blank blank) {
        this.tool = tool;
        this.blank = blank;
    }

    public String createBlockOfCode(List<Integer> coordinates) {
        StringBuilder sb = new StringBuilder(tool.getName() + ";\n");
        String format = String.format("G97 S%d M03;\nM8;\nG0 G54 X%d. Z2.;\n",
                tool.getG97(), blank.getD()+2);
        sb.append(format);
        for (int i = 0; i < coordinates.size(); i = i + 2) {
            format = String.format("G1 X%d. Z%d.;\n", coordinates.get(i), coordinates.get(i + 1));
            sb.append(format);
        }
        return sb.toString();
    }

}


