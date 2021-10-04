/**
 * Kristian Hajredinaj
 * 113367328
 * Recitation 4
 */


public enum CargoStrength {
    FRAGILE('F'), MODERATE('M'), STURDY('S');

    private char value;

    /**
     *
     * @param value
     * constructor to set characters for the strength
     */
    private CargoStrength(char value) {
        this.value = value;
    }

    public char getValue(){
        return value;
    }
}
