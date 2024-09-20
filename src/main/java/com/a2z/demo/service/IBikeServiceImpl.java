package com.a2z.demo.service;

import com.a2z.demo.model.Bike;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IBikeServiceImpl implements IBikeService
{
    List<Bike> bikeList=new ArrayList<>();
    @Override
    public Bike getBike(Integer id) {
        Optional<Bike> bikeOptional=bikeList.stream()
                .filter(b->b.getId().equals(id))
                .findFirst();
        if(bikeOptional.isPresent()) {
            return bikeOptional.get();
        }
        else {
            throw new RuntimeException("Bike not found with given Id :"+id);
        }
    }

    @Override
    public List<Bike> getAllBikes() {
        return bikeList;
    }

    @Override
    public String createBike(Bike bike) {
         bikeList.add(bike);
         return "Bike created successfully";
    }

    @Override
    public String updateBike(Integer id, Bike updatedBikeDetails) {
        Optional<Bike> bikeOptional = bikeList.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
        if (bikeOptional.isPresent()) {
            Bike updatedBike = bikeOptional.get();
            updatedBike.setId(updatedBikeDetails.getId());
            updatedBike.setModel(updatedBikeDetails.getModel());
            updatedBike.setCompany(updatedBikeDetails.getCompany());
            updatedBike.setCubiccentimeter(updatedBikeDetails.getCubiccentimeter());
            updatedBike.setMileage(updatedBikeDetails.getMileage());
            updatedBike.setPrice(updatedBikeDetails.getPrice());
            return "Bike updated successfully " + updatedBike;
        } else {
            throw new RuntimeException("Bike not found with the give Id :" + id);
        }
    }
    @Override
    public String deleteBike(Integer id) {
        Optional<Bike> bikeOptional=bikeList.stream()
                .filter(b->b.getId().equals(id))
                .findFirst();
        Bike bike1=bikeOptional.get();
        bikeList.remove(bike1);
        return "Bike deleted successfully";
    }
}
