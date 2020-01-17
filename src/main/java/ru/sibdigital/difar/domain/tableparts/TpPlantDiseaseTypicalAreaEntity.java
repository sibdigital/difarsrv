package ru.sibdigital.difar.domain.tableparts;

import ru.sibdigital.difar.domain.classifier.agrc.ClsCropEntity;
import ru.sibdigital.difar.domain.classifier.agrc.ClsPlantDiseaseEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsAreaEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsDistrictEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsRegionEntity;

import javax.persistence.*;

@Entity
@Table(name = "tp_plant_disease_typical_area", schema = "agrc")
public class TpPlantDiseaseTypicalAreaEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idCrop;
    private long idPlantDisease;
    private long idRegion;
    private long idDistrict;
    private long idArea;
    private ClsCropEntity clsCropByIdCrop;
    private ClsPlantDiseaseEntity clsPlantDiseaseByIdPlantDisease;
    private ClsRegionEntity clsRegionByIdRegion;
    private ClsDistrictEntity clsDistrictByIdDistrict;
    private ClsAreaEntity clsAreaByIdArea;

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
    @Column(name = "id_crop", nullable = false, insertable = false, updatable = false)
    public long getIdCrop() {
        return idCrop;
    }

    public void setIdCrop(long idCrop) {
        this.idCrop = idCrop;
    }

    @Basic
    @Column(name = "id_plant_disease", nullable = false, insertable = false, updatable = false)
    public long getIdPlantDisease() {
        return idPlantDisease;
    }

    public void setIdPlantDisease(long idPlantDisease) {
        this.idPlantDisease = idPlantDisease;
    }

    @Basic
    @Column(name = "id_region", nullable = false, insertable = false, updatable = false)
    public long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(long idRegion) {
        this.idRegion = idRegion;
    }

    @Basic
    @Column(name = "id_district", nullable = false, insertable = false, updatable = false)
    public long getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(long idDistrict) {
        this.idDistrict = idDistrict;
    }

    @Basic
    @Column(name = "id_area", nullable = false, insertable = false, updatable = false)
    public long getIdArea() {
        return idArea;
    }

    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpPlantDiseaseTypicalAreaEntity that = (TpPlantDiseaseTypicalAreaEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idCrop != that.idCrop) return false;
        if (idPlantDisease != that.idPlantDisease) return false;
        if (idRegion != that.idRegion) return false;
        if (idDistrict != that.idDistrict) return false;
        if (idArea != that.idArea) return false;
        return isDeleted != null ? isDeleted.equals(that.isDeleted) : that.isDeleted == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idCrop ^ (idCrop >>> 32));
        result = 31 * result + (int) (idPlantDisease ^ (idPlantDisease >>> 32));
        result = 31 * result + (int) (idRegion ^ (idRegion >>> 32));
        result = 31 * result + (int) (idDistrict ^ (idDistrict >>> 32));
        result = 31 * result + (int) (idArea ^ (idArea >>> 32));
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
    @JoinColumn(name = "id_region", referencedColumnName = "id", nullable = false)
    public ClsRegionEntity getClsRegionByIdRegion() {
        return clsRegionByIdRegion;
    }

    public void setClsRegionByIdRegion(ClsRegionEntity clsRegionByIdRegion) {
        this.clsRegionByIdRegion = clsRegionByIdRegion;
    }

    @ManyToOne
    @JoinColumn(name = "id_district", referencedColumnName = "id", nullable = false)
    public ClsDistrictEntity getClsDistrictByIdDistrict() {
        return clsDistrictByIdDistrict;
    }

    public void setClsDistrictByIdDistrict(ClsDistrictEntity clsDistrictByIdDistrict) {
        this.clsDistrictByIdDistrict = clsDistrictByIdDistrict;
    }

    @ManyToOne
    @JoinColumn(name = "id_area", referencedColumnName = "id", nullable = false)
    public ClsAreaEntity getClsAreaByIdArea() {
        return clsAreaByIdArea;
    }

    public void setClsAreaByIdArea(ClsAreaEntity clsAreaByIdArea) {
        this.clsAreaByIdArea = clsAreaByIdArea;
    }
}
