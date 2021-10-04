/**
 * Kristian Hajredinaj ID: 113367328 Recitation 4
 */

public enum LightValue {
    GREEN(2), RED(0), LEFT_SIGNAL(1);

    private int i;
    LightValue(int i) {
        this.i = i;
    }
    public int getI(){
        return i;
    }
}
