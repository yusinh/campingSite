package com.soloProject.campingSite.camping;

import com.soloProject.campingSite.local.Local;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Camping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String CampingName;

    private String address;

    private Integer Amount;

    private Integer Personnel;

    @ManyToOne(fetch = FetchType.LAZY)
    private Local local;
}