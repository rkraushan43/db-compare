package org.tricon.util.dbcompare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tricon.util.dbcompare.models.ColumnMapping;
import org.tricon.util.dbcompare.models.Connections;

@Repository
public interface ColumnMappingRepository extends JpaRepository<ColumnMapping, Long> {

	List<ColumnMapping> findByRequestId(Long requestId);
	
}
