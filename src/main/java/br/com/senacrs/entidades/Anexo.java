package br.com.senacrs.entidades;

import javax.persistence.*;

@Entity
@Table(name = "anexos", schema = "healthsys", catalog = "")
public class Anexo {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "filename")
    private String filename;

    @Basic
    @Column(name = "url")
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Anexo anexo = (Anexo) o;

        if (id != anexo.id) return false;
        if (filename != null ? !filename.equals(anexo.filename) : anexo.filename != null) return false;
        if (url != null ? !url.equals(anexo.url) : anexo.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
