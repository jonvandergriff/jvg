package com.joyride.cartrek.core.db;

import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;

import lombok.extern.slf4j.Slf4j;

/**
 * Initializes the default data for the Car Trek application
 * 
 * @author Jon Vandergriff
 * 
 */
@Slf4j
public class TestDataManager {

	public TestDataManager(DatabaseDataSourceConnection dataSourceConnection,
			IDataSet dataSet) {

		try {
			DatabaseOperation.CLEAN_INSERT.execute(dataSourceConnection,
					dataSet);
		} catch (DatabaseUnitException e) {
			log.error(e.getLocalizedMessage(), e);
		} catch (SQLException e) {
			log.error(e.getLocalizedMessage(), e);
		}
	}

}