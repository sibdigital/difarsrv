package ru.sibdigital.difar.domain.catalog;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "cls_crop_variety", schema = "agrc")
public class ClsCropVarietyEntity {
    private long idUserCreator;
    private String name;
    private Timestamp dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idCrop;
    private ClsCropEntity clsCropByIdCrop;

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

    @Basic
    @Column(name = "date_create", nullable = true)
    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
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
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_crop", nullable = false)
    public long getIdCrop() {
        return idCrop;
    }

    public void setIdCrop(long idCrop) {
        this.idCrop = idCrop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsCropVarietyEntity that = (ClsCropVarietyEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idCrop != that.idCrop) return false;
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
        result = 31 * result + (int) (idCrop ^ (idCrop >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_crop", referencedColumnName = "id", nullable = false)
    public ClsCropEntity getClsCropByIdCrop() {
        return clsCropByIdCrop;
    }

    public void setClsCropByIdCrop(ClsCropEntity clsCropByIdCrop) {
        this.clsCropByIdCrop = clsCropByIdCrop;
    }
}
