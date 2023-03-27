package kodlama.io.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import kodlama.io.ecommerce.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "products_manager")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    private double UnitPrice;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    //Parent tablosunu Product olarak seçtim. Join tablosu sadece parentta tanımlanır. İki yerde de tanımlanmaz.
    @JsonManagedReference //Sonsuz döngüyü engeller. Parent kısmına yazılır.
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "category_id"), //Set<Category> yaptığımız için Category ile ilişki kurulmalı.
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Category> categories = new HashSet<>(); //Set veri tekrarını engeller.
    //HashSet<>() e eşilemesek de oto bunu kullanır.
    //Set küme olduğu için küme elemanlarının birebir tekrarını önler.
    //Lazy ve Eager farkı: Lazy yazınca sadece Product tablosuna sorgu atar. Bütün tablolara atmaz. Performansı artırır.

}
