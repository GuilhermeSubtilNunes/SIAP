package br.com.senacrs.entidades;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "acesso_atendimentos", schema = "healthsys", catalog = "")
public class AcessoAtendimento {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "codigo")
    private String codigo;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

        AcessoAtendimento that = (AcessoAtendimento) o;

        if (id != that.id) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (dataFim != null ? !dataFim.equals(that.dataFim) : that.dataFim != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (dataFim != null ? dataFim.hashCode() : 0);
        return result;
    }
}
