package ru.sibdigital.difar.domain.register;

import ru.sibdigital.difar.domain.catalog.ClsConsumableEntity;
import ru.sibdigital.difar.domain.catalog.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.tableparts.TpRoutingConsumEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "reg_organization_consumable", schema = "org")
public class RegOrganizationConsumableEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private long id;
    private long idOrganization;
    private long idConsumable;
    private String number;
    private String name;
    private Integer affiliation;
    private Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById;
    private Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById_0;
    private Collection<TpRoutingConsumEntity> tpRoutingConsumsById;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private ClsConsumableEntity clsConsumableByIdConsumable;

    @Basic
    @Column(name = "id_user_creator", nullable = false, insertable = false, updatable = false)
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
    @Column(name = "id_consumable", nullable = false, insertable = false, updatable = false)
    public long getIdConsumable() {
        return idConsumable;
    }

    public void setIdConsumable(long idConsumable) {
        this.idConsumable = idConsumable;
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

        RegOrganizationConsumableEntity that = (RegOrganizationConsumableEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idConsumable != that.idConsumable) return false;
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
        result = 31 * result + (int) (idConsumable ^ (idConsumable >>> 32));
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (affiliation != null ? affiliation.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "regOrganizationConsumableByIdOrganizationConsum")
    public Collection<RegExecRoutingConsumEntity> getRegExecRoutingConsumsById() {
        return regExecRoutingConsumsById;
    }

    public void setRegExecRoutingConsumsById(Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById) {
        this.regExecRoutingConsumsById = regExecRoutingConsumsById;
    }

    @OneToMany(mappedBy = "regOrganizationConsumableByIdRoutingConsum")
    public Collection<RegExecRoutingConsumEntity> getRegExecRoutingConsumsById_0() {
        return regExecRoutingConsumsById_0;
    }

    public void setRegExecRoutingConsumsById_0(Collection<RegExecRoutingConsumEntity> regExecRoutingConsumsById_0) {
        this.regExecRoutingConsumsById_0 = regExecRoutingConsumsById_0;
    }

    @OneToMany(mappedBy = "regOrganizationConsumableByIdOrganizationConsumable")
    public Collection<TpRoutingConsumEntity> getTpRoutingConsumsById() {
        return tpRoutingConsumsById;
    }

    public void setTpRoutingConsumsById(Collection<TpRoutingConsumEntity> tpRoutingConsumsById) {
        this.tpRoutingConsumsById = tpRoutingConsumsById;
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
    @JoinColumn(name = "id_consumable", referencedColumnName = "id", nullable = false)
    public ClsConsumableEntity getClsConsumableByIdConsumable() {
        return clsConsumableByIdConsumable;
    }

    public void setClsConsumableByIdConsumable(ClsConsumableEntity clsConsumableByIdConsumable) {
        this.clsConsumableByIdConsumable = clsConsumableByIdConsumable;
    }
}
