package com.meditrack.medicine;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;
import java.util.*;
@Service
public class MedicineService {
 private final MedicineRepository repo;
 public MedicineService(MedicineRepository repo){this.repo=repo;}
 public List<Medicine> all(String q){
  return (q==null||q.isBlank())?repo.findAll():repo.findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(q,q);
 }
 public Medicine get(Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Medicine not found"));}
 public Medicine create(Medicine m){m.setId(null);return repo.save(m);}
 public Medicine update(Long id,Medicine input){Medicine m=get(id);m.setName(input.getName());m.setCategory(input.getCategory());m.setQuantity(input.getQuantity());m.setReorderLevel(input.getReorderLevel());m.setExpiryDate(input.getExpiryDate());return repo.save(m);}
 public void delete(Long id){repo.delete(get(id));}
 public Medicine adjust(Long id,int change){Medicine m=get(id);int next=m.getQuantity()+change;if(next<0)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Stock cannot be negative");m.setQuantity(next);return repo.save(m);}
 public Map<String,Object> summary(){
  List<Medicine> list=repo.findAll(); LocalDate today=LocalDate.now();
  long low=list.stream().filter(m->m.getQuantity()<=m.getReorderLevel()).count();
  long expiry=list.stream().filter(m->!m.getExpiryDate().isAfter(today.plusDays(30))).count();
  int units=list.stream().mapToInt(Medicine::getQuantity).sum();
  Map<String,Object> out=new LinkedHashMap<>();out.put("totalMedicines",list.size());out.put("totalUnits",units);out.put("lowStock",low);out.put("expiredOrExpiring",expiry);return out;
 }
}
