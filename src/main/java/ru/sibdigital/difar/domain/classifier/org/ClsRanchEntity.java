package ru.sibdigital.difar.domain.classifier.org;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsDistrictEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.document.DocAnimalTransferEntity;
import ru.sibdigital.difar.domain.register.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_ranch", schema = "org")
public class ClsRanchEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idOrganization;
    private long idDepart;
    private long idDistrict;
    //    private Geometry coord;
    private Collection<DocAnimalTransferEntity> docAnimalTransfersById;
    private Collection<DocAnimalTransferEntity> docAnimalTransfersById_0;
    private Collection<RegAnimalGroupEntity> regAnimalGroupsById;
    private Collection<RegAnimalLocalEntity> regAnimalLocalsById;
    private Collection<RegAnimalParamEntity> regAnimalParamsById;
    private Collection<RegAnimalStateEntity> regAnimalStatesById;
    private Collection<ClsEquipmentBaseEntity> clsEquipmentBasesById;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private ClsDepartEntity clsDepartByIdDepart;
    private ClsDistrictEntity clsDistrictByIdDistrict;
    private Collection<RegEquipmentBaseLocalEntity> regEquipmentBaseLocalsById;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsRanchEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsRanchEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsRanchEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsRanchEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsRanchEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_ranch_id_seq", schema = "org")
    public long getId() {
        return id;
    }

    public ClsRanchEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "id_organization", nullable = false, insertable = false, updatable = false)
    public long getIdOrganization() {
        return idOrganization;
    }

    public ClsRanchEntity setIdOrganization(long idOrganization) {
        this.idOrganization = idOrganization;
        return this;
    }

    @Basic
    @Column(name = "id_depart", nullable = false, insertable = false, updatable = false)
    public long getIdDepart() {
        return idDepart;
    }

    public ClsRanchEntity setIdDepart(long idDepart) {
        this.idDepart = idDepart;
        return this;
    }

    @Basic
    @Column(name = "id_district", nullable = false, insertable = false, updatable = false)
    public long getIdDistrict() {
        return idDistrict;
    }

    public ClsRanchEntity setIdDistrict(long idDistrict) {
        this.idDistrict = idDistrict;
        return this;
    }

