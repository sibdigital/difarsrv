package ru.sibdigital.difar.domain.catalog;

import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.register.RegAnimalEntity;
import ru.sibdigital.difar.domain.register.RegExternalAnimalEntity;
import ru.sibdigital.difar.domain.register.RegFieldLocalEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantDiseaseTypicalAreaEntity;
import ru.sibdigital.difar.domain.tableparts.TpPlantPestTypicalAreaEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_area", schema = "dict")
public class ClsAreaEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idDistrict;
    private Collection<RegFieldLocalEntity> regFieldLocalsById;
    private Collection<TpPlantDiseaseTypicalAreaEntity> tpPlantDiseaseTypicalAreasById;
    private Collection<TpPlantPestTypicalAreaEntity> tpPlantPestTypicalAreasById;
    private Collection<RegAnimalEntity> regAnimalsById;
    private Collection<RegExternalAnimalEntity> regExternalAnimalsById;
    private ClsDistrictEntity clsDistrictByIdDistrict;

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
    @Column(name = "id_district", nullable = false, insertable = false, updatable = false)
    public long getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(long idDistrict) {
        this.idDistrict = idDistrict;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsAreaEntity that = (ClsAreaEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idDistrict != that.idDistrict) return false;
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
        result = 31 * result + (int) (idDistrict ^ (idDistrict >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "clsAreaByIdArea")
    public Collection<RegFieldLocalEntity> getRegFieldLocalsById() {
        return regFieldLocalsById;
    }

    public void setRegFieldLocalsById(Collection<RegFieldLocalEntity> regFieldLocalsById) {
        this.regFieldLocalsById = regFieldLocalsById;
    }

    @OneToMany(mappedBy = "clsAreaByIdArea")
    public Collection<TpPlantDiseaseTypicalAreaEntity> getTpPlantDiseaseTypicalAreasById() {
        return tpPlantDiseaseTypicalAreasById;
    }

    public void setTpPlantDiseaseTypicalAreasById(Collection<TpPlantDiseaseTypicalAreaEntity> tpPlantDiseaseTypicalAreasById) {
        this.tpPlantDiseaseTypicalAreasById = tpPlantDiseaseTypicalAreasById;
    }

    @OneToMany(mappedBy = "clsAreaByIdArea")
    public Collection<TpPlantPestTypicalAreaEntity> getTpPlantPestTypicalAreasById() {
        return tpPlantPestTypicalAreasById;
    }

    public void setTpPlantPestTypicalAreasById(Collection<TpPlantPestTypicalAreaEntity> tpPlantPestTypicalAreasById) {
        this.tpPlantPestTypicalAreasById = tpPlantPestTypicalAreasById;
    }

    @OneToMany(mappedBy = "clsAreaByIdArea")
    public Collection<RegAnimalEntity> getRegAnimalsById() {
        return regAnimalsById;
    }

    public void setRegAnimalsById(Collection<RegAnimalEntity> regAnimalsById) {
        this.regAnimalsById = regAnimalsById;
    }

    @OneToMany(mappedBy = "clsAreaByIdArea")
    public Collection<RegExternalAnimalEntity> getRegExternalAnimalsById() {
        return regExternalAnimalsById;
    }

    public void setRegExternalAnimalsById(Collection<RegExternalAnimalEntity> regExternalAnimalsById) {
        this.regExternalAnimalsById = regExternalAnimalsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_district", referencedColumnName = "id", nullable = false)
    public ClsDistrictEntity getClsDistrictByIdDistrict() {
        return clsDistrictByIdDistrict;
    }

    public void setClsDistrictByIdDistrict(ClsDistrictEntity clsDistrictByIdDistrict) {
        this.clsDistrictByIdDistrict = clsDistrictByIdDistrict;
    }
}
