package ru.sibdigital.difar.domain.tableparts;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.document.DocAnimalBeatingEntity;
import ru.sibdigital.difar.domain.register.RegAnimalEntity;
import ru.sibdigital.difar.domain.register.RegAnimalGroupEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tp_animal_beating_animal_group", schema = "breed")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class TpAnimalBeatingAnimalGroupEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idAnimalBeating;
    private long idAnimalMotherGroup;
    private long idAnimalChild;
    private JsonNode listValuesMotherGroup;
    private JsonNode listValuesChild;
    private Timestamp dateBeating;
    private DocAnimalBeatingEntity docAnimalBeatingByIdAnimalBeating;
    private RegAnimalGroupEntity regAnimalGroupByIdAnimalMotherGroup;
    private RegAnimalEntity regAnimalByIdAnimalChild;

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
    @Column(name = "id_animal_beating", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalBeating() {
        return idAnimalBeating;
    }

    public void setIdAnimalBeating(long idAnimalBeating) {
        this.idAnimalBeating = idAnimalBeating;
    }

    @Basic
    @Column(name = "id_animal_mother_group", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalMotherGroup() {
        return idAnimalMotherGroup;
    }

    public void setIdAnimalMotherGroup(long idAnimalMotherGroup) {
        this.idAnimalMotherGroup = idAnimalMotherGroup;
    }

    @Basic
    @Column(name = "id_animal_child", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalChild() {
        return idAnimalChild;
    }

    public void setIdAnimalChild(long idAnimalChild) {
        this.idAnimalChild = idAnimalChild;
    }

    @Type(type = "jsonb-node")
    @Column(name = "list_values_mother_group", nullable = true)
    public JsonNode getListValuesMotherGroup() {
        return listValuesMotherGroup;
    }

    public void setListValuesMotherGroup(JsonNode listValuesMotherGroup) {
        this.listValuesMotherGroup = listValuesMotherGroup;
    }

    @Type(type = "jsonb-node")
    @Column(name = "list_values_child", nullable = true)
    public JsonNode getListValuesChild() {
        return listValuesChild;
    }

    public void setListValuesChild(JsonNode listValuesChild) {
        this.listValuesChild = listValuesChild;
    }

    @Basic
    @Column(name = "date_beating", nullable = true)
    public Timestamp getDateBeating() {
        return dateBeating;
    }

    public void setDateBeating(Timestamp dateBeating) {
        this.dateBeating = dateBeating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpAnimalBeatingAnimalGroupEntity that = (TpAnimalBeatingAnimalGroupEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idAnimalBeating != that.idAnimalBeating) return false;
        if (idAnimalMotherGroup != that.idAnimalMotherGroup) return false;
        if (idAnimalChild != that.idAnimalChild) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (listValuesMotherGroup != null ? !listValuesMotherGroup.equals(that.listValuesMotherGroup) : that.listValuesMotherGroup != null)
            return false;
        if (listValuesChild != null ? !listValuesChild.equals(that.listValuesChild) : that.listValuesChild != null)
            return false;
        return dateBeating != null ? dateBeating.equals(that.dateBeating) : that.dateBeating == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idAnimalBeating ^ (idAnimalBeating >>> 32));
        result = 31 * result + (int) (idAnimalMotherGroup ^ (idAnimalMotherGroup >>> 32));
        result = 31 * result + (int) (idAnimalChild ^ (idAnimalChild >>> 32));
        result = 31 * result + (listValuesMotherGroup != null ? listValuesMotherGroup.hashCode() : 0);
        result = 31 * result + (listValuesChild != null ? listValuesChild.hashCode() : 0);
        result = 31 * result + (dateBeating != null ? dateBeating.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_beating", referencedColumnName = "id", nullable = false)
    public DocAnimalBeatingEntity getDocAnimalBeatingByIdAnimalBeating() {
        return docAnimalBeatingByIdAnimalBeating;
    }

    public void setDocAnimalBeatingByIdAnimalBeating(DocAnimalBeatingEntity docAnimalBeatingByIdAnimalBeating) {
        this.docAnimalBeatingByIdAnimalBeating = docAnimalBeatingByIdAnimalBeating;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_mother_group", referencedColumnName = "id", nullable = false)
    public RegAnimalGroupEntity getRegAnimalGroupByIdAnimalMotherGroup() {
        return regAnimalGroupByIdAnimalMotherGroup;
    }

    public void setRegAnimalGroupByIdAnimalMotherGroup(RegAnimalGroupEntity regAnimalGroupByIdAnimalMotherGroup) {
        this.regAnimalGroupByIdAnimalMotherGroup = regAnimalGroupByIdAnimalMotherGroup;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_child", referencedColumnName = "id", nullable = false)
    public RegAnimalEntity getRegAnimalByIdAnimalChild() {
        return regAnimalByIdAnimalChild;
    }

    public void setRegAnimalByIdAnimalChild(RegAnimalEntity regAnimalByIdAnimalChild) {
        this.regAnimalByIdAnimalChild = regAnimalByIdAnimalChild;
    }
}
