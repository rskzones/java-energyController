package com.feetEnergy.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.feetEnergy.model.GeracaoEnergia;

public class GeracaoJdbcDAO {
	
	private Connection conn;
	
	public GeracaoJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<GeracaoEnergia> listar() {
		String sql = "select * from geracao";
        System.out.println(sql);		
        List<GeracaoEnergia> geraEnergia = new ArrayList<GeracaoEnergia>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				
				GeracaoEnergia geracao = new GeracaoEnergia();
				
				int id = rs.getInt("idGeracao");
				Date data = rs.getDate("data");
				float gerado = rs.getFloat("gerado");
				int tempo = rs.getInt("tempo");
				int porcentagem = rs.getInt("porcentagem");
				
				geracao.setIdGeracao(id);
				geracao.setData(data);
				geracao.setGerado(gerado);
				geracao.setTempo(tempo);
				geracao.setPorcentagem(porcentagem);
				
				geraEnergia.add(geracao);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return geraEnergia;
	}
	
}