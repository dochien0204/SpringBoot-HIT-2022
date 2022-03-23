package com.example.btvnb5.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "url_link")
public class UrlLink {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String originalLink;

    private String shortedLink;


    @CreationTimestamp
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
