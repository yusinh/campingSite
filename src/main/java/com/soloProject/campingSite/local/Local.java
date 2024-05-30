package com.soloProject.campingSite.local;

import com.soloProject.campingSite.camping.Camping;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String localName;

    @OneToMany(mappedBy = "local", cascade = CascadeType.REMOVE)
    private List<Camping> campingList = new ArrayList<>();

    public Local() {}

    public Local(String localName) {
        this.localName = localName;
    }
}
