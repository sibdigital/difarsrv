package ru.sibdigital.difar.domain.classifier.dict;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
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
public class ClsAreaEntity extends ClsBaseEntity {
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
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsAreaEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsAreaEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsAreaEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsAreaEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsAreaEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_area_id_seq", schema = "dict")
    public long getId() {
        return id;
    }

    public ClsAreaEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "id_district", nullable = false, insertable = false, updatable = false)
    public long getIdDistrict() {
        return idDistrict;
    }

    public ClsAreaEntity setIdDistrict(long idDistrict) {
        this.idDistrict = idDistrict;
        return this;
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
    @JsonIgnore
    public Collection<RegFieldLocalEntity> getRegFieldLocalsById() {
        return regFieldLocalsById;
    }

    public ClsAreaEntity setRegFieldLocalsById(Collection<RegFieldLocalEntity> regFieldLocalsById) {
        this.regFieldLocalsById = regFieldLocalsById;
        return this;
    }

    @OneToMany(mappedBy = "clsAreaByIdArea")
    @JsonIgnore
    public Collection<TpPlantDiseaseTypicalAreaEntity> getTpPlantDiseaseTypicalAreasById() {
        return tpPlantDiseaseTypicalAreasById;
    }

    public ClsAreaEntity setTpPlantDiseaseTypicalAreasById(Collection<TpPlantDiseaseTypicalAreaEntity> tpPlantDiseaseTypicalAreasById) {
        this.tpPlantDiseaseTypicalAreasById = tpPlantDiseaseTypicalAreasById;
        return this;
    }

    @OneToMany(mappedBy = "clsAreaByIdArea")
    @JsonIgnore
    public Collection<TpPlantPestTypicalAreaEntity> getTpPlantPestTypicalAreasById() {
        return tpPlantPestTypicalAreasById;
    }

    public ClsAreaEntity setTpPlantPestTypicalAreasById(Collection<TpPlantPestTypicalAreaEntity> tpPlantPestTypicalAreasById) {
        this.tpPlantPestTypicalAreasById = tpPlantPestTypicalAreasById;
        return this;
    }

    @OneToMany(mappedBy = "clsAreaByIdArea")
    @JsonIgnore
    public Collection<RegAnimalEntity> getRegAnimalsById() {
        return regAnimalsById;
    }

    public ClsAreaEntity setRegAnimalsById(Collection<RegAnimalEntity> regAnimalsById) {
        this.regAnimalsById = regAnimalsById;
        return this;
    }

    @OneToMany(mappedBy = "clsAreaByIdArea")
    @JsonIgnore
    public Collection<RegExternalAnimalEntity> getRegExternalAnimalsById() {
        return regExternalAnimalsById;
    }

    public ClsAreaEntity setRegExternalAnimalsById(Collection<RegExternalAnimalEntity> regExternalAnimalsById) {
        this.regExternalAnimalsById = regExternalAnimalsById;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_district", referencedColumnName = "id", nullable = false)
    public ClsDistrictEntity getClsDistrictByIdDistrict() {
        return clsDistrictByIdDistrict;
    }

    public ClsAreaEntity setClsDistrictByIdDistrict(ClsDistrictEntity clsDistrictByIdDistrict) {
        this.clsDistrictByIdDistrict = clsDistrictByIdDistrict;
        return this;
    }
}
