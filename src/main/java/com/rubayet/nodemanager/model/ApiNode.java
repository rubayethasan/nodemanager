package com.rubayet.nodemanager.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_nodes")
public class ApiNode {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private String overview;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getOverview() {
        return overview;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
