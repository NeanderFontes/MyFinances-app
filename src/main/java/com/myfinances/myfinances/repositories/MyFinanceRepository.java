package com.myfinances.myfinances.repositories;

import com.myfinances.myfinances.models.MyFinancesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyFinanceRepository extends JpaRepository<MyFinancesModel, Long> {
}
