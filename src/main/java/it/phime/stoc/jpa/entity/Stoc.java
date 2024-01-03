package it.phime.stoc.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "STOC")
public class Stoc {
    @Id
    @Column(name = "IDM", nullable = false)
    private Integer idm;

    @Id
    @Column(name = "PROD_ID", length = 50, nullable = false)
    private String prodId;

    @Column(name = "PRODSTOC", precision = 8, scale = 3, nullable = false)
    private Double prodStoc;

    @Column(name = "GESTIUNE_ID", nullable = false)
    private Integer gestiuneId;

    @Column(name = "DENUMIRE", length = 250, nullable = false)
    private String denumire;

    @Column(name = "BARCODE", length = 200, nullable = false)
    private String barcode;

    @Column(name = "VALINV", precision = 8, scale = 4, nullable = false)
    private Double valinv;
}
