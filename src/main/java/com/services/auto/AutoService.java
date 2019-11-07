package com.services.auto;

import com.exception.ResourceNotFoundException;
import com.models.Auto;

import java.util.List;

public interface AutoService {

   List< Auto > getAutos();

   void saveAuto(Auto theAuto) throws ResourceNotFoundException;

  Auto getAuto  (int theId)throws ResourceNotFoundException;

   void deleteAuto (int theId )throws ResourceNotFoundException ;



}