package ru.sibdigital.difar.domain.classifier.dict;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import ru.sibdigital.difar.domain.classifier.base.ClsBaseEntity;
import ru.sibdigital.difar.domain.document.DocAnimalSaleEntity;
import ru.sibdigital.difar.domain.register.RegAnimalEntity;
import ru.sibdigital.difar.domain.register.RegExternalAnimalEntity;
import ru.sibdigital.difar.domain.register.RegOrganizationPartnerEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "cls_partner", schema = "dict")
public class ClsPartnerEntity extends ClsBaseEntity {
    private long idUserCreator;
    private String name;
    private Date dateCreate;
    private Boolean isDeleted;
    private String number;
    private long id;
    private String inn;
    private long idLegalEntity;
    private Collection<DocAnimalSaleEntity> docAnimalSalesById;
    private Collection<RegAnimalEntity> regAnimalsById;
    private Collection<RegExternalAnimalEntity> regExternalAnimalsById;
    private ClsLegalEntityEntity clsLegalEntityByIdLegalEntity;
    private Collection<RegOrganizationPartnerEntity> regOrganizationPartnersById;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public ClsPartnerEntity setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
        return this;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public ClsPartnerEntity setName(String name) {
        this.name = name;
        return this;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_create", nullable = true)
    public Date getDateCreate() {
        return dateCreate;
    }

    public ClsPartnerEntity setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
        return this;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public Boolean getDeleted() {
        return isDeleted;
    }

    public ClsPartnerEntity setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 15)
    public String getNumber() {
        return number;
    }

    public ClsPartnerEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generator", sequenceName = "cls_partner_id_seq", schema = "dict")
    public long getId() {
        return id;
    }

    public ClsPartnerEntity setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "inn", nullable = true, length = 10)
    public String getInn() {
        return inn;
    }

    public ClsPartnerEntity setInn(String inn) {
        this.inn = inn;
        return this;
    }

    @Basic
    @Column(name = "id_legal_entity", nullable = false, insertable = false, updatable = false)
    public long getIdLegalEntity() {
        return idLegalEntity;
    }

    public ClsPartnerEntity setIdLegalEntity(long idLegalEntity) {
        this.idLegalEntity = idLegalEntity;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClsPartnerEntity that = (ClsPartnerEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idLegalEntity != that.idLegalEntity) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        return inn != null ? inn.equals(that.inn) : that.inn == null;
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
        result = 31 * result + (int) (idLegalEntity ^ (idLegalEntity >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "clsPartnerByIdPartner")
    @JsonIgnore
    public Collection<DocAnimalSaleEntity> getDocAnimalSalesById() {
        return docAnimalSalesById;
    }

    public ClsPartnerEntity setDocAnimalSalesById(Collection<DocAnimalSaleEntity> docAnimalSalesById) {
        this.docAnimalSalesById = docAnimalSalesById;
        return this;
    }

    @OneToMany(mappedBy = "clsPartnerByIdPartner")
    @JsonIgnore
    public Collection<RegAnimalEntity> getRegAnimalsById() {
        return regAnimalsById;
    }

    public ClsPartnerEntity setRegAnimalsById(Collection<RegAnimalEntity> regAnimalsById) {
        this.regAnimalsById = regAnimalsById;
        return this;
    }

    @OneToMany(mappedBy = "clsPartnerByIdPartner")
    @JsonIgnore
    public Collection<RegExternalAnimalEntity> getRegExternalAnimalsById() {
        return regExternalAnimalsById;
    }

    public ClsPartnerEntity setRegExternalAnimalsById(Collection<RegExternalAnimalEntity> regExternalAnimalsById) {
        this.regExternalAnimalsById = regExternalAnimalsById;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "id_legal_entity", referencedColumnName = "id", nullable = false)
    public ClsLegalEntityEntity getClsLegalEntityByIdLegalEntity() {
        return clsLegalEntityByIdLegalEntity;
    }

    public ClsPartnerEntity setClsLegalEntityByIdLegalEntity(ClsLegalEntityEntity clsLegalEntityByIdLegalEntity) {
        this.clsLegalEntityByIdLegalEntity = clsLegalEntityByIdLegalEntity;
        return this;
    }

    @OneToMany(mappedBy = "clsPartnerByIdPartner")
    @JsonIgnore
    public Collection<RegOrganizationPartnerEntity> getRegOrganizationPartnersById() {
        return regOrganizationPartnersById;
    }

    public ClsPartnerEntity setRegOrganizationPartnersById(Collection<RegOrganizationPartnerEntity> regOrganizationPartnersById) {
        this.regOrganizationPartnersById = regOrganizationPartnersById;
        return this;
    }
}
