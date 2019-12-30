package ru.sibdigital.difar.domain.tableparts;

import ru.sibdigital.difar.domain.catalog.ClsCropEntity;
import ru.sibdigital.difar.domain.catalog.ClsPlantDiseaseEntity;
import ru.sibdigital.difar.domain.catalog.ClsPlantOrganEntity;

import javax.persistence.*;

@Entity
@Table(name = "tp_plant_disease_plant_organ", schema = "agrc")
public class TpPlantDiseasePlantOrganEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idCrop;
    private long idPlantDisease;
    private long idPlantOrgan;
    private Object description;
    private ClsCropEntity clsCropByIdCrop;
    private ClsPlantDiseaseEntity clsPlantDiseaseByIdPlantDisease;
    private ClsPlantOrganEntity clsPlantOrganByIdPlantOrgan;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public void setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
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
    @Column(name = "number", nullable = false)
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
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

    @Basic
    @Column(name = "id_plant_disease", nullable = false)
    public long getIdPlantDisease() {
        return idPlantDisease;
    }

    public void setIdPlantDisease(long idPlantDisease) {
        this.idPlantDisease = idPlantDisease;
    }

    @Basic
    @Column(name = "id_plant_organ", nullable = false)
    public long getIdPlantOrgan() {
        return idPlantOrgan;
    }

    public void setIdPlantOrgan(long idPlantOrgan) {
        this.idPlantOrgan = idPlantOrgan;
    }

    @Basic
    @Column(name = "description", nullable = true)
    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpPlantDiseasePlantOrganEntity that = (TpPlantDiseasePlantOrganEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idCrop != that.idCrop) return false;
        if (idPlantDisease != that.idPlantDisease) return false;
        if (idPlantOrgan != that.idPlantOrgan) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idCrop ^ (idCrop >>> 32));
        result = 31 * result + (int) (idPlantDisease ^ (idPlantDisease >>> 32));
        result = 31 * result + (int) (idPlantOrgan ^ (idPlantOrgan >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "id_plant_disease", referencedColumnName = "id", nullable = false)
    public ClsPlantDiseaseEntity getClsPlantDiseaseByIdPlantDisease() {
        return clsPlantDiseaseByIdPlantDisease;
    }

    public void setClsPlantDiseaseByIdPlantDisease(ClsPlantDiseaseEntity clsPlantDiseaseByIdPlantDisease) {
        this.clsPlantDiseaseByIdPlantDisease = clsPlantDiseaseByIdPlantDisease;
    }

    @ManyToOne
    @JoinColumn(name = "id_plant_organ", referencedColumnName = "id", nullable = false)
    public ClsPlantOrganEntity getClsPlantOrganByIdPlantOrgan() {
        return clsPlantOrganByIdPlantOrgan;
    }

    public void setClsPlantOrganByIdPlantOrgan(ClsPlantOrganEntity clsPlantOrganByIdPlantOrgan) {
        this.clsPlantOrganByIdPlantOrgan = clsPlantOrganByIdPlantOrgan;
    }
}
