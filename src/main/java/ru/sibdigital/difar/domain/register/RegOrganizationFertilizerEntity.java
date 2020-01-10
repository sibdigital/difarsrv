package ru.sibdigital.difar.domain.register;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.catalog.ClsFertilizerEntity;
import ru.sibdigital.difar.domain.catalog.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.tableparts.TpRoutingFertilizerEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "reg_organization_fertilizer", schema = "agrc")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class RegOrganizationFertilizerEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private long id;
    private long idOrganization;
    private long idFertilizer;
    private String number;
    private String name;
    private JsonNode description;
    private Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById;
    private Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById_0;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private ClsFertilizerEntity clsFertilizerByIdFertilizer;
    private Collection<TpRoutingFertilizerEntity> tpRoutingFertilizersById;

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
    @Column(name = "id_fertilizer", nullable = false, insertable = false, updatable = false)
    public long getIdFertilizer() {
        return idFertilizer;
    }

    public void setIdFertilizer(long idFertilizer) {
        this.idFertilizer = idFertilizer;
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

        RegOrganizationFertilizerEntity that = (RegOrganizationFertilizerEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idFertilizer != that.idFertilizer) return false;
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
        result = 31 * result + (int) (idFertilizer ^ (idFertilizer >>> 32));
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "regOrganizationFertilizerByIdOrganizationFertilizer")
    public Collection<RegExecRoutingFertilizerEntity> getRegExecRoutingFertilizersById() {
        return regExecRoutingFertilizersById;
    }

    public void setRegExecRoutingFertilizersById(Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById) {
        this.regExecRoutingFertilizersById = regExecRoutingFertilizersById;
    }

    @OneToMany(mappedBy = "regOrganizationFertilizerByIdRoutingFertilizer")
    public Collection<RegExecRoutingFertilizerEntity> getRegExecRoutingFertilizersById_0() {
        return regExecRoutingFertilizersById_0;
    }

    public void setRegExecRoutingFertilizersById_0(Collection<RegExecRoutingFertilizerEntity> regExecRoutingFertilizersById_0) {
        this.regExecRoutingFertilizersById_0 = regExecRoutingFertilizersById_0;
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
    @JoinColumn(name = "id_fertilizer", referencedColumnName = "id", nullable = false)
    public ClsFertilizerEntity getClsFertilizerByIdFertilizer() {
        return clsFertilizerByIdFertilizer;
    }

    public void setClsFertilizerByIdFertilizer(ClsFertilizerEntity clsFertilizerByIdFertilizer) {
        this.clsFertilizerByIdFertilizer = clsFertilizerByIdFertilizer;
    }

    @OneToMany(mappedBy = "regOrganizationFertilizerByIdOrganizationFertilizer")
    public Collection<TpRoutingFertilizerEntity> getTpRoutingFertilizersById() {
        return tpRoutingFertilizersById;
    }

    public void setTpRoutingFertilizersById(Collection<TpRoutingFertilizerEntity> tpRoutingFertilizersById) {
        this.tpRoutingFertilizersById = tpRoutingFertilizersById;
    }
}
