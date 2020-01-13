package ru.sibdigital.difar.domain.tableparts;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.sibdigital.difar.domain.document.DocAnimalCopulationEntity;
import ru.sibdigital.difar.domain.register.RegAnimalGroupEntity;

import javax.persistence.*;

@Entity
@Table(name = "tp_animal_copulation_animal_group_female", schema = "breed")
@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
public class TpAnimalCopulationAnimalGroupFemaleEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idAnimalCopulation;
    private long idAnimalFemaleGroup;
    private long idAnimalMale;
    private JsonNode listValuesFemaleGroup;
    private JsonNode listValuesMale;
    private DocAnimalCopulationEntity docAnimalCopulationByIdAnimalCopulation;
    private RegAnimalGroupEntity regAnimalGroupByIdAnimalFemaleGroup;
    private RegAnimalGroupEntity regAnimalGroupByIdAnimalMale;

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
    @Column(name = "id_animal_copulation", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalCopulation() {
        return idAnimalCopulation;
    }

    public void setIdAnimalCopulation(long idAnimalCopulation) {
        this.idAnimalCopulation = idAnimalCopulation;
    }

    @Basic
    @Column(name = "id_animal_female_group", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalFemaleGroup() {
        return idAnimalFemaleGroup;
    }

    public void setIdAnimalFemaleGroup(long idAnimalFemaleGroup) {
        this.idAnimalFemaleGroup = idAnimalFemaleGroup;
    }

    @Basic
    @Column(name = "id_animal_male", nullable = false, insertable = false, updatable = false)
    public long getIdAnimalMale() {
        return idAnimalMale;
    }

    public void setIdAnimalMale(long idAnimalMale) {
        this.idAnimalMale = idAnimalMale;
    }

    @Type(type = "jsonb-node")
    @Column(name = "list_values_female_group", nullable = true)
    public JsonNode getListValuesFemaleGroup() {
        return listValuesFemaleGroup;
    }

    public void setListValuesFemaleGroup(JsonNode listValuesFemaleGroup) {
        this.listValuesFemaleGroup = listValuesFemaleGroup;
    }

    @Type(type = "jsonb-node")
    @Column(name = "list_values_male", nullable = true)
    public JsonNode getListValuesMale() {
        return listValuesMale;
    }

    public void setListValuesMale(JsonNode listValuesMale) {
        this.listValuesMale = listValuesMale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpAnimalCopulationAnimalGroupFemaleEntity that = (TpAnimalCopulationAnimalGroupFemaleEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idAnimalCopulation != that.idAnimalCopulation) return false;
        if (idAnimalFemaleGroup != that.idAnimalFemaleGroup) return false;
        if (idAnimalMale != that.idAnimalMale) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (listValuesFemaleGroup != null ? !listValuesFemaleGroup.equals(that.listValuesFemaleGroup) : that.listValuesFemaleGroup != null)
            return false;
        return listValuesMale != null ? listValuesMale.equals(that.listValuesMale) : that.listValuesMale == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserCreator ^ (idUserCreator >>> 32));
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idAnimalCopulation ^ (idAnimalCopulation >>> 32));
        result = 31 * result + (int) (idAnimalFemaleGroup ^ (idAnimalFemaleGroup >>> 32));
        result = 31 * result + (int) (idAnimalMale ^ (idAnimalMale >>> 32));
        result = 31 * result + (listValuesFemaleGroup != null ? listValuesFemaleGroup.hashCode() : 0);
        result = 31 * result + (listValuesMale != null ? listValuesMale.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_copulation", referencedColumnName = "id", nullable = false)
    public DocAnimalCopulationEntity getDocAnimalCopulationByIdAnimalCopulation() {
        return docAnimalCopulationByIdAnimalCopulation;
    }

    public void setDocAnimalCopulationByIdAnimalCopulation(DocAnimalCopulationEntity docAnimalCopulationByIdAnimalCopulation) {
        this.docAnimalCopulationByIdAnimalCopulation = docAnimalCopulationByIdAnimalCopulation;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_female_group", referencedColumnName = "id", nullable = false)
    public RegAnimalGroupEntity getRegAnimalGroupByIdAnimalFemaleGroup() {
        return regAnimalGroupByIdAnimalFemaleGroup;
    }

    public void setRegAnimalGroupByIdAnimalFemaleGroup(RegAnimalGroupEntity regAnimalGroupByIdAnimalFemaleGroup) {
        this.regAnimalGroupByIdAnimalFemaleGroup = regAnimalGroupByIdAnimalFemaleGroup;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_male", referencedColumnName = "id", nullable = false)
    public RegAnimalGroupEntity getRegAnimalGroupByIdAnimalMale() {
        return regAnimalGroupByIdAnimalMale;
    }

    public void setRegAnimalGroupByIdAnimalMale(RegAnimalGroupEntity regAnimalGroupByIdAnimalMale) {
        this.regAnimalGroupByIdAnimalMale = regAnimalGroupByIdAnimalMale;
    }
}