//    @Type(type="org.hibernate.spatial.GeometryType")
//    @Column(columnDefinition="Geometry", name = "coord", nullable = true)
//    public Geometry getCoord() {
//        return coord;
//    }
//
//    public ClsRanchEntity setCoord(Geometry coord) {
//        this.coord = coord;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        ClsRanchEntity that = (ClsRanchEntity) o;
//
//        if (idUserCreator != that.idUserCreator) return false;
//        if (id != that.id) return false;
//        if (idOrganization != that.idOrganization) return false;
//        if (idDepart != that.idDepart) return false;
//        if (idDistrict != that.idDistrict) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
//        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
//        if (number != null ? !number.equals(that.number) : that.number != null) return false;
//        return coord != null ? coord.equals(that.coord) : that.coord == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
//        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
//        result = 31 * result + (number != null ? number.hashCode() : 0);
//        result = 31 * result + (int) (id ^ (id >>> 32));
//        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
//        result = 31 * result + (int) (idDepart ^ (idDepart >>> 32));
//        result = 31 * result + (int) (idDistrict ^ (idDistrict >>> 32));
//        result = 31 * result + (coord != null ? coord.hashCode() : 0);
//        return result;
//    }

    @OneToMany(mappedBy = "clsRanchByIdRanch")
    @JsonIgnore
    public Collection<DocAnimalTransferEntity> getDocAnimalTransfersById() {
        return docAnimalTransfersById;
    }

    public ClsRanchEntity setDocAnimalTransfersById(Collection<DocAnimalTransferEntity> docAnimalTransfersById) {
        this.docAnimalTransfersById = docAnimalTransfersById;
        return this;
    }

    @OneToMany(mappedBy = "clsRanchByIdRanchCurrent")
    @JsonIgnore
    public Collection<DocAnimalTransferEntity> getDocAnimalTransfersById_0() {
        return docAnimalTransfersById_0;
    }

    public ClsRanchEntity setDocAnimalTransfersById_0(Collection<DocAnimalTransferEntity> docAnimalTransfersById_0) {
        this.docAnimalTransfersById_0 = docAnimalTransfersById_0;
        return this;
    }

    @OneToMany(mappedBy = "clsRanchByIdRanch")
    @JsonIgnore
    public Collection<RegAnimalGroupEntity> getRegAnimalGroupsById() {
        return regAnimalGroupsById;
    }

    public ClsRanchEntity setRegAnimalGroupsById(Collection<RegAnimalGroupEntity> regAnimalGroupsById) {
        this.regAnimalGroupsById = regAnimalGroupsById;
        return this;
    }

    @OneToMany(mappedBy = "clsRanchByIdRanch")
    @JsonIgnore
    public Collection<RegAnimalLocalEntity> getRegAnimalLocalsById() {
        return regAnimalLocalsById;
    }

    public ClsRanchEntity setRegAnimalLocalsById(Collection<RegAnimalLocalEntity> regAnimalLocalsById) {
        this.regAnimalLocalsById = regAnimalLocalsById;
        return this;
    }

    @OneToMany(mappedBy = "clsRanchByIdRanch")
    @JsonIgnore
    public Collection<RegAnimalParamEntity> getRegAnimalParamsById() {
        return regAnimalParamsById;
    }

    public ClsRanchEntity setRegAnimalParamsById(Collection<RegAnimalParamEntity> regAnimalParamsById) {
        this.regAnimalParamsById = regAnimalParamsById;
        return this;
    }

    @OneToMany(mappedBy = "clsRanchByIdRanch")
    @JsonIgnore
    public Collection<RegAnimalStateEntity> getRegAnimalStatesById() {
        return regAnimalStatesById;
    }

    public ClsRanchEntity setRegAnimalStatesById(Collection<RegAnimalStateEntity> regAnimalStatesById) {
        this.regAnimalStatesById = regAnimalStatesById;
        return this;
    }

    @OneToMany(mappedBy = "clsRanchByIdRanch")
    @JsonIgnore
    public Collection<ClsEquipmentBaseEntity> getClsEquipmentBasesById() {
        return clsEquipmentBasesById;
    }

    public ClsRanchEntity setClsEquipmentBasesById(Collection<ClsEquipmentBaseEntity> clsEquipmentBasesById) {
        this.clsEquipmentBasesById = clsEquipmentBasesById;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    public ClsOrganizationEntity getClsOrganizationByIdOrganization() {
        return clsOrganizationByIdOrganization;
    }

    public ClsRanchEntity setClsOrganizationByIdOrganization(ClsOrganizationEntity clsOrganizationByIdOrganization) {
        this.clsOrganizationByIdOrganization = clsOrganizationByIdOrganization;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_depart", referencedColumnName = "id", nullable = false)
    public ClsDepartEntity getClsDepartByIdDepart() {
        return clsDepartByIdDepart;
    }

    public ClsRanchEntity setClsDepartByIdDepart(ClsDepartEntity clsDepartByIdDepart) {
        this.clsDepartByIdDepart = clsDepartByIdDepart;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_district", referencedColumnName = "id", nullable = false)
    public ClsDistrictEntity getClsDistrictByIdDistrict() {
        return clsDistrictByIdDistrict;
    }

    public ClsRanchEntity setClsDistrictByIdDistrict(ClsDistrictEntity clsDistrictByIdDistrict) {
        this.clsDistrictByIdDistrict = clsDistrictByIdDistrict;
        return this;
    }

    @OneToMany(mappedBy = "clsRanchByIdRanch")
    @JsonIgnore
    public Collection<RegEquipmentBaseLocalEntity> getRegEquipmentBaseLocalsById() {
        return regEquipmentBaseLocalsById;
    }

    public ClsRanchEntity setRegEquipmentBaseLocalsById(Collection<RegEquipmentBaseLocalEntity> regEquipmentBaseLocalsById) {
        this.regEquipmentBaseLocalsById = regEquipmentBaseLocalsById;
        return this;
    }
}
