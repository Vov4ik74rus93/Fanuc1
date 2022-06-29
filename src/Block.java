import java.util.List;

public class Block {
    private final Tool tool;
    private final Blank blank;
    private static final String END_OF_BLOCK = DefaultCommand.WASTE + DefaultCommand.EMULSION_OFF +
            DefaultCommand.RETURN_TO_REFERENCE_POINT + DefaultCommand.OPTIONAL_PAUSE;

    public Block(Tool tool, Blank blank) {
        this.tool = tool;
        this.blank = blank;
    }
    // Здесь будет генерироваться строка в зависимости от инструмента и станка
    String setStartOfBlock(Tool tool) {
        return tool.getName() + DefaultCommand.INDENT +
                DefaultCommand.getToolAndCorrector() +
        DefaultCommand.MAXSPEED + tool.getMaxSpeed() + DefaultCommand.START_ROTATE_CLOCKWISE +
        DefaultCommand.IDLING + DefaultCommand.SET_WORK_AT_FIRST + "X" + (blank.getD() + 2)
                + "Z2." + DefaultCommand.INDENT +
        DefaultCommand.MAXSPEED + tool.getMaxSpeed() + DefaultCommand.INDENT +
        DefaultCommand.CUTTINGSPEED + tool.getCuttingSpeed() + DefaultCommand.INDENT;
    }

    String createBlockOfCode(List<Coordinate> coordinates) {
        StringBuilder sb = new StringBuilder(setStartOfBlock(tool));
        sb.append(DefaultCommand.LINEAR_INTERPOLATION + "X" +
                coordinates.get(0).getX()+DefaultCommand.INDENT);
        sb.append("Z" + coordinates.get(0).getZ()+DefaultCommand.INDENT);
        for (int i = 1; i < coordinates.size(); i++) {
            Coordinate current = coordinates.get(i);
            Coordinate prev = coordinates.get(i - 1);
            sb.append(((current.getX() != prev.getX()) ? "X" + current.getX() : ""));
            sb.append(((current.getZ() != prev.getZ()) ? "Z" + current.getZ() : ""));
            sb.append(DefaultCommand.INDENT);
        }
        sb.append(END_OF_BLOCK);
        return sb.toString();
    }

}


