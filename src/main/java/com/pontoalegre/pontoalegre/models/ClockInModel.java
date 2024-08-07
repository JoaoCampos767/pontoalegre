package com.pontoalegre.pontoalegre.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "TB_CLOCK")
public class ClockInModel extends RepresentationModel<ClockInModel> implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idClock;
    private UUID idUser;
    private Date dtClock;
    private String entryOrExit;

    public UUID getIdClock() {
        return idClock;
    }

    public void setIdClock(UUID idClock) {
        this.idClock = idClock;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public Date getDtClock() {
        return dtClock;
    }

    public void setDtClock(Date dtClock) {
        this.dtClock = dtClock;
    }

    public String getEntryOrExit() {
        return entryOrExit;
    }

    public void setEntryOrExit(String entryOrExit) {
        this.entryOrExit = entryOrExit;
    }
}
