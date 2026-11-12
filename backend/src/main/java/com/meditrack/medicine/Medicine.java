package com.meditrack.medicine;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
@Entity
@Table(name="medicines")
public class Medicine {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false) private String name;
 private String category;
 @Min(0) @Column(nullable=false) private int quantity;
 @Min(0) @Column(name="reorder_level",nullable=false) private int reorderLevel;
 @NotNull @Column(name="expiry_date",nullable=false) private LocalDate expiryDate;
 public Medicine() {}
 public Medicine(String name,String category,int quantity,int reorderLevel,LocalDate expiryDate) {
  this.name=name; this.category=category; this.quantity=quantity; this.reorderLevel=reorderLevel; this.expiryDate=expiryDate;
 }
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getName(){return name;} public void setName(String name){this.name=name;}
 public String getCategory(){return category;} public void setCategory(String category){this.category=category;}
 public int getQuantity(){return quantity;} public void setQuantity(int quantity){this.quantity=quantity;}
 public int getReorderLevel(){return reorderLevel;} public void setReorderLevel(int reorderLevel){this.reorderLevel=reorderLevel;}
 public LocalDate getExpiryDate(){return expiryDate;} public void setExpiryDate(LocalDate expiryDate){this.expiryDate=expiryDate;}
}
