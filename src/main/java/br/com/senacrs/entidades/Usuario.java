package br.com.senacrs.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios", schema = "healthsys", catalog = "")
public class Usuario extends UsuarioBase {

}
