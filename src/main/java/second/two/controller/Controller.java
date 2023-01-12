package second.two.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import second.two.entity.student;
import second.two.repo.Repo;

@RestController
@RequestMapping
public class Controller {
	@Autowired
	Repo repo;
	@GetMapping("/showdata")
	public ResponseEntity<List<student> >getstudent() {
		return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
		
		
	}
	@GetMapping("/showdata/{id}")
	public ResponseEntity<student> getstudent(@PathVariable long id) {
		Optional <student>student=repo.findById(id);
		if(student.isPresent()) {
			return new ResponseEntity<>(student.get(),HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addstudent")
	public ResponseEntity<student> addstudent(@RequestBody student student) {
		return new ResponseEntity<>(repo.save(student),HttpStatus.CREATED);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<student> editstudent(@PathVariable long id, @RequestBody student stud ) {
		Optional <student>student=repo.findById(id);
		if(student.isPresent()) {
			
			student.get().setAddress(stud.getAddress());
			student.get().setName(stud.getName());
			student.get().setEmail(stud.getEmail());
			return new ResponseEntity<>(repo.save(student.get()),HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
}

