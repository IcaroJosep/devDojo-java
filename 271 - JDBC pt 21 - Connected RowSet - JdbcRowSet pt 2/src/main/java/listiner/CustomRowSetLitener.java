package listiner;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class CustomRowSetLitener implements RowSetListener {

	@Override
	public void rowSetChanged(RowSetEvent event) {
		// TODO Auto-generated method stub
		log.info("comando \"execute()\" ativado'");
	}

	@Override
	public void rowChanged(RowSetEvent event) {
		// TODO Auto-generated method stub
		log.info("linha auterada , deletada ou incerida");
		
		if(event.getSource() instanceof RowSet) {
				try {
					((RowSet)event.getSource()).execute();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	@Override
	public void cursorMoved(RowSetEvent event) {
		// TODO Auto-generated method stub
		log.info("movimento do cursor");
	}

}
