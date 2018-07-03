package br.com.jeferson.h.padilha.melhoresPraticasOO;

public class Cnpj implements Documento{

  private String cnpj;

  public boolean ehValido() {
    return primeiroDigitoVerificador() == primeiroDigitoCorreto() && segundoDigitoVerificador() == segundoDigitoCorreto();
  }

  public String getValor() {
    return this.cnpj;
  }
  
  private int primeiroDigitoCorreto() {
    // Extrai o primeiro dígito verificador do CNPJ armazenado
    // no atributo cnpj
    return 0;
  }

  private int primeiroDigitoVerificador() {
    // Extrai o segundo dígito verificador do CNPJ armazenado
    // no atributo cnpj
    return 0;
  }

  private int segundoDigitoCorreto() {
    // Calcula o primeiro dígito verificador correto para
    // o CNPJ armazenado no atributo cnpj
    return 0;
  }

  private int segundoDigitoVerificador() {
    // Calcula o primeiro dígito verificador correto para
    // o CNPJ armazenado no atributo cnpj
    return 0;
  }

  public Cnpj(String cnpj) {
    super();
    this.cnpj = cnpj;
    
    this.ehValido();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Cnpj)) {
      return false;
    }
    Cnpj other = (Cnpj) obj;
    if (cnpj == null) {
      if (other.cnpj != null) {
        return false;
      }
    } else if (!cnpj.equals(other.cnpj)) {
      return false;
    }
    return true;
  }
  
  @Override
	public String toString() {
		return cnpj.toString();
	}

}
