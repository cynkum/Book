package com.example.book.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import javax.persistence.*;

@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idBuku;
    private String judulBuku;
    private String penerbit;
    private String tahunTerbit;

    public Book(){

    }
    public Book(String idBuku, String judulBuku, String penerbit, String tahunTerbit){
        super();
        this.idBuku=idBuku;
        this.judulBuku=judulBuku;
        this.penerbit=penerbit;
        this.tahunTerbit=tahunTerbit;
    }

    public String getIdBuku() { return idBuku; }
    public void setIdBuku(String idBuku) { this.idBuku = idBuku; }

    public String getJudulBuku() { return judulBuku; }
    public void setJudulBuku(String judulBuku) { this.judulBuku = judulBuku; }

    public String getPenerbit() { return penerbit; }
    public void setPenerbit(String penerbit) { this.penerbit = penerbit; }

    public String getTahunTerbit() { return tahunTerbit; }
    public void setTahunTerbit(String tahunTerbit) { this.tahunTerbit = tahunTerbit; }

}
