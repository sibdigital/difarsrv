package ru.sibdigital.difar.domain.classifier.dict;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.classifier.org.ClsDepartEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_legal_entity", schema = "dict")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class ClsLegalEntityEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private String inn;
    private JsonNode description;
    private Collection<ClsOrganizationEntity> clsOrganizationsById;
    private Collection<ClsPartnerEntity> clsPartnersById;
    private Collection<ClsDepartEntity> clsDepartsById;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsLegalEntityEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsLegalEntityEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsLegalEntityEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsLegalEntityEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsLegalEntityEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_legal_entity_id_seq", schema = "dict")
    public long getId() {
        return id;
    }

    public ClsLegalEntityEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "inn", nullable = true, length = 10)
    public String getInn() {
        return inn;
    }

    public ClsLegalEntityEntity setInn(String inn) {
        this.inn = inn;
        return this;
    }

    @Type(type = "jsonb-node")
    @Column(name = "description", nullable = true)
    public JsonNode getDescription() {
        return description;
    }

    public ClsLegalEntityEntity setDescription(JsonNode description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsLegalEntityEntity that = (ClsLegalEntityEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (inn != null ? !inn.equals(that.inn) : that.inn != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (inn != null ? inn.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "clsLegalEntityByIdLegalEntity")
    @JsonIgnore
    public Collection<ClsOrganizationEntity> getClsOrganizationsById() {
        return clsOrganizationsById;
    }

    public ClsLegalEntityEntity setClsOrganizationsById(Collection<ClsOrganizationEntity> clsOrganizationsById) {
        this.clsOrganizationsById = clsOrganizationsById;
        return this;
    }

    @OneToMany(mappedBy = "clsLegalEntityByIdLegalEntity")
    @JsonIgnore
    public Collection<ClsPartnerEntity> getClsPartnersById() {
        return clsPartnersById;
    }

    public ClsLegalEntityEntity setClsPartnersById(Collection<ClsPartnerEntity> clsPartnersById) {
        this.clsPartnersById = clsPartnersById;
        return this;
    }

    @OneToMany(mappedBy = "clsLegalEntityByIdLegalEntity")
    @JsonIgnore
    public Collection<ClsDepartEntity> getClsDepartsById() {
        return clsDepartsById;
    }

    public ClsLegalEntityEntity setClsDepartsById(Collection<ClsDepartEntity> clsDepartsById) {
        this.clsDepartsById = clsDepartsById;
        return this;
    }
}
