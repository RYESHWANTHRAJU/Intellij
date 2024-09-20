package com.a2z.demo.service;

import com.a2z.demo.model.Bike;

import java.util.List;

public interface IBikeService
{
    Bike getBike(Integer id);
    List<Bike> getAllBikes();
    String createBike(Bike bike);
    String updateBike(Integer id,Bike updatedBikeDetails);
    String deleteBike(Integer id);
}
