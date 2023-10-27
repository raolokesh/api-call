package com.lokesh.apiservice;

public class Model {


    public int VEHICLE_CLASS_ID;
    public String VEHICLE_CLASS_NAME;
    public int TOLL_RATE;
    public int GUI_VISIBLE;

    public int OVERLOAD_FEE;
    public int PLAZA_ID;

    public Model( int VEHICLE_CLASS_ID, String VEHICLE_CLASS_NAME, int TOLL_RATE, int GUI_VISIBLE, int OVERLOAD_FEE,int PLAZA_ID) {
        this.PLAZA_ID = PLAZA_ID;
        this.VEHICLE_CLASS_ID = VEHICLE_CLASS_ID;
        this.VEHICLE_CLASS_NAME = VEHICLE_CLASS_NAME;
        this.TOLL_RATE = TOLL_RATE;
        this.GUI_VISIBLE = GUI_VISIBLE;
        this.OVERLOAD_FEE = OVERLOAD_FEE;
    }

    public int getPLAZA_ID() {
        return PLAZA_ID;
    }

    public void setPLAZA_ID(int PLAZA_ID) {
        this.PLAZA_ID = PLAZA_ID;
    }

    public int getVEHICLE_CLASS_ID() {
        return VEHICLE_CLASS_ID;
    }

    public void setVEHICLE_CLASS_ID(int VEHICLE_CLASS_ID) {
        this.VEHICLE_CLASS_ID = VEHICLE_CLASS_ID;
    }

    public String getVEHICLE_CLASS_NAME() {
        return VEHICLE_CLASS_NAME;
    }

    public void setVEHICLE_CLASS_NAME(String VEHICLE_CLASS_NAME) {
        this.VEHICLE_CLASS_NAME = VEHICLE_CLASS_NAME;
    }

    public int getTOLL_RATE() {
        return TOLL_RATE;
    }

    public void setTOLL_RATE(int TOLL_RATE) {
        this.TOLL_RATE = TOLL_RATE;
    }

    public int getGUI_VISIBLE() {
        return GUI_VISIBLE;
    }

    public void setGUI_VISIBLE(int GUI_VISIBLE) {
        this.GUI_VISIBLE = GUI_VISIBLE;
    }

    public int getOVERLOAD_FEE() {
        return OVERLOAD_FEE;
    }

    public void setOVERLOAD_FEE(int OVERLOAD_FEE) {
        this.OVERLOAD_FEE = OVERLOAD_FEE;
    }
}
