package ru.sibdigital.difar.domain.catalog;

import ru.sibdigital.difar.domain.document.DocActualYieldEntity;
import ru.sibdigital.difar.domain.document.DocRoutingEntity;
import ru.sibdigital.difar.domain.tableparts.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "cls_crop", schema = "agrc")
public class ClsCropEntity {
    private long idUserCreator;
    private String name;
    private Timestamp dateCreate;
    private Boolean isDeleted;
    private String number;
    private String code;
    private long id;
    private Collection<ClsCropVarietyEntity> clsCropVarietiesById;
    private Collection<DocActualYieldEntity> docActualYieldsById;
    private Collection<DocRoutingEntity> docRoutingsById;
    private Collection<TpPlantDiseaseAffectedCropEntity> tpPlantDiseaseAffectedCropsById;
    private Collection<TpPlantDiseaseDiseaseFeatureEntity> tpPlantDiseaseDiseaseFeaturesById;
    private Collection<TpPlantDiseasePeriodEntity> tpPlantDiseasePeriodsById;
    private Collection<TpPlantDiseasePlantOrganEntity> tpPlantDiseasePlantOrgansById;
    private Collection<TpPlantDiseaseTypicalAreaEntity> tpPlantDiseaseTypicalAreasById;
    private Collection<TpPlantPestAffectedCropEntity> tpPlantPestAffectedCropsById;
    private Collection<TpPlantPestPeriodEntity> tpPlantPestPeriodsById;
    private Collection<TpPlantPestPlantOrganEntity> tpPlantPestPlantOrgansById;
    private Collection<TpPlantPestTypicalAreaEntity> tpPlantPestTypicalAreasById;

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
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsCropEntity that = (ClsCropEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        return code != null ? code.equals(that.code) : that.code == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    public Collection<ClsCropVarietyEntity> getClsCropVarietiesById() {
        return clsCropVarietiesById;
    }

    public void setClsCropVarietiesById(Collection<ClsCropVarietyEntity> clsCropVarietiesById) {
        this.clsCropVarietiesById = clsCropVarietiesById;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    public Collection<DocActualYieldEntity> getDocActualYieldsById() {
        return docActualYieldsById;
    }

    public void setDocActualYieldsById(Collection<DocActualYieldEntity> docActualYieldsById) {
        this.docActualYieldsById = docActualYieldsById;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    public Collection<DocRoutingEntity> getDocRoutingsById() {
        return docRoutingsById;
    }

    public void setDocRoutingsById(Collection<DocRoutingEntity> docRoutingsById) {
        this.docRoutingsById = docRoutingsById;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    public Collection<TpPlantDiseaseAffectedCropEntity> getTpPlantDiseaseAffectedCropsById() {
        return tpPlantDiseaseAffectedCropsById;
    }

    public void setTpPlantDiseaseAffectedCropsById(Collection<TpPlantDiseaseAffectedCropEntity> tpPlantDiseaseAffectedCropsById) {
        this.tpPlantDiseaseAffectedCropsById = tpPlantDiseaseAffectedCropsById;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    public Collection<TpPlantDiseaseDiseaseFeatureEntity> getTpPlantDiseaseDiseaseFeaturesById() {
        return tpPlantDiseaseDiseaseFeaturesById;
    }

    public void setTpPlantDiseaseDiseaseFeaturesById(Collection<TpPlantDiseaseDiseaseFeatureEntity> tpPlantDiseaseDiseaseFeaturesById) {
        this.tpPlantDiseaseDiseaseFeaturesById = tpPlantDiseaseDiseaseFeaturesById;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    public Collection<TpPlantDiseasePeriodEntity> getTpPlantDiseasePeriodsById() {
        return tpPlantDiseasePeriodsById;
    }

    public void setTpPlantDiseasePeriodsById(Collection<TpPlantDiseasePeriodEntity> tpPlantDiseasePeriodsById) {
        this.tpPlantDiseasePeriodsById = tpPlantDiseasePeriodsById;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    public Collection<TpPlantDiseasePlantOrganEntity> getTpPlantDiseasePlantOrgansById() {
        return tpPlantDiseasePlantOrgansById;
    }

    public void setTpPlantDiseasePlantOrgansById(Collection<TpPlantDiseasePlantOrganEntity> tpPlantDiseasePlantOrgansById) {
        this.tpPlantDiseasePlantOrgansById = tpPlantDiseasePlantOrgansById;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    public Collection<TpPlantDiseaseTypicalAreaEntity> getTpPlantDiseaseTypicalAreasById() {
        return tpPlantDiseaseTypicalAreasById;
    }

    public void setTpPlantDiseaseTypicalAreasById(Collection<TpPlantDiseaseTypicalAreaEntity> tpPlantDiseaseTypicalAreasById) {
        this.tpPlantDiseaseTypicalAreasById = tpPlantDiseaseTypicalAreasById;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    public Collection<TpPlantPestAffectedCropEntity> getTpPlantPestAffectedCropsById() {
        return tpPlantPestAffectedCropsById;
    }

    public void setTpPlantPestAffectedCropsById(Collection<TpPlantPestAffectedCropEntity> tpPlantPestAffectedCropsById) {
        this.tpPlantPestAffectedCropsById = tpPlantPestAffectedCropsById;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    public Collection<TpPlantPestPeriodEntity> getTpPlantPestPeriodsById() {
        return tpPlantPestPeriodsById;
    }

    public void setTpPlantPestPeriodsById(Collection<TpPlantPestPeriodEntity> tpPlantPestPeriodsById) {
        this.tpPlantPestPeriodsById = tpPlantPestPeriodsById;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    public Collection<TpPlantPestPlantOrganEntity> getTpPlantPestPlantOrgansById() {
        return tpPlantPestPlantOrgansById;
    }

    public void setTpPlantPestPlantOrgansById(Collection<TpPlantPestPlantOrganEntity> tpPlantPestPlantOrgansById) {
        this.tpPlantPestPlantOrgansById = tpPlantPestPlantOrgansById;
    }

    @OneToMany(mappedBy = "clsCropByIdCrop")
    public Collection<TpPlantPestTypicalAreaEntity> getTpPlantPestTypicalAreasById() {
        return tpPlantPestTypicalAreasById;
    }

    public void setTpPlantPestTypicalAreasById(Collection<TpPlantPestTypicalAreaEntity> tpPlantPestTypicalAreasById) {
        this.tpPlantPestTypicalAreasById = tpPlantPestTypicalAreasById;
    }
}
