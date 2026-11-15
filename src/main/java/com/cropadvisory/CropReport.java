
package com.cropadvisory;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "crop_reports")
public class CropReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageName;

    private LocalDateTime uploadedAt;

    public CropReport() {
    }

    public CropReport(String imageName, LocalDateTime uploadedAt) {
        this.imageName = imageName;
        this.uploadedAt = uploadedAt;
    }

    public Long getId() {
        return id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}
