package com.rendyrobbani.keuangan.presentation.web.master;

import com.rendyrobbani.keuangan.application.web.record.master.fungsi.WebMasterFungsiCreateRequestRecord;
import com.rendyrobbani.keuangan.application.web.record.master.fungsi.WebMasterFungsiUpdateRequestRecord;
import com.rendyrobbani.keuangan.domain.auth.WebAuthorizationService;
import com.rendyrobbani.keuangan.domain.model.vo.Role;
import com.rendyrobbani.keuangan.domain.port.incoming.web.master.fungsi.*;
import com.rendyrobbani.keuangan.presentation.web.WebResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class WebMasterFungsiController {

	private final WebResponse response;

	private final WebAuthorizationService authorizationService;

	private final WebMasterFungsiSelectService selectService;

	private final WebMasterFungsiCreateService createService;

	private final WebMasterFungsiUpdateService updateService;

	private final WebMasterFungsiDeleteService deleteService;

	private final WebMasterFungsiLockedService lockedService;

	@GetMapping("/web/master/fungsi")
	public ResponseEntity<?> selectAll() {
		authorizationService.hasInRole(Role.SEKDA, Role.PPKD, Role.TAPD);
		return response.success(selectService.selectAll());
	}

	@GetMapping("/web/master/fungsi/{id}")
	public ResponseEntity<?> selectById(@PathVariable String id) {
		authorizationService.hasInRole(Role.SEKDA, Role.PPKD, Role.TAPD);
		return response.success(selectService.selectById(id));
	}

	@PostMapping("/web/master/fungsi")
	public ResponseEntity<?> create(@RequestBody WebMasterFungsiCreateRequestRecord request) {
		authorizationService.hasInRole(Role.PPKD);
		return response.success(createService.create(request));
	}

	@PutMapping("/web/master/fungsi/{id}")
	public ResponseEntity<?> update(@PathVariable String id,
	                                @RequestBody WebMasterFungsiUpdateRequestRecord request) {
		authorizationService.hasInRole(Role.PPKD);
		return response.success(updateService.update(id, request));
	}

	@DeleteMapping("/web/master/fungsi/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		authorizationService.hasInRole(Role.PPKD);
		return response.success(deleteService.delete(id));
	}

	@PostMapping("/web/master/fungsi/{id}")
	public ResponseEntity<?> restore(@PathVariable String id) {
		authorizationService.hasInRole();
		return response.success(deleteService.restore(id));
	}

	@PatchMapping("/web/master/fungsi/{id}/lock")
	public ResponseEntity<?> lock(@PathVariable String id) {
		authorizationService.hasInRole(Role.PPKD);
		return response.success(lockedService.lock(id));
	}

	@PatchMapping("/web/master/fungsi/{id}/unlock")
	public ResponseEntity<?> unlock(@PathVariable String id) {
		authorizationService.hasInRole(Role.PPKD);
		return response.success(lockedService.unlock(id));
	}

}