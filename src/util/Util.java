package util;

import dao.RodadaDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart.Data;
import model.Rodada;

public class Util {
    public float pontoFlutuante(Float n, int totDepoisDoPonto) {
    	String s = Float.toString(n);
		int c = 0;
		String nc = "";
		int c1 = 0;
		boolean passou = false;
		while(c < s.length()) {
			if(passou == true) {
				c1++;
				if(c1 == (totDepoisDoPonto + 1)) {
					break;
				}
			}
			if(s.charAt(c) == '.') {
				passou = true;
			}
			nc += s.charAt(c);
			c++;
		}
		n = Float.parseFloat(nc);
		return n;
    }
	public String convDataBancoToForm(String form){
		form = form.replace(" ", "T");
        form = form.replaceFirst(":00", "");
		return form;
	}
	
	public String convDataFormToBanco(String form) {
		form += ":00";
		form = form.replaceAll("T", " ");
		return form;
	}
	
    public String convDataBanco(Date d) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datastring = sdf.format(d);
        return datastring;
    }
    
    
    
    public Date convDataJava(String dataBanco) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;
        try {
            d = sdf.parse(dataBanco);
        } catch (ParseException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
    public int rodadaCorrente() throws SQLException, ParseException{
        RodadaDAO rdao = new RodadaDAO();
        ArrayList<Rodada> r = new ArrayList<Rodada>();
        r = rdao.selectAll("order by (dataInicio)");
        rdao.closeDataBase();
        int c = 0, rodada;
        Date d = new Date();
        while(c < r.size()){
            if(((d.compareTo(r.get(c).getDataInicio()) == 1) && (d.compareTo(r.get(c).getDataFim()) == -1))
                    || ((d.compareTo(r.get(c).getDataInicio()) == -1) && (d.compareTo(r.get(c).getDataFim()) == -1))){
                rodada = r.get(c).getIdRodada();
                return rodada;
            }
            c++;
        }
        return r.get(r.size() - 1).getIdRodada();
    }
    
    public boolean podeEscalar() throws SQLException, ParseException{
        Date d = new Date();
        RodadaDAO rdao = new RodadaDAO();
        Rodada r = new Rodada();
        r = rdao.selectAll("WHERE idRodada = "+this.rodadaCorrente()).get(0);
        rdao.closeDataBase();
        if((d.compareTo(r.getDataInicio()) == 1) && (d.compareTo(r.getDataFim()) == -1)){
            return false;
        }else if((d.compareTo(r.getDataInicio()) == 1) && (d.compareTo(r.getDataFim()) == 1)){
            return false;
        }
        return true;
    }
    
    public boolean terminou() throws SQLException, ParseException{
        Date d = new Date();
        RodadaDAO rdao = new RodadaDAO();
        d.compareTo(rdao.selectAll("WHERE idRodada = '"+this.rodadaCorrente()+"'").get(0).getDataFim());
        rdao.selectAll("WHERE idRodada = '"+this.rodadaCorrente()+"'").get(0).getDataFim().compareTo(d);
        if(d.compareTo(rdao.selectAll("WHERE idRodada = '"+this.rodadaCorrente()+"'").get(0).getDataFim()) == 1){
            rdao.closeDataBase();
            return true;
        }
        rdao.closeDataBase();
        return false;
    }
    
    public String tratarPasta(String cursoc) {
    	if(cursoc.equals("Informática")){
    		return "informatica";	
		}else if(cursoc.equals("Química")){
			return "quimica";
		}else if(cursoc.equals("Edificações")){
			return "edificacoes";
		}else if(cursoc.equals("Mecânica")){
			return "mecanica";
		}else if(cursoc.equals("Telecomunicações")){
			return "telecomunicacoes";
		}else if(cursoc.equals("Eletrotécnica")){
			return "eletrotecnica";
		}
		return cursoc;
    }
}