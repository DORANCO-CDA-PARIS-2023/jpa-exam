package com.doranco.service;


import com.doranco.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static java.lang.Math.E;

@Service

public class ReservationService  {

    public List<Reservation> findAll() {
        List<Reservation> list1= new ArrayList<>();
        return list1;
}}
