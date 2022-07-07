package com.jb.couponsphase3.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "coupons", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"company_id", "title"})})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Company company;

    //    @ManyToOne
//    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Category category;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false, length = 50)
    private String description;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String image;

}
