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


import com.Test.Hafidh.Model.ImageModel;
import com.Test.Hafidh.Repository.ImagesRepository;

@RestController
@RequestMapping("image/api/")
public class ImageControlller {

	@Autowired
	private ImagesRepository imRepo;
	
	//get All
		@GetMapping("getAll")
		public List<ImageModel> getAllHafidh(){
			return this.imRepo.findAll();
		}
		
		//get By Id
		
		@GetMapping("/getById/{id}")
		public ResponseEntity<Optional<ImageModel>> getImageById(@PathVariable(value = "id") Long hafidhId){
			Optional<ImageModel> hafidh = imRepo.findById(hafidhId);
			
			if(hafidh==null) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok().body(hafidh);
			}
					
		}
		
		//Save
		@PostMapping("/save")
		public ImageModel createImage(@Validated @RequestBody ImageModel hafidh) {
			return imRepo.save(hafidh);
		}
		
		//update
		@PutMapping("update/{id}")
		public ResponseEntity<ImageModel> updateLog (@PathVariable(value="id") Long id,@Validated @RequestBody ImageModel hafidh){
			Optional<ImageModel> h = imRepo.findById(id);
			if(h==null) {
				return ResponseEntity.notFound().build();
			}else {
				
				imRepo.deleteById(id);
				hafidh.setIdrequestbooking(id);;
				ImageModel hResult=imRepo.save(hafidh);
				return ResponseEntity.ok().body(hResult);
			}

		}
		
		
		//delete
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<ImageModel> deleteLog(@PathVariable(value = "id") Long hafidhId){
			Optional<ImageModel> hafidh = imRepo.findById(hafidhId);
			if(hafidh==null) {
				return ResponseEntity.notFound().build();
			}else {
				imRepo.deleteById(hafidhId);
				return  ResponseEntity.ok().build();
			}
		}
	
}
