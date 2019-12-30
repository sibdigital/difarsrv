package ru.sibdigital.difar.domain.catalog;

import ru.sibdigital.difar.domain.document.DocAnimalSaleEntity;
import ru.sibdigital.difar.domain.register.RegAnimalEntity;
import ru.sibdigital.difar.domain.register.RegExternalAnimalEntity;
import ru.sibdigital.difar.domain.register.RegOrganizationPartnerEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "cls_partner", schema = "dict")
public class ClsPartnerEntity {
    private long idUserCreator;
    private String name;
    private Timestamp dateCreate;
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

    @Basic
    @Column(name = "date_create", nullable = true)
    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
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
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "inn", nullable = true, length = 10)
    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Basic
    @Column(name = "id_legal_entity", nullable = false)
    public long getIdLegalEntity() {
        return idLegalEntity;
    }

    public void setIdLegalEntity(long idLegalEntity) {
        this.idLegalEntity = idLegalEntity;
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
    public Collection<DocAnimalSaleEntity> getDocAnimalSalesById() {
        return docAnimalSalesById;
    }

    public void setDocAnimalSalesById(Collection<DocAnimalSaleEntity> docAnimalSalesById) {
        this.docAnimalSalesById = docAnimalSalesById;
    }

    @OneToMany(mappedBy = "clsPartnerByIdPartner")
    public Collection<RegAnimalEntity> getRegAnimalsById() {
        return regAnimalsById;
    }

    public void setRegAnimalsById(Collection<RegAnimalEntity> regAnimalsById) {
        this.regAnimalsById = regAnimalsById;
    }

    @OneToMany(mappedBy = "clsPartnerByIdPartner")
    public Collection<RegExternalAnimalEntity> getRegExternalAnimalsById() {
        return regExternalAnimalsById;
    }

    public void setRegExternalAnimalsById(Collection<RegExternalAnimalEntity> regExternalAnimalsById) {
        this.regExternalAnimalsById = regExternalAnimalsById;
    }

    @ManyToOne
    @JoinColumn(name = "id_legal_entity", referencedColumnName = "id", nullable = false)
    public ClsLegalEntityEntity getClsLegalEntityByIdLegalEntity() {
        return clsLegalEntityByIdLegalEntity;
    }

    public void setClsLegalEntityByIdLegalEntity(ClsLegalEntityEntity clsLegalEntityByIdLegalEntity) {
        this.clsLegalEntityByIdLegalEntity = clsLegalEntityByIdLegalEntity;
    }

    @OneToMany(mappedBy = "clsPartnerByIdPartner")
    public Collection<RegOrganizationPartnerEntity> getRegOrganizationPartnersById() {
        return regOrganizationPartnersById;
    }

    public void setRegOrganizationPartnersById(Collection<RegOrganizationPartnerEntity> regOrganizationPartnersById) {
        this.regOrganizationPartnersById = regOrganizationPartnersById;
    }
}
