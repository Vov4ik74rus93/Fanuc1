public class Tool {
    // Все режимы усредненные без учета ньюансов обработки, металла, зажима и прочего
    private final NameOfTool name;
    private double takeoff;
    private int constSpeed;
    private int maxSpeed;
    private int cuttingSpeed;
    private double supply;
    private boolean isInner;

    public Tool(NameOfTool name) {
        this.name = name;
        switch (name) {
            case PROHODNOY:
                setParameters(2, 500, 1800, 200, 0.2, false);
                break;
            case KONTURNIY:
                setParameters(2, 500, 2000, 220, 0.16, false);
                break;
            case REZBOVOY:
                setParameters(0.1, 600, 0, 0, 2., false);
                break;
        }
    }

    private void setParameters(double takeoff, int constTurn, int maxSpeed,
                               int cuttingSpeed, double supply, boolean isInner) {
        this.takeoff = takeoff;
        this.constSpeed = constTurn;
        this.maxSpeed = maxSpeed;
        this.cuttingSpeed = cuttingSpeed;
        this.supply = supply;
        this.isInner = isInner;
    }


    public double getTakeoff() {
        return takeoff;
    }

    public int getConstSpeed() {
        return constSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getCuttingSpeed() {
        return cuttingSpeed;
    }

    public double getSupply() {
        return supply;
    }

    public String getName() {
        return name.name();
    }

    public boolean isInner() {
        return isInner;
    }

}


enum NameOfTool {
    // Здесь будет перечисление всех использующихся видов резцов
    PROHODNOY,
    KONTURNIY,
    REZBOVOY
}
