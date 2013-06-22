package br.com.testeunitario.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class ServicoDaoImpl {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public ServicoDaoImpl(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	
	public Servico buscarServico(Integer codigoServico, Integer codigoDoProduto){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT s.COD_SERVICO, s.DSC_SERVICO_ABREV ");
		sql.append(" FROM  SDE_SERVICO_CBHPM s");
		sql.append(" INNER JOIN SDE_SERV_PRODUTO_CBHPM sp ON s.COD_SERVICO = sp.COD_SERVICO");
		sql.append(" WHERE ");
		sql.append(" s.COD_SITUACAO_REG in (5,6) ");
		sql.append(" and sysdate BETWEEN s.DAT_INIC_VIGENCIA and s.DAT_FIM_VIGENCIA");
		sql.append(" and sysdate BETWEEN sp.DAT_INIC_VIGENCIA and sp.DAT_FIM_VIGENCIA");
		sql.append(" and sp.COD_PROD = :codProduto ");
		sql.append(" and s.COD_SERVICO = :codServico ");
		
		if(false){
			sql.append(" AND ( s.IDC_ORIGEM_SERV = 'T'							");
			sql.append(" 		OR 	NOT EXISTS(	SELECT	DISTINCT 1				");
			sql.append("							FROM 	sde_conversao_tuss t 	");
			sql.append(" 							WHERE 	s.COD_SERVICO = t.COD_SERVICO_SAS	"); 
			sql.append(" 							AND 	sysdate BETWEEN t.DAT_INIC_VIGENCIA AND t.DAT_FIM_VIGENCIA )) ");
		}else {
			sql.append(" AND s.IDC_ORIGEM_SERV = 'S' ");
		}
		SqlParameterSource namedParameters = new MapSqlParameterSource("codServico", 1).addValue("codProduto", 544);
		
		Servico servico = namedParameterJdbcTemplate.queryForObject(sql.toString(), namedParameters, new RowMapper() {
			public Object mapRow(ResultSet resultSet, int rowNum)
			throws SQLException {
			return new Servico(resultSet.getInt("COD_SERVICO"), resultSet.getString("DSC_SERVICO_ABREV"));
			}
		});
		
		
		return servico;
	}

}
