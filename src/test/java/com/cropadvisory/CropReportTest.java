package com.cropadvisory;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CropReportTest {

    @Test
    void testCropReportConstructor() {

        LocalDateTime date = LocalDateTime.now();

        CropReport report = new CropReport(
                "tomato-leaf.jpg",
                date
        );

        assertEquals("tomato-leaf.jpg", report.getImageName());
        assertEquals(date, report.getUploadedAt());
    }

    @Test
    void testCropReportSetters() {

        CropReport report = new CropReport();

        LocalDateTime date = LocalDateTime.now();

        report.setImageName("potato-leaf.jpg");
        report.setUploadedAt(date);

        assertEquals("potato-leaf.jpg", report.getImageName());
        assertEquals(date, report.getUploadedAt());
    }
}