package com.asherflo.testing.domain;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

public class Roles {
    private Long id;
    private String name;
    private  String username;
    @ManyToMany(fetch = EAGER)
    private Collection<Roles> roles = new ArrayList<>(); 

}
