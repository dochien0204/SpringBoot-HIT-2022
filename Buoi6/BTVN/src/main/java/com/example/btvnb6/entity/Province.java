package com.example.btvnb6.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long provinceId;

    @Nationalized
    private String name;

    private String slug;

    @Nationalized
    private String type;

    @Nationalized
    private String nameWithType;

    private Long code;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "province")
    private List<District> districts;
}
