package com.a2z.demo.service;

import com.a2z.demo.controller.Voter;
import java.util.*;
public interface IVoterService
{
    Voter getVoter(Integer id);
    List<Voter> getAllVoters();
    String createVoter(Voter voter);
    String updateVoter(Integer id,Voter updatedVoterDetails);
    String deleteVoter(Integer id);

}
