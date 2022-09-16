package ClassesDAO;

import ClassesDeNegocio.Livro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LivroDAO extends Livro {
    
    //*CLASSE ASSUNTODAO INSERT
    
     public int inclui ( Connection conn ) throws SQLException {
    
    // Prepara um comando SQL para execução.
PreparedStatement pstmt =conn.prepareStatement
 ( " INSERT INTO LIVROS ( NOME , AUTOR )" + " VALUES ( ? , ? ) " ) ;
 
 // Configura os valores que serão substituídos nas interrogações do SQL . 
pstmt.setString(1, nome); 
pstmt.setString ( 2 , autor ) ; 
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
( " UPDATE LIVROS SET NOME = ? , AUTOR = ? WHERE CODIGO ? " ) ;

 // Configura os valores que serão substituídos nas interrogações do SQL .

 pstmt.setString ( 1 , nome ) ;

 pstmt.setString ( 2 , autor ) ; 

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
( " DELETE FROM LIVROS WHERE CODIGO = ? " ) ;

 pstmt.setInt ( 1 , codPesquisa ) ; 
int n = pstmt.executeUpdate ( ) ; 
pstmt.close ( ) ;
 if ( n == 1 ) 
return true ; 
else
 return false ;
}
    
    //*CLASSE ASSUNTODAO CONSULTA
    
    public Livro consultaUmLivro ( Connection conn , int codPesquisa ) throws SQLException { 
Livro livro = null ;
 PreparedStatement pstmt = conn.prepareStatement ( " SELECT * FROM LIVROS WHERE CODIGO ? " ) ;

 pstmt.setInt ( 1 , codPesquisa ) ; 
ResultSet rs = pstmt.executeQuery ( ) ; 
if ( rs.next ( ) ) { 

// Se achou aquele livro , instancia um novo objeto para emcapsular as informações : CODIGO , NOME E AUTOR .// 

livro = new Livro ( rs.getInt ( " CODIGO " ) , 
rs.getString ( " NOME " ) ,
 rs.getString ( " AUTOR " ) 
) ;
 } else { // Se não achou , lança uma exceção com a mensagem " livro não encontrado " . 
throw new SQLException ( " Editor não encontrado !!! " ) ; 
} pstmt.close ( ) ; 
// retorna CODIGO , NOME E AUTOR encapsuldos 
// em um objeto instanciado de Livro.
 return livro ; 
}   
    
}
