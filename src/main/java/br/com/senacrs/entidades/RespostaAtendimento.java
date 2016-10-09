package br.com.senacrs.entidades;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "respostas_atendimentos", schema = "healthsys", catalog = "")
public class RespostaAtendimento {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /*@Basic
    @Column(name = "data_resposta")
    private Timestamp data_resposta;*/

    @Basic
    @Column(name = "titulo")
    private String titulo;

    @Basic
    @Column(name = "descricao")
    private String descricao;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "atendimento_id", nullable = false)
    private Atendimento atendimento;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioPublico usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public Timestamp getData_resposta() {
        return data_resposta;
    }

    public void setData_resposta(Timestamp data_resposta) {
        this.data_resposta = data_resposta;
    }*/

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public UsuarioPublico getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioPublico usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RespostaAtendimento that = (RespostaAtendimento) o;

        if (id != that.id) return false;
        //if (data_resposta != null ? !data_resposta.equals(that.data_resposta) : that.data_resposta != null) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;
        if (atendimento != null ? !atendimento.equals(that.atendimento) : that.atendimento != null) return false;
        return usuario != null ? usuario.equals(that.usuario) : that.usuario == null;

    }

    @Override
    public int hashCode() {
        int result = id;
       // result = 31 * result + (data_resposta != null ? data_resposta.hashCode() : 0);
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (atendimento != null ? atendimento.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        return result;
    }
}
