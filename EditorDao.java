package ClassesDAO;

import ClassesDeNegocio.Editor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class EditorDao extends Editor {
    
    //*CLASSE ASSUNTODAO INSERT
    
     public int inclui ( Connection conn ) throws SQLException { 

// Prepara um comando SQL para execução.
PreparedStatement pstmt = conn.prepareStatement
 ( " INSERT INTO EDITORES ( NOME , SOBRENOME )" + " VALUES ( ? , ? ) " ) ;
 
 // Configura os valores que serão substituídos nas interrogações do SQL . 
pstmt.setString(1, nome); 
pstmt.setString ( 2 , sobrenome ) ; 
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
( " UPDATE EDITORES SET NOME = ? , SOBRENOME = ? WHERE CODIGO ? " ) ;

 // Configura os valores que serão substituídos nas interrogações do SQL .

 pstmt.setString ( 1 , nome ) ;

 pstmt.setString ( 2 , sobrenome ) ; 

pstmt.setString ( 3 , codigo ) ;

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
( " DELETE FROM EDITORES WHERE CODIGO = ? " ) ;

 pstmt.setInt ( 1 , codPesquisa ) ; 
int n = pstmt.executeUpdate ( ) ; 
pstmt.close ( ) ;
 if ( n == 1 ) 
return true ; 
else
 return false ;
}
    
    //*CLASSE ASSUNTODAO CONSULTA
    
    public Editor consultaUmEditor ( Connection conn , int codPesquisa ) throws SQLException { 
Editor editor = null ;
 PreparedStatement pstmt = conn.prepareStatement ( " SELECT * FROM Editores WHERE CODIGO ? " ) ;

 pstmt.setInt ( 1 , codPesquisa ) ; 
ResultSet rs = pstmt.executeQuery ( ) ; 
if ( rs.next ( ) ) { 

// Se achou aquele editor , instancia um novo objeto para emcapsular as informações : CODIGO , NOME E SOBRENOME .// 

editor = new Editor ( rs.getInt ( " CODIGO " ) , 
rs.getString ( " NOME " ) ,
 rs.getString ( " SOBRENOME " ) 
) ;
 } else { // Se não achou , lança uma exceção com a mensagem " editor não encontrado " . 
throw new SQLException ( " Editor não encontrado !!! " ) ; 
} pstmt.close ( ) ; 
// retorna CODIGO , NOME E SOBRENOME encapsuldos 
// em um objeto instanciado de Editor .
 return editor ; 
}   
}
