package com.jwt.JWT.Project.service.Impl;

import com.websiteshop.dao.StatiticDAO;
import com.websiteshop.entity.Statitics;
import com.websiteshop.model.StatisticalForMonthProjections;
import com.websiteshop.model.StatisticalForProductProjections;
import com.websiteshop.model.StatisticalForYearProjections;
import com.websiteshop.service.StatisticalService;
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
