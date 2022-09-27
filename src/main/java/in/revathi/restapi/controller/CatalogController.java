package in.revathi.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.revathi.restapi.dao.CatalogDAO;
import in.revathi.restapi.model.CatalogModel;
import in.revathi.restapi.service.SequenceGeneratorService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CatalogController {

	@Autowired
	CatalogDAO catalogDAO;
	
	@Autowired
	SequenceGeneratorService seqGeneratorService;
	
	@PostMapping("/create")
	public CatalogModel create(@RequestBody CatalogModel newCatalogObject) {
		newCatalogObject.setId(seqGeneratorService.generateSequence(CatalogModel.SEQUENCE_NAME));
		return catalogDAO.save(newCatalogObject);
	}
	
	@GetMapping("/read")
	public List<CatalogModel> read(){
		return catalogDAO.findAll();
	}
	
	@GetMapping("/read/{id}")
	public CatalogModel read(@PathVariable Long id) {
		Optional<CatalogModel> catalogObj = catalogDAO.findById(id);
		if(catalogObj.isPresent()) {
			return catalogObj.get();
		}else {
			throw new RuntimeException("Catalog not found with id "+id);
		}
	}
	
	@PutMapping("/update")
	public CatalogModel update(@RequestBody CatalogModel modifiedCatalogObject) {
		return catalogDAO.save(modifiedCatalogObject);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		Optional<CatalogModel> catalogObj = catalogDAO.findById(id);
		if(catalogObj.isPresent()) {
			catalogDAO.delete(catalogObj.get());
			return "Catalog deleted with id "+id;
		}else {
			throw new RuntimeException("Catalog not found for id "+id);
		}
	}
	
}
