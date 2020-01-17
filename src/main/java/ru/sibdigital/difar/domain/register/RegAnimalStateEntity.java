package ru.sibdigital.difar.domain.register;

import ru.sibdigital.difar.domain.classifier.breed.ClsTypeAnimalEventEntity;
import ru.sibdigital.difar.domain.classifier.dict.ClsOrganizationEntity;
import ru.sibdigital.difar.domain.classifier.org.ClsRanchEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "reg_animal_state", schema = "breed")
public class RegAnimalStateEntity {
    private long idUserCreator;
    private Timestamp dateCreate;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private long id;
    private long idOrganization;
    private long idRanch;
    private long idAnimal;
    private long idDoc;
    private long idTypeAnimalEvent;
    private BigDecimal weight;
    private ClsOrganizationEntity clsOrganizationByIdOrganization;
    private ClsRanchEntity clsRanchByIdRanch;
    private RegAnimalEntity regAnimalByIdAnimal;
    private ClsTypeAnimalEventEntity clsTypeAnimalEventByIdTypeAnimalEvent;

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
    @Column(name = "id_ranch", nullable = false, insertable = false, updatable = false)
    public long getIdRanch() {
        return idRanch;
    }

    public void setIdRanch(long idRanch) {
        this.idRanch = idRanch;
    }

    @Basic
    @Column(name = "id_animal", nullable = false, insertable = false, updatable = false)
    public long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(long idAnimal) {
        this.idAnimal = idAnimal;
    }

    @Basic
    @Column(name = "id_doc", nullable = false, insertable = false, updatable = false)
    public long getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(long idDoc) {
        this.idDoc = idDoc;
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
    @Column(name = "weight", nullable = true, precision = 5)
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegAnimalStateEntity that = (RegAnimalStateEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (id != that.id) return false;
        if (idOrganization != that.idOrganization) return false;
        if (idRanch != that.idRanch) return false;
        if (idAnimal != that.idAnimal) return false;
        if (idDoc != that.idDoc) return false;
        if (idTypeAnimalEvent != that.idTypeAnimalEvent) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (dateBegin != null ? !dateBegin.equals(that.dateBegin) : that.dateBegin != null) return false;
        if (dateEnd != null ? !dateEnd.equals(that.dateEnd) : that.dateEnd != null) return false;
        return weight != null ? weight.equals(that.weight) : that.weight == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idOrganization ^ (idOrganization >>> 32));
        result = 31 * result + (int) (idRanch ^ (idRanch >>> 32));
        result = 31 * result + (int) (idAnimal ^ (idAnimal >>> 32));
        result = 31 * result + (int) (idDoc ^ (idDoc >>> 32));
        result = 31 * result + (int) (idTypeAnimalEvent ^ (idTypeAnimalEvent >>> 32));
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
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
    @JoinColumn(name = "id_ranch", referencedColumnName = "id", nullable = false)
    public ClsRanchEntity getClsRanchByIdRanch() {
        return clsRanchByIdRanch;
    }

    public void setClsRanchByIdRanch(ClsRanchEntity clsRanchByIdRanch) {
        this.clsRanchByIdRanch = clsRanchByIdRanch;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal", referencedColumnName = "id", nullable = false)
    public RegAnimalEntity getRegAnimalByIdAnimal() {
        return regAnimalByIdAnimal;
    }

    public void setRegAnimalByIdAnimal(RegAnimalEntity regAnimalByIdAnimal) {
        this.regAnimalByIdAnimal = regAnimalByIdAnimal;
    }

    @ManyToOne
    @JoinColumn(name = "id_type_animal_event", referencedColumnName = "id", nullable = false)
    public ClsTypeAnimalEventEntity getClsTypeAnimalEventByIdTypeAnimalEvent() {
        return clsTypeAnimalEventByIdTypeAnimalEvent;
    }

    public void setClsTypeAnimalEventByIdTypeAnimalEvent(ClsTypeAnimalEventEntity clsTypeAnimalEventByIdTypeAnimalEvent) {
        this.clsTypeAnimalEventByIdTypeAnimalEvent = clsTypeAnimalEventByIdTypeAnimalEvent;
    }
}
