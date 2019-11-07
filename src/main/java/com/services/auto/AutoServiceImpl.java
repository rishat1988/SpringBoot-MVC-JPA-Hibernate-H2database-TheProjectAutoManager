package com.services.auto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.models.Auto;
import com.repositories.AutoRepository;

@Service
public class AutoServiceImpl implements AutoService {

	@Autowired
	private AutoRepository autoRepository;

	@Override

	public List<Auto> getAutos() {
		return autoRepository.findAll();
	}

	@Override

	public void saveAuto(Auto theAuto) {

		autoRepository.save(theAuto);
	}

	@Override

	public Auto getAuto(int id) throws ResourceNotFoundException {
		return autoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

	}

	@Override

	public void deleteAuto(int theId) {
		autoRepository.deleteById(theId);
	}
}