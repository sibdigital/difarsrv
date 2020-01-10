package ru.sibdigital.difar.domain.catalog;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Geometry;
import ru.sibdigital.difar.domain.document.DocAnimalTransferEntity;
import ru.sibdigital.difar.domain.register.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_ranch", schema = "org")
public class ClsRanchEntity {
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
    @Column(name = "id_organization", nullable = false, insertable = false, updatable = false)
    public long getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(long idOrganization) {
        this.idOrganization = idOrganization;
    }

    @Basic
    @Column(name = "id_depart", nullable = false, insertable = false, updatable = false)
    public long getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(long idDepart) {
        this.idDepart = idDepart;
    }

    @Basic
    @Column(name = "id_district", nullable = false, insertable = false, updatable = false)
    public long getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(long idDistrict) {
        this.idDistrict = idDistrict;
    }

//    @Type(type="org.hibernate.spatial.GeometryType")
//    @Column(columnDefinition="Geometry", name = "coord", nullable = true)
//    public Geometry getCoord() {
//        return coord;
//    }
//
//    public void setCoord(Geometry coord) {
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
    public Collection<DocAnimalTransferEntity> getDocAnimalTransfersById() {
        return docAnimalTransfersById;
    }

    public void setDocAnimalTransfersById(Collection<DocAnimalTransferEntity> docAnimalTransfersById) {
        this.docAnimalTransfersById = docAnimalTransfersById;
    }

    @OneToMany(mappedBy = "clsRanchByIdRanchCurrent")
    public Collection<DocAnimalTransferEntity> getDocAnimalTransfersById_0() {
        return docAnimalTransfersById_0;
    }

    public void setDocAnimalTransfersById_0(Collection<DocAnimalTransferEntity> docAnimalTransfersById_0) {
        this.docAnimalTransfersById_0 = docAnimalTransfersById_0;
    }

    @OneToMany(mappedBy = "clsRanchByIdRanch")
    public Collection<RegAnimalGroupEntity> getRegAnimalGroupsById() {
        return regAnimalGroupsById;
    }

    public void setRegAnimalGroupsById(Collection<RegAnimalGroupEntity> regAnimalGroupsById) {
        this.regAnimalGroupsById = regAnimalGroupsById;
    }

    @OneToMany(mappedBy = "clsRanchByIdRanch")
    public Collection<RegAnimalLocalEntity> getRegAnimalLocalsById() {
        return regAnimalLocalsById;
    }

    public void setRegAnimalLocalsById(Collection<RegAnimalLocalEntity> regAnimalLocalsById) {
        this.regAnimalLocalsById = regAnimalLocalsById;
    }

    @OneToMany(mappedBy = "clsRanchByIdRanch")
    public Collection<RegAnimalParamEntity> getRegAnimalParamsById() {
        return regAnimalParamsById;
    }

    public void setRegAnimalParamsById(Collection<RegAnimalParamEntity> regAnimalParamsById) {
        this.regAnimalParamsById = regAnimalParamsById;
    }

    @OneToMany(mappedBy = "clsRanchByIdRanch")
    public Collection<RegAnimalStateEntity> getRegAnimalStatesById() {
        return regAnimalStatesById;
    }

    public void setRegAnimalStatesById(Collection<RegAnimalStateEntity> regAnimalStatesById) {
        this.regAnimalStatesById = regAnimalStatesById;
    }

    @OneToMany(mappedBy = "clsRanchByIdRanch")
    public Collection<ClsEquipmentBaseEntity> getClsEquipmentBasesById() {
        return clsEquipmentBasesById;
    }

    public void setClsEquipmentBasesById(Collection<ClsEquipmentBaseEntity> clsEquipmentBasesById) {
        this.clsEquipmentBasesById = clsEquipmentBasesById;
    }

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    public ClsOrganizationEntity getClsOrganizationByIdOrganization() {
        return clsOrganizationByIdOrganization;
    }

    public void setClsOrganizationByIdOrganization(ClsOrganizationEntity clsOrganizationByIdOrganization) {
        this.clsOrganizationByIdOrganization = clsOrganizationByIdOrganization;
    }

    @ManyToOne
    @JoinColumn(name = "id_depart", referencedColumnName = "id", nullable = false)
    public ClsDepartEntity getClsDepartByIdDepart() {
        return clsDepartByIdDepart;
    }

    public void setClsDepartByIdDepart(ClsDepartEntity clsDepartByIdDepart) {
        this.clsDepartByIdDepart = clsDepartByIdDepart;
    }

    @ManyToOne
    @JoinColumn(name = "id_district", referencedColumnName = "id", nullable = false)
    public ClsDistrictEntity getClsDistrictByIdDistrict() {
        return clsDistrictByIdDistrict;
    }

    public void setClsDistrictByIdDistrict(ClsDistrictEntity clsDistrictByIdDistrict) {
        this.clsDistrictByIdDistrict = clsDistrictByIdDistrict;
    }

    @OneToMany(mappedBy = "clsRanchByIdRanch")
    public Collection<RegEquipmentBaseLocalEntity> getRegEquipmentBaseLocalsById() {
        return regEquipmentBaseLocalsById;
    }

    public void setRegEquipmentBaseLocalsById(Collection<RegEquipmentBaseLocalEntity> regEquipmentBaseLocalsById) {
        this.regEquipmentBaseLocalsById = regEquipmentBaseLocalsById;
    }
}
