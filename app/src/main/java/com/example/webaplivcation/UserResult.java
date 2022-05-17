package com.example.webaplivcation;

public class UserResult {

    private String name;
    private String result;
    private int flagResource;

    public UserResult(String name, String result, int flag) {

        this.name = name;
        this.result = result;
        this.flagResource = flag;
    }



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getFlagResource() {
        return this.flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }
}
