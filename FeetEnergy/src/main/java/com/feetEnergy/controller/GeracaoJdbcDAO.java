package com.feetEnergy.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.feetEnergy.model.GeracaoEnergia;

import com.feetEnergy.comunicacaoSerial.ControlePorta;

public class GeracaoJdbcDAO {

	private Connection conn;

	public GeracaoJdbcDAO(Connection conn) {
		this.conn = conn;
	}

	public List<GeracaoEnergia> listar() {
		String sql = "SELECT * FROM geracao";
		System.out.println(sql);
		List<GeracaoEnergia> geraEnergia = new ArrayList<GeracaoEnergia>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {

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

	public boolean salvar(GeracaoEnergia g) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO geracao(gerado, tempo, porcentgem) VALUES (?,?,?)";
		
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			
			prepareStatement.setDouble(1, g.getGerado());
			prepareStatement.setInt(2, g.getTempo());
			prepareStatement.setInt(3, g.getPorcentagem());
			prepareStatement.executeUpdate();
			prepareStatement.close();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		} 
	}

}