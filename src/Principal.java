import java.sql.SQLException;
import util.Util;
public class Principal {

	public static void main(String[] args) throws SQLException {
		Float real = 9.854f;
		Util u = new Util();
		real = u.pontoFlutuante(real, 0);
		System.out.println(real);
	}
}
