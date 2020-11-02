package com.Test.Hafidh.Controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Test.Hafidh.Model.HafidhModel;
import com.Test.Hafidh.Repository.HafidhRepository;


@RestController
@RequestMapping("hafidh/api/")
public class HafidhController {
	
	@Autowired
	private HafidhRepository hafidhRep;
	
	//get All
	@GetMapping("getAll")
	public List<HafidhModel> getAllHafidh(){
		return this.hafidhRep.findAll();
	}
	
	//get By Id
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Optional<HafidhModel>> getHafidhById(@PathVariable(value = "id") Long hafidhId){
		Optional<HafidhModel> hafidh = hafidhRep.findById(hafidhId);
		
		if(hafidh==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(hafidh);
		}
				
	}
	
	//Save
	@PostMapping("/save")
	public HafidhModel createHafidh(@Validated @RequestBody HafidhModel hafidh) {
		return hafidhRep.save(hafidh);
	}
	
	//update
	@PutMapping("update/{id}")
	public ResponseEntity<HafidhModel> updateLog (@PathVariable(value="id") Long id,@Validated @RequestBody HafidhModel hafidh){
		Optional<HafidhModel> h = hafidhRep.findById(id);
		if(h==null) {
			return ResponseEntity.notFound().build();
		}else {
			
			hafidhRep.deleteById(id);
			hafidh.setIdRequestBooking(id);
			HafidhModel hResult=hafidhRep.save(hafidh);
			return ResponseEntity.ok().body(hResult);
		}

	}
	
	
	//delete
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HafidhModel> deleteLog(@PathVariable(value = "id") Long hafidhId){
		Optional<HafidhModel> hafidh = hafidhRep.findById(hafidhId);
		if(hafidh==null) {
			return ResponseEntity.notFound().build();
		}else {
			hafidhRep.deleteById(hafidhId);
			return  ResponseEntity.ok().build();
		}
	}

}
