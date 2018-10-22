package com.fs.countrylibrary;


/**
 * Created by wangjian on 2016/5/3.
 */
public class UsStatesBean {

    private int id;

    @Override
    public String toString() {
        return "UsStatesBean{" +
                "id=" + id +
                ", states_code='" + states_code + '\'' +
                ", states='" + states + '\'' +
                ", readioButtonChecked=" + readioButtonChecked +
                ", checkType=" + checkType +
                '}';
    }

    private String states_code;

    private String states;

    private boolean readioButtonChecked;

    private boolean checkType;

    public boolean isCheckType() {
        return checkType;
    }

    public void setCheckType(boolean checkType) {
        this.checkType = checkType;
    }

    public boolean isReadioButtonChecked() {
        return readioButtonChecked;
    }

    public void setReadioButtonChecked(boolean readioButtonChecked) {
        this.readioButtonChecked = readioButtonChecked;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStates_code() {
        return states_code;
    }

    public void setStates_code(String states_code) {
        this.states_code = states_code;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }


}