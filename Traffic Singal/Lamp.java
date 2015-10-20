/**
 * Each lamp controls a direction of the road, so there are totally 12 lamps.
 * s2n,n2s
 * s2w,n2e
 * e2w,w2e
 * e2s,w2n
 * s2e,n2w(Always Green)
 * e2n,w2s(Always Green)
 * @see java.lang.Enum above JDK 1.5
 */

public enum Lamp {
    S2N(false,"N2S","S2W"),S2W(false,"N2E","E2W"),E2W(false,"W2E","E2S"),E2S(false,"W2N","S2N"),
    N2S(false,null,null),N2E(false,null,null),W2E(false,null,null),W2N(false,null,null),
    S2E(true,null,null),E2N(true,null,null),N2W(true,null,null),W2S(true,null,null);
 
    //Only consider Green and Red
    private boolean status;
    //The Opposite lamp which change at the same time
    private String opposite;
    //The next lamp which is different to the current lamp
    private String next;
 
    private Lamp(boolean status,String opposite,String next){...}
    public boolean getStatus(){ return status;}

    //Change the opposite lamp at the same time
    public void toGreen(){
        this.status = true;
        if(opposite != null){
            Lamp.valueOf(opposite).toGreen();
        }
 
    }
    public void toRed(){...}

    //Return the next lamp
    public Lamp next(){
        if(next != null){
            return Lamp.valueOf(next);
        }
        return null;
    }
}