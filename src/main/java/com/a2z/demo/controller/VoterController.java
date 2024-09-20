package com.a2z.demo.controller;
import com.a2z.demo.service.IVoterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("voters")

public class VoterController
{
    private final IVoterService iVoterService;

    public VoterController(IVoterService iVoterService) {
        this.iVoterService = iVoterService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Voter> getVoter(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iVoterService.getVoter(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<Voter>> getAllVoters()
    {
        return ResponseEntity.ok(iVoterService.getAllVoters());
    }

    @PostMapping
    public ResponseEntity<String> createVoter(@RequestBody Voter voter)
    {
        return ResponseEntity.ok(iVoterService.createVoter(voter));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateVoter(@PathVariable Integer id,@RequestBody Voter updatedVoterDetails)
    {
        return ResponseEntity.ok(iVoterService.updateVoter(id,updatedVoterDetails));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVoter(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iVoterService.deleteVoter(id));
    }

}
