package ru.sibdigital.difar.domain.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.catalog.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.catalog.ClsTypeAnimalEventEntity;
import ru.sibdigital.difar.domain.tableparts.TpAnimalEventAnimalEntity;
import ru.sibdigital.difar.domain.tableparts.TpAnimalEventAnimalGroupEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "doc_animal_event", schema = "breed")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class DocAnimalEventEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateReg;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idOrganization;
    private long idTypeAnimalEvent;
    private JsonNode listValues;
    private Boolean isPair;
    private Integer multiplicity;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private ClsTypeAnimalEventEntity clsTypeAnimalEventByIdTypeAnimalEvent;
    private Collection<TpAnimalEventAnimalEntity> tpAnimalEventAnimalsById;
    private Collection<TpAnimalEventAnimalGroupEntity> tpAnimalEventAnimalGroupsById;

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
    @Column(name = "date_reg", nullable = true)
    public Timestamp getDateReg() {
        return dateReg;
    }

    public void setDateReg(Timestamp dateReg) {
        this.dateReg = dateReg;
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
    @Column(name = "id_type_animal_event", nullable = false, insertable = false, updatable = false)
    public long getIdTypeAnimalEvent() {
        return idTypeAnimalEvent;
    }

    public void setIdTypeAnimalEvent(long idTypeAnimalEvent) {
        this.idTypeAnimalEvent = idTypeAnimalEvent;
    }

    @Type(type = "jsonb-node")
    @Column(name = "list_values", nullable = true)
    public JsonNode getListValues() {
        return listValues;
    }

    public void setListValues(JsonNode listValues) {
        this.listValues = listValues;
    }

    @Basic
    @Column(name = "is_pair", nullable = true)
    public Boolean getPair() {
        return isPair;
    }

    public void setPair(Boolean pair) {
        isPair = pair;
    }

    @Basic
    @Column(name = "multiplicity", nullable = true)
    public Integer getMultiplicity() {
        return multiplicity;
    }

    public void setMultiplicity(Integer multiplicity) {
        this.multiplicity = multiplicity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocAnimalEventEntity that = (DocAnimalEventEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idTypeAnimalEvent != that.idTypeAnimalEvent) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (dateReg != null ? !dateReg.equals(that.dateReg) : that.dateReg != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (listValues != null ? !listValues.equals(that.listValues) : that.listValues != null) return false;
        if (isPair != null ? !isPair.equals(that.isPair) : that.isPair != null) return false;
        return multiplicity != null ? multiplicity.equals(that.multiplicity) : that.multiplicity == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (dateReg != null ? dateReg.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        result = 31 * result + (int) (idTypeAnimalEvent ^ (idTypeAnimalEvent >>> 32));
        result = 31 * result + (listValues != null ? listValues.hashCode() : 0);
        result = 31 * result + (isPair != null ? isPair.hashCode() : 0);
        result = 31 * result + (multiplicity != null ? multiplicity.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "id_type_animal_event", referencedColumnName = "id", nullable = false)
    public ClsTypeAnimalEventEntity getClsTypeAnimalEventByIdTypeAnimalEvent() {
        return clsTypeAnimalEventByIdTypeAnimalEvent;
    }

    public void setClsTypeAnimalEventByIdTypeAnimalEvent(ClsTypeAnimalEventEntity clsTypeAnimalEventByIdTypeAnimalEvent) {
        this.clsTypeAnimalEventByIdTypeAnimalEvent = clsTypeAnimalEventByIdTypeAnimalEvent;
    }

    @OneToMany(mappedBy = "docAnimalEventByIdAnimalEvent")
    @JsonIgnore
    public Collection<TpAnimalEventAnimalEntity> getTpAnimalEventAnimalsById() {
        return tpAnimalEventAnimalsById;
    }

    public void setTpAnimalEventAnimalsById(Collection<TpAnimalEventAnimalEntity> tpAnimalEventAnimalsById) {
        this.tpAnimalEventAnimalsById = tpAnimalEventAnimalsById;
    }

    @OneToMany(mappedBy = "docAnimalEventByIdAnimalEvent")
    @JsonIgnore
    public Collection<TpAnimalEventAnimalGroupEntity> getTpAnimalEventAnimalGroupsById() {
        return tpAnimalEventAnimalGroupsById;
    }

    public void setTpAnimalEventAnimalGroupsById(Collection<TpAnimalEventAnimalGroupEntity> tpAnimalEventAnimalGroupsById) {
        this.tpAnimalEventAnimalGroupsById = tpAnimalEventAnimalGroupsById;
    }
}
