public class Tool {
    // Все режимы усредненные без учета ньюансов обработки, металла, зажима и прочего
    private final NameOfTool name;
    private double u;
    private int g97;
    private int g50;
    private int g96;
    private double f;
    private boolean isInner;

    public Tool(NameOfTool name) {
        this.name = name;
        switch (name) {
            case PROHODNOY -> {
                u = 2;
                g97 = 500;
                g50 = 1800;
                g96 = 180;
                f = 0.2;
                break;
            }
            case KONTURNIY -> {
                u = 1.5;
                g97 = 500;
                g50 = 2000;
                g96 = 220;
                f = 0.16;
                break;
            }
            case REZBOVOY -> {
                u = 2;
                g97 = 500;
                g50 = 1800;
                g96 = 180;
                break;
            }
        }
    }

    public double getU() {
        return u;
    }

    public int getG97() {
        return g97;
    }

    public int getG50() {
        return g50;
    }

    public int getG96() {
        return g96;
    }

    public double getF() {
        return f;
    }
    public String getName() {
        return name.name();
    }

    public boolean isInner() {
        return isInner;
    }

}
