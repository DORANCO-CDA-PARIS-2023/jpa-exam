package com.doranco.interfaces;

import com.doranco.entity.Chambres;

public interface Ichambres extends Icrud<Chambres> {
    public Chambres findByNumero(int numero);

    public Chambres[] findByType(String type);

    public Chambres[] findByPrix(double prix);
}
