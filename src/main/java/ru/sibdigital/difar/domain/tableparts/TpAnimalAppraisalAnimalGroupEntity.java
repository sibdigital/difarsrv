package ru.sibdigital.difar.domain.tableparts;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.document.DocAnimalAppraisalEntity;
import ru.sibdigital.difar.domain.register.RegAnimalGroupEntity;

import javax.persistence.*;

@Entity
@Table(name = "tp_animal_appraisal_animal_group", schema = "breed")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class TpAnimalAppraisalAnimalGroupEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idAnimalAppraisal;
    private long idAnimalGroup;
    private JsonNode listValues;
    private DocAnimalAppraisalEntity docAnimalAppraisalByIdAnimalAppraisal;
    private RegAnimalGroupEntity regAnimalGroupByIdAnimalGroup;

    @Basic
    @Column(name = "id_user_creator", nullable = false)
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
    @Column(name = "id_animal_appraisal", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalAppraisal() {
        return idAnimalAppraisal;
    }

    public void setIdAnimalAppraisal(long idAnimalAppraisal) {
        this.idAnimalAppraisal = idAnimalAppraisal;
    }

    @Basic
    @Column(name = "id_animal_group", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalGroup() {
        return idAnimalGroup;
    }

    public void setIdAnimalGroup(long idAnimalGroup) {
        this.idAnimalGroup = idAnimalGroup;
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

        TpAnimalAppraisalAnimalGroupEntity that = (TpAnimalAppraisalAnimalGroupEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idAnimalAppraisal != that.idAnimalAppraisal) return false;
        if (idAnimalGroup != that.idAnimalGroup) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        return listValues != null ? listValues.equals(that.listValues) : that.listValues == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idAnimalAppraisal ^ (idAnimalAppraisal >>> 32));
        result = 31 * result + (int) (idAnimalGroup ^ (idAnimalGroup >>> 32));
        result = 31 * result + (listValues != null ? listValues.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_appraisal", referencedColumnName = "id", nullable = false)
    public DocAnimalAppraisalEntity getDocAnimalAppraisalByIdAnimalAppraisal() {
        return docAnimalAppraisalByIdAnimalAppraisal;
    }

    public void setDocAnimalAppraisalByIdAnimalAppraisal(DocAnimalAppraisalEntity docAnimalAppraisalByIdAnimalAppraisal) {
        this.docAnimalAppraisalByIdAnimalAppraisal = docAnimalAppraisalByIdAnimalAppraisal;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_group", referencedColumnName = "id", nullable = false)
    public RegAnimalGroupEntity getRegAnimalGroupByIdAnimalGroup() {
        return regAnimalGroupByIdAnimalGroup;
    }

    public void setRegAnimalGroupByIdAnimalGroup(RegAnimalGroupEntity regAnimalGroupByIdAnimalGroup) {
        this.regAnimalGroupByIdAnimalGroup = regAnimalGroupByIdAnimalGroup;
    }
}
