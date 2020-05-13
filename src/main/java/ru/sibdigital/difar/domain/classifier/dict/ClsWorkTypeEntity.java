package ru.sibdigital.difar.domain.classifier.dict;

import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cls_work_type", schema = "dict")
public class ClsWorkTypeEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idParent;
//    private String parentPath;

    public ClsWorkTypeEntity() {
        setDeleted(false);
    }

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsWorkTypeEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsWorkTypeEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsWorkTypeEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsWorkTypeEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsWorkTypeEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_work_type_id_seq", schema = "dict")
    public long getId() {
        return id;
    }

    public ClsWorkTypeEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "id_parent", nullable = false, insertable = false, updatable = false)
    public long getIdParent() {
        return idParent;
    }

    public ClsWorkTypeEntity setIdParent(long idParent) {
        this.idParent = idParent;
        return this;
    }

//    @Column(columnDefinition = "ltree", name = "parent_path", nullable = false)
//    public String getParentPath() {
//        return parentPath;
//    }
//
//    public ClsWorkTypeEntity setParentPath(String parentPath) {
//        this.parentPath = parentPath;
//        return this;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClsWorkTypeEntity that = (ClsWorkTypeEntity) o;
        return idUserCreator == that.idUserCreator &&
                id == that.id &&
                idParent == that.idParent &&
                Objects.equals(name, that.name) &&
                Objects.equals(dateCreate, that.dateCreate) &&
                Objects.equals(isDeleted, that.isDeleted) &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUserCreator, name, dateCreate, isDeleted, number, id, idParent);
    }
}
