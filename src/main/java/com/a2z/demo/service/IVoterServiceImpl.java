package com.a2z.demo.service;

import com.a2z.demo.controller.Voter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class IVoterServiceImpl implements IVoterService
{
List<Voter> voterList=new ArrayList<>();
    @Override
    public Voter getVoter(Integer id) {
        Optional<Voter> voterOptional=voterList.stream()
                .filter(vot->vot.getId().equals(id))
                .findFirst();
        if(voterOptional.isPresent())
        {
            return voterOptional.get();
        }
        else {
            throw new RuntimeException("Voter not found with given id "+id);
        }
    }

    @Override
    public List<Voter> getAllVoters() {
        return voterList ;
    }

    @Override
    public String createVoter(Voter voter) {
       voterList.add(voter);
       return "voter created successfully";
    }

    @Override
    public String updateVoter(Integer id, Voter updatedVoterDetails) {
        Optional<Voter> voterOptional=voterList.stream()
                .filter(vot->vot.getId().equals(id))
                .findFirst();
        if(voterOptional.isPresent()) {
            Voter updatedVoter = voterOptional.get();
            updatedVoter.setId(updatedVoterDetails.getId());
            updatedVoter.setName(updatedVoterDetails.getName());
            updatedVoter.setAge(updatedVoterDetails.getAge());
            updatedVoter.setGender(updatedVoterDetails.getGender());
            updatedVoter.setParty(updatedVoterDetails.getParty());

            return "voter updated successfully "+updatedVoter;
    }
        else {
            throw new RuntimeException("voter not found with id "+id);
        }
    }

    @Override
    public String deleteVoter(Integer id)
    {
           Optional<Voter> voterOptional= voterList.stream()
                    .filter(vot->vot.getId().equals(id))
                    .findFirst();
            voterList.remove(voterOptional.get());
            return "voter deleted successfully";
    }
}