package ru.sibdigital.difar.domain.catalog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.register.RegAnimalEntity;
import ru.sibdigital.difar.domain.register.RegExternalAnimalEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_breed", schema = "breed")
public class ClsBreedEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idKindAnimal;
    private ClsKindAnimalEntity clsKindAnimalByIdKindAnimal;
    private Collection<RegAnimalEntity> regAnimalsById;
    private Collection<RegExternalAnimalEntity> regExternalAnimalsById;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public void setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_kind_animal", nullable = false, insertable = false, updatable = false)
    public long getIdKindAnimal() {
        return idKindAnimal;
    }

    public void setIdKindAnimal(long idKindAnimal) {
        this.idKindAnimal = idKindAnimal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsBreedEntity that = (ClsBreedEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idKindAnimal != that.idKindAnimal) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        return number != null ? number.equals(that.number) : that.number == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idKindAnimal ^ (idKindAnimal >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_kind_animal", referencedColumnName = "id", nullable = false)
    public ClsKindAnimalEntity getClsKindAnimalByIdKindAnimal() {
        return clsKindAnimalByIdKindAnimal;
    }

    public void setClsKindAnimalByIdKindAnimal(ClsKindAnimalEntity clsKindAnimalByIdKindAnimal) {
        this.clsKindAnimalByIdKindAnimal = clsKindAnimalByIdKindAnimal;
    }

    @OneToMany(mappedBy = "clsBreedByIdBreed")
    @JsonIgnore
public Collection<RegAnimalEntity> getRegAnimalsById() {
        return regAnimalsById;
    }

    public void setRegAnimalsById(Collection<RegAnimalEntity> regAnimalsById) {
        this.regAnimalsById = regAnimalsById;
    }

    @OneToMany(mappedBy = "clsBreedByIdBreed")
    @JsonIgnore
public Collection<RegExternalAnimalEntity> getRegExternalAnimalsById() {
        return regExternalAnimalsById;
    }

    public void setRegExternalAnimalsById(Collection<RegExternalAnimalEntity> regExternalAnimalsById) {
        this.regExternalAnimalsById = regExternalAnimalsById;
    }
}
