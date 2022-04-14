package com.example.btvnb6.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    private String name;

    @Nationalized
    private String type;

    private String slug;

    @Nationalized
    private String nameWithType;

    @Nationalized
    private String path;

    @Nationalized
    private String pathWithType;

    private Long code;

    private Long parentCode;
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

}
