package ClassesDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Connection {

    PreparedStatement prepare;
    PreparedStatement prepareStatement;
    public Connection criaConexaoBanco ( ) { 
Connection connection = null ; 
String url = " jdbc : odbc : biblioteca " ; 
String usuario = " vitor " ;
 String senha = " vitor " ;
 try {
 Class.forName( " sun.jdbc.odbc.Jdbc0dbcDriver " ); 
connection = DriverManager.getConnection ( url , usuario , senha ) ;
 } 
catch( ClassNotFoundException cnfex ) { 
System.err.println ( " Failed to load JDBC / ODBC driver . " ) ;
 cnfex.printStackTrace ( ) ; 
System.exit ( 1 ) ; 
}
 return connection ;
 }   

    PreparedStatement prepareStatement(String _update_autores_set_nome____sobrenome___w) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
