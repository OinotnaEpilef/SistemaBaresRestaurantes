package modelos;

/**
 * Esta classe e o modelo para os usuarios que serao cadastrados no sistema, ela
 * herda os metodos e atributos da classe abstrata <b>Entidade</b>.
 * 
 * 
 * 
 */

public abstract class User extends Entidade {
	protected String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}