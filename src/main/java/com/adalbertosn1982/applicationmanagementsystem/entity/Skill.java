package com.adalbertosn1982.applicationmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
//insert name as a unique field

@Table(name = "skill", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})

public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Skill name is required")
    @Size(min = 2, max = 65, message = "Skill name must be between 2 and 65 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s.+#-]+$", message = "Skill name can only contain letters, numbers, spaces and basic punctuation")
    //@Column(nullable = false)
    @Column(columnDefinition="varchar(65)",nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "skills")
    private Set<Applicant> applicants = new HashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Skill skill = (Skill) o;
        return getId() != null && Objects.equals(getId(), skill.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
