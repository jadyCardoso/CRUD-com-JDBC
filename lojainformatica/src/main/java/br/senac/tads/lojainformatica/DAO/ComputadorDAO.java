/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.lojainformatica.DAO;

import br.senac.tads.lojainformatica.Model.ComputadorModel;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

/**
 *
 * @author jadycardoso
 */
public class ComputadorDAO {

    public static String url = "jdbc:mysql://localhost:3306/lojainformatica" + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    public static String login = "root";
    public static String senha = "adminadmin";

    public static boolean salvar(ComputadorModel c) {

        boolean retorno = false;
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO computador (processador, marca, hd ) values (?,?,?) ");
            comandoSQL.setString(1, c.getProcessador());
            comandoSQL.setString(2, c.getMarca());
            comandoSQL.setString(3, c.getHd());

            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
                throw new Exception("Não foi possível inserir o computador");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro:" + ex.getMessage());
            retorno = false;
        } catch (Exception ex) {
            System.out.println("Erro:" + ex.getMessage());
            retorno = false;
        }
        return retorno;
    }

    public static boolean alterar(ComputadorModel objComputador) {

        boolean retorno = false;
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement sql = conexao.prepareStatement("UPDATE computador SET Processador=?, Marca=?, Hd=? WHERE id=?");
            sql.setString(1, objComputador.getProcessador());
            sql.setString(2, objComputador.getMarca());
            sql.setString(3, objComputador.getHd());
            sql.setInt(4, objComputador.getId());

            int linhasAfetadas = sql.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }
        } catch (Exception e) {
            System.out.println("erro ao alterar computador");
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }

        return retorno;
    }

    public static boolean excluir(int ID) {

        boolean retorno = false;
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement sql = conexao.prepareStatement("DELETE FROM computador WHERE id=?");
            sql.setInt(1, ID);

            int linhasAfetadas = sql.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (Exception e) {
            System.out.println("erro ao excluir computador");
        } finally {

            try {

                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }

        return retorno;
    }

    public static ArrayList<ComputadorModel> selecioneComputadores() {

        ArrayList<ComputadorModel> listaRetorno = new ArrayList<ComputadorModel>();
        ResultSet rs = null;
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);
            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM computador");
            rs = sql.executeQuery();

            while (rs.next()) {
                ComputadorModel objComputador = new ComputadorModel();
                objComputador.setId(rs.getInt("id"));
                objComputador.setProcessador(rs.getString("processador"));
                objComputador.setHd(rs.getString("hd"));
                listaRetorno.add(objComputador);

            }

        } catch (Exception e) {
            System.out.println("erro ao listar computadores");
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }

        return listaRetorno;
    }

    public static ArrayList<ComputadorModel> selececioneComputadoresPeloProcessador(String processador) {

        ArrayList<ComputadorModel> listaRetorno = new ArrayList<ComputadorModel>();
        ResultSet rs = null;
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM computador WHERE processador like ?");
            sql.setString(1, '%' + processador + '%');

            rs = sql.executeQuery();

            while (rs.next()) {
                ComputadorModel objComputador = new ComputadorModel();
                objComputador.setId(rs.getInt("id"));
                objComputador.setProcessador(rs.getString("processador"));
                objComputador.setHd(rs.getString("hd"));
                listaRetorno.add(objComputador);
            }
        } catch (Exception e) {
            System.out.println("erro ao listar computadores");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }
        return listaRetorno;
    }

    public static ComputadorModel selectComputador(int ID) {

        ComputadorModel objComputador = null;
        ResultSet rs = null;
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement sql = conexao.prepareStatement("SELECT * FROM computador WHERE id = ?");
            sql.setInt(1, ID);

            rs = sql.executeQuery();

            while (rs.next()) {
                objComputador = new ComputadorModel();
                objComputador.setId(rs.getInt("id"));
                objComputador.setProcessador(rs.getString("processador"));
                objComputador.setHd(rs.getString("hd"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao procurar o Computador");
        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (Exception e) {
            }
        }

        return objComputador;
    }

}
