package org.tricon.util.dbcompare.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tricon.util.dbcompare.connectionmanager.Connect;
import org.tricon.util.dbcompare.dao.ColumnMappingRepository;
import org.tricon.util.dbcompare.dao.ConnectionsRepository;
import org.tricon.util.dbcompare.models.ColumnMapping;
import org.tricon.util.dbcompare.models.Connections;
import org.tricon.util.dbcompare.models.RowCombined;

@Service
public class CompareService {

	private final Logger					_LOGGER	= LoggerFactory.getLogger(CompareService.class);
	
	@Autowired
	private ConnectionsRepository conRepository;
	
	@Autowired
	private ColumnMappingRepository  mappingRepository;
	
	@Autowired
	private Connect connect;

	
	public List<RowCombined> compare(Long requestid){
	
		_LOGGER.debug("Inside method CompareService.compare. Starting DB compare for request id:{}",requestid);
		
		Connections con= conRepository.findByRequestId(requestid).get(0);
		
		DataSource ds1	=connect.getDataSource(con.getDb1_url(), con.getDb1_provider(), con.getDb1_username(), con.getDb1_password());
		
		DataSource ds2	=connect.getDataSource(con.getDb2_url(), con.getDb2_provider(), con.getDb2_username(), con.getDb2_password());
		
		List<ColumnMapping> mappings= mappingRepository.findByRequestId(requestid);
		
		Map<String,RowCombined> allRowsMap=null;
		List<RowCombined> filteredList=new ArrayList<RowCombined>();
		for (ColumnMapping mapping : mappings) {
			_LOGGER.debug(mapping.toString());
			String q1="select "+mapping.getKey1_name()+ " , "+mapping.getCol1_name()+" from "+ mapping.getTbl1_name();
			String q2="select "+mapping.getKey2_name()+ " , "+mapping.getCol2_name()+" from "+ mapping.getTbl2_name();
			try {
				allRowsMap=new HashMap<String,RowCombined>();
				ResultSet rs1=ds1.getConnection().prepareStatement(q1).executeQuery();
				ResultSet rs2=ds2.getConnection().prepareStatement(q2).executeQuery();
				populateRowMapping(rs1, rs2, mapping, allRowsMap);
				List<RowCombined> allRows=new ArrayList<RowCombined>(allRowsMap.values());
				filteredList.addAll(allRows.parallelStream().filter(row -> !row.isMatch()).collect(Collectors.toList()));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return filteredList;
	}
	private void populateRowMapping(ResultSet rs1,ResultSet rs2,ColumnMapping mapping,Map<String,RowCombined> allRowsMap) throws SQLException{
		RowCombined rc=null;
		while(rs1.next()){
			rc=new RowCombined();
			rc.setTbl1(mapping.getTbl1_name());
			rc.setTbl2(mapping.getTbl2_name());
			rc.setKey1(rs1.getString(mapping.getKey1_name()));
			rc.setCol1(mapping.getCol1_name());
			rc.setValue1(getValue(rs1, mapping.getCol1_name(),mapping.getCol1_type()));
			allRowsMap.put(rc.getKey1(), rc);
		}
		while(rs2.next()){
			rc=allRowsMap.get(rs2.getString(mapping.getKey2_name()));
			rc.setKey2(rs2.getString(mapping.getKey2_name()));
			rc.setValue2(getValue(rs2, mapping.getCol2_name(),mapping.getCol2_type()));
			rc.setCol2(mapping.getCol2_name());
		}
	}
	private Object getValue(ResultSet rs,String fieldName,String fieldType)  throws SQLException{
		Object o=null;
		switch(fieldType.toLowerCase()){
		case "string":
			o=rs.getString(fieldName);
			break;
		case "integer":
			o=rs.getInt(fieldName);
			break;
		case "boolean":
			o=rs.getBoolean(fieldName);
			break;
		case "date":
			o=rs.getDate(fieldName);
			break;
		case "object":
			o=rs.getObject(fieldName);
			break;
		default :
			o=rs.getObject(fieldName);
			break;
		}
		return o;
	}
}
