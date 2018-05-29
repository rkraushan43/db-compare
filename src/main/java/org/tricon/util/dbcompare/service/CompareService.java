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
		
		//_LOGGER.info("ds1: {}, ds2: {}",ds1,ds2);

		List<ColumnMapping> mappings= mappingRepository.findByRequestId(requestid);
		
		Map<String,RowCombined> allRowsMap=new HashMap<String,RowCombined>();
		RowCombined rc;
		List<RowCombined> filteredList=null;
		for (ColumnMapping mapping : mappings) {
			_LOGGER.info(mapping.toString());
			String q1="select "+mapping.getKey1_name()+ " , "+mapping.getCol1_name()+" from "+ mapping.getTbl1_name();
			String q2="select "+mapping.getKey2_name()+ " , "+mapping.getCol2_name()+" from "+ mapping.getTbl2_name();
			try {
				ResultSet rs1=ds1.getConnection().prepareStatement(q1).executeQuery();
				ResultSet rs2=ds2.getConnection().prepareStatement(q2).executeQuery();
				while(rs1.next()){
					rc=new RowCombined();
					rc.setKey1(rs1.getString(mapping.getKey1_name()));
					rc.setStrValue1(rs1.getString(mapping.getCol1_name()));
					rc.setCol1(mapping.getCol1_name());
					allRowsMap.put(rc.getKey1(), rc);
				}
				while(rs2.next()){
					rc=allRowsMap.get(rs2.getString(mapping.getKey2_name()));
					rc.setKey2(rs2.getString(mapping.getKey2_name()));
					rc.setStrValue2(rs2.getString(mapping.getCol2_name()));
					rc.setCol2(mapping.getCol2_name());
				}
				
				List<RowCombined> allRows=new ArrayList<RowCombined>(allRowsMap.values());
				filteredList=allRows.stream().filter(row -> !row.isMatch()).collect(Collectors.toList());
				for(RowCombined r:filteredList){
					_LOGGER.info(r.toString());
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return filteredList;
	
	
		
	}
}
