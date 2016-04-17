package com.example.martin.duportablebatteries;


public class Battery {

    private String id;
    private String percent;
    private String state;
    private String posX;
    private String posY;
    private String time;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The percent
     */
    public String getPercent() {
        return percent;
    }

    /**
     *
     * @param percent
     * The percent
     */
    public void setPercent(String percent) {
        this.percent = percent;
    }

    /**
     *
     * @return
     * The state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     * The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     * The gps
     */
    public String getPosX() {
        return posX;
    }

    /**
     *
     * @param posX
     * The gps
     */
    public void setPosX(String gps) {this.posX = gps;}
    /**
     *
     * @return
     * The gps
     */
    public String getPosY() {
        return posY;
    }

    /**
     *
     * @param posY
     * The gps
     */
    public void setPosY(String gps) {this.posY = gps;}

    /**
     *
     * @return
     * The time
     */
    public String getTime() {
        return time;
    }

    /**
     *
     * @param time
     * The time
     */
    public void setTime(String time) {
        this.time = time;
    }

}