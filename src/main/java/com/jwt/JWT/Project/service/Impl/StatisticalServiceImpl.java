package com.jwt.JWT.Project.service.Impl;

import com.jwt.JWT.Project.dto.StatisticalForMonthProjections;
import com.jwt.JWT.Project.dto.StatisticalForProductProjections;
import com.jwt.JWT.Project.dto.StatisticalForYearProjections;
import com.jwt.JWT.Project.entity.Statitics;
import com.jwt.JWT.Project.repository.StatiticDAO;
import com.jwt.JWT.Project.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticalServiceImpl implements StatisticalService {

	@Autowired
	StatiticDAO sdao;

	@Override
	public Statitics SLOrder() {
		return sdao.SLOrder();
	}

	@Override
	public List<StatisticalForMonthProjections> statisticalForMonth() {
		return sdao.statisticalForMonth();
	}

	@Override
	public List<StatisticalForYearProjections> statisticalForYear() {
		return sdao.statisticalForYear();
	}

	@Override
	public List<StatisticalForProductProjections> statisticalForProduct() {
		return sdao.statisticalForProduct();
	}	
}
