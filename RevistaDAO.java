package ClassesDAO;

import ClassesDeNegocio.Revista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class RevistaDAO extends Revista {
    
    //*CLASSE ASSUNTODAO INSERT
    
      public int inclui ( Connection conn ) throws SQLException { 

// Prepara um comando SQL para execução.
PreparedStatement pstmt = conn.prepareStatement
 ( " INSERT INTO REVISTAS ( NOME)" + " VALUES ( ?) " ) ;
 
 // Configura os valores que serão substituídos nas interrogações do SQL . 
pstmt.setString(1, nome); 
// Executa o SQL e guarda o total de registros modificados em tt_modificados . 

int tt_modificados = pstmt.executeUpdate(); 

// Fecha PreparedStatement .

 pstmt.close ( ) ;
 return tt_modificados ; 
}
    public boolean altera ( Connection conn ) 
throws SQLException 
{ 
// Prepara um comando SQL para execução . 

PreparedStatement pstmt = conn.prepareStatement 
( " UPDATE REVISTAS SET NOME = ? , WHERE CODIGO ? " ) ;

 // Configura os valores que serão substituídos nas interrogações do SQL .

 pstmt.setString ( 1 , nome ) ;

pstmt.setString ( 2 , codigo ) ;

 // Executa o SQL que foi montado e retorna a quantidade de registros atualizados . 
int n = pstmt.executeUpdate ( ) ; 
pstmt.close ( ) ; 
if ( n == 1 ) 
return true ; 
else
 return false ; 
}

    private void Statement(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void Update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     //*CLASSE ASSUNTODAO DELETE
    
    public boolean exclui ( Connection conn , int codPesquisa ) throws SQLException
 { 
PreparedStatement pstmt = conn.prepareStatement 
( " DELETE FROM REVISTAS WHERE CODIGO = ? " ) ;

 pstmt.setInt ( 1 , codPesquisa ) ; 
int n = pstmt.executeUpdate ( ) ; 
pstmt.close ( ) ;
 if ( n == 1 ) 
return true ; 
else
 return false ;
}
    
    //*CLASSE ASSUNTODAO CONSULTA
    
    public Revista consultaUmRevista ( Connection conn , int codPesquisa ) throws SQLException { 
Revista revista = null ;
 PreparedStatement pstmt = conn.prepareStatement ( " SELECT * FROM REVISTAS WHERE CODIGO ? " ) ;

 pstmt.setInt ( 1 , codPesquisa ) ; 
ResultSet rs = pstmt.executeQuery ( ) ; 
if ( rs.next ( ) ) { 

// Se achou aquela revista , instancia um novo objeto para emcapsular as informações : CODIGO , NOME.// 

revista = new Revista ( rs.getInt ( " CODIGO " ) , 
rs.getString ( " NOME " ) ,
 rs.getString ( " SOBRENOME " ) 
) ;
 } else { // Se não achou , lança uma exceção com a mensagem " revista não encontrada " . 
throw new SQLException ( " Revista não encontrado !!! " ) ; 
} pstmt.close ( ) ; 
// retorna CODIGO , NOME encapsuldos 
// em um objeto instanciado de Revistas .
 return revista ; 
}       
}
