package com.biswa.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.biswa.entity.Employee;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Integer> {
	@Query(value = "select * from emp where id= ?1", nativeQuery = true)
	ArrayList<Employee> getEmployeeData(int id);
	@Query(value = "SELECT x.DATE_OF_TRN, nvl(z.dp_sname,'NA') AS short_name, nvl(z.dp_lname,'NA') AS long_name, x.pl_no, nvl(y.des,'NA') AS description, x.stock AS quantity, x.stock_value FROM immis.mmm_stock x, immis.mmm_item y, immis.mgm_depot z FETCH FIRST 150 ROW ONLY", nativeQuery = true)
	LinkedList<StockDetails> getStockDetails();

	/*
	 * @Procedure(name = "EMP_PROC") List<Employee> employeeDetails(@Param("E_ID")
	 * int E_ID);
	 */
	public static interface StockDetails{
		String getShort_name();
		String getLong_name();
		String getPl_no();
		String getDescription();
		String getQuantity();
		String getStock_value();
		String getDate_Of_Trn();
	}
}
