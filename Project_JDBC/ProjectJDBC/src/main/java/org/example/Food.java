package org.example;

public class Food {
    private int id;
    private String name;
    private String type;
    private boolean exotic;

    public Food() {

    }

    public Food(int id, String name, String type, boolean exotic) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.exotic = exotic;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isExotic() {
        return exotic;
    }

    public void setExotic(boolean exotic) {
        this.exotic = exotic;
    }

    @Override
    public String toString() {
        return  id +
                " " + name  +
                " " + type  +
                " " + exotic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
