package br.com.senacrs.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios", schema = "healthsys", catalog = "")
public class UsuarioPublico extends UsuarioBase {

    @Override
    @JsonIgnore
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    @JsonIgnore
    public String getSenha() {
        return super.getSenha();
    }

    @Override
    @JsonIgnore
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    @JsonIgnore
    public TipoSanguineo getTipoSanguineo() {
        return super.getTipoSanguineo();
    }

    @Override
    @JsonIgnore
    public String getTelefone() {
        return super.getTelefone();
    }

    @Override
    @JsonIgnore
    public String getEstado() {
        return super.getEstado();
    }

    @Override
    @JsonIgnore
    public String getCidade() {
        return super.getCidade();
    }

    @Override
    @JsonIgnore
    public String getCep() {
        return super.getCep();
    }

    @Override
    @JsonIgnore
    public String getObservacoes() {
        return super.getObservacoes();
    }
}
