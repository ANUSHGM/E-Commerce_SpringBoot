package ecommerceapp.service;

import org.springframework.http.ResponseEntity;

public interface BillingService {

	public ResponseEntity<String> GenerateBill();

}
