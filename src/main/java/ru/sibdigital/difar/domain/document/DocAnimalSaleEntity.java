package ru.sibdigital.difar.domain.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.sibdigital.difar.domain.catalog.ClsPartnerEntity;
import ru.sibdigital.difar.domain.catalog.ClsTypeAnimalEventEntity;
import ru.sibdigital.difar.domain.tableparts.TpAnimalSaleAnimalEntity;
import ru.sibdigital.difar.domain.tableparts.TpAnimalSaleAnimalGroupEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "doc_animal_sale", schema = "breed")
public class DocAnimalSaleEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateReg;
    private Boolean isDeleted;
    private String number;
    private long id;
    private long idOrganization;
    private long idTypeAnimalEvent;
    private long idPartner;
    private Integer multiplicity;
    private ClsTypeAnimalEventEntity clsTypeAnimalEventByIdTypeAnimalEvent;
    private ClsPartnerEntity clsPartnerByIdPartner;
    private Collection<TpAnimalSaleAnimalEntity> tpAnimalSaleAnimalsById;
    private Collection<TpAnimalSaleAnimalGroupEntity> tpAnimalSaleAnimalGroupsById;

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

    @Basic
    @Column(name = "id_partner", nullable = false, insertable = false, updatable = false)
    public long getIdPartner() {
        return idPartner;
    }

    public void setIdPartner(long idPartner) {
        this.idPartner = idPartner;
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

        DocAnimalSaleEntity that = (DocAnimalSaleEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idTypeAnimalEvent != that.idTypeAnimalEvent) return false;
        if (idPartner != that.idPartner) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (dateReg != null ? !dateReg.equals(that.dateReg) : that.dateReg != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
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
        result = 31 * result + (int) (idPartner ^ (idPartner >>> 32));
        result = 31 * result + (multiplicity != null ? multiplicity.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_type_animal_event", referencedColumnName = "id", nullable = false)
    public ClsTypeAnimalEventEntity getClsTypeAnimalEventByIdTypeAnimalEvent() {
        return clsTypeAnimalEventByIdTypeAnimalEvent;
    }

    public void setClsTypeAnimalEventByIdTypeAnimalEvent(ClsTypeAnimalEventEntity clsTypeAnimalEventByIdTypeAnimalEvent) {
        this.clsTypeAnimalEventByIdTypeAnimalEvent = clsTypeAnimalEventByIdTypeAnimalEvent;
    }

    @ManyToOne
    @JoinColumn(name = "id_partner", referencedColumnName = "id", nullable = false)
    public ClsPartnerEntity getClsPartnerByIdPartner() {
        return clsPartnerByIdPartner;
    }

    public void setClsPartnerByIdPartner(ClsPartnerEntity clsPartnerByIdPartner) {
        this.clsPartnerByIdPartner = clsPartnerByIdPartner;
    }

    @OneToMany(mappedBy = "docAnimalSaleByIdAnimalSale")
    @JsonIgnore
    public Collection<TpAnimalSaleAnimalEntity> getTpAnimalSaleAnimalsById() {
        return tpAnimalSaleAnimalsById;
    }

    public void setTpAnimalSaleAnimalsById(Collection<TpAnimalSaleAnimalEntity> tpAnimalSaleAnimalsById) {
        this.tpAnimalSaleAnimalsById = tpAnimalSaleAnimalsById;
    }

    @OneToMany(mappedBy = "docAnimalSaleByIdAnimalSale")
    @JsonIgnore
    public Collection<TpAnimalSaleAnimalGroupEntity> getTpAnimalSaleAnimalGroupsById() {
        return tpAnimalSaleAnimalGroupsById;
    }

    public void setTpAnimalSaleAnimalGroupsById(Collection<TpAnimalSaleAnimalGroupEntity> tpAnimalSaleAnimalGroupsById) {
        this.tpAnimalSaleAnimalGroupsById = tpAnimalSaleAnimalGroupsById;
    }
}
