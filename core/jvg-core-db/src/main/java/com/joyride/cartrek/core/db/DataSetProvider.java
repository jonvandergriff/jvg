package com.joyride.cartrek.core.db;

import java.io.IOException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.IOUtils;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.Resource;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class DataSetProvider implements FactoryBean<IDataSet> {

	@Getter
	@Setter
	private Resource dataLocation;

	public IDataSet getDataSet() {

		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		IDataSet dataSet = null;

		try {
			String data = IOUtils.toString(dataLocation.getInputStream());

			log.debug("test data: " + data);

			// builder.setColumnSensing(true);
			// builder.setCaseSensitiveTableNames(false);
			dataSet = builder.build(IOUtils.toInputStream(data));
		} catch (DataSetException e) {
			log.error("Um...", e);
		} catch (IOException e) {
			log.error("um...", e);
		}

		return dataSet;
	}

	@Override
	public IDataSet getObject() throws Exception {
		return getDataSet();
	}

	@Override
	public Class<?> getObjectType() {
		return IDataSet.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}