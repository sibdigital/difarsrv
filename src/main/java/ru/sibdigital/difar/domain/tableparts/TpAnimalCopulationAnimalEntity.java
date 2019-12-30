package ru.sibdigital.difar.domain.tableparts;

import ru.sibdigital.difar.domain.document.DocAnimalCopulationEntity;
import ru.sibdigital.difar.domain.register.RegAnimalEntity;

import javax.persistence.*;

@Entity
@Table(name = "tp_animal_copulation_animal", schema = "breed")
public class TpAnimalCopulationAnimalEntity {
    private long idUserCreator;
    private Boolean isDeleted;
    private long number;
    private long id;
    private long idAnimalCopulation;
    private long idAnimalFemale;
    private long idAnimalMale;
    private Object listValuesFemale;
    private Object listValuesMale;
    private DocAnimalCopulationEntity docAnimalCopulationByIdAnimalCopulation;
    private RegAnimalEntity regAnimalByIdAnimalFemale;
    private RegAnimalEntity regAnimalByIdAnimalMale;

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
    @Column(name = "id_animal_copulation", nullable = false)
    public long getIdAnimalCopulation() {
        return idAnimalCopulation;
    }

    public void setIdAnimalCopulation(long idAnimalCopulation) {
        this.idAnimalCopulation = idAnimalCopulation;
    }

    @Basic
    @Column(name = "id_animal_female", nullable = false)
    public long getIdAnimalFemale() {
        return idAnimalFemale;
    }

    public void setIdAnimalFemale(long idAnimalFemale) {
        this.idAnimalFemale = idAnimalFemale;
    }

    @Basic
    @Column(name = "id_animal_male", nullable = false)
    public long getIdAnimalMale() {
        return idAnimalMale;
    }

    public void setIdAnimalMale(long idAnimalMale) {
        this.idAnimalMale = idAnimalMale;
    }

    @Basic
    @Column(name = "list_values_female", nullable = true)
    public Object getListValuesFemale() {
        return listValuesFemale;
    }

    public void setListValuesFemale(Object listValuesFemale) {
        this.listValuesFemale = listValuesFemale;
    }

    @Basic
    @Column(name = "list_values_male", nullable = true)
    public Object getListValuesMale() {
        return listValuesMale;
    }

    public void setListValuesMale(Object listValuesMale) {
        this.listValuesMale = listValuesMale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TpAnimalCopulationAnimalEntity that = (TpAnimalCopulationAnimalEntity) o;

        if (idUserCreator != that.idUserCreator) return false;
        if (number != that.number) return false;
        if (id != that.id) return false;
        if (idAnimalCopulation != that.idAnimalCopulation) return false;
        if (idAnimalFemale != that.idAnimalFemale) return false;
        if (idAnimalMale != that.idAnimalMale) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (listValuesFemale != null ? !listValuesFemale.equals(that.listValuesFemale) : that.listValuesFemale != null)
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
        result = 31 * result + (int) (idAnimalFemale ^ (idAnimalFemale >>> 32));
        result = 31 * result + (int) (idAnimalMale ^ (idAnimalMale >>> 32));
        result = 31 * result + (listValuesFemale != null ? listValuesFemale.hashCode() : 0);
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
    @JoinColumn(name = "id_animal_female", referencedColumnName = "id", nullable = false)
    public RegAnimalEntity getRegAnimalByIdAnimalFemale() {
        return regAnimalByIdAnimalFemale;
    }

    public void setRegAnimalByIdAnimalFemale(RegAnimalEntity regAnimalByIdAnimalFemale) {
        this.regAnimalByIdAnimalFemale = regAnimalByIdAnimalFemale;
    }

    @ManyToOne
    @JoinColumn(name = "id_animal_male", referencedColumnName = "id", nullable = false)
    public RegAnimalEntity getRegAnimalByIdAnimalMale() {
        return regAnimalByIdAnimalMale;
    }

    public void setRegAnimalByIdAnimalMale(RegAnimalEntity regAnimalByIdAnimalMale) {
        this.regAnimalByIdAnimalMale = regAnimalByIdAnimalMale;
    }
}
