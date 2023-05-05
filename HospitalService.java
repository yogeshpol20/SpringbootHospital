package com.jsp.springboothospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboothospital.dao.HospitalDao;
import com.jsp.springboothospital.dto.Hospital;
import com.jsp.springboothospital.exception.HospitalIdNotFoundException;
import com.jsp.springbootuser.dto.User;
import com.jsp.springbootuser.util.ResponseStructure;

@Service
public class HospitalService 
{
	@Autowired
	private HospitalDao dao;
	
	public ResponseStructure<Hospital> saveHospital(Hospital hospital)
	{
		Hospital hospital2= dao.saveHospital(hospital);
		if(hospital2!=null)
		{
			ResponseStructure<Hospital> structure = new ResponseStructure<Hospital>();
			structure.setMessage("Hospital saved successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(hospital2);
			return structure;
					
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Hospital>>findHospitalById(int id)
	{
		Hospital hospital=dao.findHospitalById(id);
		if(hospital!=null)
		{
			ResponseStructure<Hospital> structure=new ResponseStructure<Hospital>();
			structure.setMessage("Hospital fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.FOUND);
		}
		else
		{
		//return null;
		throw new HospitalIdNotFoundException("failed to fetch the hospital !");
		}
	}
	

}
