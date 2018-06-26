package com.dulal.spring_10v2movie;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Movie {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long m_id;

    @NotNull
    @Size (min=5)
    private String m_title;

    @NotNull
    @Min(1900)
    @Max(2018)
    private int m_year;

    @NotNull
    @Size(min=5)
    private String m_desc;

    @NotNull
    @Size(min = 5)
    private String m_genre;


    public long getM_id() {
        return m_id;
    }

    public void setM_id(long m_id) {
        this.m_id = m_id;
    }

    public String getM_title() {
        return m_title;
    }

    public void setM_title(String m_title) {
        this.m_title = m_title;
    }

    public int getM_year() {
        return m_year;
    }

    public void setM_year(int m_year) {
        this.m_year = m_year;
    }

    public String getM_desc() {
        return m_desc;
    }

    public void setM_desc(String m_desc) {
        this.m_desc = m_desc;
    }

    public String getM_genre() {
        return m_genre;
    }

    public void setM_genre(String m_genre) {
        this.m_genre = m_genre;
    }


}
