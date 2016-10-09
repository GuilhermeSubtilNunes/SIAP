package br.com.senacrs.entidades;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "doencas_pacientes", schema = "healthsys", catalog = "")
public class DoencasPacientes {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "paciente_id")
    private int pacienteId;

    @Basic
    @Column(name = "data_inicio")
    private Date dataInicio;

    @Basic
    @Column(name = "data_fim")
    private Date dataFim;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoencasPacientes that = (DoencasPacientes) o;

        if (id != that.id) return false;
        if (pacienteId != that.pacienteId) return false;
        if (dataInicio != null ? !dataInicio.equals(that.dataInicio) : that.dataInicio != null) return false;
        if (dataFim != null ? !dataFim.equals(that.dataFim) : that.dataFim != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pacienteId;
        result = 31 * result + (dataInicio != null ? dataInicio.hashCode() : 0);
        result = 31 * result + (dataFim != null ? dataFim.hashCode() : 0);
        return result;
    }
}
