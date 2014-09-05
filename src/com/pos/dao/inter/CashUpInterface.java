package com.pos.dao.inter;

import java.util.List;

import com.pos.model.CashUp;

public interface CashUpInterface {
	public int saveCashUp(CashUp cashup);
	public CashUp getCashUpById(int id);
	public List<CashUp> getAllCashUps();
}
