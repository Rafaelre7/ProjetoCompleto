package UTIL;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import BD.Conexao;


public class RelatorioUtil {
	
	public static void
	
	executarRelatorio(String arquivoRelatorio, HashMap<String, Object> parametros){
		
		try{
			
			JasperReport jasperReport = (JasperReport)
					JRLoader.loadObject(new File (arquivoRelatorio));
			Connection jdbcConnection = Conexao.getConexao();
			
			JasperPrint jasperPrint;
			
			if(parametros != null){
				
			 jasperPrint = JasperFillManager.fillReport(
						jasperReport, parametros, jdbcConnection);
			}else{
				
				 jasperPrint = JasperFillManager.fillReport(
							jasperReport, null, jdbcConnection);
			}
			
			
				JasperViewer.viewReport(jasperPrint, false);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}