package listiner;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

import lombok.extern.log4j.Log4j2;

//listiner monitora o rowSet instanciado e nao o banco de dadosdiretamente.

@Log4j2
public class CustomRowSetLitener implements RowSetListener {

	@Override
	public void rowSetChanged(RowSetEvent event) {
		log.info("comando \"execute()\" ativado'");
	}

	
	@Override
	public void rowChanged(RowSetEvent event) {
		log.info("linha auterada , deletada ou incerida");
		
		if(event.getSource() instanceof RowSet) {         
				try {									  
					((RowSet)event.getSource()).execute();//senpre q a o evento de alteraao
				} catch (SQLException e) {				  //ele reatribuia a query assim atualisando 
					e.printStackTrace();				  //o rowSet utilisado 
				}
		}
	}

	@Override
	public void cursorMoved(RowSetEvent event) {
		log.info("movimento do cursor");
	}

}
