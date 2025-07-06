package com.adalbertosn1982.applicationmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.jdbc.NVarcharJdbcType;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //varchar

    @Column(columnDefinition="varchar(60)", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "skills")
    private Set<Applicant> applicants = new HashSet<>();
}
