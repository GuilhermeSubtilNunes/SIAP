package br.com.senacrs.entidades;

import javax.persistence.*;

@Entity
@Table(name = "doencas", schema = "healthsys", catalog = "")
public class Doenca {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "cid")
    private String cid;

    @Basic
    @Column(name = "nome")
    private String nome;

    @Basic
    @Column(name = "sintoma")
    private String sintoma;
    
    @Basic
    @Column(name = "causa")
    private String causa;
    
    @Basic
    @Column(name = "tratamento")
    private String tratamento;
    
    @Basic
    @Column(name = "patologia")
    private String patologia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }
    
    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }
    
    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }
    
    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doenca doenca = (Doenca) o;

        if (id != doenca.id) return false;
        if (cid != null ? !cid.equals(doenca.cid) : doenca.cid != null) return false;
        if (nome != null ? !nome.equals(doenca.nome) : doenca.nome != null) return false;
        if (sintoma != null ? !sintoma.equals(doenca.sintoma) : doenca.sintoma != null) return false;
        if (causa != null ? !causa.equals(doenca.causa) : doenca.causa != null) return false;
        if (tratamento != null ? !tratamento.equals(doenca.tratamento) : doenca.tratamento != null) return false;
        if (patologia != null ? !patologia.equals(doenca.patologia) : doenca.patologia != null) return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (sintoma != null ? sintoma.hashCode() : 0);
        result = 31 * result + (causa != null ? causa.hashCode() : 0);
        result = 31 * result + (tratamento != null ? tratamento.hashCode() : 0);
        result = 31 * result + (patologia != null ? patologia.hashCode() : 0);
        return result;
    }
}
