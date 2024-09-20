package com.a2z.demo.controller;
import com.a2z.demo.model.Bike;
import com.a2z.demo.service.IBikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bikes")
public class BikeController
{
    private final IBikeService iBikeService;

    public BikeController(IBikeService iBikeService) {
        this.iBikeService = iBikeService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Bike> getBike(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iBikeService.getBike(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<Bike>> getAllBikes()
    {
        return ResponseEntity.ok(iBikeService.getAllBikes());
    }

    @PostMapping
    public ResponseEntity<String> createBike(@RequestBody Bike bike)
    {
        return ResponseEntity.ok(iBikeService.createBike(bike));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateBike(@PathVariable Integer id,@RequestBody Bike updatedBikeDetails)
    {
        return ResponseEntity.ok(iBikeService.updateBike(id, updatedBikeDetails));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBike(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iBikeService.deleteBike(id));
    }
}
