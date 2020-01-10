package ru.sibdigital.difar.domain.tableparts;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.catalog.ClsAnimalRetirementCauseEntity;
import ru.sibdigital.difar.domain.document.DocAnimalRetirementEntity;
import ru.sibdigital.difar.domain.register.RegAnimalGroupEntity;

import javax.persistence.*;

@Entity
@Table(name = "tp_animal_retirement_animal_group", schema = "breed")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class TpAnimalRetirementAnimalGroupEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idAnimalRetirement;
    private long idAnimalGroup;
    private long idAnimalRetirementCause;
    private JsonNode listValues;
    private DocAnimalRetirementEntity docAnimalRetirementByIdAnimalRetirement;
    private RegAnimalGroupEntity regAnimalGroupByIdAnimalGroup;
    private ClsAnimalRetirementCauseEntity clsAnimalRetirementCauseByIdAnimalRetirementCause;

    @Basic
    @Column(name = "id_user_creator", nullable = false, insertable = false, updatable = false)
    public long getIdUserCreator() {
        return idUserCreator;
    }

    public void setIdUserCreator(long idUserCreator) {
        this.idUserCreator = idUserCreator;
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
    @Column(name = "number", nullable = false)
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
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
    @Column(name = "id_animal_retirement", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalRetirement() {
        return idAnimalRetirement;
    }

    public void setIdAnimalRetirement(long idAnimalRetirement) {
        this.idAnimalRetirement = idAnimalRetirement;
    }

    @Basic
    @Column(name = "id_animal_group", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalGroup() {
        return idAnimalGroup;
    }

    public void setIdAnimalGroup(long idAnimalGroup) {
        this.idAnimalGroup = idAnimalGroup;
    }

    @Basic
    @Column(name = "id_animal_retirement_cause", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalRetirementCause() {
        return idAnimalRetirementCause;
    }

    public void setIdAnimalRetirementCause(long idAnimalRetirementCause) {
        this.idAnimalRetirementCause = idAnimalRetirementCause;
    }

    @Type(type = "jsonb-node")
    @Column(name = "list_values", nullable = true)
    public JsonNode getListValues() {
        return listValues;
    }

    public void setListValues(JsonNode listValues) {
        this.listValues = listValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpAnimalRetirementAnimalGroupEntity that = (TpAnimalRetirementAnimalGroupEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idAnimalRetirement != that.idAnimalRetirement) return false;
        if (idAnimalGroup != that.idAnimalGroup) return false;
        if (idAnimalRetirementCause != that.idAnimalRetirementCause) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        return listValues != null ? listValues.equals(that.listValues) : that.listValues == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idAnimalRetirement ^ (idAnimalRetirement >>> 32));
        result = 31 * result + (int) (idAnimalGroup ^ (idAnimalGroup >>> 32));
        result = 31 * result + (int) (idAnimalRetirementCause ^ (idAnimalRetirementCause >>> 32));
        result = 31 * result + (listValues != null ? listValues.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_retirement", referencedColumnName = "id", nullable = false)
    public DocAnimalRetirementEntity getDocAnimalRetirementByIdAnimalRetirement() {
        return docAnimalRetirementByIdAnimalRetirement;
    }

    public void setDocAnimalRetirementByIdAnimalRetirement(DocAnimalRetirementEntity docAnimalRetirementByIdAnimalRetirement) {
        this.docAnimalRetirementByIdAnimalRetirement = docAnimalRetirementByIdAnimalRetirement;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_group", referencedColumnName = "id", nullable = false)
    public RegAnimalGroupEntity getRegAnimalGroupByIdAnimalGroup() {
        return regAnimalGroupByIdAnimalGroup;
    }

    public void setRegAnimalGroupByIdAnimalGroup(RegAnimalGroupEntity regAnimalGroupByIdAnimalGroup) {
        this.regAnimalGroupByIdAnimalGroup = regAnimalGroupByIdAnimalGroup;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_retirement_cause", referencedColumnName = "id", nullable = false)
    public ClsAnimalRetirementCauseEntity getClsAnimalRetirementCauseByIdAnimalRetirementCause() {
        return clsAnimalRetirementCauseByIdAnimalRetirementCause;
    }

    public void setClsAnimalRetirementCauseByIdAnimalRetirementCause(ClsAnimalRetirementCauseEntity clsAnimalRetirementCauseByIdAnimalRetirementCause) {
        this.clsAnimalRetirementCauseByIdAnimalRetirementCause = clsAnimalRetirementCauseByIdAnimalRetirementCause;
    }
}
