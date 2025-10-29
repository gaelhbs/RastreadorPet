package com.senai.rastreadorpet.entities;

import com.senai.rastreadorpet.models.AlertModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
@Setter
public class Geofence {
    private int id;
    private String name;
    private float area;
    private boolean active;
    private int userId;
    private List<AlertModel> alerts = new ArrayList<>();
}
