package id.ac.ui.cs.advprog.bookubehistory.model;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.sql.Date;
import java.util.UUID;
//Tidak ada entity karena landing page tidak perlu menyimpan ke db
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//Book yang didefinisikan di kelas ini hanya terdiri dari atribut yang dibutuhkan pada landing page seperti UUID, judul, dan foto buku
public class Book {

    //    @Id
//    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    //    @Column(nullable = false)
    private String title;

    //    @Column(nullable = false)
//    @Check(constraints = "download_count >= 0")
    private int price;

    //    @Column(nullable = false)
    private String photoUrl;

    public Book(String title, int price, String photoUrl, UUID id) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.photoUrl = photoUrl;
    }
}