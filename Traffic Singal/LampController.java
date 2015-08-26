public class LampController {
    private Lamp currentLamp;
    private static LampController lc = new LampController();
 
    //LampController is a Singleton, it only returns the instance
    private LampController(){this.currentLamp = Lamp.S2N;}

    public static LampController getInstance(){return lc;}
 
    //simulation the whole process
    //turn currentLamp to Green, wait seconds, turn to red and move to next
    public void start(){...}
}