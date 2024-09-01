package com.example.school_service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.school_service.model.School;
import com.example.school_service.service.SchoolService;

@CrossOrigin("*")
@RequestMapping(value = "/school")
@RestController
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public School addSchool(@RequestBody School school){
        return schoolService.addSchool(school);
    }
    
 		@PutMapping("/{id}")
 		public ResponseEntity<School> updateSchool(@PathVariable int id, @RequestBody School schoolDetails){
 			School school = schoolService.fetchSchoolById(id);
 			school.setSchoolName(schoolDetails.getSchoolName());
 			school.setLocation(schoolDetails.getLocation());
 			school.setPrincipalName(schoolDetails.getPrincipalName());
 			
 			School updatedSchool = schoolService.addSchool(school);
 			return ResponseEntity.ok(updatedSchool);
 		}
 		
    @GetMapping
    public List<School> fetchSchools(){
        return  schoolService.fetchSchools();
    }
    @GetMapping("/{id}")
    public School fetchSchoolById(@PathVariable int id){
        return schoolService.fetchSchoolById(id);
    }
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSchool(@PathVariable int id){
		School school = schoolService.fetchSchoolById(id);
		schoolService.deleteSchool(school);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
