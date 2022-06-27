import java.util.List;

public class Block {
    private final Tool tool;
    private final Blank blank;
    private int numberOfTool = 0;
    private final String END_OF_BLOCK = "G0Z2.;\nM9;\nG28U0.W0.M05;\nM01;\n";

    public Block(Tool tool, Blank blank) {
        this.tool = tool;
        this.blank = blank;
    }

    public String createBlockOfCode(List<Coordinate> coordinates) {
        StringBuilder sb = new StringBuilder(tool.getName() + ";\n");
        numberOfTool = tool.isInner() ? numberOfTool + 2 : numberOfTool + 1;
        sb.append(String.format("T%1$02d%1$02d;\n", numberOfTool));
        sb.append(String.format("G97 S%d M03;\nM8;\nG0 G54 X%d. Z2.;\n",
                tool.getG97(), blank.getD()+2));
        sb.append(String.format("G50 S%d;\nG96 S%d;\n",
                tool.getG50(), tool.getG96()));
        for (int i = 0; i < coordinates.size(); i++) {
            sb.append(String.format("G1 X%d. Z%d.;\n", coordinates.get(i).getX(), coordinates.get(i).getY()));
        }
        sb.append(END_OF_BLOCK);
        return sb.toString();
    }

}


