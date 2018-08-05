package com.terry.gakkisimle.im.entity.po;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "parent_id")
    private Long pId;
    private String name;

    @Override
    public String toString() {
        return "Tree{" +
                "id='" + id + '\'' +
                ", pId='" + pId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}