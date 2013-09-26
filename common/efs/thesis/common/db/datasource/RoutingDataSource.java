package efs.thesis.common.db.datasource;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author Edward Fernando
 * @project Thesis Project, 2013
 */


public class RoutingDataSource extends AbstractRoutingDataSource {

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}
	
	@Override
	protected Object determineCurrentLookupKey() {
		return null;
	}

}
