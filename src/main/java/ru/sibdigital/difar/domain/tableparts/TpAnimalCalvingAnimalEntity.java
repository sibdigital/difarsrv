package ru.sibdigital.difar.domain.tableparts;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.document.DocAnimalCalvingEntity;
import ru.sibdigital.difar.domain.register.RegAnimalEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tp_animal_calving_animal", schema = "breed")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class TpAnimalCalvingAnimalEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idAnimalCalving;
    private long idAnimalMother;
    private long idAnimalFather;
    private long idAnimalChild;
    private JsonNode listValuesMother;
    private JsonNode listValuesFather;
    private JsonNode listValuesChild;
    private Timestamp dateBirth;
    private DocAnimalCalvingEntity docAnimalCalvingByIdAnimalCalving;
    private RegAnimalEntity regAnimalByIdAnimalMother;
    private RegAnimalEntity regAnimalByIdAnimalFather;
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
    @Column(name = "id_animal_calving", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalCalving() {
        return idAnimalCalving;
    }

    public void setIdAnimalCalving(long idAnimalCalving) {
        this.idAnimalCalving = idAnimalCalving;
    }

    @Basic
    @Column(name = "id_animal_mother", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalMother() {
        return idAnimalMother;
    }

    public void setIdAnimalMother(long idAnimalMother) {
        this.idAnimalMother = idAnimalMother;
    }

    @Basic
    @Column(name = "id_animal_father", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalFather() {
        return idAnimalFather;
    }

    public void setIdAnimalFather(long idAnimalFather) {
        this.idAnimalFather = idAnimalFather;
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
    @Column(name = "list_values_mother", nullable = true)
    public JsonNode getListValuesMother() {
        return listValuesMother;
    }

    public void setListValuesMother(JsonNode listValuesMother) {
        this.listValuesMother = listValuesMother;
    }

    @Type(type = "jsonb-node")
    @Column(name = "list_values_father", nullable = true)
    public JsonNode getListValuesFather() {
        return listValuesFather;
    }

    public void setListValuesFather(JsonNode listValuesFather) {
        this.listValuesFather = listValuesFather;
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

        TpAnimalCalvingAnimalEntity that = (TpAnimalCalvingAnimalEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idAnimalCalving != that.idAnimalCalving) return false;
        if (idAnimalMother != that.idAnimalMother) return false;
        if (idAnimalFather != that.idAnimalFather) return false;
        if (idAnimalChild != that.idAnimalChild) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (listValuesMother != null ? !listValuesMother.equals(that.listValuesMother) : that.listValuesMother != null)
            return false;
        if (listValuesFather != null ? !listValuesFather.equals(that.listValuesFather) : that.listValuesFather != null)
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
        result = 31 * result + (int) (idAnimalMother ^ (idAnimalMother >>> 32));
        result = 31 * result + (int) (idAnimalFather ^ (idAnimalFather >>> 32));
        result = 31 * result + (int) (idAnimalChild ^ (idAnimalChild >>> 32));
        result = 31 * result + (listValuesMother != null ? listValuesMother.hashCode() : 0);
        result = 31 * result + (listValuesFather != null ? listValuesFather.hashCode() : 0);
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
    @JoinColumn(name = "id_animal_mother", referencedColumnName = "id", nullable = false)
    public RegAnimalEntity getRegAnimalByIdAnimalMother() {
        return regAnimalByIdAnimalMother;
    }

    public void setRegAnimalByIdAnimalMother(RegAnimalEntity regAnimalByIdAnimalMother) {
        this.regAnimalByIdAnimalMother = regAnimalByIdAnimalMother;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_father", referencedColumnName = "id", nullable = false)
    public RegAnimalEntity getRegAnimalByIdAnimalFather() {
        return regAnimalByIdAnimalFather;
    }

    public void setRegAnimalByIdAnimalFather(RegAnimalEntity regAnimalByIdAnimalFather) {
        this.regAnimalByIdAnimalFather = regAnimalByIdAnimalFather;
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
