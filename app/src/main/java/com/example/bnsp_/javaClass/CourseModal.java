package com.example.bnsp_.javaClass;

public class CourseModal {

    private String keterangan, tanggal,status;
    private Integer nominal;

    public CourseModal( String tanggal, Integer nominal, String keterangan, String status) {
        this.status = status;
        this.nominal = nominal;
        this.keterangan = keterangan;
        this.tanggal = tanggal;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String  status) {
        this.status = status;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
