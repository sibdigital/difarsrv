package ru.sibdigital.difar.domain.register;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.sibdigital.difar.domain.catalog.ClsEquipmentKindEntity;
import ru.sibdigital.difar.domain.catalog.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.tableparts.TpRoutingEquipmentEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "reg_organization_equipment", schema = "org")
public class RegOrganizationEquipmentEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private long id;
    private long idOrganization;
    private long idEquipmentKind;
    private String number;
    private String name;
    private Integer affiliation;
    private Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById;
    private Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById_0;
    private Collection<TpRoutingEquipmentEntity> tpRoutingEquipmentsById;
    private Collection<RegEquipmentBaseLocalEntity> regEquipmentBaseLocalsById;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private ClsEquipmentKindEntity clsEquipmentKindByIdEquipmentKind;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public void setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
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
    @Column(name = "date_begin", nullable = true)
    public Timestamp getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Timestamp dateBegin) {
        this.dateBegin = dateBegin;
    }

    @Basic
    @Column(name = "date_end", nullable = true)
    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
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
    @Column(name = "id_organization", nullable = false, insertable = false, updatable = false)
    public long getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(long idOrganization) {
        this.idOrganization = idOrganization;
    }

    @Basic
    @Column(name = "id_equipment_kind", nullable = false, insertable = false, updatable = false)
    public long getIdEquipmentKind() {
        return idEquipmentKind;
    }

    public void setIdEquipmentKind(long idEquipmentKind) {
        this.idEquipmentKind = idEquipmentKind;
    }

    @Basic
    @Column(name = "number", nullable = true, length = 15)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
    @Column(name = "affiliation", nullable = true)
    public Integer getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Integer affiliation) {
        this.affiliation = affiliation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegOrganizationEquipmentEntity that = (RegOrganizationEquipmentEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idEquipmentKind != that.idEquipmentKind) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (dateBegin != null ? !dateBegin.equals(that.dateBegin) : that.dateBegin != null) return false;
        if (dateEnd != null ? !dateEnd.equals(that.dateEnd) : that.dateEnd != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return affiliation != null ? affiliation.equals(that.affiliation) : that.affiliation == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        result = 31 * result + (int) (idEquipmentKind ^ (idEquipmentKind >>> 32));
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (affiliation != null ? affiliation.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "regOrganizationEquipmentByIdOrganizationEquipment")
    @JsonIgnore
public Collection<RegExecRoutingEquipmentEntity> getRegExecRoutingEquipmentsById() {
        return regExecRoutingEquipmentsById;
    }

    public void setRegExecRoutingEquipmentsById(Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById) {
        this.regExecRoutingEquipmentsById = regExecRoutingEquipmentsById;
    }

    @OneToMany(mappedBy = "regOrganizationEquipmentByIdRoutingEquipment")
    @JsonIgnore
public Collection<RegExecRoutingEquipmentEntity> getRegExecRoutingEquipmentsById_0() {
        return regExecRoutingEquipmentsById_0;
    }

    public void setRegExecRoutingEquipmentsById_0(Collection<RegExecRoutingEquipmentEntity> regExecRoutingEquipmentsById_0) {
        this.regExecRoutingEquipmentsById_0 = regExecRoutingEquipmentsById_0;
    }

    @OneToMany(mappedBy = "regOrganizationEquipmentByIdOrganizationEquipment")
    @JsonIgnore
public Collection<TpRoutingEquipmentEntity> getTpRoutingEquipmentsById() {
        return tpRoutingEquipmentsById;
    }

    public void setTpRoutingEquipmentsById(Collection<TpRoutingEquipmentEntity> tpRoutingEquipmentsById) {
        this.tpRoutingEquipmentsById = tpRoutingEquipmentsById;
    }

    @OneToMany(mappedBy = "regOrganizationEquipmentByIdOrganizationEquipment")
    @JsonIgnore
public Collection<RegEquipmentBaseLocalEntity> getRegEquipmentBaseLocalsById() {
        return regEquipmentBaseLocalsById;
    }

    public void setRegEquipmentBaseLocalsById(Collection<RegEquipmentBaseLocalEntity> regEquipmentBaseLocalsById) {
        this.regEquipmentBaseLocalsById = regEquipmentBaseLocalsById;
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
    @JoinColumn(name = "id_equipment_kind", referencedColumnName = "id", nullable = false)
    public ClsEquipmentKindEntity getClsEquipmentKindByIdEquipmentKind() {
        return clsEquipmentKindByIdEquipmentKind;
    }

    public void setClsEquipmentKindByIdEquipmentKind(ClsEquipmentKindEntity clsEquipmentKindByIdEquipmentKind) {
        this.clsEquipmentKindByIdEquipmentKind = clsEquipmentKindByIdEquipmentKind;
    }
}
