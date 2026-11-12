package com.meditrack.medicine;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api")
public class MedicineController {
 private final MedicineService service;
 public MedicineController(MedicineService service){this.service=service;}
 @GetMapping("/medicines") public List<Medicine> all(@RequestParam(required=false) String q){return service.all(q);}
 @GetMapping("/medicines/{id}") public Medicine get(@PathVariable Long id){return service.get(id);}
 @PostMapping("/medicines") @ResponseStatus(HttpStatus.CREATED) public Medicine create(@Valid @RequestBody Medicine m){return service.create(m);}
 @PutMapping("/medicines/{id}") public Medicine update(@PathVariable Long id,@Valid @RequestBody Medicine m){return service.update(id,m);}
 @DeleteMapping("/medicines/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.delete(id);}
 @PatchMapping("/medicines/{id}/stock") public Medicine stock(@PathVariable Long id,@RequestParam int change){return service.adjust(id,change);}
 @GetMapping("/dashboard") public Map<String,Object> dashboard(){return service.summary();}
}
