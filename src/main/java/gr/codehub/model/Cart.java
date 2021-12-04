package gr.codehub.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cart extends Entity{

    private LocalDateTime dateTime;
    private Customer customer;
    private List<Product> products = new ArrayList();
    private Employee helpingEmployee;

    @Override
    public String forTextFile() {
        return getId() + ","
                + getDateTime();
    }


}
