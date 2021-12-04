package gr.codehub.model;


import lombok.Data;

@Data
public abstract class Entity {

    private int id;

    public abstract String forTextFile();
}
