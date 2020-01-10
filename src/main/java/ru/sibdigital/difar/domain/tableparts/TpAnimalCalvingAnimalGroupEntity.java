package ru.sibdigital.difar.domain.tableparts;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.document.DocAnimalCalvingEntity;
import ru.sibdigital.difar.domain.register.RegAnimalEntity;
import ru.sibdigital.difar.domain.register.RegAnimalGroupEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tp_animal_calving_animal_group", schema = "breed")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class TpAnimalCalvingAnimalGroupEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idAnimalCalving;
    private long idAnimalMotherGroup;
    private long idAnimalFatherGroup;
    private long idAnimalChild;
    private JsonNode listValuesMotherGroup;
    private JsonNode listValuesFatherGroup;
    private JsonNode listValuesChild;
    private Timestamp dateBirth;
    private DocAnimalCalvingEntity docAnimalCalvingByIdAnimalCalving;
    private RegAnimalGroupEntity regAnimalGroupByIdAnimalMotherGroup;
    private RegAnimalGroupEntity regAnimalGroupByIdAnimalFatherGroup;
    private RegAnimalEntity regAnimalByIdAnimalChild;

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
    @Column(name = "id_animal_calving", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalCalving() {
        return idAnimalCalving;
    }

    public void setIdAnimalCalving(long idAnimalCalving) {
        this.idAnimalCalving = idAnimalCalving;
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
    @Column(name = "id_animal_father_group", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalFatherGroup() {
        return idAnimalFatherGroup;
    }

    public void setIdAnimalFatherGroup(long idAnimalFatherGroup) {
        this.idAnimalFatherGroup = idAnimalFatherGroup;
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
    @Column(name = "list_values_father_group", nullable = true)
    public JsonNode getListValuesFatherGroup() {
        return listValuesFatherGroup;
    }

    public void setListValuesFatherGroup(JsonNode listValuesFatherGroup) {
        this.listValuesFatherGroup = listValuesFatherGroup;
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
    @Column(name = "date_birth", nullable = true)
    public Timestamp getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Timestamp dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpAnimalCalvingAnimalGroupEntity that = (TpAnimalCalvingAnimalGroupEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idAnimalCalving != that.idAnimalCalving) return false;
        if (idAnimalMotherGroup != that.idAnimalMotherGroup) return false;
        if (idAnimalFatherGroup != that.idAnimalFatherGroup) return false;
        if (idAnimalChild != that.idAnimalChild) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (listValuesMotherGroup != null ? !listValuesMotherGroup.equals(that.listValuesMotherGroup) : that.listValuesMotherGroup != null)
            return false;
        if (listValuesFatherGroup != null ? !listValuesFatherGroup.equals(that.listValuesFatherGroup) : that.listValuesFatherGroup != null)
            return false;
        if (listValuesChild != null ? !listValuesChild.equals(that.listValuesChild) : that.listValuesChild != null)
            return false;
        return dateBirth != null ? dateBirth.equals(that.dateBirth) : that.dateBirth == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idAnimalCalving ^ (idAnimalCalving >>> 32));
        result = 31 * result + (int) (idAnimalMotherGroup ^ (idAnimalMotherGroup >>> 32));
        result = 31 * result + (int) (idAnimalFatherGroup ^ (idAnimalFatherGroup >>> 32));
        result = 31 * result + (int) (idAnimalChild ^ (idAnimalChild >>> 32));
        result = 31 * result + (listValuesMotherGroup != null ? listValuesMotherGroup.hashCode() : 0);
        result = 31 * result + (listValuesFatherGroup != null ? listValuesFatherGroup.hashCode() : 0);
        result = 31 * result + (listValuesChild != null ? listValuesChild.hashCode() : 0);
        result = 31 * result + (dateBirth != null ? dateBirth.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_calving", referencedColumnName = "id", nullable = false)
    public DocAnimalCalvingEntity getDocAnimalCalvingByIdAnimalCalving() {
        return docAnimalCalvingByIdAnimalCalving;
    }

    public void setDocAnimalCalvingByIdAnimalCalving(DocAnimalCalvingEntity docAnimalCalvingByIdAnimalCalving) {
        this.docAnimalCalvingByIdAnimalCalving = docAnimalCalvingByIdAnimalCalving;
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
    @JoinColumn(name = "id_animal_father_group", referencedColumnName = "id", nullable = false)
    public RegAnimalGroupEntity getRegAnimalGroupByIdAnimalFatherGroup() {
        return regAnimalGroupByIdAnimalFatherGroup;
    }

    public void setRegAnimalGroupByIdAnimalFatherGroup(RegAnimalGroupEntity regAnimalGroupByIdAnimalFatherGroup) {
        this.regAnimalGroupByIdAnimalFatherGroup = regAnimalGroupByIdAnimalFatherGroup;
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
