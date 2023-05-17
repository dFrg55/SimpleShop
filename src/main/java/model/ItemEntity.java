package model;

import jakarta.persistence.*;
import jakarta.ws.rs.FormParam;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity implements Serializable {

    @Id
    @FormParam("id")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    public ItemEntity(String nameItem, Integer price) {
        this.name = nameItem;
        this.price = price;
    }

    @FormParam("name")
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @FormParam("price")
    @Column(name = "price")
    @Getter
    @Setter
    private Integer price;

    @FormParam("description")
    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

}