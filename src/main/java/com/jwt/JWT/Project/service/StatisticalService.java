package com.jwt.JWT.Project.service;

import com.websiteshop.entity.Statitics;
import com.websiteshop.model.StatisticalForMonthProjections;
import com.websiteshop.model.StatisticalForProductProjections;
import com.websiteshop.model.StatisticalForYearProjections;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatisticalService {

	Statitics SLOrder();

	List<StatisticalForProductProjections> statisticalForProduct();

	List<StatisticalForYearProjections> statisticalForYear();

	List<StatisticalForMonthProjections> statisticalForMonth();

}
