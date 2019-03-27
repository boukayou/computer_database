
package com.excilys.boukayou.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.excilys.boukayou.modele.Company;

public interface CompanyDaoJpa extends PagingAndSortingRepository<Company, Long> {

}
