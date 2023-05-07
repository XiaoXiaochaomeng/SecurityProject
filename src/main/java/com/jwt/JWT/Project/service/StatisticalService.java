package com.jwt.JWT.Project.service;

import com.jwt.JWT.Project.dto.StatisticalForMonthProjections;
import com.jwt.JWT.Project.dto.StatisticalForProductProjections;
import com.jwt.JWT.Project.dto.StatisticalForYearProjections;
import com.jwt.JWT.Project.entity.Statitics;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatisticalService {

	Statitics SLOrder();

	List<StatisticalForProductProjections> statisticalForProduct();

	List<StatisticalForYearProjections> statisticalForYear();

	List<StatisticalForMonthProjections> statisticalForMonth();

}
