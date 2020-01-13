package ru.sibdigital.difar.domain.register;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.catalog.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.catalog.ClsProtectionEquipmentEntity;
import ru.sibdigital.difar.domain.tableparts.TpRoutingProtectionEquipmentEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "reg_organization_protection_equipment", schema = "agrc")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class RegOrganizationProtectionEquipmentEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private long id;
    private long idOrganization;
    private long idProtectionEquipment;
    private String number;
    private String name;
    private JsonNode description;
    private Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById;
    private Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById_0;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private ClsProtectionEquipmentEntity clsProtectionEquipmentByIdProtectionEquipment;
    private Collection<TpRoutingProtectionEquipmentEntity> tpRoutingProtectionEquipmentsById;

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
    @Column(name = "id_protection_equipment", nullable = false, insertable = false, updatable = false)
    public long getIdProtectionEquipment() {
        return idProtectionEquipment;
    }

    public void setIdProtectionEquipment(long idProtectionEquipment) {
        this.idProtectionEquipment = idProtectionEquipment;
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

    @Type(type = "jsonb-node")
    @Column(name = "description", nullable = true)
    public JsonNode getDescription() {
        return description;
    }

    public void setDescription(JsonNode description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegOrganizationProtectionEquipmentEntity that = (RegOrganizationProtectionEquipmentEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idProtectionEquipment != that.idProtectionEquipment) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (dateBegin != null ? !dateBegin.equals(that.dateBegin) : that.dateBegin != null) return false;
        if (dateEnd != null ? !dateEnd.equals(that.dateEnd) : that.dateEnd != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        result = 31 * result + (int) (idProtectionEquipment ^ (idProtectionEquipment >>> 32));
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "regOrganizationProtectionEquipmentByIdOrganizationProtectionEquipment")
    public Collection<RegExecRoutingProtectionEquipmentEntity> getRegExecRoutingProtectionEquipmentsById() {
        return regExecRoutingProtectionEquipmentsById;
    }

    public void setRegExecRoutingProtectionEquipmentsById(Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById) {
        this.regExecRoutingProtectionEquipmentsById = regExecRoutingProtectionEquipmentsById;
    }

    @OneToMany(mappedBy = "regOrganizationProtectionEquipmentByIdRoutingProtectionEquipment")
    public Collection<RegExecRoutingProtectionEquipmentEntity> getRegExecRoutingProtectionEquipmentsById_0() {
        return regExecRoutingProtectionEquipmentsById_0;
    }

    public void setRegExecRoutingProtectionEquipmentsById_0(Collection<RegExecRoutingProtectionEquipmentEntity> regExecRoutingProtectionEquipmentsById_0) {
        this.regExecRoutingProtectionEquipmentsById_0 = regExecRoutingProtectionEquipmentsById_0;
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
    @JoinColumn(name = "id_protection_equipment", referencedColumnName = "id", nullable = false)
    public ClsProtectionEquipmentEntity getClsProtectionEquipmentByIdProtectionEquipment() {
        return clsProtectionEquipmentByIdProtectionEquipment;
    }

    public void setClsProtectionEquipmentByIdProtectionEquipment(ClsProtectionEquipmentEntity clsProtectionEquipmentByIdProtectionEquipment) {
        this.clsProtectionEquipmentByIdProtectionEquipment = clsProtectionEquipmentByIdProtectionEquipment;
    }

    @OneToMany(mappedBy = "regOrganizationProtectionEquipmentByIdOrganizationProtectionEquipment")
    public Collection<TpRoutingProtectionEquipmentEntity> getTpRoutingProtectionEquipmentsById() {
        return tpRoutingProtectionEquipmentsById;
    }

    public void setTpRoutingProtectionEquipmentsById(Collection<TpRoutingProtectionEquipmentEntity> tpRoutingProtectionEquipmentsById) {
        this.tpRoutingProtectionEquipmentsById = tpRoutingProtectionEquipmentsById;
    }
}
