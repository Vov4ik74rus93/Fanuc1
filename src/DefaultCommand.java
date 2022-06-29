public class DefaultCommand {

    static final String INDENT = ";\n";
    static final String WASTE = "G0Z2." + INDENT;
    static final String EMULSION_ON = "M08" + INDENT;
    static final String EMULSION_OFF = "M09" + INDENT;
    static final String RETURN_TO_REFERENCE_POINT = "G28U0.W0.M05" + INDENT;
    static final String OPTIONAL_PAUSE = "M01" + INDENT;
    static final String LINEAR_INTERPOLATION = "G01";
    static final String IDLING = "G00";
    static final String START_ROTATE_CLOCKWISE = "M03" + INDENT;
    static final String START_ROTATE_COUNTERCLOCKWISE = "M04" + INDENT;
    static final String CONSTSPEED = "G97S";
    static final String MAXSPEED = "G50S";
    static final String CUTTINGSPEED = "G96S";
    static final String SET_WORK_AT_FIRST = "G54";

    private static int numberOfTool = 0;

    // нужно будет реализовать закоментированую строчку. Пока пусть висит, дабы не забыть
    static String getToolAndCorrector () {
        //numberOfTool = tool.isInner() ? numberOfTool + 2 : numberOfTool + 1;
        numberOfTool++;
        return String.format("T%1$02d%1$02d" + INDENT, numberOfTool);
    }


    private DefaultCommand() {
    }
}
