package ru.sibdigital.difar.domain.classifier.org;

import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsDistrictEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cls_equipment_base", schema = "org")
public class ClsEquipmentBaseEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idOrganization;
    private long idDepart;
    private long idDistrict;
    private long idRanch;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private ClsDepartEntity clsDepartByIdDepart;
    private ClsDistrictEntity clsDistrictByIdDistrict;
    private ClsRanchEntity clsRanchByIdRanch;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsEquipmentBaseEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsEquipmentBaseEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsEquipmentBaseEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsEquipmentBaseEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsEquipmentBaseEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_equipment_base_id_seq", schema = "org")
    public long getId() {
        return id;
    }

    public ClsEquipmentBaseEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "id_organization", nullable = false, insertable = false, updatable = false)
    public long getIdOrganization() {
        return idOrganization;
    }

    public ClsEquipmentBaseEntity setIdOrganization(long idOrganization) {
        this.idOrganization = idOrganization;
        return this;
    }

    @Basic
    @Column(name = "id_depart", nullable = false, insertable = false, updatable = false)
    public long getIdDepart() {
        return idDepart;
    }

    public ClsEquipmentBaseEntity setIdDepart(long idDepart) {
        this.idDepart = idDepart;
        return this;
    }

    @Basic
    @Column(name = "id_district", nullable = false, insertable = false, updatable = false)
    public long getIdDistrict() {
        return idDistrict;
    }

    public ClsEquipmentBaseEntity setIdDistrict(long idDistrict) {
        this.idDistrict = idDistrict;
        return this;
    }

    @Basic
    @Column(name = "id_ranch", nullable = false, insertable = false, updatable = false)
    public long getIdRanch() {
        return idRanch;
    }

    public ClsEquipmentBaseEntity setIdRanch(long idRanch) {
        this.idRanch = idRanch;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsEquipmentBaseEntity that = (ClsEquipmentBaseEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idDepart != that.idDepart) return false;
        if (idDistrict != that.idDistrict) return false;
        if (idRanch != that.idRanch) return false;
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
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        result = 31 * result + (int) (idDepart ^ (idDepart >>> 32));
        result = 31 * result + (int) (idDistrict ^ (idDistrict >>> 32));
        result = 31 * result + (int) (idRanch ^ (idRanch >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_organization", referencedColumnName = "id", nullable = false)
    public ClsOrganizationEntity getClsOrganizationByIdOrganization() {
        return clsOrganizationByIdOrganization;
    }

    public ClsEquipmentBaseEntity setClsOrganizationByIdOrganization(ClsOrganizationEntity clsOrganizationByIdOrganization) {
        this.clsOrganizationByIdOrganization = clsOrganizationByIdOrganization;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_depart", referencedColumnName = "id", nullable = false)
    public ClsDepartEntity getClsDepartByIdDepart() {
        return clsDepartByIdDepart;
    }

    public ClsEquipmentBaseEntity setClsDepartByIdDepart(ClsDepartEntity clsDepartByIdDepart) {
        this.clsDepartByIdDepart = clsDepartByIdDepart;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_district", referencedColumnName = "id", nullable = false)
    public ClsDistrictEntity getClsDistrictByIdDistrict() {
        return clsDistrictByIdDistrict;
    }

    public ClsEquipmentBaseEntity setClsDistrictByIdDistrict(ClsDistrictEntity clsDistrictByIdDistrict) {
        this.clsDistrictByIdDistrict = clsDistrictByIdDistrict;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_ranch", referencedColumnName = "id", nullable = false)
    public ClsRanchEntity getClsRanchByIdRanch() {
        return clsRanchByIdRanch;
    }

    public ClsEquipmentBaseEntity setClsRanchByIdRanch(ClsRanchEntity clsRanchByIdRanch) {
        this.clsRanchByIdRanch = clsRanchByIdRanch;
        return this;
    }
}
