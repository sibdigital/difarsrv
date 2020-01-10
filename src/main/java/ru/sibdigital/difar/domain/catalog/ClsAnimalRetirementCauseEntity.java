package ru.sibdigital.difar.domain.catalog;

import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.tableparts.TpAnimalRetirementAnimalEntity;
import ru.sibdigital.difar.domain.tableparts.TpAnimalRetirementAnimalGroupEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_animal_retirement_cause", schema = "breed")
public class ClsAnimalRetirementCauseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private String code;
    private long id;
    private long idParent;
//    private String parentPath;
    private Collection<TpAnimalRetirementAnimalEntity> tpAnimalRetirementAnimalsById;
    private Collection<TpAnimalRetirementAnimalGroupEntity> tpAnimalRetirementAnimalGroupsById;

    @Basic
    @Column(name = "id_user_creator", nullable = false, insertable = false, updatable = false)
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

    @Basic
    @Column(name = "code", nullable = false, length = 64)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "id_parent", nullable = false, insertable = false, updatable = false)
    public long getIdParent() {
        return idParent;
    }

    public void setIdParent(long idParent) {
        this.idParent = idParent;
    }

//    @Column(columnDefinition = "ltree", name = "parent_path", nullable = true)
//    public String getParentPath() {
//        return parentPath;
//    }
//
//    public void setParentPath(String parentPath) {
//        this.parentPath = parentPath;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        ClsAnimalRetirementCauseEntity that = (ClsAnimalRetirementCauseEntity) o;
//
//        if (idUserCreator != that.idUserCreator) return false;
//        if (id != that.id) return false;
//        if (idParent != that.idParent) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
//        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
//        if (number != null ? !number.equals(that.number) : that.number != null) return false;
//        if (code != null ? !code.equals(that.code) : that.code != null) return false;
//        return parentPath != null ? parentPath.equals(that.parentPath) : that.parentPath == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
//        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
//        result = 31 * result + (number != null ? number.hashCode() : 0);
//        result = 31 * result + (code != null ? code.hashCode() : 0);
//        result = 31 * result + (int) (id ^ (id >>> 32));
//        result = 31 * result + (int) (idParent ^ (idParent >>> 32));
//        result = 31 * result + (parentPath != null ? parentPath.hashCode() : 0);
//        return result;
//    }

    @OneToMany(mappedBy = "clsAnimalRetirementCauseByIdAnimalRetirementCause")
    public Collection<TpAnimalRetirementAnimalEntity> getTpAnimalRetirementAnimalsById() {
        return tpAnimalRetirementAnimalsById;
    }

    public void setTpAnimalRetirementAnimalsById(Collection<TpAnimalRetirementAnimalEntity> tpAnimalRetirementAnimalsById) {
        this.tpAnimalRetirementAnimalsById = tpAnimalRetirementAnimalsById;
    }

    @OneToMany(mappedBy = "clsAnimalRetirementCauseByIdAnimalRetirementCause")
    public Collection<TpAnimalRetirementAnimalGroupEntity> getTpAnimalRetirementAnimalGroupsById() {
        return tpAnimalRetirementAnimalGroupsById;
    }

    public void setTpAnimalRetirementAnimalGroupsById(Collection<TpAnimalRetirementAnimalGroupEntity> tpAnimalRetirementAnimalGroupsById) {
        this.tpAnimalRetirementAnimalGroupsById = tpAnimalRetirementAnimalGroupsById;
    }
}
